package murasky.gameoflife.neighbor;

import murasky.gameoflife.CellState;
import murasky.gameoflife.board.Board;
import murasky.gameoflife.board.Coordinate;
import murasky.gameoflife.board.OffsetCoordinate;
import murasky.gameoflife.cell.CellIdentifier;

import java.util.Arrays;
import java.util.List;

public class NeighborFinder {
    public int findLiveNeighborCount(Board board, Coordinate coordinate) {

        int numberOfLiveNeighbor = 0;
        CellIdentifier cellIdentifier = new CellIdentifier();
        List<OffsetCoordinate> neighborsOffsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, board.getCells().length);

        for (OffsetCoordinate offsetCoordinate : neighborsOffsetCoordinates) {
            System.out.println(offsetCoordinate.getX() +":"+offsetCoordinate.getY());
            if (board.getCells()[coordinate.getX()+offsetCoordinate.getX()][coordinate.getY()+offsetCoordinate.getY()].equals(CellState.ALIVE)){
                    numberOfLiveNeighbor++;
            }
        }
        return numberOfLiveNeighbor;
    }
}
