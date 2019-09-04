package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.City;

public class CityStorageImpl extends AbstractStorage<City> implements CityStorage {

    @Override
    public City get(String name) {
        if (!storage.containsKey(name)) {
            throw new StorageException("Object with given name not found.");
        }
        return storage.get(name);
    }
}
