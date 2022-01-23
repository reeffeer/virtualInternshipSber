package com.sber;

import com.sber.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SplitSolution {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(("/Users/reefs/java/city_ru.csv")));

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] paramOfCity = line.split(";");
            //System.out.println(Arrays.toString(paramOfCity));

                String name = paramOfCity[paramOfCity.length-5];
                String region = paramOfCity[paramOfCity.length-4];
                String district = paramOfCity[paramOfCity.length-3];
                String population = paramOfCity[paramOfCity.length-2];
                String foundation = paramOfCity[paramOfCity.length-1];

                City city = new City();
                city.setName(name);
                city.setRegion(region);
                city.setDistrict(district);
                city.setPopulation(population);
                city.setFoundation(foundation);

                System.out.println(city.toString());

        }
        sc.close();
    }
}
