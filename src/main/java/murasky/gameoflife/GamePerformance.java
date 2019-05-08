package murasky.gameoflife;

import com.ford.game.common.GameOfLifeBoard;
import com.ford.game.common.flife.framework.GameOfLifeStringProfiler;
import murasky.gameoflife.board.Board;
import murasky.gameoflife.board.BoardConverter;
import murasky.gameoflife.board.BoardNextStateGenerator;
import murasky.gameoflife.neighbor.NeighborFinder;
import murasky.gameoflife.rule.ConwaysRule;

public class GamePerformance extends GameOfLifeStringProfiler<Board> {

    private BoardNextStateGenerator boardNextStateGenerator = new BoardNextStateGenerator(new NeighborFinder(), new ConwaysRule());

    @Override
    protected GameOfLifeBoard convertToBoard(Board board) {
        return BoardConverter.convertBoardToGameOfLifeBoard(board);
    }

    @Override
    protected Board calculateNextGen(Board board) {
        return boardNextStateGenerator.generatorNextBoardState(board);
    }

    @Override
    protected Board convertFromBoard(GameOfLifeBoard gameOfLifeBoard) {
        return BoardConverter.convertGameOfLifeBoardToBoard(gameOfLifeBoard);
    }
}
