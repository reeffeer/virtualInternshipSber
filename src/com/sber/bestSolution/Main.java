package com.sber.bestSolution;


import java.text.MessageFormat;
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
//        // отсортировали список в порядке убывания населения, на первой позиции будет город с наибольшим населением
////        print(cities);
//        //перевели в массив
//        toArr(cities);
//        //нулевой индекс массива будет соответсвтовать городу с максимальным населением
//        System.out.println("---City with the biggest population---");
//        System.out.println(cities.get(0));

        //вариант без сортировки
//        simpleFindBiggestPopulation(cities);

//        findByInsertionSort(cities);

        lambdaFindMaxPopulation(cities);
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

    public static void simpleFindBiggestPopulation(List<City> cities) {
        City[] citiesArr = cities.toArray(new City[cities.size()]);
        City maxPop = citiesArr[0];
        int indexOfMaxPop = 0;
        for (int i = 1; i < citiesArr.length; i++) {
            if (citiesArr[i].getPopulation() > maxPop.getPopulation()) {
                maxPop = citiesArr[i];
                indexOfMaxPop = i;
            }
        }
        System.out.println("[" + indexOfMaxPop +"]" + " = " + maxPop.getPopulation());
    }

    public static void findByInsertionSort(List<City> cities) {
        City[] arr = new City[cities.size()];
        cities.toArray(arr);
        for (int i = 1; i < arr.length; i++) {
            City current = arr[i];
            int j = i - 1;
            while (j >= 0 && current.getPopulation() < arr[j].getPopulation()) {
             arr[j + 1] = arr[j];
             j--;
            }
            arr[j + 1] = current;
        }
        System.out.println("[" + (arr.length-1) + "]" + " = " + arr[arr.length-1].getPopulation());
    }

    public static void lambdaFindMaxPopulation(List<City> cities) {
        System.out.println(cities.stream().max(Comparator.comparing(City::getPopulation)));
    }
}
