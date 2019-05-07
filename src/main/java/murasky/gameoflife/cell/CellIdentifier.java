package murasky.gameoflife.cell;

import murasky.gameoflife.board.Coordinate;
import murasky.gameoflife.board.OffsetCoordinate;

import java.util.Arrays;
import java.util.List;

public class CellIdentifier {
    public List<OffsetCoordinate> findNeighborsOffsetCoordinates(Coordinate coordinate, int lengthOfSide) {

        if (isCellLeftTopCorner(coordinate)){
            System.out.println("LeftTopCorner");
            return Arrays.asList(new OffsetCoordinate(0,1),
                    new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
        }
        if (isTopRightCorner(coordinate, lengthOfSide)){
            System.out.println("RightTopCorner");
            return  Arrays.asList(new OffsetCoordinate(0,-1),
                    new OffsetCoordinate(1,-1), new OffsetCoordinate(1,0));
        }
        if (isCellTopEdge(coordinate, lengthOfSide)) {
            System.out.println("TopEdge");
            return Arrays.asList(new OffsetCoordinate(0,-1),
                    new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1), new OffsetCoordinate(1,0),
                    new OffsetCoordinate(1,1));
        }
        if (isCellMiddle(coordinate, lengthOfSide)){
            System.out.println("Middle");
            return Arrays.asList(new OffsetCoordinate(-1,-1),
                    new OffsetCoordinate(-1,0), new OffsetCoordinate(-1,1),
                    new OffsetCoordinate(0,-1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1),
                    new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
        }
        if (isLeftEdge(coordinate, lengthOfSide)){
            System.out.println("Left Edge");
            return Arrays.asList(new OffsetCoordinate(-1,0),
                    new OffsetCoordinate(-1,1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,0),
                    new OffsetCoordinate(1,1));
        } if (isRightEdge(coordinate, lengthOfSide)){
            System.out.println("Right Edge");
            return Arrays.asList(new OffsetCoordinate(-1,0),
                    new OffsetCoordinate(-1,-1), new OffsetCoordinate(0,-1), new OffsetCoordinate(1,-1),
                    new OffsetCoordinate(1,0));
        }


        return null;
    }

    private boolean isTopRightCorner(Coordinate coordinate, int lengthOfSide) {
        return coordinate.getX() == 0 && coordinate.getY() == lengthOfSide-1;
    }

    private boolean isRightEdge(Coordinate coordinate, int lengthOfSide) {
        return (coordinate.getX() > 0 && coordinate.getX() < lengthOfSide) && coordinate.getY() == lengthOfSide-1;
    }

    private boolean isLeftEdge(Coordinate coordinate, int lengthOfSide) {
        return (coordinate.getX() > 0 && coordinate.getX() < lengthOfSide) && coordinate.getY() ==0;
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
