package murasky.gameoflife.performance;

import com.ford.game.common.flife.FLifeParameterizedTestBase;
import com.ford.game.common.flife.framework.GameOfLifeString;
import murasky.gameoflife.GamePerformance;

public class GameOfLifePerformanceTest extends FLifeParameterizedTestBase {

    public GameOfLifePerformanceTest(String scenarioName) {
        super(scenarioName);
    }

    @Override
    protected GameOfLifeString getImplementation() {
        return new GamePerformance();
    }
}
