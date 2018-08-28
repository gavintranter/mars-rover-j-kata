package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

enum Command {

    f {
        @Override
        public Location execute(Location location) {
            return location.applyVectorTo(location.getHeading().getVector());
        }
    },
    b {
        @Override
        public Location execute(Location location) {
            return location.applyVectorTo(location.getHeading().getVector().getInverse());
        }
    },
    r {
        @Override
        public Location execute(Location location) {
            return location.changeHeadingTo(location.getHeading().clockWise());
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
