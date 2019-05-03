package murasky.gameoflife.neighbor;

import murasky.gameoflife.board.Board;
import murasky.gameoflife.board.BoardCreator;
import murasky.gameoflife.board.Coordinate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static murasky.gameoflife.CellState.ALIVE;
import static murasky.gameoflife.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

class NeighborFinderTest {

    private BoardCreator boardCreator = new BoardCreator();
    private NeighborFinder neighborFinder = new NeighborFinder();


    @Test
    public void findNeighborsForMiddleCellOf3x3Board(){
        Board board = boardCreator.create(ALIVE, DEAD, DEAD,
                                          DEAD, ALIVE, ALIVE,
                                          DEAD, DEAD, ALIVE);

        int actual = neighborFinder.findLiveNeighborCount(board, new Coordinate(1,1));

        assertThat(actual).isEqualTo(3);
    }

    @Test
    public void findNeighborsForTopLeftCellOf3x3Board(){
        Board board = boardCreator.create(ALIVE, DEAD, DEAD,
                                          DEAD, ALIVE, ALIVE,
                                          DEAD, DEAD, ALIVE);

        int actual = neighborFinder.findLiveNeighborCount(board, new Coordinate(0,0));

        assertThat(actual).isEqualTo(1);
    }

}