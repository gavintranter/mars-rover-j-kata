package uk.trantr.kata.marsroverj.navigation;

import java.util.function.IntFunction;

public enum Heading {
    NORTH {
        @Override
        public Coordinate getVector() {
            return Y_VECTOR;
        }

        @Override
        public Heading clockwise() {
            return EAST;
        }

        @Override
        public Heading anticlockwise() {
            return WEST;
        }
    },
    EAST {
        @Override
        public Coordinate getVector() {
            return X_VECTOR;
        }

        @Override
        public Heading clockwise() {
            return SOUTH;
        }

        @Override
        public Heading anticlockwise() {
            return NORTH;
        }
    },
    SOUTH {
        @Override
        public Coordinate getVector() {
            return Y_VECTOR.adjustBy(INVERT_FUNCTION, INVERT_FUNCTION);
        }

        @Override
        public Heading clockwise() {
            return WEST;
        }

        @Override
        public Heading anticlockwise() {
            return EAST;
        }
    },
    WEST {
        @Override
        public Coordinate getVector() {
            return X_VECTOR.adjustBy(INVERT_FUNCTION, INVERT_FUNCTION);
        }

        @Override
        public Heading clockwise() {
            return NORTH;
        }

        @Override
        public Heading anticlockwise() {
            return SOUTH;
        }
    };

    public static final IntFunction<Integer> INVERT_FUNCTION = v -> v * -1;
    public static final Coordinate X_VECTOR = new Coordinate(1, 0);
    public static final Coordinate Y_VECTOR = new Coordinate(0, 1);

    public abstract Coordinate getVector();

    public abstract Heading clockwise();

    public abstract Heading anticlockwise();
}
