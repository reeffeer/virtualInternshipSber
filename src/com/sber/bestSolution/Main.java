package com.sber.bestSolution;


import java.util.List;

import static com.sber.bestSolution.CityUtils.*;

public class Main {

    public static void main(String[] args) {
        List<City> cities = parse();
        print(cities);

        reversedSortByName(cities);
        print(cities);

        lambdaReversedSortByName(cities);
        print(cities);

        reversedSortByDistrict(cities);
        print(cities);
    }

}
