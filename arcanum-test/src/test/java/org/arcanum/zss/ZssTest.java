package org.arcanum.zss;

import org.arcanum.AbstractArcanumTest;
import org.arcanum.Element;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * @author Angelo De Caro (arcanumlib@gmail.com)
 */
public class ZssTest extends AbstractArcanumTest {

    @Parameterized.Parameters
    public static Collection parameters() {
        Object[][] data = {
                {false, "org/arcanum/pairing/a/a_181_603.properties"},
                {true, "org/arcanum/pairing/a/a_181_603.properties"},
        };

        return Arrays.asList(data);
    }


    public ZssTest(boolean usePBC, String curvePath) {
        super(usePBC, curvePath);
    }


    @Test
    public void testZss() {
        Element P, Ppub, x, S, H, t1, t2, t3, t4;

        x = pairing.getZr().newRandomElement();
        P = pairing.getG1().newRandomElement();

        Ppub = P.duplicate().mulZn(x);

        byte[] source = "Message".getBytes();

        H = pairing.getZr().newElementFromHash(source, 0, source.length);
        t1 = pairing.getZr().newElement().set(H).add(x).invert();
        S = pairing.getG1().newElement().set(P).mulZn(t1);

        t2 = pairing.getG1().newElement().set(P).mulZn(H).add(Ppub);

        t3 = pairing.pairing(t2, S);
        t4 = pairing.pairing(P, P);

        assertTrue(t3.isEqual(t4));
     }

}
