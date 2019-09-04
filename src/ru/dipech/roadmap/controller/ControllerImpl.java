package ru.dipech.roadmap.controller;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.City;
import ru.dipech.roadmap.model.Road;
import ru.dipech.roadmap.storage.CityStorage;
import ru.dipech.roadmap.storage.RoadStorage;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ControllerImpl implements Controller {
    private CityStorage cityStorage;
    private RoadStorage roadStorage;

    public ControllerImpl(CityStorage cityStorage, RoadStorage roadStorage) {
        Objects.requireNonNull(cityStorage, "cityStorage must not be null");
        Objects.requireNonNull(cityStorage, "roadStorage must not be null");
        this.cityStorage = cityStorage;
        this.roadStorage = roadStorage;
    }

    @Override
    public void addCity(City city) {
        executeOrSout(() -> cityStorage.add(city));
    }

    @Override
    public void addRoad(Road road) {
        executeOrSout(() -> roadStorage.add(road));
    }

    @Override
    public void removeRoad(Road road) {
        executeOrSout(() -> roadStorage.remove(road));
    }

    @Override
    public City getCityByName(String name) {
        return returnOrSout(() -> cityStorage.get(name));
    }

    @Override
    public List<Road> getRoadsByCity(City city) {
        return null;
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
