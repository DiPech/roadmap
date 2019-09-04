package ru.dipech.roadmap.model;

import java.util.Objects;

public class City extends AbstractModel {
    private double x;
    private double y;

    public City(String name, double x, double y) {
        super(name);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return Double.compare(city.x, x) == 0 &&
                Double.compare(city.y, y) == 0;
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
