package uk.trantr.kata.marsroverj;

import static uk.trantr.kata.marsroverj.Heading.NORTH;
import static uk.trantr.kata.marsroverj.Heading.SOUTH;

public enum Command {

    F{
        @Override
        Location translate(Location location) {
            int y = location.getY();
            if (NORTH == location.getHeading()) {
                y = y + 1;
            }
            else if (SOUTH == location.getHeading()) {
                y = y - 1;
            }

            return new Location(location.getX(), y, location.getHeading());
        }
    },
    B{
        @Override
        Location translate(Location location) {
            int y = location.getY();
            if (NORTH == location.getHeading()) {
                y = y - 1;
            }
            else if (SOUTH == location.getHeading()) {
                y = y + 1;
            }

            return new Location(location.getX(), y, location.getHeading());
        }
    };

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)).toUpperCase());
    }

    public Location translateFrom(Location location) {

        Location newLocation = null;

        if (this == F) {
            newLocation = this.translate(location);
        }
        else if (this == B) {
            newLocation = this.translate(location);
        }


        return newLocation;
    }

    abstract Location translate(Location location);
}
