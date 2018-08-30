package uk.trantr.kata.marsroverj.navigation;

import java.util.function.IntFunction;

public class Map {

    private final IntFunction<Integer> latitudeAdjustment;
    private final IntFunction<Integer> longitudeAdjustment;

    public Map(int latitudeExtent, int longitudeExtent) {
        latitudeAdjustment = x -> {
            int beyondExtent = x % latitudeExtent;
            return (beyondExtent == 0) ? latitudeExtent : beyondExtent;
        };

        longitudeAdjustment = x -> {
            int beyondExtent = x % longitudeExtent;
            return (beyondExtent == 0) ? longitudeExtent : beyondExtent;
        };
    }

    public Coordinate moveTo(Coordinate newNorthernCoordinate) {
        return newNorthernCoordinate.adjustBy(latitudeAdjustment, longitudeAdjustment);
    }
}