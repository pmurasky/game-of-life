package murasky.gameoflife.rule;

import murasky.gameoflife.CellState;

import static murasky.gameoflife.CellState.ALIVE;
import static murasky.gameoflife.CellState.DEAD;

public class ConwaysRule {


    public CellState apply(CellState currentCellState, int liveNeighbors){

        if (liveNeighbors < 2 || liveNeighbors > 3 ||
                (currentCellState == DEAD && liveNeighbors != 3)){
            return DEAD;
        }
        return ALIVE;
    }
}
