package business;

import org.junit.Assert;
import org.junit.Test;
import domain.State;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Luiz Eduardo on 14/06/2018.
 */
public class InitTest {
    @Test
    public void testInit(){
        State resultado = Init.init(5, 5, 6);
        ArrayList < Integer > result = new ArrayList<Integer>();
        result.add(resultado.getRow());
        result.add(resultado.getWidth());
        result.add(resultado.getMines());

        State esperado = State.builder()
                .mines(6)
                .width(5)
                .row(5)
                .build();

        ArrayList < Integer > expected = new ArrayList<Integer>();
        expected.add(esperado.getRow());
        expected.add(esperado.getWidth());
        expected.add(esperado.getMines());

        Assert.assertEquals(expected, result);
    }
}
