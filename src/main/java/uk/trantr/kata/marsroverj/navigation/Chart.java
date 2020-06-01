package uk.trantr.kata.marsroverj.navigation;

public interface Chart {
    Location transformToChart(Location location);

    Traversable determineIfPassable(Location location);
}
