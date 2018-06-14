package business;

import utils.Input;
import domain.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Luiz Eduardo on 08/06/2018.
 */
public class Game {
    private Input in;
    private Minefield graph;
    private Controller controller;

    public Game(){
        in = new Input();
        cls();
    }

    public int menu(){
        System.out.println("Bem-vindo ao campo-minado\n\n1 - Jogar\n2 - Sair\n\n");
        System.out.print("Opção: ");

        int option = in.readInt();

        return option;
    }

    public void choose(int option){
        switch(option){
            case 1:
                controller = new Controller();
                graph = new Minefield();

                controller.read();

                State state = Init.init(controller.getRow(), controller.getWidth(), controller.getMines());
                controller.play(state, graph);
                break;
            case 2:
                System.exit(0);
                break;
            default:
                cls();
                System.out.println("Opção inválida, escolha apenas uma das opções válidas\n");
        }
    }

    private void cls(){
        for(int i = 0; i < 50; i++)
            System.out.println();
    }
}