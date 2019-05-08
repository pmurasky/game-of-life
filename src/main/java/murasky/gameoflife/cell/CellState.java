package murasky.gameoflife.cell;

public enum CellState {

    ALIVE(true),
    DEAD(false);

    private boolean state;

    CellState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }
}
