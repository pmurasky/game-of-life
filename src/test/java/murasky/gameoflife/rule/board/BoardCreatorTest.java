package murasky.gameoflife.rule.board;

import murasky.gameoflife.CellState;
import murasky.gameoflife.board.Board;
import murasky.gameoflife.board.BoardCreator;
import org.junit.jupiter.api.Test;

import static murasky.gameoflife.CellState.ALIVE;
import static murasky.gameoflife.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardCreatorTest {

    @Test
    public void canCreateBoard2x2WithState() {
        BoardCreator boardCreator = new BoardCreator();
        CellState[][] expectedCells = {{ALIVE, DEAD}, {DEAD, ALIVE}};
        Board expectedBoard = new Board(expectedCells);

        Board actualBoard = boardCreator.create(ALIVE, DEAD, DEAD, ALIVE);

        assertThat(actualBoard).isEqualToComparingFieldByField(expectedBoard);
    }
}
