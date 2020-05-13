package uk.trantr.kata.marsroverj.navigation;

import java.util.function.IntFunction;

public enum Heading {
    NORTH {
        @Override
        Coordinate getVector() {
            return P_Y_VECTOR;
        }

        @Override
        Heading clockwise() {
            return EAST;
        }

        @Override
        Heading anticlockwise() {
            return WEST;
        }
    },
    EAST {
        @Override
        Coordinate getVector() {
            return P_X_VECTOR;
        }

        @Override
        Heading clockwise() {
            return SOUTH;
        }

        @Override
        Heading anticlockwise() {
            return NORTH;
        }
    },
    SOUTH {
        @Override
        Coordinate getVector() {
            return N_Y_VECTOR;
        }

        @Override
        Heading clockwise() {
            return WEST;
        }

        @Override
        Heading anticlockwise() {
            return EAST;
        }
    },
    WEST {
        @Override
        Coordinate getVector() {
            return N_X_VECTOR;
        }

        @Override
        Heading clockwise() {
            return NORTH;
        }

        @Override
        Heading anticlockwise() {
            return SOUTH;
        }
    };

    static final IntFunction<Integer> INVERT_FUNCTION = v -> v * -1;

    private static final Coordinate P_X_VECTOR = Coordinate.ONE_ZERO;
    private static final Coordinate N_X_VECTOR = P_X_VECTOR.adjustBy(INVERT_FUNCTION, INVERT_FUNCTION);
    private static final Coordinate P_Y_VECTOR = Coordinate.ZERO_ONE;
    private static final Coordinate N_Y_VECTOR = P_Y_VECTOR.adjustBy(INVERT_FUNCTION, INVERT_FUNCTION);

    abstract Coordinate getVector();

    abstract Heading clockwise();

    abstract Heading anticlockwise();
}
