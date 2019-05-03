package murasky.gameoflife.cell;

import murasky.gameoflife.board.Coordinate;
import murasky.gameoflife.board.OffsetCoordinate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CellIdentifierTest {

    private CellIdentifier cellIdentifier = new CellIdentifier();

    @Test
    public void verifyCoordinateNeighborsForTopLeftCell(){
        Coordinate coordinate = new Coordinate(0,0);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        Assertions.assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(0,1),
                new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
    }

    @Test
    public void verifyCoordinateNeighborsForTopMiddleCell(){
        Coordinate coordinate = new Coordinate(0,1);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        Assertions.assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(0,-1),
                new OffsetCoordinate(0,1), new OffsetCoordinate(-1,-1), new OffsetCoordinate(-1,0),
                new OffsetCoordinate(-1,1));
    }

    @Test
    public void verifyCoordinateNeighborsForMiddleCell(){
        Coordinate coordinate = new Coordinate(1,1);
        List<OffsetCoordinate> offsetCoordinates = cellIdentifier.findNeighborsOffsetCoordinates(coordinate, 3);

        Assertions.assertThat(offsetCoordinates).containsExactlyInAnyOrder(new OffsetCoordinate(-1,-1),
                new OffsetCoordinate(-1,0), new OffsetCoordinate(-1,1),
                new OffsetCoordinate(0,-1), new OffsetCoordinate(0,1), new OffsetCoordinate(1,-1),
                new OffsetCoordinate(1,0), new OffsetCoordinate(1,1));
    }



}