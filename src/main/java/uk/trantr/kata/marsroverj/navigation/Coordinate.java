package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;
import java.util.function.Function;

public class Coordinate {
    public static final Function<Coordinate, Coordinate> Y_VECTOR = (c) -> new Coordinate(c.x, c.y + 1);
    public static final Function<Coordinate, Coordinate> Y_REVERSE_VECTOR = (c) -> new Coordinate(c.x, c.y - 1);
    public static final Function<Coordinate, Coordinate> X_VECTOR = (c) -> new Coordinate(c.x + 1, c.y);
    public static final Function<Coordinate, Coordinate> X_REVERSE_VECTOR = (c) -> new Coordinate(c.x - 1, c.y);

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate translate(Function<Coordinate, Coordinate> vector) {
        return vector.apply(this);
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