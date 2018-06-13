package business;

import domain.State;
import utils.ConversionData;
import utils.Input;

/**
 * @author Luiz Eduardo on 08/06/2018.
 */
public class Minefield {
    Input in;
    private int vis;
    private final int WIN = 1, LOSE = 0;

    Minefield(){
        in = new Input();
        vis = 0;
    }

    State play(State state, int x, int y){
        if(state.getField().get(x).get(y) != ConversionData.MINE) {
            openCells(state, x, y);

            if( state.freeCells() == vis ) {
                state.setWin(WIN);
            }
        } else {
            state.setWin(LOSE);
        }

        return state;
    }

    private void openCells(State state, int x, int y){
        if(state.getField().get(x).get(y) == ConversionData.MINE || state.getVisited().get(x).get(y))
            return;

        state.getVisited().get(x).set(y, true);
        vis++;

        if(state.getField().get(x).get(y) > 0)
            return;

        if(x > 0) openCells(state, x-1, y);
        if(y > 0) openCells(state, x, y-1);
        if(y < (state.getWidth()-1)) openCells(state, x, y+1);
        if(x < (state.getRow()-1)) openCells(state, x+1, y);
    }
}