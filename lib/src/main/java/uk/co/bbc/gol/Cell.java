package uk.co.bbc.gol;

import java.util.Arrays;
import java.util.List;

class Cell {
    final int x;
    final int y;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    List<Cell> neighbours() {
        return Arrays.asList(
                new Cell(this.x - 1, this.y - 1),
                new Cell(this.x, this.y - 1),
                new Cell(this.x + 1, this.y - 1),
                new Cell(this.x - 1, this.y),
                new Cell(this.x + 1, this.y),
                new Cell(this.x - 1, this.y + 1),
                new Cell(this.x, this.y + 1),
                new Cell(this.x + 1, this.y + 1)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        return y == cell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
