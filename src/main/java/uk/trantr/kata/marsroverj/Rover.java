package uk.trantr.kata.marsroverj;

import uk.trantr.kata.marsroverj.navigation.Coordinate;
import uk.trantr.kata.marsroverj.navigation.Location;
import uk.trantr.kata.marsroverj.navigation.NavigationChart;

import java.util.Objects;

public final class Rover {
    private Location location;
    private final NavigationChart chart;

    public Rover(Location location, NavigationChart chart) {
        this.location = location;
        this.chart = chart;
    }

    public void process(String commandSequence) {
        try {
            for (char c : commandSequence.toCharArray()) {
                Location suggestedLocation = Command.parse(c).execute(location);
                Coordinate suggestedCoordinate = chart.moveTo(suggestedLocation.getCoordinate());

                if (!chart.isSafe(suggestedCoordinate)) {
                    break;
                }

                location = new Location(suggestedCoordinate, suggestedLocation.getHeading());
            }
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
