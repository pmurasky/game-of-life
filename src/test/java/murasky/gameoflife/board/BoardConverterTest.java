package murasky.gameoflife.board;

import com.ford.game.common.BoardCoordinate;
import com.ford.game.common.GameOfLifeBoard;
import murasky.gameoflife.assertion.BoardAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static murasky.gameoflife.cell.CellState.ALIVE;
import static murasky.gameoflife.cell.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardConverterTest {

    private BoardCreator boardCreator = new BoardCreator();

    @Test
    public void canConvertGameOfLifeBoardToBoard() {
        List<BoardCoordinate> deadCoordinates = Lists.newArrayList(new BoardCoordinate(0, 0),
                new BoardCoordinate(0, 1), new BoardCoordinate(1, 1));
        List<BoardCoordinate> aliveCoordinates = Lists.newArrayList(new BoardCoordinate(1, 0));
        GameOfLifeBoard gameOfLifeBoard = new GameOfLifeBoard(aliveCoordinates, deadCoordinates);
        Board expectedBoard = boardCreator.create(DEAD, DEAD, ALIVE, DEAD);

        Board board = BoardConverter.convertGameOfLifeBoardToBoard(gameOfLifeBoard);

        BoardAssert.assertThat(board).boardIsEqual(expectedBoard);
    }

    @Test
    public void canConvertBoardToGameOfLifeBoard(){
        Board inputBoard = boardCreator.create(DEAD, DEAD, ALIVE, DEAD);

        GameOfLifeBoard gameOfLifeBoard = BoardConverter.convertBoardToGameOfLifeBoard(inputBoard);

        assertThat(gameOfLifeBoard.getDeadBoardCoordinates()).containsExactlyInAnyOrder(new BoardCoordinate(0, 0),
                new BoardCoordinate(0, 1), new BoardCoordinate(1, 1));
        assertThat(gameOfLifeBoard.getLiveBoardCoordinates()).containsExactlyInAnyOrder(new BoardCoordinate(1,0));
    }
}
