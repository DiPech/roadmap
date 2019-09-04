package ru.dipech.roadmap.model;

import java.util.Objects;

public class City extends AbstractModel {
    private float x;
    private float y;

    public City(String name, float x, float y) {
        Objects.requireNonNull(name, "name must not be null");
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return Float.compare(city.x, x) == 0 &&
                Float.compare(city.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y);
    }

    @Override
    public String toString() {
        return "City{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }
}
