package uk.trantr.kata.marsroverj;

public enum Command {

    F,
    B;

    public static Command parse(int symbol) {
        return valueOf(String.valueOf(((char)symbol)).toUpperCase());
    }

}
