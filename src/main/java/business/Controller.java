package business;

import domain.State;
import utils.ConversionData;
import utils.Input;

import static utils.Validator.isValidPos;

/**
 * @author Luiz Eduardo on 12/06/2018.
 */
public class Controller {
    private Input in;

    private int row;
    private int width;
    private int mines;
    private final int WIN = 1, LOSE = 0;

    Controller(){
        in = new Input();
    }

    public int getRow() {
        return row;
    }

    public int getWidth() {
        return width;
    }

    public int getMines() {
        return mines;
    }

    public void read(){
        System.out.println("Digite a quantidade de linhas e colunas do campo minado.");

        this.row = in.readNumberOfLines();
        this.width = in.readNumberOfColumns();
        this.mines = in.readNumberOfMines(row, width);
    }

    public void play(State state, Minefield field){
        while(state.getWin() == -1) {
            show(state);

            int[] coordinates = readPos(state);
            int x = coordinates[0];
            int y = coordinates[1];

            state = field.play(state, x, y);
        }

        if(state.getWin() == WIN){
            System.out.println("Parabéns, você foi o vencedor!");
        } else if(state.getWin() == LOSE){
            System.out.println("Infelizmente você perdeu :/");
        }

        showAll(state);
    }

    private int[] readPos(State state){
        System.out.print("Escolha a posição (i, j) que deseja jogar: \n");
        int numberOfInvalidPos = 0, x, y;
        boolean invalidPos = true;

        do {
            if(numberOfInvalidPos > 0){
                System.out.println("Posição inválida! Escolha a posição (i, j) que deseja jogar: \n");
            }

            System.out.print("i : ");
            x = in.readInt();
            x--;

            System.out.print("j : ");
            y = in.readInt();
            y--;

            numberOfInvalidPos++;

            if( !isValidPos(x, y, row, width)) {
                if(!state.getVisited().get(x).get(y)) {
                    invalidPos = false;
                }
            }
        } while( invalidPos );

        return new int[]{x, y};
    }

    private void show(State state){
        System.out.print("   ");

        for(int i = 0; i < state.getWidth(); i++){
            if(i != state.getWidth()-1)
                System.out.print(" " + (i+1) + "  ");
            else
                System.out.println(" " + (i+1));
        }

        for(int i = 0; i < state.getRow(); i++){
            System.out.print(" " + (i+1) + " ");

            for(int j = 0; j < state.getWidth(); j++) {
                if(state.getVisited().get(i).get(j))
                    System.out.print(ConversionData.intToString(state.getField().get(i).get(j)) + " ");
                else
                    System.out.print("[?] ");
            } System.out.println();
        }
    }

    private void showAll(State state){
        System.out.print("  ");

        for(int i = 0; i < state.getWidth(); i++){
            if(i != state.getWidth()-1)
                System.out.print(" " + (i+1) + "  ");
            else
                System.out.println(" " + (i+1));
        }
        for(int i = 0; i < state.getRow(); i++){
            System.out.print((i+1) + " ");

            for(int j = 0; j < state.getWidth(); j++)
                System.out.print(ConversionData.intToString(state.getField().get(i).get(j)) + " ");
            System.out.println();
        }
    }
}
