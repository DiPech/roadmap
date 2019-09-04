package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.model.Road;

public interface RoadStorage extends Storage<Road> {
    void remove(Road road);
}
