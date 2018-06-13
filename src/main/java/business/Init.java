package business;

import domain.State;
import utils.ConversionData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Luiz Eduardo on 12/06/2018.
 */
public class Init extends Field {
    Init(){

    }

    public static State init(int row, int width, int mines, List < List <Integer> > field, List < List < Boolean > > visited, Random generator){
        createMatrix(row, width, field, visited);
        setMatrixToZero(row, width, field, visited);
        populateMines(row, width, mines, generator, field);
        minefield(row, width, field);

        return new State(field, visited, row, width, mines);
    }

    private static void createMatrix(int row, int width, List< List < Integer > > field, List < List < Boolean> > visited){
        for (int i = 0; i < row; i++) {
            field.add(new ArrayList<Integer>(width));
            visited.add(new ArrayList<Boolean>(width));
        }
    }

    private static void setMatrixToZero(int row, int width, List < List < Integer > > field, List < List < Boolean > > visited){
        for (int i = 0; i < row; i++){
            for (int j = 0; j < width; j++) {
                field.get(i).add(ConversionData.EMPTY);
                visited.get(i).add(false);
            }
        }
    }

    private static void populateMines(int row, int width, int mines, Random generator, List < List < Integer > > field){
        for (int i = 0, a, b; i < mines; i++) {
            a = generator.nextInt(row);
            b = generator.nextInt(width);

            while(field.get(a).get(b) == ConversionData.MINE){
                a = generator.nextInt(row);
                b = generator.nextInt(width);
            }

            field.get(a).set(b, ConversionData.MINE);
        }
    }

    private static void minefield(int row, int width, List < List <Integer> > field){
        for (int i = 0; i < row; i++)
            for (int j = 0; j < width; j++)
                if (field.get(i).get(j) != ConversionData.MINE)
                    count(i, j, row, width, field);
    }

    private static void count(int i, int j, int row, int width, List < List <Integer> > field) {
        int value = field.get(i).get(j);

        if(j != 0){
            if(field.get(i).get(j-1) == ConversionData.MINE) {
                value++;
                field.get(i).set(j, value);
            }

            if(i != 0){
                if(field.get(i-1).get(j-1) == ConversionData.MINE){
                    value++;
                    field.get(i).set(j, value);
                }
            }
        }

        if(i != 0){
            if(field.get(i-1).get(j) == ConversionData.MINE){
                value++;
                field.get(i).set(j, value);
            }
        }

        if(j != width-1) {
            if (field.get(i).get(j + 1) == ConversionData.MINE) {
                value++;
                field.get(i).set(j, value);
            }

            if(i != row-1){
                if(field.get(i+1).get(j+1) == ConversionData.MINE){
                    value++;
                    field.get(i).set(j, value);
                }
            }
        }

        if(i != row-1) {
            if (field.get(i + 1).get(j) == ConversionData.MINE) {
                value++;
                field.get(i).set(j, value);
            }
        }

        if(i != 0 && j != width-1){
            if(field.get(i-1).get(j+1) == ConversionData.MINE){
                value++;
                field.get(i).set(j, value);
            }
        }

        if(i != row-1 && j != 0){
            if(field.get(i+1).get(j-1) == ConversionData.MINE){
                value++;
                field.get(i).set(j, value);
            }
        }
    }
}