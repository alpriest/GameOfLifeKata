package uk.co.bbc.gol;

/**
 * Created by priesa24 on 13/04/2017.
 */
class Painter {
    public void draw(Game game) {
        final GameDimensions gameDimensions = new GameDimensionsImpl(game);
        final GameDimensions wrappedDimensions = new PaddedGameDimensions(gameDimensions);
        paintCell(game, wrappedDimensions, wrappedDimensions.minX(), wrappedDimensions.minY());
    }

    private void paintCell(final Game game, final GameDimensions gameDimensions, int x, int y) {
        if (game.cellAt(x, y)) {
            System.out.print("X ");
        } else {
            System.out.print(". ");
        }

        if (x < gameDimensions.maxX()) {
            paintCell(game, gameDimensions, x+1, y);
        } else {
            if (y >= gameDimensions.maxY()) {
                System.out.println();
                System.out.println();
            } else {
                System.out.println();
                paintCell(game, gameDimensions, gameDimensions.minX(), y + 1);
            }
        }
    }
}
