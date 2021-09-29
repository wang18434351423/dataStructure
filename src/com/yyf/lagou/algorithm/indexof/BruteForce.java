package com.yyf.lagou.algorithm.indexof;

/**
 * 字符串匹配暴力破解算法 BF 算法
 */
public class BruteForce {

    public static void main(String[] args) {
        System.out.println(indexOf("asdfg","aa"));
    }

    /**
     * 是否包含对应的子串
     * @param main 主串
     * @param sub 子串
     * @return
     */
    private static boolean indexOf(String main, String sub) {
        if (sub.length() < main.length()) {
            char[] mainArr = main.toCharArray();
            for (int i = 0; i <= main.length() - sub.length(); i++) {
                char[] chars = new char[sub.length()];
                for (int j = 0; j < sub.length(); j++) {
                    chars[j] = mainArr[j + i];
                }
                //获取到截取到的字符串并查看字符串是否匹配
                if (sub.equals(String.valueOf(chars))) {
                    return true;
                }
            }
        }
        return false;
    }


}
