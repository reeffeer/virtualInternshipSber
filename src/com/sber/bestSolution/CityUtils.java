package com.sber.bestSolution;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityUtils {
    public static List<City> parse() {
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("/Users/reefs/java/city_ru.csv")); // Загрузка данных из файла
            while (scanner.hasNextLine()) { // Обработка данных и заполнение массива
                cities.add(parse(scanner.nextLine()));
            }
            scanner.close(); // Не забываем вызвать метод закрытия потока данных
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";"); // Задается разделитель в строке с данными
        scanner.skip("\\d*"); // Необходимо пропустить значение номера строки по условиям задачи
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) { // В файле с городами возможно отсутствие данного значения
            foundation = scanner.next();
        }
        scanner.close();

        return new City(name, region, district, population, foundation);
    }

    public static void reversedSortByName(List<City> cities) {
        cities.sort(new CityComparator().reversed());
    }

    public static void lambdaReversedSortByName(List<City> cities) {
        cities.sort((City c1, City c2) -> c2.getName().compareToIgnoreCase(c1.getName()));
    }

    public static void reversedSortByDistrict(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName).reversed());
    }

    public static void countCitiesOfRegions(List<City> cities) {
        Map<String, Integer> countMap = new HashMap<>();

        for (City city : cities) {

            if (countMap.containsKey(city.getRegion()))
                countMap.put(city.getRegion(), countMap.get(city.getRegion()) + 1);
            else
                countMap.put(city.getRegion(), 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
