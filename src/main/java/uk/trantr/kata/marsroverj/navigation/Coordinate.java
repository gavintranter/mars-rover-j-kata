package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;
import java.util.function.IntFunction;

public final class Coordinate {
    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate getInverse() {
        return new Coordinate(x * -1, y * -1);
    }

    Coordinate adjustBy(IntFunction<Integer> xAdjustment, IntFunction<Integer> yAdjustment) {
        return new Coordinate(xAdjustment.apply(x), yAdjustment.apply(y));
    }

    Coordinate add(Coordinate coordinate) {
        return new Coordinate(x + coordinate.x, y + coordinate.y);
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