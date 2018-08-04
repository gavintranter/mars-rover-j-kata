package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

public enum Command {

    f {
        @Override
        public Location executeAgainst(Location location) {
            return location.apply(location.getHeading().getVector());
        }
    },
    b {
        @Override
        public Location executeAgainst(Location location) {
            return location.apply(location.getHeading().getReverseVector());
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)));
    }

    public abstract Location executeAgainst(Location location);
}
