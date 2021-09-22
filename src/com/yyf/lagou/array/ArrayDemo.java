package com.yyf.lagou.array;

import java.util.Arrays;

/**
 * 数组操作模仿
 */
public class ArrayDemo {

    int[] nums = new int[8];

    public ArrayDemo(){
        nums[0] = 3;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 3;
        nums[4] = 4;
        nums[5] = 5;
        nums[6] = 6;
        nums[7] = 7;
    }

    public int get(int index){
        if(index >= nums.length || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        return nums[index];
    }

    public void update(int index, int val){
        if(index >= nums.length || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        nums[index] = val;
    }

    public void insertTail(int val){
        nums[6] = val;
    }

    public void insertMid(int index,int val){
        if(index >= nums.length || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        for(int i = nums.length - 1; i >= index ; i--){
            if(nums[i] != 0){
                nums[i + 1] = nums[i];
            }
        }
        nums[index] = val;
    }

    public void resize(){
        int[] newNums = new int[2 * nums.length];
        System.arraycopy(nums,0,newNums,0,nums.length);
        nums = newNums;
    }

    public void insertOutOfBounds(int index,int val){
        resize();
        nums[index] = val;
    }

    public void deleteMid(int index){
        for (;index < nums.length - 1; index++) {
            nums[index] = nums[index + 1];
        }
        nums[nums.length - 1] = 0;
    }

    public void disPlay(){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(nums);
    }

    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.disPlay();
        arrayDemo.deleteMid(7);
        arrayDemo.disPlay();
    }

}
