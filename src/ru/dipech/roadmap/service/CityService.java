package ru.dipech.roadmap.service;

import ru.dipech.roadmap.model.City;
import ru.dipech.roadmap.model.Road;

import java.util.List;

public interface CityService {
    List<Road> getRoads(City city);
}
