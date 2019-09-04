package ru.dipech.roadmap.service;

import ru.dipech.roadmap.model.City;
import ru.dipech.roadmap.model.Road;
import ru.dipech.roadmap.storage.RoadStorage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CityServiceImpl implements CityService {
    private RoadStorage storage;

    public CityServiceImpl(RoadStorage storage) {
        Objects.requireNonNull(storage);
        this.storage = storage;
    }

    @Override
    public List<Road> getRoads(City city) {
        List<Road> roads = storage.getAll();
        return roads.stream()
                .filter((r) -> r.getCityFrom().equals(city) || r.getCityTo().equals(city))
                .collect(Collectors.toList());
    }
}
