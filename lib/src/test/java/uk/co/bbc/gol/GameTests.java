package uk.co.bbc.gol;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GameTests {

    @Test
    public void testSingleCellDiesAfterEvolving() {
        Game game = new Game(Arrays.asList(new Cell(1, 1)));
        game = game.iterate();
        assertFalse(game.aliveCells.contains(new Cell(1, 1)));
    }

    @Test
    public void testSingleCellWithTwoNeighboursLivesAfterEvolving() {
        Game game = new Game(Arrays.asList(new Cell(0, 0), new Cell(1, 1), new Cell(2, 0)));
        game = game.iterate();
        assertTrue(game.aliveCells.contains(new Cell(1, 1)));
    }

    @Test
    public void testCellsWithFourNeighboursDieAfterEvolving() {
        Game game = new Game(Arrays.asList(new Cell(0, 0), new Cell(1, 0), new Cell(2, 0), new Cell(0, 1), new Cell(1, 1)));
        game = game.iterate();
        assertFalse(game.aliveCells.contains(new Cell(1, 0)));
        assertFalse(game.aliveCells.contains(new Cell(1, 1)));
    }

    @Test
    public void testCellWithThreeLiveNeighboursBecomesAlive() {
        Game game = new Game(Arrays.asList(new Cell(0, 0), new Cell(1, 0), new Cell(2, 0)));
        game = game.iterate();
        assertTrue(game.aliveCells.contains(new Cell(1, 1)));
        assertTrue(game.aliveCells.contains(new Cell(1, 0)));
    }

    @Test
    public void testHorizontalBarFlipsVertical() {
        Game game = new Game(Arrays.asList(new Cell(1, 1), new Cell(2, 1), new Cell(3, 1)));
        game = game.iterate();
        assertTrue(game.aliveCells.contains(new Cell(2, 0)));
        assertTrue(game.aliveCells.contains(new Cell(2, 1)));
        assertTrue(game.aliveCells.contains(new Cell(2, 2)));
    }
}