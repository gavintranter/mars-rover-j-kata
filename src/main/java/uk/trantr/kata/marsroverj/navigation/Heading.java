package uk.trantr.kata.marsroverj.navigation;

public enum Heading {
    NORTH {
        @Override
        public Coordinate getVector() {
            return Y_VECTOR;
        }

        @Override
        public Heading clockWise() {
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
        public Heading clockWise() {
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
            return Y_VECTOR.getInverse();
        }

        @Override
        public Heading clockWise() {
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
            return X_VECTOR.getInverse();
        }

        @Override
        public Heading clockWise() {
            return NORTH;
        }

        @Override
        public Heading anticlockwise() {
            return SOUTH;
        }
    };

    public static final Coordinate X_VECTOR = new Coordinate(1, 0);
    public static final Coordinate Y_VECTOR = new Coordinate(0, 1);

    public abstract Coordinate getVector();

    public abstract Heading clockWise();

    public abstract Heading anticlockwise();
}
