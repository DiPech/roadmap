package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.City;

import java.util.HashMap;
import java.util.Map;

public class CityStorageImpl implements CityStorage {
    private Map<String, City> storage = new HashMap<>();

    @Override
    public void add(City city) {
        if (storage.containsKey(city.getName())) {
            throw new StorageException("Already has a city with given name.");
        }
        storage.put(city.getName(), city);
    }

    @Override
    public City get(String name) {
        if (!storage.containsKey(name)) {
            throw new StorageException("City with given name not found.");
        }
        return storage.get(name);
    }
}
