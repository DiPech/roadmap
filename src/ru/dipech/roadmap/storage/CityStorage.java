package ru.dipech.roadmap.storage;

import ru.dipech.roadmap.model.City;

public interface CityStorage extends Storage<City> {
    City get(String name);
}
