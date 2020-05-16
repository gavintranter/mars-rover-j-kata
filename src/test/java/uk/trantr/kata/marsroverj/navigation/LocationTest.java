package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.navigation.Heading.*;

class LocationTest {

    @Test
    void willChangeLocationForward() {
        Location initial = new Location(1, 1, N);

        Location actual = initial.forward();

        assertThat(actual).isEqualTo(new Location(1, 2, N));
    }

    @Test
    void willChangeLocationBackwards() {
        Location initial = new Location(1, 1, N);

        Location actual = initial.backwards();

        assertThat(actual).isEqualTo(new Location(1, 0, N));
    }

    @Test
    void willChangeDirectionClockwise() {
        Location initial = new Location(1, 1, N);

        Location actual = initial.changeHeadingClockwise();

        assertThat(actual).isEqualTo(new Location(1, 1, E));
    }

    @Test
    void willChangeDirectionAntiClockwise() {
        Location initial = new Location(1, 1, N);

        Location actual = initial.changeHeadingAnticlockwise();

        assertThat(actual).isEqualTo(new Location(1, 1, W));
    }
}