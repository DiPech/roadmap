package ru.dipech.roadmap.controller;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.City;
import ru.dipech.roadmap.model.Road;
import ru.dipech.roadmap.service.CityService;
import ru.dipech.roadmap.storage.CityStorage;
import ru.dipech.roadmap.storage.RoadStorage;
import ru.dipech.roadmap.to.RoadTo;
import ru.dipech.roadmap.util.RoadUtil;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ControllerImpl implements Controller {
    private CityStorage cityStorage;
    private RoadStorage roadStorage;
    private CityService cityService;

    public ControllerImpl(CityStorage cityStorage, RoadStorage roadStorage, CityService cityService) {
        Objects.requireNonNull(cityStorage, "cityStorage must not be null");
        Objects.requireNonNull(cityStorage, "roadStorage must not be null");
        Objects.requireNonNull(cityService, "roadStorage must not be null");
        this.cityStorage = cityStorage;
        this.roadStorage = roadStorage;
        this.cityService = cityService;
    }

    @Override
    public synchronized void addCity(City city) {
        executeOrSout(() -> cityStorage.add(city));
    }

    @Override
    public synchronized void addRoad(Road road) {
        executeOrSout(() -> roadStorage.add(road));
    }

    @Override
    public synchronized void removeRoad(Road road) {
        executeOrSout(() -> roadStorage.remove(road));
    }

    @Override
    public synchronized City getCityByName(String name) {
        return returnOrSout(() -> cityStorage.get(name));
    }

    @Override
    public synchronized List<RoadTo> getRoadsByCity(City city) {
        List<Road> roads = cityService.getRoads(city);
        return RoadUtil.toTransferObjects(roads);
    }

    private void executeOrSout(Runnable runnable) {
        try {
            runnable.run();
        } catch (StorageException e) {
            System.out.println(e.getMessage());
        }
    }

    private <T> T returnOrSout(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (StorageException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
