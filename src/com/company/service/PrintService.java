package com.company.service;

import com.company.models.Driver;
import com.company.models.Truck;

public class PrintService {

    public static void print(Truck[] trucks) {
        System.out.println("=========== * TRUCKS * =============");
        System.out.println(" # |    Bus    |  Driver  |  State");
        System.out.println("---+-----------+----------+---------");
        for (int j = 0; j < trucks.length; j++) {
            System.out.println(trucks[j]);
        }
    }

    public static void print(Driver[] drivers) {
        System.out.println("=========== * DRIVERS * ===========");
        System.out.println("     #    |   Driver   |   Bus      ");
        System.out.println("----------+------------+------------");
        for (int j = 0; j < drivers.length; j++) {
            System.out.println(drivers[j]);
        }
    }
}
