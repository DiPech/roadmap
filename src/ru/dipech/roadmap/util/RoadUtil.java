package ru.dipech.roadmap.util;

import ru.dipech.roadmap.model.Road;
import ru.dipech.roadmap.to.RoadTo;

import java.util.ArrayList;
import java.util.List;

public class RoadUtil {
    public static List<RoadTo> toTransferObjects(List<Road> roads) {
        List<RoadTo> roadsTo = new ArrayList<>();
        roads.forEach(r -> roadsTo.add(new RoadTo(r.getName(), r.getCityFrom(), r.getCityTo())));
        return roadsTo;
    }
}
