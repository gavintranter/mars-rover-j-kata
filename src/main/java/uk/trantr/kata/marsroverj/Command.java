package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

enum Command {
    FORWARD {
        @Override
        public Location calculateLocation(Location location) {
            return location.forward();
        }
    },
    BACKWARD {
        @Override
        public Location calculateLocation(Location location) {
            return location.backwards();
        }
    },
    RIGHT {
        @Override
        public Location calculateLocation(Location location) {
            return location.changeHeadingClockwise();
        }
    },
    LEFT {
        @Override
        public Location calculateLocation(Location location) {
            return location.changeHeadingAnticlockwise();
        }
    };

    public static Command parse(char symbol) {
        return switch (symbol) {
            case 'f' -> FORWARD;
            case 'b' -> BACKWARD;
            case 'r' -> RIGHT;
            case 'l' -> LEFT;
            default -> throw new IllegalArgumentException("Unexpected value: " + symbol);
        };
    }

    public abstract Location calculateLocation(Location location);
}
