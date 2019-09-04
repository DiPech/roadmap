package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.model.Road;

import java.util.List;

public interface RoadStorage extends Storage<Road> {
    void remove(Road road);

    List<Road> getAll();
}
