package murasky.gameoflife.board;

import murasky.gameoflife.cell.CellState;

public class BoardCreator {
    public Board create(CellState... cellStates) {

        int x = 0;
        int y = 0;
        int lengthOfSideCounter = 0;
        int lengthOfSide = (int) Math.sqrt(cellStates.length);
        CellState[][] cells = new CellState[lengthOfSide][lengthOfSide];
        for (CellState cellState : cellStates) {
            cells[x][y] = cellState;
            lengthOfSideCounter++;
            y++;
            if (lengthOfSideCounter >= lengthOfSide) {
                lengthOfSideCounter = 0;
                y = 0;
                x++;
            }
        }
        return new Board(cells);
    }
}
