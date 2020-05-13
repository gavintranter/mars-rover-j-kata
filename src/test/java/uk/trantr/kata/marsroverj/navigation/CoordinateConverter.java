package uk.trantr.kata.marsroverj.navigation;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class CoordinateConverter implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (source instanceof Coordinate) {
            return source;
        }

        if (source instanceof String) {
            String location = (String) source;
            String[] split = location.split("/");

            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);

            return Coordinate.at(x, y);
        }

        throw new ArgumentConversionException(source + " is not a valid coordinate");
    }
}
