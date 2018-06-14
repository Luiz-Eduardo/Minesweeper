package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luiz Eduardo on 12/06/2018.
 */
public class State {
    List <List< Integer >> field;
    List < List < Boolean > > visited;

    private int win = -1;
    private int row;
    private int width;
    private int mines;

    public int getMines() {
        return mines;
    }

    public int getWin(){
        return win;
    }

    public void setWin(int win){
        this.win = win;
    }

    public State(List< List < Integer > > field, List< List < Boolean > > visited, int row, int width, int mines){
        this.field = field;
        this.visited = visited;
        this.row = row;
        this.width = width;
        this.mines = mines;
    }
    public List<List<Integer>> getField() {
        return field;
    }

    public List<List<Boolean>> getVisited() {
        return visited;
    }

    public int freeCells() {
        return width*row - mines;
    }

    public int getRow() {
        return row;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        if (getWin() != state.getWin()) return false;
        if (getRow() != state.getRow()) return false;
        if (getWidth() != state.getWidth()) return false;
        if (mines != state.mines) return false;
        if (getField() != null ? !getField().equals(state.getField()) : state.getField() != null) return false;
        return getVisited() != null ? getVisited().equals(state.getVisited()) : state.getVisited() == null;
    }

    @Override
    public int hashCode() {
        int result = getField() != null ? getField().hashCode() : 0;
        result = 31 * result + (getVisited() != null ? getVisited().hashCode() : 0);
        result = 31 * result + getWin();
        result = 31 * result + getRow();
        result = 31 * result + getWidth();
        result = 31 * result + mines;
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List < List < Integer > > field = new ArrayList<List<Integer>>();
        private List < List < Boolean > > visited = new ArrayList<List<Boolean>>();

        private int win = -1;
        private int row;
        private int width;
        private int mines;

        private Builder() {
        }

        public Builder fields(List < List < Integer > > campos) {
            this.field = campos;
            return this;
        }

        public Builder visited(List < List < Boolean > > visited) {
            this.visited = visited;
            return this;
        }

        public Builder row(int row) {
            this.row = row;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder mines(int mines) {
            this.mines = mines;
            return this;
        }

        public State build() {
            return new State(this.field, this.visited, this.row, this.width, this.mines);
        }
    }
}
