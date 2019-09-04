package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.Road;

import java.util.HashMap;
import java.util.Map;

public class RoadStorageImpl implements RoadStorage {
    private Map<String, Road> storage = new HashMap<>();

    @Override
    public void add(Road road) {
        if (storage.containsKey(road.getName())) {
            throw new StorageException("Already has a road with given name.");
        }
        storage.put(road.getName(), road);
    }

    @Override
    public void remove(Road road) {
        if (!storage.containsKey(road.getName())) {
            throw new StorageException("Road with given name not found.");
        }
        storage.remove(road.getName());
    }
}
