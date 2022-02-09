package com.sber.bestSolution;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static com.sber.bestSolution.CityUtils.*;

public class Main {

    public static void main(String[] args) {
        List<City> cities = parse();
//        print(cities);
//
//        reversedSortByName(cities);
//        print(cities);
//
//        lambdaReversedSortByName(cities);
//        print(cities);
//
//        reversedSortByDistrict(cities);
//        print(cities);

        //вариант с сортировкой по населению
//        sortPopulation(cities);
        // отсортировали список в порядке убывания населения, на первой позиции будет город с наибольшим населением
//        print(cities);
        //перевели в массив
//        toArr(cities);
        //нулевой индекс массива будет соответсвтовать городу с максимальным населением
//        System.out.println("---City with the biggest population---");
//        System.out.println(cities.get(0));

        //вариант без сортировки
        findBiggestPopulation(cities);

    }

    public static void toArr(List<City> cities) {
        Object[] citiesArray = cities.toArray();
    }

    public static void sortPopulation(List<City> cities) {
        cities.sort(new Comparator<City>()  {
            @Override
            public int compare(City o1, City o2) {
                return o1.getPopulation() - o2.getPopulation();
            }
        }.reversed());
    }

    public static void findBiggestPopulation(List<City> cities) {
        City[] citiesArray = cities.toArray(new City[0]);
        City[] citiesArr = citiesArray;
        int maxPop = citiesArr[0].getPopulation();
        int indexOfMaxPop = 0;
        for (int i = 1; i < citiesArr.length; i++) {
            if (citiesArr[i].getPopulation() > maxPop) {
                maxPop = citiesArr[i].getPopulation();
                indexOfMaxPop = i;
            }
        }
        System.out.println("[" + indexOfMaxPop +"]" + " = " + maxPop);
    }
}
