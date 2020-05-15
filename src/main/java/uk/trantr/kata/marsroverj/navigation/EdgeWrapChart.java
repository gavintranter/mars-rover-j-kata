package uk.trantr.kata.marsroverj.navigation;

import java.util.Set;
import java.util.function.IntFunction;

public class EdgeWrapChart extends SkeletonChart {

    public static Chart create(int latitudeExtent, int longitudeExtent, Set<Coordinate> obstacles) {
        IntFunction<Integer> latitudeAdjustment = x -> {
            int beyondExtent = x % latitudeExtent;
            return (beyondExtent == 0) ? latitudeExtent : beyondExtent;
        };

        IntFunction<Integer> longitudeAdjustment = x -> {
            int beyondExtent = x % longitudeExtent;
            return (beyondExtent == 0) ? longitudeExtent : beyondExtent;
        };

        return new EdgeWrapChart(latitudeAdjustment, longitudeAdjustment, obstacles);
    }

    private EdgeWrapChart(IntFunction<Integer> latitudeAdjustment, IntFunction<Integer> longitudeAdjustment, Set<Coordinate> obstacles) {
        super(latitudeAdjustment, longitudeAdjustment, obstacles);
    }
}