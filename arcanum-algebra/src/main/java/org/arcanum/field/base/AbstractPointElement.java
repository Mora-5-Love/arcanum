package org.arcanum.field.base;

import org.arcanum.Element;
import org.arcanum.Point;

import java.math.BigInteger;

/**
 * @author Angelo De Caro (arcanumlib@gmail.com)
 */
public abstract class AbstractPointElement<E extends Element, F extends AbstractFieldOver> extends AbstractElement<F> implements Point<E> {

    protected E  x, y;


    protected AbstractPointElement(F field) {
        super(field);
    }


    public Element duplicate() {
        return null;
    }

    public Element set(Element value) {
        return null;
    }

    public Element set(int value) {
        return null;
    }

    public Element set(BigInteger value) {
        return null;
    }

    public BigInteger toBigInteger() {
        return null;
    }

    public Element setToRandom() {
        return null;
    }

    public Element setFromHash(byte[] source, int offset, int length) {
        return null;
    }

    public Element setToZero() {
        return null;
    }

    public boolean isZero() {
        return false;
    }

    public Element setToOne() {
        return null;
    }

    public boolean isEqual(Element value) {
        return false;
    }

    public boolean isOne() {
        return false;
    }

    public Element invert() {
        return null;
    }

    public Element negate() {
        return null;
    }

    public Element add(Element element) {
        return null;
    }

    public Element mul(Element element) {
        return null;
    }

    public Element mul(BigInteger n) {
        return null;
    }

    public boolean isSqr() {
        return false;
    }

    public int sign() {
        return 0;
    }

    public E getX() {
        return x;
    }

    public E getY() {
        return y;
    }


    public int getLengthInBytesCompressed() {
        throw new IllegalStateException("Not Implemented yet!");
    }

    public byte[] toBytesCompressed() {
        throw new IllegalStateException("Not Implemented yet!");
    }

    public int setFromBytesCompressed(byte[] source) {
        throw new IllegalStateException("Not Implemented yet!");
    }

    public int setFromBytesCompressed(byte[] source, int offset) {
        throw new IllegalStateException("Not Implemented yet!");
    }

    public int getLengthInBytesX() {
        throw new IllegalStateException("Not Implemented yet!");
    }

    public byte[] toBytesX() {
        throw new IllegalStateException("Not Implemented yet!");
    }

    public int setFromBytesX(byte[] source) {
        throw new IllegalStateException("Not Implemented yet!");
    }

    public int setFromBytesX(byte[] source, int offset) {
        throw new IllegalStateException("Not Implemented yet!");
    }

}
