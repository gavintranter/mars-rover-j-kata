package uk.trantr.kata.marsroverj;

public enum Command {

    F{
        @Override
        public Location translateFrom(Location location) {
            return location.translatingY(location.getHeading().getVector());
        }
    },
    B{
        @Override
        public Location translateFrom(Location location) {
            return location.translatingY(location.getHeading().getReverseVector());
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)).toUpperCase());
    }

    public abstract Location translateFrom(Location location);
}
