package com.company;

import com.company.exceptions.JsonFileNotFoundException;
import com.company.models.Driver;
import com.company.models.Truck;
import com.company.service.InstructionService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static com.company.service.InstructionService.getInstruction;
import static com.company.service.PrintAllInfo.printAllInformation;
import static com.company.service.PrintService.print;


public class Main {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path PATH = Paths.get("./truck.json");
    public static final Path PATH1 = Paths.get("./driver.json");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Truck[] trucks = {
                new Truck(1, "Zil       ", "", "base"),
                new Truck(2, "Scaniya   ", "", "route"),
                new Truck(3, "Volvo     ", "", "repair"),
        };

        Driver[] drivers = {
                new Driver(1, "Chynara   ", "Zil"),
                new Driver(2, "Kanat     ", "Scaniya"),
                new Driver(3, "Dinara    ", "Volvo"),
        };
//        Gson gson = new Gson();
//        String json = GSON.toJson(trucks);
//        System.out.println();
//        for (Truck truck : trucks) {
//            String toString = truck.toString();
//            System.out.println(toString);
//        }
//        System.out.println("---------------------------------------");
        print(trucks);
        print(drivers);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        while (true) {

            System.out.println("Выберите один из грузовиков: ");
            int a = scanner.nextInt();

            for (Truck t : trucks) {
                if (a == t.getId()) {
                    System.out.println("N  : " + t.getId());
                    System.out.println("Truck : " + t.getName());
                    System.out.println("Driver : " + t.getDriver());
                    System.out.println("Truck State: " + t.getState());

//                    System.out.println("Press 1 to change Driver");
//                    System.out.println("Press 2 to send to the Route");
//                    System.out.println("Press 3 ot send to the Repairing");
                    InstructionService.getInstruction();
                    int input = scanner.nextInt();
                    try {
                        if (input == 1) {
                            Truck.changeDriver(t, drivers);
//                            System.out.println("-----------------------------");
//                            System.err.println("Вы успешно сменили водителя");
                            printAllInformation(trucks, drivers);
                        } else if (input == 2) {
                            Truck.startDriving(t);
//                            System.out.println("-----------------------------");
//                            System.err.println("Грузовик успешно вышел в путь");
                            printAllInformation(trucks, drivers);
                        } else if (input == 3) {
                            Truck.startRepair(t);

//                            System.out.println("-----------------------------");
//                            System.err.println("Вы успешно сдали грузовик на ремонт");
                            printAllInformation(trucks, drivers);
                        } else {
                            throw new JsonFileNotFoundException();
                        }
                    } catch (JsonFileNotFoundException e) {
                        System.err.println("МЫ НЕ НАШЛИ ГРУЗОВИКА С ЭТИМ НОМЕРОМ");
                    }
                }
            }
        }
    }
}
