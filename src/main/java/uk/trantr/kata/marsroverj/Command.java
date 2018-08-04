package uk.trantr.kata.marsroverj;

import static uk.trantr.kata.marsroverj.Heading.NORTH;

public enum Command {

    F,
    B;

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)).toUpperCase());
    }

    public Location translateFrom(Location location) {

        Location newLocation = null;

        if (this == F) {
            newLocation = new Location(1, location.getY() + 1, NORTH);
        }
        else if (this == B) {
            newLocation = new Location(1, location.getY() - 1, NORTH);
        }


        return newLocation;
    }
}
