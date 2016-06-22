package com.yylx.daggerlearn.alogrithm;

/**
 * Created by zqj on 2016/6/2 09:38.
 */
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0)
            throw new IllegalArgumentException();
        return a / b;
    }

}
