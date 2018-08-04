package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

public enum Command {

    f {
        @Override
        public Location translateFrom(Location location) {
            return location.translateTo(location.getHeading().getVector());
        }
    },
    b {
        @Override
        public Location translateFrom(Location location) {
            return location.translateTo(location.getHeading().getReverseVector());
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)));
    }

    public abstract Location translateFrom(Location location);
}
