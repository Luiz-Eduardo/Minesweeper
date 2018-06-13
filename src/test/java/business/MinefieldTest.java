package business;

import org.junit.Assert;
import org.junit.Test;
import domain.State;

import java.util.Arrays;

/**
 * Created by logique on 13/06/18.
 */
public class MinefieldTest {

    @Test
    public void testPlay() {
        State estadoInicial = State.builder()
                .mines(5)
                .row(5)
                .width(5)
                .fields(Arrays.asList(
                        Arrays.asList(-1, 1, 0, 1, -1),
                        Arrays.asList(1, 2, 1, 1, 1),
                        Arrays.asList(0, 1, -1, 2, 1),
                        Arrays.asList(1, 2, 2, 2, -1),
                        Arrays.asList(1, -1, 1, 1, 1)
                ))
                .visited(Arrays.asList(
                        Arrays.asList(false, false, false, false, false),
                        Arrays.asList(false, false, false, false, false),
                        Arrays.asList(false, false, false, false, false),
                        Arrays.asList(false, false, false, false, false),
                        Arrays.asList(false, false, false, false, false)
                ))
                .build();

        State resultado = new Minefield().play(estadoInicial, 1, 2);

        State esperado = State.builder()
                .mines(5)
                .row(5)
                .width(5)
                .fields(Arrays.asList(
                        Arrays.asList(-1, 1, 0, 1, -1),
                        Arrays.asList(1, 2, 1, 1, 1),
                        Arrays.asList(0, 1, -1, 2, 1),
                        Arrays.asList(1, 2, 2, 2, -1),
                        Arrays.asList(1, -1, 1, 1, 1)
                ))
                .visited(Arrays.asList(
                        Arrays.asList(false, false, false, false, false),
                        Arrays.asList(false, false, true, false, false),
                        Arrays.asList(false, false, false, false, false),
                        Arrays.asList(false, false, false, false, false),
                        Arrays.asList(false, false, false, false, false)
                ))
                .build();

        Assert.assertEquals(esperado, resultado);
    }

}
