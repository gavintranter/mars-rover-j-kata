package uk.trantr.kata.marsroverj;

import java.util.function.Function;

public enum Heading {
    NORTH {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.Y_DASH;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.Y_REVERSE_DASH;
        }
    },
    EAST {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.X_DASH;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.X_REVERSE_DASH;
        }
    },
    SOUTH {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.Y_REVERSE_DASH;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.Y_DASH;
        }
    },
    WEST {
        @Override
        public Function<Coordinate, Coordinate> getVector() {
            return Coordinate.X_REVERSE_DASH;
        }

        @Override
        public Function<Coordinate, Coordinate> getReverseVector() {
            return Coordinate.X_DASH;
        }
    };

    public abstract Function<Coordinate, Coordinate> getVector();
    public abstract Function<Coordinate, Coordinate> getReverseVector();
}
