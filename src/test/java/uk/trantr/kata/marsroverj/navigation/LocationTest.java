package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.navigation.Heading.NORTH;

class LocationTest {

    @Test
    void willTransformLocation() {
        Location initialLocation = new Location(1, 1, NORTH);

        Location location = initialLocation.moveTo(new Coordinate(1, 0));

        assertThat(location).isNotEqualTo(initialLocation)
                .isEqualTo(new Location(2, 1, NORTH));
    }
}