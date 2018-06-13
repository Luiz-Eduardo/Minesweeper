package utils;

import java.util.Scanner;

import static utils.Validator.isValid;
import static utils.Validator.isValidMines;

/**
 * @autor Luiz Eduardo on 11/06/2018.
 * Classe utilizada para garantir que os dados digitados na entrada são válidos.
 */

public class Input {
    Scanner in;

    public Input(){
        in = new Scanner(System.in);
    }

    /**
     * Método utilizado para validar o tipo de dado
     * @return valor inteiro válido.
     */
    public Integer readInt(){
        Integer valor = null;

        do {
            try {
                valor = in.nextInt();
            } catch (Exception e) {
                System.out.println("Digite um número válido!");
                in.nextLine();
            }
        } while(valor == null);

        return valor;
    }

    public int readNumberOfLines(){
        System.out.print("Linhas: ");

        int lines;

        do {
            lines = readInt();
        } while(!isValid(lines));

        return lines;
    }

    public int readNumberOfColumns(){
        System.out.print("Colunas: ");

        int columns;

        do {
            columns = readInt();
        } while(!isValid(columns));

        return columns;
    }

    public int readNumberOfMines(int row, int width){
        System.out.println("Digite a quantidade de minas: ");
        int mines;

        do{
            mines = readInt();
        } while(!isValidMines(mines, row, width));

        return mines;
    }
}
