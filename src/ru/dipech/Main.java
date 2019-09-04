package ru.dipech;

import ru.dipech.roadmap.controller.Controller;
import ru.dipech.roadmap.controller.ControllerImpl;
import ru.dipech.roadmap.model.City;
import ru.dipech.roadmap.model.Road;
import ru.dipech.roadmap.service.CityService;
import ru.dipech.roadmap.service.CityServiceImpl;
import ru.dipech.roadmap.storage.CityStorage;
import ru.dipech.roadmap.storage.CityStorageImpl;
import ru.dipech.roadmap.storage.RoadStorage;
import ru.dipech.roadmap.storage.RoadStorageImpl;
import ru.dipech.roadmap.to.RoadTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        RoadStorage roadStorage = new RoadStorageImpl();
        CityStorage cityStorage = new CityStorageImpl();
        CityService cityService = new CityServiceImpl(roadStorage);
        Controller controller = new ControllerImpl(cityStorage, roadStorage, cityService);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Введите команду [ " +
                    "addcity name x y | addroad name cityFromName cityToName | " +
                    "removeroad roadName | " +
                    "getcity name | getroads cityName " +
                    "]:");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 4) {
                System.out.println("Неверная команда.");
                continue;
            }
            City city;
            Road road;
            switch (params[0]) {
                case "addcity":
                    city = new City(params[1], Double.parseDouble(params[2]), Double.parseDouble(params[3]));
                    controller.addCity(city);
                    break;
                case "addroad":
                    road = new Road(params[1],
                            controller.getCityByName(params[2]),
                            controller.getCityByName(params[3]));
                    controller.addRoad(road);
                    break;
                case "removeroad":
                    road = new Road(params[1]);
                    controller.removeRoad(road);
                    break;
                case "getcity":
                    city = controller.getCityByName(params[1]);
                    if (city != null) {
                        System.out.println(city);
                    }
                    break;
                case "getroads":
                    city = controller.getCityByName(params[1]);
                    if (city != null) {
                        List<RoadTo> roads = controller.getRoadsByCity(city);
                        if (roads != null) {
                            System.out.println(roads);
                        }
                    }
                    break;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }
}
