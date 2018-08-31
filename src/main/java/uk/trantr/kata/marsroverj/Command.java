package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

enum Command {

    // Using unorthodox naming to reduce code required to determine invalid commands.
    // This removes the need for a list of the uppercase commands to be considered invalid,
    // allowing this enum to represent all the valid commands.
    f {
        @Override
        public Location execute(Location location) {
            return location.moveTo(location.getHeading().getVector());
        }
    },
    b {
        @Override
        public Location execute(Location location) {
            return location.moveTo(location.getHeading().getVector().adjustBy(x -> x * -1, y -> y * -1));
        }
    },
    r {
        @Override
        public Location execute(Location location) {
            return location.changeHeadingTo(location.getHeading().clockwise());
        }
    },
    l {
        @Override
        public Location execute(Location location) {
            return location.changeHeadingTo(location.getHeading().anticlockwise());
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)));
    }

    public abstract Location execute(Location location);
}
