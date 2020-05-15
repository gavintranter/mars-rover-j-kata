package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;
import java.util.function.IntFunction;

public final class Coordinate {
    public static final Coordinate ZER0_ZERO = new Coordinate(0, 0);
    public static final Coordinate ONE_ONE = new Coordinate(1, 1);
    public static final Coordinate ZERO_ONE = new Coordinate(0, 1);
    public static final Coordinate ONE_ZERO = new Coordinate(1, 0);

    private final int x;
    private final int y;

    public static Coordinate at(int x, int y) {
        if ((x == 0)) {
            if (y == 0) {
                return ZER0_ZERO;
            }
            else if (y == 1) {
                return ZERO_ONE;
            }
        }

        if ((x == 1)) {
            if (y == 0) {
                return ONE_ZERO;
            }
            else if (y == 1) {
                return ONE_ONE;
            }
        }

        return new Coordinate(x, y);
    }

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinate adjustBy(IntFunction<Integer> xAdjustment, IntFunction<Integer> yAdjustment) {
        return new Coordinate(xAdjustment.apply(x), yAdjustment.apply(y));
    }

    Coordinate plus(Coordinate coordinate) {
        return new Coordinate(x + coordinate.x, y + coordinate.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        Coordinate other = (Coordinate) o;
        return (x == other.x) && (y == other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate{(" + x + ", " + y + ")}";
    }
}