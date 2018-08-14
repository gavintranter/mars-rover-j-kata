package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

enum Command {

    f {
        @Override
        public Location executeAgainst(Location location) {
            return location.apply(location.getHeading().getVector());
        }
    },
    b {
        @Override
        public Location executeAgainst(Location location) {
            return location.apply(location.getHeading().getVector().inverse());
        }
    },
    r {
        @Override
        public Location executeAgainst(Location location) {
            return null;
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)));
    }

    public abstract Location executeAgainst(Location location);
}
