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
                .row(4)
                .width(3)
                .fields(Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(3, 4)
                ))
                .visited(Arrays.asList((Arrays.asList(true, false))))
                .build();
        State actual = new Minefield().play(estadoInicial, 3, 3);

      //  Assert.assertEquals(esperado, resultado);
    }

}
