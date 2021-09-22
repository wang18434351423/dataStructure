package com.yyf.lagou.other;

/**
 * 斐波那契数列：0、1、1、2、3、5、8、13、21、34、55.....
 * 规律：从第3个数开始，每个数等于前面两个数的和
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(recursion(9));
    }

    public static int recursion(int n){
        if(n <= 1) return n;
        return recursion(n - 1) + recursion(n - 2);
    }

}
