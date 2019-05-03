package murasky.gameoflife.rule;

import murasky.gameoflife.CellState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static murasky.gameoflife.CellState.ALIVE;
import static murasky.gameoflife.CellState.DEAD;
import static org.assertj.core.api.Assertions.assertThat;

public class ConwayRuleTest {

    private ConwaysRule rule;

    @BeforeEach
    public void setup(){
        rule = new ConwaysRule();
    }

    @Test
    public void liveCellWithFewerThanTwoLiveNeighborsDies(){

        assertThat(rule.apply(ALIVE, 1)).isEqualTo(DEAD);
    }

    @Test
    public void  liveCellWithTwoLiveNeighborLives(){

        CellState actual = rule.apply(ALIVE, 2);

        assertThat(actual).isEqualTo(ALIVE);
    }

    @Test
    public void  liveCellWithThreeLiveNeighborLives(){

        CellState actual = rule.apply(ALIVE, 3);

        assertThat(actual).isEqualTo(ALIVE);
    }

    @Test
    public void  liveCellWithMoreThanThreeLiveNeighborDies(){

        CellState actual = rule.apply(ALIVE, 4);

        assertThat(actual).isEqualTo(DEAD);
    }

    @Test
    public void  deadCellWithThreeLiveNeighborLives(){

        CellState actual = rule.apply(DEAD, 3);

        assertThat(actual).isEqualTo(ALIVE);
    }

    @Test
    public void deadCellWithTwoLiveNeighborsStaysDead() {
        CellState actual = rule.apply(DEAD, 2);

        assertThat(actual).isEqualTo(DEAD);

    }
}
