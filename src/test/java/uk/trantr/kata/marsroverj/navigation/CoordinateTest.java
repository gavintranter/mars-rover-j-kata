package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @ParameterizedTest(name = "Case: {index} -> Vector {0} Will be transformed by {1} to give {2}")
    @CsvSource({"1/1, 0/1, 1/2",
                "1/1, 0/-1, 1/0",
                "1/1, 1/0, 2/1",
                "1/1, -1/0, 0/1"})
    void willAddCoordinates(@ConvertWith(CoordinateConverter.class) Coordinate initial,
                            @ConvertWith(CoordinateConverter.class) Coordinate newCoordinate,
                            @ConvertWith(CoordinateConverter.class) Coordinate result) {

        Coordinate actual = initial.plus(newCoordinate);

        assertThat(actual).isEqualTo(result);
    }

    @Test
    void willAdjustCoordinate() {
        Coordinate initial = Coordinate.ONE_ONE;
        Coordinate expected = Coordinate.at(2, 3);

        Coordinate actual = initial.adjustBy(x -> x + 1, y -> y + 2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void willReuseCommonCoordinates() {
        Coordinate a = Coordinate.ZER0_ZERO;
        Coordinate b = Coordinate.at(0, 0);

        Coordinate c = Coordinate.ZERO_ONE;
        Coordinate d = Coordinate.at(0, 1);

        Coordinate e = Coordinate.ONE_ZERO;
        Coordinate f = Coordinate.at(1, 0);

        Coordinate g = Coordinate.ONE_ONE;
        Coordinate h = Coordinate.at(1, 1);

        assertThat(a == b).isTrue();
        assertThat(c == d).isTrue();
        assertThat(e == f).isTrue();
        assertThat(g == h).isTrue();
    }
}