package uk.trantr.kata.marsroverj.navigation;

import java.util.function.Function;

public enum Heading {
    NORTH {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.Y_VECTOR;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.Y_REVERSE_VECTOR;
        }
    },
    EAST {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.X_VECTOR;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.X_REVERSE_VECTOR;
        }
    },
    SOUTH {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.Y_REVERSE_VECTOR;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.Y_VECTOR;
        }
    },
    WEST {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.X_REVERSE_VECTOR;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.X_VECTOR;
        }
    };

    public abstract Function<Coordinate, Coordinate> getVector();
    public abstract Function<Coordinate, Coordinate> getReverseVector();
}
