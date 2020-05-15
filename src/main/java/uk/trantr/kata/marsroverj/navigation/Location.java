package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;

import static uk.trantr.kata.marsroverj.navigation.Heading.INVERT_FUNCTION;

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

    public Location forward() {
        return new Location(coordinate.plus(heading.getVector()), heading);
    }

    public Location backwards() {
        return new Location(coordinate.plus(heading.getVector().adjustBy(INVERT_FUNCTION, INVERT_FUNCTION)), heading);
    }

    public Location changeHeadingClockwise() {
        return new Location(coordinate, heading.clockwise());
    }

    public Location changeHeadingAnticlockwise() {
        return new Location(coordinate, heading.anticlockwise());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        Location other = (Location) o;
        return (heading == other.heading) && Objects.equals(coordinate, other.coordinate);
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
