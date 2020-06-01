package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;
import java.util.Set;
import java.util.function.IntFunction;

public abstract class SkeletonChart implements Chart {
    final IntFunction<Integer> latitudeAdjustment;
    final IntFunction<Integer> longitudeAdjustment;
    final Set<Coordinate> obstacles;

    public SkeletonChart(IntFunction<Integer> latitudeAdjustment, IntFunction<Integer> longitudeAdjustment, Set<Coordinate> obstacles) {
        this.latitudeAdjustment = latitudeAdjustment;
        this.longitudeAdjustment = longitudeAdjustment;
        this.obstacles = obstacles;
    }

    @Override
    public Location translateToChart(Location location) {
        return new Location(location.getCoordinate().adjustBy(latitudeAdjustment, longitudeAdjustment), location.getHeading());
    }

    @Override
    public Traversable isSafe(Location location) {
        if (obstacles.contains(location.getCoordinate())) {
            return Traversable.unsafeToProceed(location);
        }
        else {
            return Traversable.safeToProceed(location);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkeletonChart)) {
            return false;
        }

        SkeletonChart other = (SkeletonChart) o;

        if (!Objects.equals(latitudeAdjustment, other.latitudeAdjustment)) {
            return false;
        }
        if (!Objects.equals(longitudeAdjustment, other.longitudeAdjustment)) {
            return false;
        }
        return Objects.equals(obstacles, other.obstacles);
    }

    @Override
    public int hashCode() {
        int result = latitudeAdjustment.hashCode();
        result = (31 * result) + longitudeAdjustment.hashCode();
        result = (31 * result) + ((obstacles != null) ? obstacles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SkeletonChart{" +
                "obstacles=" + obstacles +
                ", longitudeAdjustment=" + longitudeAdjustment +
                ", latitudeAdjustment=" + latitudeAdjustment +
                "}";
    }
}
