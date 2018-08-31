package uk.trantr.kata.marsroverj.navigation;

import java.util.Set;
import java.util.function.IntFunction;

public class Map {

    private final IntFunction<Integer> latitudeAdjustment;
    private final IntFunction<Integer> longitudeAdjustment;
    private final Set<Coordinate> obstacles;

    public Map(int latitudeExtent, int longitudeExtent, Set<Coordinate> obstacles) {
        latitudeAdjustment = x -> {
            int beyondExtent = x % latitudeExtent;
            return (beyondExtent == 0) ? latitudeExtent : beyondExtent;
        };

        longitudeAdjustment = x -> {
            int beyondExtent = x % longitudeExtent;
            return (beyondExtent == 0) ? longitudeExtent : beyondExtent;
        };

        this.obstacles = obstacles;
    }

    public Coordinate moveTo(Coordinate newNorthernCoordinate) {
        return newNorthernCoordinate.adjustBy(latitudeAdjustment, longitudeAdjustment);
    }

    public boolean isSafe(Coordinate coordinate) {
        return !(obstacles.contains(coordinate));
    }
}