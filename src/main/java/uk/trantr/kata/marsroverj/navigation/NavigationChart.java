package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;
import java.util.Set;
import java.util.function.IntFunction;

public class NavigationChart {

    private final IntFunction<Integer> latitudeAdjustment;
    private final IntFunction<Integer> longitudeAdjustment;
    private final Set<Coordinate> obstacles;

    public NavigationChart(int latitudeExtent, int longitudeExtent, Set<Coordinate> obstacles) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NavigationChart)) return false;

        NavigationChart that = (NavigationChart) o;

        if (!Objects.equals(latitudeAdjustment, that.latitudeAdjustment)) {
            return false;
        }
        if (!Objects.equals(longitudeAdjustment, that.longitudeAdjustment)) {
            return false;
        }
        return Objects.equals(obstacles, that.obstacles);
    }

    @Override
    public int hashCode() {
        int result = (latitudeAdjustment != null) ? latitudeAdjustment.hashCode() : 0;
        result = (31 * result) + ((longitudeAdjustment != null) ? longitudeAdjustment.hashCode() : 0);
        result = (31 * result) + ((obstacles != null) ? obstacles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NavigationChart{" +
                "obstacles=" + obstacles +
                ", longitudeAdjustment=" + longitudeAdjustment +
                ", latitudeAdjustment=" + latitudeAdjustment +
                "}";
    }
}