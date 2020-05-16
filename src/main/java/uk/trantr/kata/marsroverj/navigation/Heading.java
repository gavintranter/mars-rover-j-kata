package uk.trantr.kata.marsroverj.navigation;

import java.util.function.IntFunction;

public enum Heading {
    N {
        @Override
        Coordinate getVector() {
            return P_Y_VECTOR;
        }

        @Override
        Heading clockwise() {
            return E;
        }

        @Override
        Heading anticlockwise() {
            return W;
        }
    },
    E {
        @Override
        Coordinate getVector() {
            return P_X_VECTOR;
        }

        @Override
        Heading clockwise() {
            return S;
        }

        @Override
        Heading anticlockwise() {
            return N;
        }
    },
    S {
        @Override
        Coordinate getVector() {
            return N_Y_VECTOR;
        }

        @Override
        Heading clockwise() {
            return W;
        }

        @Override
        Heading anticlockwise() {
            return E;
        }
    },
    W {
        @Override
        Coordinate getVector() {
            return N_X_VECTOR;
        }

        @Override
        Heading clockwise() {
            return N;
        }

        @Override
        Heading anticlockwise() {
            return S;
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
