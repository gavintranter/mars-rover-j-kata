package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;

import java.util.Objects;

public final class Rover {
    private Location location;

    public Rover(Location location) {
        this.location = location;
    }

    public void process(String commandSequence) {
        try {
            commandSequence.chars()
                    .forEach(c -> location = Command.parse(c).executeAgainst(location));
        } catch (IllegalArgumentException e) {
            // Ignore unknown commands
        }
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
