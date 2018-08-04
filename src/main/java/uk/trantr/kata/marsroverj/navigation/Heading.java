package uk.trantr.kata.marsroverj.navigation;

public enum Heading {
    NORTH {
        @Override
        public Coordinate.Vector getVector() {
            return Coordinate.Vector.Y;
        }

        @Override
        public Coordinate.Vector getReverseVector() {
            return Coordinate.Vector.Y_REVERSE;
        }
    },
    EAST {
        @Override
        public Coordinate.Vector getVector() {
            return Coordinate.Vector.X;
        }

        @Override
        public Coordinate.Vector getReverseVector() {
            return Coordinate.Vector.X_REVERSE;
        }
    },
    SOUTH {
        @Override
        public Coordinate.Vector getVector() {
            return Coordinate.Vector.Y_REVERSE;
        }

        @Override
        public Coordinate.Vector getReverseVector() {
            return Coordinate.Vector.Y;
        }
    },
    WEST {
        @Override
        public Coordinate.Vector getVector() {
            return Coordinate.Vector.X_REVERSE;
        }

        @Override
        public Coordinate.Vector getReverseVector() {
            return Coordinate.Vector.X;
        }
    };

    public abstract Coordinate.Vector getVector();
    public abstract Coordinate.Vector getReverseVector();
}
