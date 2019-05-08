package murasky.gameoflife.board;

import murasky.gameoflife.CellState;
import murasky.gameoflife.neighbor.NeighborFinder;
import murasky.gameoflife.rule.ConwaysRule;

public class BoardNextStateGenerator {

    private NeighborFinder neighborFinder;
    private ConwaysRule conwaysRule;

    public BoardNextStateGenerator(NeighborFinder neighborFinder, ConwaysRule conwaysRule) {
        this.neighborFinder = neighborFinder;
        this.conwaysRule = conwaysRule;
    }

    public Board generatorNextBoardState(Board inputBoard) {
        int lengthOfSide = inputBoard.getCells().length;
        CellState[][] nextGenerationCells = new CellState[lengthOfSide][lengthOfSide];
        for (int x = 0; x < lengthOfSide; x++){
            for ( int y = 0; y < lengthOfSide; y++){
                int liveNeighbors = neighborFinder.findLiveNeighborCount(inputBoard,new Coordinate(x,y));
                CellState nextCellState = conwaysRule.apply(inputBoard.getCells()[x][y], liveNeighbors);
                nextGenerationCells[x][y] = nextCellState;
            }
        }
        return new Board(nextGenerationCells);
    }
}
