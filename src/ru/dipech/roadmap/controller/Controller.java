package ru.dipech.roadmap.controller;

import ru.dipech.roadmap.model.City;
import ru.dipech.roadmap.model.Road;
import ru.dipech.roadmap.to.RoadTo;

import java.util.List;

public interface Controller {
    void addCity(City city);

    void addRoad(Road road);

    void removeRoad(Road road);

    City getCityByName(String name);

    List<RoadTo> getRoadsByCity(City city);
}
