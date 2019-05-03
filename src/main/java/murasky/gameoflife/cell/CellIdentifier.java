package murasky.gameoflife.cell;

import murasky.gameoflife.board.Coordinate;
import murasky.gameoflife.board.OffsetCoordinate;

import java.util.Arrays;
import java.util.List;

public class CellIdentifier {
    public List<OffsetCoordinate> findNeighborsOffsetCoordinates(Coordinate coordinate, int lengthOfSide) {

        if (isCellLeftTopCorner(coordinate)){
            return Arrays.asList(new OffsetCoordinate(0,1),
                    new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
        }
        if (isCellMiddle(coordinate)){
            return Arrays.asList(new OffsetCoordinate(-1,-1),
                    new OffsetCoordinate(-1,0), new OffsetCoordinate(-1,1),
                    new OffsetCoordinate(0,-1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1),
                    new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
        }
        if (isCellTopEdge(coordinate, lengthOfSide)) {
            return Arrays.asList(new OffsetCoordinate(0,-1),
                    new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1), new OffsetCoordinate(1,0),
                    new OffsetCoordinate(1,1));
        }


        return null;
    }

    private boolean isCellLeftTopCorner(Coordinate coordinate) {
        return coordinate.getX() == 0 && coordinate.getY() == 0;
    }

    private boolean isCellMiddle(Coordinate coordinate) {
        return coordinate.getX() != 0 && coordinate.getY() != 0;
    }

    private boolean isCellTopEdge(Coordinate coordinate, int lengthOfSide) {
        return coordinate.getX() == 0 && (coordinate.getY() > 0 && coordinate.getY() < lengthOfSide);
    }
}
