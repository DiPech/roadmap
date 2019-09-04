package ru.dipech.roadmap.model;

import java.util.Objects;

public class Road {
    private String name;
    private City cityFrom;
    private City cityTo;

    public Road(String name, City cityFrom, City cityTo) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(cityFrom, "cityFrom must not be null");
        Objects.requireNonNull(cityTo, "cityTo must not be null");
        this.name = name;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return name.equals(road.name) &&
                cityFrom.equals(road.cityFrom) &&
                cityTo.equals(road.cityTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cityFrom, cityTo);
    }
}
