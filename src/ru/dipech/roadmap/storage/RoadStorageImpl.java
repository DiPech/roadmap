package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.Road;

import java.util.ArrayList;
import java.util.List;

public class RoadStorageImpl extends AbstractStorage<Road> implements RoadStorage {

    @Override
    public void remove(Road road) {
        if (!storage.containsKey(road.getName())) {
            throw new StorageException("Object with given name not found.");
        }
        storage.remove(road.getName());
    }

    @Override
    public List<Road> getAll() {
        return new ArrayList<>(storage.values());
    }
}
