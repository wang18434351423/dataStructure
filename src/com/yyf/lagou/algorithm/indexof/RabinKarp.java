package com.yyf.lagou.algorithm.indexof;
/**
 * 字符串匹配算法
 * RK 算法：在 BF 暴力匹配算法的基础上优化了匹配串和子串的匹配
 *         将 equals 比较优化为 hash 值匹配，数组的匹配效率更高
 */
public class RabinKarp {

    public static void main(String[] args) {
        System.out.println(indexOf("asdfg","as"));
    }

    /**
     * 字符串匹配
     * @param main 主串
     * @param sub 子串
     * @return
     */
    private static boolean indexOf(String main, String sub) {
        for (int i = 0; i < main.length() - sub.length() + 1; i++) {
            char[] chars = new char[sub.length()];
            for (int j = 0; j < chars.length; j++) {
                chars[j] = main.charAt(i + j);
            }
           if (strToHash(String.valueOf(chars)) == strToHash(sub)) {
               return true;
           }
        }
        return false;
    }

    /**
     * 自定义哈希算法 计算字符串的hash值
     * 支持 a-z 二十六进制
     * @param str 待计算的hash值
     * @return
     */
    public static int strToHash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash *= 26;
            hash += str.charAt(i) - 97;
        }
        return hash;
    }

}