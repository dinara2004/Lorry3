package com.company.models;

import java.util.Random;

public class Truck {

    private Integer id;
    private String name;
    private String driver;
    private String state;

    public Truck() {
    }

    public Truck(Integer id, String name, String driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static void changeDriver(Truck truck, Driver[] driver) {
        for (Driver d:driver) {
            if(d.getTruck().matches("[^a-zA-Z]*")){ // bosh driverdi myntip tappait bosh driverdi (d.getTruck != null) ushintip teksherishiniz kerek
                truck.setDriver(d.getName());
                d.setTruck(truck.getName());
                break;
            }
        }
        if (truck.getState().equals("route")){
            System.err.println("Вы не можете сменить водителя, потому что водитель уже в пути!\n"
                    + truck.getName());
        } else if (truck.getState().equals("repair")){
            System.err.println("Вы не можете сменить водителя, потому что грузовик на ремонте!\n"
                    +truck.getName());
        } else if (truck.getState().equals("base")){
            System.err.println("Вы успешно сменили водителя!\n"
                    + truck.getName());
        }
    }

    public static void startDriving(Truck truck) {
        if (truck.getState().equals("base")){
            if (!truck.getDriver().equals("")){ // nulldu dagy unutbanyz
                truck.setState("route");
                System.err.println("Водитель успешно стартовал");
            } else {
                System.err.println("Здесь нет водителя!");
            }
        } else if (truck.getState().equals("route")){
            System.err.println("Водитель уже в пути!");
        } else {
            Random random = new Random(); // emne uchun randomdu koldondunuz
            int road = random.nextInt(2);
            if (road == 0){
                truck.setState("route");
                System.out.println("Грузовик уже в пути!");
            } else {
                truck.setState("base");
                System.out.println("Грузовик на базе");
            }
        }
    }

    public static void startRepair(Truck truck) {
        if (truck.getState().equals("base")){
            truck.setState("repair");
            System.out.println("Грузовик на ремонте");
        }else if (truck.getState().equals("route")){
            truck.setState("repair");
        }else {.                                                // <- bul jaka if kohsup koyushunuz kerek eken sebebi 'dinara' dep jazyp koysok dele ishtei beret
            System.out.println("Грузовик на ремонте");
        }
    }

        @Override
    public String toString() {
            return id + "  | " + name + "|  " + driver + "        | " + state + '\n';
    }
}


