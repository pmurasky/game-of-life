package murasky.gameoflife.board;

import com.ford.game.common.BoardCoordinate;
import com.ford.game.common.GameOfLifeBoard;
import murasky.gameoflife.cell.CellState;

import java.util.ArrayList;
import java.util.List;

import static murasky.gameoflife.cell.CellState.ALIVE;
import static murasky.gameoflife.cell.CellState.DEAD;

public class BoardConverter {
    public static Board convertGameOfLifeBoardToBoard(GameOfLifeBoard gameOfLifeBoard) {

        int lengthOfSide = (int) Math.sqrt(gameOfLifeBoard.getTotalNumberOfCells());
        CellState[][] cells = new CellState[lengthOfSide][lengthOfSide];

        for (BoardCoordinate boardCoordinate : gameOfLifeBoard.getDeadBoardCoordinates()) {
            cells[boardCoordinate.getX()][boardCoordinate.getY()] = DEAD;
        }

        for (BoardCoordinate boardCoordinate : gameOfLifeBoard.getLiveBoardCoordinates()) {
            cells[boardCoordinate.getX()][boardCoordinate.getY()] = ALIVE;
        }


        return new Board(cells);
    }

    public static GameOfLifeBoard convertBoardToGameOfLifeBoard(Board inputBoard) {
        List<BoardCoordinate> deadBoardCoordinates = new ArrayList();
        List<BoardCoordinate> aliveBoardCoordinates = new ArrayList<>();
        int lengthOfSide = inputBoard.getCells().length;
        for (int x = 0; x < lengthOfSide; x++) {
            for (int y = 0; y < lengthOfSide; y++) {
                BoardCoordinate boardCoordinate = new BoardCoordinate(x, y);
                if (inputBoard.getCells()[x][y] == ALIVE) {
                    aliveBoardCoordinates.add(boardCoordinate);
                } else {
                    deadBoardCoordinates.add(boardCoordinate);
                }
            }
        }
        return new GameOfLifeBoard(aliveBoardCoordinates, deadBoardCoordinates);
    }
}
