package uk.trantr.kata.marsroverj.navigation;

import java.util.Set;
import java.util.function.IntFunction;

/**
 * This Chart wraps at the edges, producing something akin to a doughnut shapped chart.
 * Each chart extent begins at 1 rather than zero and extends to include the provide extent.
 * Foe example if the extent is 4, the available location are 1, 2, 3 and 4.
 */
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