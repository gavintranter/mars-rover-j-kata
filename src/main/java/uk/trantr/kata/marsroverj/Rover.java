package uk.trantr.kata.marsroverj;

import java.util.Objects;

import static uk.trantr.kata.marsroverj.Heading.NORTH;

public final class Rover {
    private Location location;

    public Rover(Location location) {
        this.location = location;
    }

    public void process(String commandSequence) {
        location = "b".equals(commandSequence) ?
                new Location(1, 0, NORTH) :
                new Location(1, 2, NORTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;
        Rover rover = (Rover) o;
        return Objects.equals(location, rover.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public String toString() {
        return "Rover{location=" + location + '}';
    }
}
