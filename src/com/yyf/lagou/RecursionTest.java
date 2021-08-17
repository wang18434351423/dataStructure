package com.yyf.lagou;

public class RecursionTest {

    public static void main(String[] args) {
        System.out.println(func(9));
    }

    //斐波那契数列递归实现 0 ,1 ,1, 2
    public static int func(int n){
        if(n < 2) return  1;
        return func(n - 1) + func(n - 2);
    }
}
