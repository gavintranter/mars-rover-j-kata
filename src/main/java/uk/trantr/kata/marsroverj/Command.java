package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

enum Command {

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
