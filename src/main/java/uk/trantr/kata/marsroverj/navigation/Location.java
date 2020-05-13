package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;

public final class Location {
    private final Coordinate coordinate;
    private final Heading heading;

    public Location(int x, int y, Heading heading) {
        this(Coordinate.at(x, y), heading);
    }

    public Location(Coordinate coordinate, Heading heading) {
        this.coordinate = coordinate;
        this.heading = heading;
    }

    public Heading getHeading() {
        return heading;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Location moveTo(Coordinate newCoordinate) {
        return new Location(coordinate.plus(newCoordinate), heading);
    }

    public Location changeHeadingTo(Heading newHeading) {
        return new Location(coordinate, newHeading);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        Location location = (Location) o;
        return (heading == location.heading) && Objects.equals(coordinate, location.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heading, coordinate);
    }

    @Override
    public String toString() {
        return "Location{" + coordinate + ", " + heading + "}";
    }
}
