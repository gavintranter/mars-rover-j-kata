package uk.trantr.kata.marsroverj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.Heading.NORTH;

class RoverTest {

    private static final Location INITIAL_LOCATION = new Location(1, 1, NORTH);

    @Test
    void willMoveRoverForwards() {
        Rover rover = new Rover(INITIAL_LOCATION);

        rover.process("f");

        assertThat(rover).isEqualTo(new Rover(new Location(1, 2, NORTH)));
    }
}