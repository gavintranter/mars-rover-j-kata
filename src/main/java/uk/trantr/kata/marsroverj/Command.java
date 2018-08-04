package uk.trantr.kata.marsroverj;

public enum Command {

    f {
        @Override
        public Location translateFrom(Location location) {
            return location.translatingY(location.getHeading().getVector());
        }
    },
    b {
        @Override
        public Location translateFrom(Location location) {
            return location.translatingY(location.getHeading().getReverseVector());
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)));
    }

    public abstract Location translateFrom(Location location);
}
