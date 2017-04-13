# GameOfLifeKata

Functional programming exercise written in Java 8 using streams.

# Implementation Rules

No assignment, only initialisation.

This means:
- No for loops with e.g. i++
- No array[x] = y
- No .set(x)
- Only final variables
- Only final fields
- Only immutable data structures

# Game Rules
The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, each of which is in one of two possible states, alive or dead, or "populated" or "unpopulated". Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:
	1	Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
	2	Any live cell with two or three live neighbours lives on to the next generation.
	3	Any live cell with more than three live neighbours dies, as if by overpopulation.
	4	Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
