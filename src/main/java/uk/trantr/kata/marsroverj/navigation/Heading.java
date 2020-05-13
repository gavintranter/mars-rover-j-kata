package uk.trantr.kata.marsroverj.navigation;

import java.util.function.IntFunction;

public enum Heading {
    NORTH {
        @Override
        public Coordinate getVector() {
            return P_Y_VECTOR;
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
            return P_X_VECTOR;
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
            return N_Y_VECTOR;
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
            return N_X_VECTOR;
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

    private static final IntFunction<Integer> INVERT_FUNCTION = v -> v * -1;
    private static final Coordinate P_X_VECTOR = Coordinate.ONE_ZERO;
    private static final Coordinate N_X_VECTOR = P_X_VECTOR.adjustBy(INVERT_FUNCTION, INVERT_FUNCTION);
    private static final Coordinate P_Y_VECTOR = Coordinate.ZERO_ONE;
    private static final Coordinate N_Y_VECTOR = P_Y_VECTOR.adjustBy(INVERT_FUNCTION, INVERT_FUNCTION);

    public abstract Coordinate getVector();

    public abstract Heading clockwise();

    public abstract Heading anticlockwise();
}
