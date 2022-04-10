package com.company.service;

import com.company.models.Driver;
import com.company.models.Truck;

import java.util.Arrays;

public class PrintAllInfo {
    public static void printAllInformation(Truck[] trucks, Driver[] drivers) {
        System.out.println("-----------------------------");
        Arrays.stream(trucks).forEach(System.out::println);
        System.out.println("---------------------------------------");
        Arrays.stream(drivers).forEach(System.out::println);

    }
}