package org.arcanum.util.concurrent.accumultor;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (arcanumlib@gmail.com)
 * @since 1.0.0
 */
public class BigIntegerMulAccumulator extends AbstractAccumulator<BigInteger> {

    public BigIntegerMulAccumulator() {
        this.result = BigInteger.ONE;
    }


    protected void reduce(BigInteger value) {
        result = result.multiply(value);
    }

}
