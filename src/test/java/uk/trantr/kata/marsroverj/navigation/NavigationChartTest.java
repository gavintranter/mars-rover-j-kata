package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.navigation.Heading.NORTH;

class NavigationChartTest {

    private final Set<Coordinate> obstacles = new HashSet<>();
    private final Chart navigationChart = NavigationChart.create(5, 4, obstacles);

    @ParameterizedTest(name = "Case: {index} -> Will adjust {0} to {1}")
    @CsvSource({"1/5/NORTH, 1/1/NORTH",
                "1/3/SOUTH, 1/3/SOUTH",
                "1/0/WEST, 1/4/WEST",
                "6/1/EAST, 1/1/EAST",
                "3/1/EAST, 3/1/EAST",
                "0/1/EAST, 5/1/EAST"})
    void willAdjustOnlyCoordinateBeyondExtents(@ConvertWith(LocationConverter.class) Location newLocation,
                                           @ConvertWith(LocationConverter.class) Location expectedCoordinate) {

        Location adjustedLocation = navigationChart.determineActualLocation(newLocation);

        assertThat(adjustedLocation).isEqualTo(expectedCoordinate);
    }

    @Test
    void willReportCoordinateIsFreeOfDanger() {
        Location location = new Location(Coordinate.ONE_ONE, NORTH);

        boolean result = navigationChart.isSafe(location);

        assertThat(result).isTrue();
    }

    @Test
    void willReportCoordinateIsNotFreeOfDanger() {
        obstacles.add(Coordinate.ONE_ONE);
        Location location = new Location(Coordinate.ONE_ONE, NORTH);

        boolean result = navigationChart.isSafe(location);

        assertThat(result).isFalse();
    }
}