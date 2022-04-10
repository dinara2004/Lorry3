package com.company.models;

public class Driver {

    private Integer id;
    private String name;
    private String truck;

    public Driver() {
    }

    public Driver(Integer id, String name, String truck) {
        this.id = id;
        this.name = name;
        this.truck = truck;
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

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }


    @Override
    public String toString() {
        return id + "         |  "+ name +"| " + truck +'\n';
    }
}
