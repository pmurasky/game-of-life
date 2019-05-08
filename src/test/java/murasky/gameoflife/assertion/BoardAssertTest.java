package murasky.gameoflife.assertion;

import murasky.gameoflife.CellState;
import murasky.gameoflife.board.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static murasky.gameoflife.CellState.ALIVE;
import static murasky.gameoflife.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class BoardAssertTest {

    @Test
    public void verifyBoardsAreEqual() {
        CellState[][] cells = {{ALIVE, DEAD},
                                {DEAD, ALIVE}};
        Board expectedBoard = new Board(cells);
        Board actualBoard = new Board(cells);

        BoardAssert.assertThat(actualBoard).boardIsEqual(expectedBoard);
    }

    @Test
    public void boardsDoNotHaveEqualCells() {

        CellState[][] expectedCells = {{ALIVE, DEAD},
                                       {DEAD, ALIVE}};

        CellState[][] actualCells = {{ALIVE, DEAD},
                                    {DEAD, ALIVE},
                                    {DEAD, ALIVE}};


        Board expectedBoard = new Board(expectedCells);
        Board actualBoard = new Board(actualCells);

        try {
            BoardAssert.assertThat(actualBoard).boardIsEqual(expectedBoard);
            fail("Assertion failure should have occurred");
        } catch (AssertionError ae){
            assertThat(ae.getMessage()).isEqualTo("The actual board has 3 cells and expected board has 2 cells");
        }

    }

    @Test
    public void boardsCellStateDoNotMatch() {

        CellState[][] expectedCells = {{ALIVE, DEAD},
                                         {DEAD, DEAD}};

        CellState[][] actualCells = {{ALIVE, DEAD},
                                     {DEAD, ALIVE}};

        Board expectedBoard = new Board(expectedCells);
        Board actualBoard = new Board(actualCells);

        try {
            BoardAssert.assertThat(actualBoard).boardIsEqual(expectedBoard);
            fail("Assertion failure should have occurred");
        } catch (AssertionError ae){
            assertThat(ae.getMessage()).isEqualTo("The actual cell(1,1) is ALIVE while the expected cell(1,1) is DEAD");
        }

    }

}