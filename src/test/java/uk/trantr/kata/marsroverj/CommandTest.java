package uk.trantr.kata.marsroverj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import uk.trantr.kata.marsroverj.navigation.Location;
import uk.trantr.kata.marsroverj.navigation.LocationConverter;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    // The parameterised test cheat a little by taking advantage of the implicit char <-> int conversions
    @ParameterizedTest
    @CsvSource({"f, f", "b, b", "r, r", "l, l"})
    void willParseKnownCommands(char symbol, Command expectedCommand) {
        assertThat(Command.parse(symbol)).isSameAs(expectedCommand);
    }

    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to moe from {1} to {2}")
    @CsvSource({"f, 1/1/N, 1/2/N",
            "b, 1/1/N, 1/0/N",
            "f, 1/1/S, 1/0/S",
            "b, 1/1/S, 1/2/S",
            "f, 1/1/E, 2/1/E",
            "b, 1/1/E, 0/1/E",
            "f, 1/1/W, 0/1/W",
            "b, 1/1/W, 2/1/W",
            "r, 1/1/N, 1/1/E",
            "r, 1/1/E, 1/1/S",
            "r, 1/1/S, 1/1/W",
            "r, 1/1/W, 1/1/N",
            "l, 1/1/N, 1/1/W",
            "l, 1/1/W, 1/1/S",
            "l, 1/1/S, 1/1/E",
            "l, 1/1/E, 1/1/N"})
    void willTranslateLocationAppropriateToHeading(char symbol,
                                                   @ConvertWith(LocationConverter.class) Location initialLocation,
                                                   @ConvertWith(LocationConverter.class) Location finalLocation) {

        Location actualLocation = Command.parse(symbol).execute(initialLocation);

        assertThat(actualLocation).isEqualTo(finalLocation);
    }

    @ParameterizedTest
    @ValueSource(chars = {'F', 'B', 'R'})
    void willIgnoreUppercaseRepresentationsOfCommands(char symbol) {
        Throwable thrown = Assertions.catchThrowable(() -> Command.parse(symbol));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}