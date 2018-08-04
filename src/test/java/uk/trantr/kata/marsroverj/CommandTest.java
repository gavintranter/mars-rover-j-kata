package uk.trantr.kata.marsroverj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.trantr.kata.marsroverj.Heading.NORTH;

class CommandTest {

    // This test cheats a little by taking advantage of the implicit char <-> int conversions
    @ParameterizedTest
    @CsvSource({"f, F", "b, B"})
    void willParseKnownCommands(char symbol, Command expectedCommand) {
        assertThat(Command.parse(symbol)).isSameAs(expectedCommand);
    }

    @ParameterizedTest(name = "Case: {index} -> Command: {0} will cause Rover to be at {1}")
    @CsvSource({"f, 1/2/NORTH",
            "b, 1/0/NORTH"})
    void willTranslateLocationAppropriateToHeading() {
        Location initialLocation = new Location(1, 1, NORTH);
        Location expectedLocation = new Location(1, 2, NORTH);

        Location actualLocation = Command.F.translateFrom(initialLocation);

        assertThat(actualLocation).isEqualTo(expectedLocation);
    }

    @Test
    void willIgnoreUnknownCommands() {
        Throwable thrown = Assertions.catchThrowable(() -> Command.parse('A'));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}