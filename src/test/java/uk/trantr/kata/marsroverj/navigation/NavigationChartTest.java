package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NavigationChartTest {

    private final Set<Coordinate> obstacles = new HashSet<>();
    private final NavigationChart navigationChart = new NavigationChart(5, 4, obstacles);

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
        Coordinate coordinate = Coordinate.ONE_ONE;

        boolean result = navigationChart.isSafe(coordinate);

        assertThat(result).isTrue();
    }

    @Test
    void willReportCoordinateIsNotFreeOfDanger() {
        obstacles.add(Coordinate.ONE_ONE);
        Coordinate coordinate = Coordinate.ONE_ONE;

        boolean result = navigationChart.isSafe(coordinate);

        assertThat(result).isFalse();
    }
}