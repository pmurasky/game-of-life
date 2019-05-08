package murasky.gameoflife.board;

import murasky.gameoflife.assertion.BoardAssert;
import murasky.gameoflife.neighbor.NeighborFinder;
import murasky.gameoflife.rule.ConwaysRule;
import org.junit.jupiter.api.Test;

import static murasky.gameoflife.cell.CellState.ALIVE;
import static murasky.gameoflife.cell.CellState.DEAD;


public class BoardNextStateGeneratorTest {

    private BoardCreator boardCreator = new BoardCreator();
    private BoardNextStateGenerator boardNextStateGenerator =
            new BoardNextStateGenerator(new NeighborFinder(), new ConwaysRule());

    @Test
    public void canGenerateNextStateForBoard3x3() {
        Board board = boardCreator.create(ALIVE, ALIVE, DEAD,
                ALIVE, DEAD, ALIVE,
                DEAD, DEAD, ALIVE);

        Board expectedBoard = boardCreator.create(ALIVE, ALIVE, DEAD,
                ALIVE, DEAD, ALIVE,
                DEAD, ALIVE, DEAD);

        Board nextStateBoard = boardNextStateGenerator.generatorNextBoardState(board);

        BoardAssert.assertThat(nextStateBoard).boardIsEqual(expectedBoard);
    }
}
