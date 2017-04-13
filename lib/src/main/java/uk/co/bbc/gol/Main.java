package uk.co.bbc.gol;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        final Game game = new Game(new HashSet<>(Arrays.asList(new Cell(1, 1), new Cell(1, 2), new Cell(1, 3))));
        new Main().iterate(game, 0);
    }

    private void iterate(Game game, int count) {
        if (count < 10) {
            new Painter().draw(game);
            iterate(game.iterate(), count + 1);
        }
    }
}