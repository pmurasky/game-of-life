package murasky.gameoflife.assertion;

import murasky.gameoflife.board.Board;
import org.assertj.core.api.AbstractAssert;

import static java.lang.String.format;

public class BoardAssert extends AbstractAssert<BoardAssert, Board> {

    public BoardAssert(Board actual) {
        super(actual, BoardAssert.class);
    }

    public static BoardAssert assertThat(Board actual) {
        return new BoardAssert(actual);
    }

    public BoardAssert boardIsEqual(Board expectedBoard) {

        if (actual.getCells().length != expectedBoard.getCells().length) {
            failWithMessage(format("The actual board has %s cells and expected board has %s cells", actual.getCells().length,
                    expectedBoard.getCells().length));
        }

        int lengthOfSide = (int) Math.sqrt(actual.getCells().length);
        for (int x = 0; x <= lengthOfSide; x++) {
            for (int y = 0; y <= lengthOfSide; y++) {
                if (expectedBoard.getCells()[x][y].isState() != actual.getCells()[x][y].isState()) {
                    String coordinateString = x + "," + y;
                    failWithMessage(format("The actual cell(%s) is %s while the expected cell(%s) is %s", coordinateString,
                            actual.getCells()[x][y], coordinateString, expectedBoard.getCells()[x][y]));
                }
            }
        }

        return this;
    }


}
