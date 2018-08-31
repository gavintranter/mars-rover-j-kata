package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MapTest {

    private final Set<Coordinate> obstacles = new HashSet<>();
    private final Map map = new Map(5, 4, obstacles);

    @ParameterizedTest(name = "Case: {index} -> Will adjust {0} to {1}")
    @CsvSource({"1/5, 1/1",
                "1/3, 1/3",
                "1/0, 1/4",
                "6/1, 1/1",
                "3/1, 3/1",
                "0/1, 5/1"})
    void willAdjustOnlyCoordinateBeyondExtents(@ConvertWith(CoordinateConverter.class) Coordinate newTopCoordinate,
                                           @ConvertWith(CoordinateConverter.class) Coordinate expectedBottomCoordinate) {

        Coordinate adjustedCoordinate = map.moveTo(newTopCoordinate);

        assertThat(adjustedCoordinate).isEqualTo(expectedBottomCoordinate);
    }

    @Test
    void willReportCoordinateIsFreeOfDanger() {
        Coordinate coordinate = new Coordinate(1, 1);

        boolean result = map.isSafe(coordinate);

        assertThat(result).isTrue();
    }

    @Test
    void willReportCoordinateIsNotFreeOfDanger() {
        obstacles.add(new Coordinate(1, 1));
        Coordinate coordinate = new Coordinate(1, 1);

        boolean result = map.isSafe(coordinate);

        assertThat(result).isFalse();
    }
}