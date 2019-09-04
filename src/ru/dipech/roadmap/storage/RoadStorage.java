package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.model.Road;

public interface RoadStorage {

    void add(Road road);

    void remove(Road road);

}
