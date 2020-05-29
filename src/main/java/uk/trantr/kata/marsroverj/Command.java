package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

enum Command {

    // Using unorthodox naming to reduce code required to determine invalid commands.
    // This removes the need for a list of the uppercase commands to be considered invalid,
    // allowing this enum to represent all the valid commands.
    f {
        @Override
        public Location execute(Location location) {
            return location.forward();
        }
    },
    b {
        @Override
        public Location execute(Location location) {
            return location.backwards();
        }
    },
    r {
        @Override
        public Location execute(Location location) {
            return location.changeHeadingClockwise();
        }
    },
    l {
        @Override
        public Location execute(Location location) {
            return location.changeHeadingAnticlockwise();
        }
    };

    public static Command parse(char symbol) {
        return valueOf(String.valueOf(((char)symbol)));
    }

    public abstract Location execute(Location location);
}
