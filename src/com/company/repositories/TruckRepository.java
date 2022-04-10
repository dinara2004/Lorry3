package com.company.repositories;

import com.company.models.Truck;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TruckRepository {
    List<Truck> truckList;

    public TruckRepository() throws FileNotFoundException {
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(
                new FileReader("resources/trucks.json"));
        Truck[] trucks = gson.fromJson(jsonReader, Truck.class);
        truckList = new ArrayList<Truck>(List.of(trucks));

    }
}
