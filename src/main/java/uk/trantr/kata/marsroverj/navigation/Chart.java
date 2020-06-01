package uk.trantr.kata.marsroverj.navigation;

public interface Chart {
    Location determineActualLocation(Location location);

    Traversable isSafe(Location location);
}
