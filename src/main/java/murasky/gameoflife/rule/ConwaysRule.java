package murasky.gameoflife.rule;

import murasky.gameoflife.cell.CellState;

import static murasky.gameoflife.cell.CellState.ALIVE;
import static murasky.gameoflife.cell.CellState.DEAD;

public class ConwaysRule {


    public CellState apply(CellState currentCellState, int liveNeighbors){

        if (liveNeighbors < 2 || liveNeighbors > 3 ||
                (currentCellState == DEAD && liveNeighbors != 3)){
            return DEAD;
        }
        return ALIVE;
    }
}
