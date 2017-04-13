package uk.co.bbc.gol;

class PaddedGameDimensions implements GameDimensions
{
    private final GameDimensions gameDimensions;

    PaddedGameDimensions(final GameDimensions gameDimensions) {
        this.gameDimensions = new GameDimensionsImpl(gameDimensions.minX() - 1, gameDimensions.minY() - 1, gameDimensions.maxX() + 1, gameDimensions.maxY() + 1);
    }

    @Override
    public int minX() {
        return gameDimensions.minX();
    }

    @Override
    public int maxX() {
        return gameDimensions.maxX();
    }

    @Override
    public int minY() {
        return gameDimensions.minY();
    }

    @Override
    public int maxY() {
        return gameDimensions.maxY();
    }
}
