package uk.trantr.kata.marsroverj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uk.trantr.kata.marsroverj.navigation.Chart;
import uk.trantr.kata.marsroverj.navigation.Coordinate;
import uk.trantr.kata.marsroverj.navigation.EdgeWrapEastingAndNorthingChart;
import uk.trantr.kata.marsroverj.navigation.Location;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.navigation.Coordinate.at;
import static uk.trantr.kata.marsroverj.navigation.Heading.E;
import static uk.trantr.kata.marsroverj.navigation.Heading.N;

class RoverTest {

    private static final Location INITIAL_LOCATION = new Location(1, 1, N);

    private Rover rover;

    @BeforeEach
    void setUp() {
        Set<Coordinate> obstacles = new HashSet<>();
        obstacles.add(at(2, 2));

        Chart chart = EdgeWrapEastingAndNorthingChart.create(4, 4, obstacles);

        rover = new Rover(INITIAL_LOCATION, chart);
    }

    static Stream<Arguments> commandSequences() {
        return Stream.of(
                Arguments.of(new char[] {'f','f','r','f','f','r','f','f','r','f','f','r'}),
                Arguments.of(new char[] {'f','f','l','f','f','l','f','f','l','f','f','l'}),
                Arguments.of(new char[] {'b','b','r','b','b','r','b','b','r','b','b','r'}),
                Arguments.of(new char[] {'b','b','l','b','b','l','b','b','l','b','b','l'})
        );
    }
    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to be at {1}")
    @MethodSource("commandSequences")
    void roverTravelInASquareShapeReturningToItsOrigin(char[] commandSequence) {
        rover.process(commandSequence);

        assertThat(rover.reportLocation()).isEqualTo(INITIAL_LOCATION);
    }

    @Test
    void willGoOnMoreComplexJourneyReturningToOrigin() {
        rover.process(new char[]{'f', 'f', 'r', 'f', 'f', 'l', 'f', 'f', 'l', 'f', 'f', 'r'});

        assertThat(rover.reportLocation()).isEqualTo(INITIAL_LOCATION);
    }

    @Test
    void willAbortWhenEncounteringUnknownCommand() {
        rover.process(new char[] {'f','f','A','f','f'});

        assertThat(rover.reportLocation()).isEqualTo(new Location(1, 3, N));
    }

    @Test
    void willCircumnavigation() {
        rover.process(new char[] {'f','f','f','f'});

        assertThat(rover.reportLocation()).isEqualTo(new Location(1, 1, N));
    }

    @Test
    void willStopParsingCommandsWhenObstacleReached() {
        rover.process(new char[] {'f','r','f','l','f','r','f'});

        assertThat(rover.reportLocation()).isEqualTo(new Location(1, 2, E));
    }
}