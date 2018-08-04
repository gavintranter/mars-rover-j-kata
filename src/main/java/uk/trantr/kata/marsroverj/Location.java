package uk.trantr.kata.marsroverj;

import java.util.Objects;

public final class Location {
    private final int x;
    private final int y;
    private final Heading heading;

    public Location(int x, int y, Heading heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    public int getX() {
        return x;
    }

    public Location translatingY(int value) {
        return new Location(x, value, heading);
    }

    public int getY() {
        return y;
    }

    public Heading getHeading() {
        return heading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        Location location = (Location) o;
        return (x == location.x) &&
                (y == location.y) &&
                (heading == location.heading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, heading);
    }

    @Override
    public String toString() {
        return "Location{x=" + x +
                ", y=" + y +
                ", heading=" + heading +
                '}';
    }
}
