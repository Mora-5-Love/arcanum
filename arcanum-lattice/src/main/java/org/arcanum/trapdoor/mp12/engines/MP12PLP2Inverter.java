package org.arcanum.trapdoor.mp12.engines;

import org.arcanum.Element;
import org.arcanum.Vector;
import org.arcanum.common.cipher.engine.AbstractElementCipher;
import org.arcanum.common.math.BigIntegerUtils;
import org.arcanum.trapdoor.mp12.params.MP12PLP2PublicKeyParameters;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (arcanumlib@gmail.com)
 */
public class MP12PLP2Inverter extends AbstractElementCipher<Element, Vector, MP12PLP2PublicKeyParameters> {

    protected MP12PLP2PublicKeyParameters parameters;
    protected BigInteger oneFourthOrder;
    protected int n, k;


    public MP12PLP2Inverter init(MP12PLP2PublicKeyParameters param) {
        this.parameters = param;

        this.oneFourthOrder = parameters.getZq().getOrder().divide(BigIntegerUtils.FOUR);
        this.n = parameters.getParameters().getN();
        this.k =  parameters.getK();

        return this;
    }

    public Vector processElements(Element... input) {
        Vector v = (Vector) input[0];

        Vector result = (Vector) parameters.getSyndromeField().newZeroElement();

        for (int i = 0, cursor = 0; i < n; i++) {
            Element s = result.getAt(i);

            for (int j = k - 1; j >= 0; j--) {
                Element temp = parameters.getG().getAt(0, j).duplicate().mul(s).negate().add(v.getAt(cursor + j));

                BigInteger value = temp.toBigInteger().add(temp.getField().getOrder());
                boolean b1 = value.testBit(k - 1);
                boolean b2 = value.testBit(k - 2);
                if ((b1 || b2 ) && (!(b1 && b2)))
//                if (temp.toBigInteger().abs().compareTo(oneFourthOrder) >= 0)
                    s.add(parameters.getG().getAt(0, k - 1 - j));

//                e.getAt(j).set(v.getAt(j)).sub(parameters.getG().getAt(0, j));
            }

            cursor += k;
        }


        return result;
    }

}
