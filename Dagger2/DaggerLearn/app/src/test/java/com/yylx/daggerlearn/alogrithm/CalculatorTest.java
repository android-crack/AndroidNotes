package com.yylx.daggerlearn.alogrithm;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by zqj on 2016/6/2 10:02.
 */
public class CalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();

    }

    @Test
    public void testAdd() throws Exception {
        int sum = calculator.add(1, 2);
        assertEquals(sum, 3);
    }

    @Test
    public void testMultiply() throws Exception {
        int mul = calculator.multiply(2, 3);
        assertEquals(mul, 6);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivide() {
        double div = calculator.divide(3, 0);
        //        assertEquals(div, 3d);
    }
}