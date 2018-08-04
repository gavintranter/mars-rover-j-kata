package uk.trantr.kata.marsroverj;

import java.util.function.Function;

public enum Heading {
    NORTH {
        @Override
        public Function<Integer, Integer> getVector() {
            return (y) -> y + 1;
        }

        @Override
        public Function<Integer, Integer> getReverseVector() {
            return (y) -> y - 1;
        }
    },
    EAST {
        @Override
        public Function<Integer, Integer> getVector() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Function<Integer, Integer> getReverseVector() {
            throw new UnsupportedOperationException();
        }
    },
    SOUTH {
        @Override
        public Function<Integer, Integer> getVector() {
            return (y) -> y - 1;
        }

        @Override
        public Function<Integer, Integer> getReverseVector() {
            return (y) -> y + 1;
        }
    },
    WEST {
        @Override
        public Function<Integer, Integer> getVector() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Function<Integer, Integer> getReverseVector() {
            throw new UnsupportedOperationException();
        }
    };

    public abstract Function<Integer, Integer> getVector();
    public abstract Function<Integer, Integer> getReverseVector();
}
