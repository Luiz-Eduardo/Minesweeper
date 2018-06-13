import business.Game;
import utils.ConversionData;

/**
 * @author Luiz Eduardo on 08/06/2018.
 */
public class MineSweeper {
    public static void main(String[] args){
        Game game = new Game();

        int option;

        do {
            option = game.menu();
            game.choose(option);
        } while( option != ConversionData.PLAY);

    }
}
