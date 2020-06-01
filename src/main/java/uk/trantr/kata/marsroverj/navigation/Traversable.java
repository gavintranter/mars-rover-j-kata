package uk.trantr.kata.marsroverj.navigation;

public final class Traversable {
    private enum Status {SAFE, UNSAFE}

    private final Status status;
    private final Location location;

    static Traversable safeToProceed(Location location) {
        return new Traversable(Status.SAFE, location);
    }

    static Traversable unsafeToProceed(Location location) {
        return new Traversable(Status.UNSAFE, location);
    }

    private Traversable(Status status, Location location) {
        this.status = status;
        this.location = location;
    }

    public boolean isSafe() {
        return status == Status.SAFE;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "TranslationResult{location=" + location + ", transverable=" + status + '}';
    }
}
