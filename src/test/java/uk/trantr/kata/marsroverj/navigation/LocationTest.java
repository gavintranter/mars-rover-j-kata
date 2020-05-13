package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.navigation.Heading.*;

class LocationTest {

    @Test
    void willTransformLocation() {
        Location initialLocation = new Location(1, 1, NORTH);

        Location location = initialLocation.moveTo(Coordinate.ONE_ZERO);

        assertThat(location).isNotEqualTo(initialLocation)
                .isEqualTo(new Location(2, 1, NORTH));
    }

    @Test
    void willChangeLocationForward() {
        Location initial = new Location(1, 1, NORTH);

        Location actual = initial.forward();

        assertThat(actual).isEqualTo(new Location(1, 2, NORTH));
    }

    @Test
    void willChangeLocationBackwards() {
        Location initial = new Location(1, 1, NORTH);

        Location actual = initial.backwards();

        assertThat(actual).isEqualTo(new Location(1, 0, NORTH));
    }

    @Test
    void willChangeDirectionClockwise() {
        Location initial = new Location(1, 1, NORTH);

        Location actual = initial.changeHeadingClockwise();

        assertThat(actual).isEqualTo(new Location(1, 1, EAST));
    }

    @Test
    void willChangeDirectionAntiClockwise() {
        Location initial = new Location(1, 1, NORTH);

        Location actual = initial.changeHeadingAnticlockwise();

        assertThat(actual).isEqualTo(new Location(1, 1, WEST));
    }
}