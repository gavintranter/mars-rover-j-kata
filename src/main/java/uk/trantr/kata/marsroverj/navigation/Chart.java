package uk.trantr.kata.marsroverj.navigation;

public interface Chart {
    Location translateToChart(Location location);

    Traversable isSafe(Location location);
}
