package ru.dipech.roadmap.model;

import java.util.Objects;

public class Road extends AbstractModel {
    private City cityFrom;
    private City cityTo;

    public Road(String name) {
        this(name, null, null);
    }

    public Road(String name, City cityFrom, City cityTo) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    public City getCityFrom() {
        return cityFrom;
    }

    public City getCityTo() {
        return cityTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Road road = (Road) o;
        return Objects.equals(cityFrom, road.cityFrom) &&
                Objects.equals(cityTo, road.cityTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cityFrom, cityTo);
    }

    @Override
    public String toString() {
        return "Road{" +
                "cityFrom=" + cityFrom +
                ", cityTo=" + cityTo +
                ", name='" + name + '\'' +
                '}';
    }
}
