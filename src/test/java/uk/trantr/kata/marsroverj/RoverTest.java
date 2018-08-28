package uk.trantr.kata.marsroverj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import uk.trantr.kata.marsroverj.navigation.Location;
import uk.trantr.kata.marsroverj.navigation.LocationConverter;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.navigation.Heading.NORTH;

class RoverTest {

    private static final Location INITIAL_LOCATION = new Location(1, 1, NORTH);

    Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover(INITIAL_LOCATION);
    }


    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to be at {1}")
    @CsvSource({"ff, 1/3/NORTH",
                "bb, 1/-1/NORTH"})
    void willMoveRover(String commandSequence,
                       @ConvertWith(LocationConverter.class) Location finalLocation) {

        rover.process(commandSequence);

        assertThat(rover).isEqualTo(new Rover(finalLocation));
    }

    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to be at {1}")
    @CsvSource({"ffrffrffrffr",
                "fflfflfflffl",
                "bbrbbrbbrbbr",
                "bblbblbblbbl"})
    void roverTravelInASquareShapeReturningToItsOrigin(String commandSequence) {
        rover.process(commandSequence);

        assertThat(rover).isEqualTo(new Rover(INITIAL_LOCATION));
    }

    @Test
    void willGoOnMoreComplexJourneyReturningToOrigin() {
        rover.process("frflfrflfrfrffbrflffrffr");

        assertThat(rover).isEqualTo(new Rover(INITIAL_LOCATION));
    }
}