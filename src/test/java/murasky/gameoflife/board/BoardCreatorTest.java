package murasky.gameoflife.board;

import murasky.gameoflife.cell.CellState;
import murasky.gameoflife.assertion.BoardAssert;
import org.junit.jupiter.api.Test;

import static murasky.gameoflife.cell.CellState.ALIVE;
import static murasky.gameoflife.cell.CellState.DEAD;

public class BoardCreatorTest {

    @Test
    public void canCreateBoard2x2WithState() {
        BoardCreator boardCreator = new BoardCreator();
        CellState[][] expectedCells = {{ALIVE, DEAD}, {DEAD, ALIVE}};
        Board expectedBoard = new Board(expectedCells);

        Board actualBoard = boardCreator.create(ALIVE, DEAD, DEAD, ALIVE);

        BoardAssert.assertThat(actualBoard).boardIsEqual(expectedBoard);
    }

    @Test
    public void canCreateBoard3x3WithState() {
        BoardCreator boardCreator = new BoardCreator();
        CellState[][] expectedCells = {{ALIVE, DEAD, DEAD},
                                       {DEAD, ALIVE, ALIVE},
                                       {DEAD, DEAD, ALIVE} };
        Board expectedBoard = new Board(expectedCells);

        Board actualBoard = boardCreator.create(ALIVE, DEAD, DEAD,
                                                DEAD, ALIVE, ALIVE,
                                                DEAD, DEAD, ALIVE);

        BoardAssert.assertThat(actualBoard).boardIsEqual(expectedBoard);
    }
}
