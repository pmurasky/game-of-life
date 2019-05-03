package murasky.gameoflife.board;

import murasky.gameoflife.CellState;

public class Board {

    CellState[][] cells;

    public Board(CellState[][] cells) {
        this.cells = cells;
    }

    public CellState[][] getCells() {
        return cells;
    }
}
