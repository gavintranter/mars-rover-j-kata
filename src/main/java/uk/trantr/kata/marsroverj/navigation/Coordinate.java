package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;

public final class Coordinate {
    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate inverse() {
        return new Coordinate(x * -1, y * -1);
    }

    Coordinate apply(Coordinate vector) {
        return new Coordinate(x + vector.x, y + vector.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        Coordinate that = (Coordinate) o;
        return (x == that.x) &&
                (y == that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate{(" + x +
                ", " + y +
                ")}";
    }
}