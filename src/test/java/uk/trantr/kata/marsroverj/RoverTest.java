package uk.trantr.kata.marsroverj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import uk.trantr.kata.marsroverj.navigation.Coordinate;
import uk.trantr.kata.marsroverj.navigation.Location;
import uk.trantr.kata.marsroverj.navigation.NavigationChart;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.navigation.Heading.NORTH;

class RoverTest {

    private static final Location INITIAL_LOCATION = new Location(1, 1, NORTH);

    private Rover rover;
    private NavigationChart chart;

    @BeforeEach
    void setUp() {
        Set<Coordinate> obstacles = new HashSet<>();
        obstacles.add(new Coordinate(2, 1));

        chart = new NavigationChart(2, 4, obstacles);
        rover = new Rover(INITIAL_LOCATION, chart);
    }

    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to be at {1}")
    @CsvSource({"ffrffrffrffr",
                "fflfflfflffl",
                "bbrbbrbbrbbr",
                "bblbblbblbbl"})
    void roverTravelInASquareShapeReturningToItsOrigin(String commandSequence) {
        rover.process(commandSequence);

        assertThat(rover).isEqualTo(new Rover(INITIAL_LOCATION, chart));
    }

    @Test
    void willGoOnMoreComplexJourneyReturningToOrigin() {
        rover.process("frflfrflfrfrffbrflffrffr");

        assertThat(rover).isEqualTo(new Rover(INITIAL_LOCATION, chart));
    }

    @Test
    void willAbortWhenEncounteringUnknownCommand() {
        rover.process("ffAff");

        assertThat(rover).isEqualTo(new Rover(new Location(1, 3, NORTH), chart));
    }

    @Test
    void willCircumnavigation() {
        rover.process("ffff");

        assertThat(rover).isEqualTo(new Rover(new Location(1, 1, NORTH), chart));
    }
}