package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Chart;
import uk.trantr.kata.marsroverj.navigation.Location;
import uk.trantr.kata.marsroverj.navigation.Traversable;

import java.nio.CharBuffer;
import java.util.Objects;

public final class Rover {
    private final Chart chart;
    private Location location;
    private boolean obstacleEncountered = false;

    public Rover(Location location, Chart chart) {
        this.location = location;
        this.chart = chart;
    }

    public void process(char[] commandSequence) {
        obstacleEncountered = false;
        try {
             CharBuffer.wrap(commandSequence).chars()
                 .mapToObj(command -> Command.parse((char)command).calculateLocation(location))
                 .map(chart::transformToChart)
                 .map(chart::determineIfPassable)
                 .forEach(this::accept);
        }
        catch (IllegalArgumentException e) {
            // Ignore unknown commands
        }
    }

    private void accept(Traversable newLocation) {
        if (!obstacleEncountered) {
            if (newLocation.isSafe()) {
                location = newLocation.getLocation();
            } else {
                obstacleEncountered = true;
                System.err.println("Obstacle encountered at " + newLocation.getLocation());
            }
        }
    }

    public Location reportLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rover)) {
            return false;
        }

        Rover other = (Rover) o;

        if (!location.equals(other.location)) {
            return false;
        }
        return chart.equals(other.chart);
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
