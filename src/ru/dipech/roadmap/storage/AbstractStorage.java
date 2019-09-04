package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.exception.StorageException;
import ru.dipech.roadmap.model.AbstractModel;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStorage<T extends AbstractModel> implements Storage<T> {
    protected Map<String, T> storage = new HashMap<>();

    public void add(T t) {
        if (storage.containsKey(t.getName())) {
            throw new StorageException("Already has an object with given name.");
        }
        storage.put(t.getName(), t);
    }
}
