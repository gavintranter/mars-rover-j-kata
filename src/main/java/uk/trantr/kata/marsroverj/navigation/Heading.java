package uk.trantr.kata.marsroverj.navigation;

public enum Heading {
    NORTH {
        @Override
        public Coordinate getVector() {
            return Y_VECTOR;
        }
    },
    EAST {
        @Override
        public Coordinate getVector() {
            return X_VECTOR;
        }
    },
    SOUTH {
        @Override
        public Coordinate getVector() {
            return Y_VECTOR.getInverse();
        }
    },
    WEST {
        @Override
        public Coordinate getVector() {
            return X_VECTOR.getInverse();
        }
    };

    public static final Coordinate X_VECTOR = new Coordinate(1, 0);
    public static final Coordinate Y_VECTOR = new Coordinate(0, 1);

    public abstract Coordinate getVector();
}
