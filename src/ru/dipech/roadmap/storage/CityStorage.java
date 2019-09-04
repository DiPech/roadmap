package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.model.City;

public interface CityStorage {

    void add(City city);

    City get(String name);

}
