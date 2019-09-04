package ru.dipech.roadmap.to;

import ru.dipech.roadmap.model.AbstractModel;
import ru.dipech.roadmap.model.City;

import java.util.Objects;

public class RoadTo extends AbstractModel {
    private String cityFromName;
    private String cityToName;
    private double distance;

    public RoadTo(String name, City cityFrom, City cityTo) {
        super(name);
        Objects.requireNonNull(cityFrom, "cityFrom must not be null");
        Objects.requireNonNull(cityTo, "cityTo must not be null");
        this.cityFromName = cityFrom.getName();
        this.cityToName = cityTo.getName();
        this.distance = calcDistance(cityFrom, cityTo);
    }

    private double calcDistance(City cityFrom, City cityTo) {
        return Math.sqrt(Math.pow(cityFrom.getX() - cityTo.getX(), 2) +
                Math.pow(cityFrom.getY() - cityTo.getY(), 2));
    }

    @Override
    public String toString() {
        return "RoadTo{" +
                "cityFromName='" + cityFromName + '\'' +
                ", cityToName='" + cityToName + '\'' +
                ", distance=" + distance +
                ", name='" + name + '\'' +
                '}';
    }
}
