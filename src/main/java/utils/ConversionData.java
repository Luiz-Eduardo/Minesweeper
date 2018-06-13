package utils;

/**
 * @author Luiz Eduardo on 11/06/2018.
 * Classe utilizada para converter dados inteiros para caracteres.
 */

public class ConversionData {
    public static final int  MINE = -1, EMPTY = 0, PLAY = 1;

    /**
     * Recebe um inteiro na posição (Xi, Yi) e retorna o caractere que deve ser mostrado na tela para o usuário.
     * @param value valor inteiro da posição da mina
     * @return caractere que será impresso para o usuário
     */
    public static String intToString(int value){
        switch(value){
            case EMPTY:
                return "[-]";
            case MINE:
                return "[*]";
            default:
                return ("[" + ((char)(value + '0')) + "]");
        }
    }
}
