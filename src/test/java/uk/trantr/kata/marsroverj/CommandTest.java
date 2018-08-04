package uk.trantr.kata.marsroverj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    // This test cheats a little by taking advantage of the implicit char <-> int conversions
    @ParameterizedTest
    @CsvSource({"f, F", "b, B"})
    void willParseKnownCommands(char symbol, Command expectedCommand) {
        assertThat(Command.parse(symbol)).isSameAs(expectedCommand);
    }

    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to be at {2}")
    @CsvSource({"f, 1/1/NORTH, 1/2/NORTH",
            "b, 1/1/NORTH, 1/0/NORTH",
            "f, 1/1/SOUTH, 1/0/SOUTH"})
    void willTranslateLocationAppropriateToHeading(char symbol,
                                                   @ConvertWith(LocationConverter.class) Location initialLocation,
                                                   @ConvertWith(LocationConverter.class) Location finalLocation) {

        Location actualLocation = Command.parse(symbol).translateFrom(initialLocation);

        assertThat(actualLocation).isEqualTo(finalLocation);
    }

    @Test
    void willIgnoreUnknownCommands() {
        Throwable thrown = Assertions.catchThrowable(() -> Command.parse('A'));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}