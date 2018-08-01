package uk.trantr.kata.marsroverj;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.Heading.NORTH;

class RoverTest {

    private static final Location INITIAL_LOCATION = new Location(1, 1, NORTH);

    private final Rover rover = new Rover(INITIAL_LOCATION);

    @ParameterizedTest(name = "Command: {0} will cause Rover to be at {1}")
    @CsvSource({"f, 1/2/NORTH",
    "b, 1/0/NORTH",
    "a, 1/1/NORTH"})
    void willMoveRover(String commandSequence,
                       @ConvertWith(LocationConverter.class) Location finalLocation) {

        rover.process(commandSequence);

        assertThat(rover).isEqualTo(new Rover(finalLocation));
    }

}