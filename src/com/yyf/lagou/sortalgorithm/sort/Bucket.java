package com.yyf.lagou.sortalgorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 桶排序：桶排序是一种线性时间的排序算法
 *       需要维护若干个桶，每个桶拥有自己的数据范围
 *       将待排序数列中的数据存入桶中，再将每个桶中的数据进行排序
 *       最后输出桶中的数据
 */
public class Bucket {

    public static void main(String[] args) {
        double[] arr = {4.5,0.84,3.25,2.18,0.5};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 桶排序
     * @param arr
     */
    private static void sort(double[] arr) {
        //获取最大值和最小值之间的差额
        double max = 0d;
        double min = 0d;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        //计算差额
        double dif = max - min;

        //构建桶
        int butNum = arr.length;
        //桶容器初始化
        ArrayList<LinkedList<Double>> butContext = new ArrayList<>(butNum);
        for (int i = 0; i < butNum; i++) {
            butContext.add(new LinkedList<Double>());
        }
        //将数据填充到桶中
        for (int i = 0; i < arr.length; i++) {
            //计算数据应该存放在哪个桶中
            int index = (int) ((arr[i] - min) * (butNum - 1) / dif);
            //数据入桶
            butContext.get(index).add(arr[i]);
        }
        //将桶中的数据进行排序
        for (int i = 0; i < butNum; i++) {
           butContext.get(i).sort(Double::compareTo);
        }
        //按照顺序输出桶中的数据
        for (int i = 0,k = 0; i < butNum; i++) {
            for (int j = 0; j < butContext.get(i).size(); j++,k++) {
                arr[k] = butContext.get(i).get(j);
            }
        }
    }
}
