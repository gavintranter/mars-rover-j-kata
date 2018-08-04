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
    void willTranslateLocationAppropriateToHeading(@ConvertWith(CoordinateConverter.class) Coordinate vector,
                                                   @ConvertWith(CoordinateConverter.class) Coordinate initital,
                                                   @ConvertWith(CoordinateConverter.class) Coordinate result) {

        Coordinate actual = initital.apply(vector);

        assertThat(actual).isEqualTo(result);
    }
}