package uk.trantr.kata.marsroverj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import uk.trantr.kata.marsroverj.navigation.Location;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {


    @ParameterizedTest
    @CsvSource({"f, f", "b, b"})
    void willParseKnownCommands(char symbol, Command expectedCommand) {
        assertThat(Command.parse(symbol)).isSameAs(expectedCommand);
    }

    // The parameterised test cheat a little by taking advantage of the implicit char <-> int conversions

    @Test
    void willIgnoreUnknownCommands() {
        Throwable thrown = Assertions.catchThrowable(() -> Command.parse('a'));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to moe from {1} to {2}")
    @CsvSource({"f, 1/1/NORTH, 1/2/NORTH",
            "b, 1/1/NORTH, 1/0/NORTH",
            "f, 1/1/SOUTH, 1/0/SOUTH",
            "b, 1/1/SOUTH, 1/2/SOUTH",
            "f, 1/1/EAST, 2/1/EAST",
            "b, 1/1/EAST, 0/1/EAST",
            "f, 1/1/WEST, 0/1/WEST",
            "b, 1/1/WEST, 2/1/WEST"})
    void willTranslateLocationAppropriateToHeading(char symbol,
                                                   @ConvertWith(LocationConverter.class) Location initialLocation,
                                                   @ConvertWith(LocationConverter.class) Location finalLocation) {

        Location actualLocation = Command.parse(symbol).translateFrom(initialLocation);

        assertThat(actualLocation).isEqualTo(finalLocation);
    }

    @ParameterizedTest
    @ValueSource(chars = {'F', 'B', 'R', 'E'})
    void willIgnoreUppercaseRepresentationsOfCommands(char symbol) {
        Throwable thrown = Assertions.catchThrowable(() -> Command.parse(symbol));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}