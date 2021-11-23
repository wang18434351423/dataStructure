package com.yyf.lagou.algorithm.indexof;

/**
 * 字符串匹配 BM 算法：滑动算法
 *      -   坏字符规则：匹配串从后向前和主串进行比较，遇到坏字符，记录坏字符的下标 si，
 *                    判断坏字符在子串中是否存在，存在则记录存在的位置 xi，计算出
 *                    匹配串滑动的数量 si - xi
 *      -   好后缀规则
 */
public class BoyerMoore {

    private static final int SIZE = 256; // 全局变量或成员变量

    public static void main(String[] args) {
        System.out.println(indexOf("aaaaa","bba"));
    }

    /**
     * BM算法 坏字符匹配
     * @param main
     * @param sub
     * @return
     */
    private static int indexOf(String main, String sub) {
        int[] dc = new int[SIZE];
        //初始化数组中的元素为-1
        for (int i = 0; i < SIZE; i++) {
            dc[i] = -1;
        }
        //将子串的字符都维护到数组中
        for (int i = 0; i < sub.length(); i++) {
            dc[sub.charAt(i)] = i;
        }

        // i表示主串与模式串对齐的第一个字符
        int i = 0;

        while (i >= 0 && i <= main.length() - sub.length()) {
            int j = 0;
            //子串从后向前匹配
            for (j = sub.length() - 1; j >= 0 ; j--) {
                if (sub.charAt(j) != main.charAt(i + j)) {
                    break;
                }
            }
            //如果匹配成功 返回匹配串和主串对齐的第一个字符的下标
            if (j < 0) {
                return i;
            }
            //将匹配串进行滑动处理
            char c = main.charAt(i + j);
            i = i + c < j ? (j - dc[c]) : j;
        }

        return -1;
    }
}
