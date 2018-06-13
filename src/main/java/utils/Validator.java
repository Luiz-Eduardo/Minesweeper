package utils;

/**
 * @author Luiz Eduardo on 11/06/2018.
 * Classe utilizada para validar os valores dentro do range possível.
 */

public class Validator {
    public static boolean isValidPos(int x, int y, int row, int width){
        return ( (x < 0) || (x > row-1) || (y < 0) || (y > width-1));
    }

    public static boolean isValidMines(int x, int row, int width){
        return (x > 0 && x < (row*width));
    }

    public static boolean isValid(int x){
        return x > 0;
    }
}
