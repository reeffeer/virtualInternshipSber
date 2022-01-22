package com.sber.trainer;

import com.sber.model.City;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CreateModel {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File(("/Users/reefs/java/city_ru.csv")));

        while (sc.hasNextLine()) {
            sc.useDelimiter("\\;");
            sc.next();
            while (sc.hasNext()) {
                String name = sc.next();
                String region = sc.next();
                String district = sc.next();
                String population = sc.next();
                String foundation = sc.next();

                City city = new City();
                city.setName(name);
                city.setRegion(region);
                city.setDistrict(district);
                city.setPopulation(population);
                city.setFoundation(foundation);

                System.out.println(city.toString());
            }
        }
    }
}

