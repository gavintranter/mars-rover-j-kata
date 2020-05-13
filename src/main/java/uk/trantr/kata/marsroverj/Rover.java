package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Location;
import uk.trantr.kata.marsroverj.navigation.NavigationChart;

import java.util.Objects;

public final class Rover {
    private final NavigationChart chart;
    private Location location;

    public Rover(Location location, NavigationChart chart) {
        this.location = location;
        this.chart = chart;
    }

    public void process(String commandSequence) {
        try {
             commandSequence.chars()
                 .mapToObj(command -> Command.parse(command).execute(location))
                 .map(chart::determineActualLocation)
                 .takeWhile(chart::isSafe)
                 .forEach(newLocation -> location = newLocation);
        }
        catch (IllegalArgumentException e) {
            // Ignore unknown commands
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

        Rover rover = (Rover) o;

        if (!location.equals(rover.location)) {
            return false;
        }
        return chart.equals(rover.chart);
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
