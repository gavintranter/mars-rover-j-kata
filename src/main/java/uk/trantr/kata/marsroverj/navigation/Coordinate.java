package uk.trantr.kata.marsroverj.navigation;

import java.util.Objects;
import java.util.function.Function;

final class Coordinate {
    enum Vector {
        Y(c -> new Coordinate(c.x, c.y + 1)),
        Y_REVERSE(c -> new Coordinate(c.x, c.y - 1)),
        X(c -> new Coordinate(c.x + 1, c.y)),
        X_REVERSE(c -> new Coordinate(c.x - 1, c.y));

        private final Function<Coordinate, Coordinate> vector;

        Vector(Function<Coordinate, Coordinate> vector) {
            this.vector = vector;
        }

        Function<Coordinate, Coordinate> getVector() {
            return vector;
        }
    }

    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinate apply(Vector vector) {
        return vector.getVector().apply(this);
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