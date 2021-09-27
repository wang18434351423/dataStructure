package com.yyf.lagou.sortalgorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            //外层循环优化，内部不再交换，外部循环跳出
            boolean isSort = true;
            //内部循环优化，前几轮移动到右侧的数据后面不进行比较
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSort = false;
                }
            }
            if (isSort){
                break;
            }
        }
    }
}
