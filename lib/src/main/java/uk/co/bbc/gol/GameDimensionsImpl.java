package uk.co.bbc.gol;

class GameDimensionsImpl implements GameDimensions {
    private final Integer minX;
    private final Integer minY;
    private final Integer maxX;
    private final Integer maxY;

    GameDimensionsImpl(Game game) {
        minX = game.aliveCells.stream().map(cell -> cell.x).reduce(Math::min).orElse(0);
        minY = game.aliveCells.stream().map(cell -> cell.y).reduce(Math::min).orElse(0);
        maxX = game.aliveCells.stream().map(cell -> cell.x).reduce(Math::max).orElse(0);
        maxY = game.aliveCells.stream().map(cell -> cell.y).reduce(Math::max).orElse(0);
    }

    GameDimensionsImpl(Integer minX, Integer minY, Integer maxX, Integer maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int minX() {
        return this.minX;
    }

    public int maxX() {
        return this.maxX;
    }

    public int minY() {
        return this.minY;
    }

    public int maxY() {
        return this.maxY;
    }
}

