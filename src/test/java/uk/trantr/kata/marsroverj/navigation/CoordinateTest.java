package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @ParameterizedTest(name = "Case: {index} -> Vector {0} Will transform {1} to {2}")
    @CsvSource({"0/1, 1/1, 1/2",
            "0/-1, 1/1, 1/0",
            "1/0, 1/1, 2/1",
            "-1/0, 1/1, 0/1"})
    void willAddCoordinates(@ConvertWith(CoordinateConverter.class) Coordinate newCoordinate,
                            @ConvertWith(CoordinateConverter.class) Coordinate initial,
                            @ConvertWith(CoordinateConverter.class) Coordinate result) {

        Coordinate actual = initial.add(newCoordinate);

        assertThat(actual).isEqualTo(result);
    }

    @ParameterizedTest(name = "Case: {index} -> Vector {0} -> {1}")
    @CsvSource({"0/0, 0/0",
            "0/1, 0/-1",
            "1/0, -1/0",
            "12/0, -12/0",
            "6/7, -6/-7"})
    void willInvertCoordinate(@ConvertWith(CoordinateConverter.class) Coordinate initial,
                              @ConvertWith(CoordinateConverter.class) Coordinate result) {

        Coordinate actual = initial.getInverse();

        assertThat(actual).isEqualTo(result);
    }
}