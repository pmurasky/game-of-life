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
        if (isCellTopRightCorner(coordinate, lengthOfSide)){
            return  Arrays.asList(new OffsetCoordinate(0,-1),
                    new OffsetCoordinate(1,-1), new OffsetCoordinate(1,0));
        }
        if (isCellTopEdge(coordinate, lengthOfSide)) {
            return Arrays.asList(new OffsetCoordinate(0,-1),
                    new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1), new OffsetCoordinate(1,0),
                    new OffsetCoordinate(1,1));
        }
        if (isCellMiddle(coordinate, lengthOfSide)){
            return Arrays.asList(new OffsetCoordinate(-1,-1),
                    new OffsetCoordinate(-1,0), new OffsetCoordinate(-1,1),
                    new OffsetCoordinate(0,-1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1),
                    new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
        }
        if (isLeftEdge(coordinate, lengthOfSide)){
            return Arrays.asList(new OffsetCoordinate(-1,0),
                    new OffsetCoordinate(-1,1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,0),
                    new OffsetCoordinate(1,1));
        } if (isRightEdge(coordinate, lengthOfSide)){
            return Arrays.asList(new OffsetCoordinate(-1,0),
                    new OffsetCoordinate(-1,-1), new OffsetCoordinate(0,-1), new OffsetCoordinate(1,-1),
                    new OffsetCoordinate(1,0));
        } if (isCellLeftBottomCorner(coordinate, lengthOfSide)){
            return Arrays.asList(new OffsetCoordinate(-1,0),
                    new OffsetCoordinate(-1,1), new OffsetCoordinate(0,1));

        } if(isCellBottomEdge(coordinate, lengthOfSide)){
            return Arrays.asList(new OffsetCoordinate(-1,-1),
                    new OffsetCoordinate(-1,0), new OffsetCoordinate(-1,1), new OffsetCoordinate(0,-1),
                    new OffsetCoordinate(0,1));
        } if (isCellBottomRightCorner(coordinate, lengthOfSide)){
            return Arrays.asList(new OffsetCoordinate(0,-1),
                    new OffsetCoordinate(-1,-1), new OffsetCoordinate(-1,0));
        }


        return null;
    }

    private boolean isCellBottomRightCorner(Coordinate coordinate, int lengthOfSide) {
        return coordinate.getX() == lengthOfSide-1 && coordinate.getY() == lengthOfSide -1;
    }

    private boolean isCellBottomEdge(Coordinate coordinate, int lengthOfSide) {
        return coordinate.getX() == lengthOfSide-1 && (coordinate.getY() > 0 && coordinate.getY() < lengthOfSide-1);
    }

    private boolean isCellLeftBottomCorner(Coordinate coordinate, int lengthOfSide) {
        return coordinate.getX() == lengthOfSide-1 && coordinate.getY() == 0;
    }

    private boolean isCellTopRightCorner(Coordinate coordinate, int lengthOfSide) {
        return coordinate.getX() == 0 && coordinate.getY() == lengthOfSide-1;
    }

    private boolean isRightEdge(Coordinate coordinate, int lengthOfSide) {
        return (coordinate.getX() > 0 && coordinate.getX() < lengthOfSide-1) && coordinate.getY() == lengthOfSide-1;
    }

    private boolean isLeftEdge(Coordinate coordinate, int lengthOfSide) {
        return (coordinate.getX() > 0 && coordinate.getX() < lengthOfSide-1) && coordinate.getY() ==0;
    }

    private boolean isCellLeftTopCorner(Coordinate coordinate) {
        return coordinate.getX() == 0 && coordinate.getY() == 0;
    }

    private boolean isCellMiddle(Coordinate coordinate, int lengthOfSide) {
        return (coordinate.getX() != 0 && coordinate.getY() != 0) && (coordinate.getX() != lengthOfSide-1 && coordinate.getY() != lengthOfSide-1);
    }

    private boolean isCellTopEdge(Coordinate coordinate, int lengthOfSide) {
        return coordinate.getX() == 0 && (coordinate.getY() > 0 && coordinate.getY() < lengthOfSide);
    }
}
