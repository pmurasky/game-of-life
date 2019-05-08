package murasky.gameoflife.cell;

import murasky.gameoflife.board.Coordinate;
import murasky.gameoflife.board.OffsetCoordinate;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CellIdentifierTest {

    private CellIdentifier cellIdentifier = new CellIdentifier();

    @Test
    public void verifyCoordinateNeighborsForTopLeftCell(){
        Coordinate coordinate = new Coordinate(0,0);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(0,1),
                new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
    }

    @Test
    public void verifyCoordinateNeighborsForTopMiddleCell(){
        Coordinate coordinate = new Coordinate(0,1);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(0,-1),
                new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1), new OffsetCoordinate(1,0),
                new OffsetCoordinate(1,1));
    }

    @Test
    public void verifyCoordinateNeighborsForTopRightCell(){
        Coordinate coordinate = new Coordinate(0,2);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(0,-1),
                new OffsetCoordinate(1,-1), new OffsetCoordinate(1,0));
    }

    @Test
    public void verifyCoordinateNeighborsForMiddleCell(){
        Coordinate coordinate = new Coordinate(1,1);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(-1,-1),
                new OffsetCoordinate(-1,0), new OffsetCoordinate(-1,1),
                new OffsetCoordinate(0,-1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1),
                new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
    }

    @Test
    public void verifyCoordinateNeighborsForLeftEdgeCell(){
        Coordinate coordinate = new Coordinate(1,0);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(-1,0),
                new OffsetCoordinate(-1,1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,0),
                new OffsetCoordinate(1,1));
    }

    @Test
    public void verifyCoordinateNeighborsForRightEdgeCell(){
        Coordinate coordinate = new Coordinate(1,2);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(-1,0),
                new OffsetCoordinate(-1,-1), new OffsetCoordinate(0,-1), new OffsetCoordinate(1,-1),
                new OffsetCoordinate(1,0));
    }

    @Test
    public void verifyCoordinateNeighborsForBottomLeftCell(){
        Coordinate coordinate = new Coordinate(2,0);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(-1,0),
                new OffsetCoordinate(-1,1), new OffsetCoordinate(0,1));
    }

    @Test
    public void verifyCoordinateNeighborsForBottomEdgeCell(){
        Coordinate coordinate = new Coordinate(2,1);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(-1,-1),
                new OffsetCoordinate(-1,0), new OffsetCoordinate(-1,1), new OffsetCoordinate(0,-1),
                new OffsetCoordinate(0,1));
    }

    @Test
    public void verifyCoordinateNeighborsForBottomRightCell(){
        Coordinate coordinate = new Coordinate(2,2);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(0,-1),
                new OffsetCoordinate(-1,-1), new OffsetCoordinate(-1,0));
    }
}