package uk.trantr.kata.marsroverj;

public enum Command {

    F{
        @Override
        public Location translateFrom(Location location) {
            int y = location.getY();
            y = location.getHeading().getVector().apply(y);
            return new Location(location.getX(), y, location.getHeading());
        }
    },
    B{
        @Override
        public Location translateFrom(Location location) {
            int y = location.getY();
            y = location.getHeading().getReverseVector().apply(y);
            return new Location(location.getX(), y, location.getHeading());
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)).toUpperCase());
    }

    public abstract Location translateFrom(Location location);
}
