package com.yyf.lagou.sortalgorithm.sort;

import java.util.Arrays;

/**
 * 计数排序：
 *    构造一个取值范围内长度的数组容器
 *    遍历待排序数组，在容器对应的下标位置上进行计数+1操作
 *    遍历容器，输出下标位置，元素多大输出几次
 */
public class Count {

    public static void main(String[] args) {
        int[] arr = {9,1,2,7,8,1,3,6,5,3};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 计数排序
     * @param arr
     */
    private static void sort(int[] arr) {
        //寻找数据范围
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
           if (arr[i] > max) max = arr[i];
           if (arr[i] < min) min = arr[i];
        }
        //创建数据范围长度的容器
        int[] context = new int[max - min + 1];
        //遍历无序数组，开始填充下标计数
        for (int i = 0; i < arr.length; i++) {
            //这里加上偏移量计算
            context[arr[i] - min] += 1;
        }
        //将排好序的数据填充到数组中
        for (int i = 0, j = 0; i < context.length; i++) {
            while (context[i] > 0) {
                //这里赋值也加上偏移量计算
                arr[j] = i + min;
                context[i] -= 1;
                j++;
            }
        }
    }
}
