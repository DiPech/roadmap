package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.Road;

public class RoadStorageImpl extends AbstractStorage<Road> implements RoadStorage {

    @Override
    public void remove(Road road) {
        if (!storage.containsKey(road.getName())) {
            throw new StorageException("Object with given name not found.");
        }
        storage.remove(road.getName());
    }
}
