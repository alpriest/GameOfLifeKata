package uk.co.bbc.gol;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Game {
    final Set<Cell> aliveCells;

    Game(Set<Cell> aliveCells) {
        this.aliveCells = aliveCells;
    }

    Game iterate() {
        Stream<Cell> cellsToRemainAlive = aliveCells
                .stream()
                .filter(cell -> aliveNeighbourCount(cell) >= 2 && aliveNeighbourCount(cell) < 4);

        Stream<Cell> cellsToBecomeAlive = aliveCells
                .stream()
                .flatMap(this::cellsThatShouldBecomeAlive);

        Set<Cell> cellsForNewGame = Stream.concat(cellsToRemainAlive, cellsToBecomeAlive)
                .collect(Collectors.toSet());

        return new Game(cellsForNewGame);
    }

    private long aliveNeighbourCount(final Cell cell) {
        return aliveCells.stream()
                .filter(gameCell -> cell.neighbours().contains(gameCell))
                .count();
    }

    private Stream<Cell> cellsThatShouldBecomeAlive(final Cell cell) {
        return cell.neighbours()
                .stream()
                .filter(neighbouringCell -> aliveNeighbourCount(neighbouringCell) == 3);
    }

    boolean cellAt(int x, int y) {
        return aliveCells.stream().anyMatch(cell -> cell.x == x && cell.y == y);
    }
}
