package uk.trantr.kata.marsroverj.navigation;

public enum Heading {
    NORTH {
        @Override
        public Coordinate getVector() {
            return new Coordinate(0, 1);
        }

        @Override
        public Coordinate getReverseVector() {
            return new Coordinate(0, -1);
        }
    },
    EAST {
        @Override
        public Coordinate getVector() {
            return new Coordinate(1, 0);
        }

        @Override
        public Coordinate getReverseVector() {
            return new Coordinate(-1, 0);
        }
    },
    SOUTH {
        @Override
        public Coordinate getVector() {
            return new Coordinate(0, -1);
        }

        @Override
        public Coordinate getReverseVector() {
            return new Coordinate(0, 1);
        }
    },
    WEST {
        @Override
        public Coordinate getVector() {
            return new Coordinate(-1, 0);
        }

        @Override
        public Coordinate getReverseVector() {
            return new Coordinate(1, 0);
        }
    };

    public abstract Coordinate getVector();
    public abstract Coordinate getReverseVector();
}
