package com.yyf.jike;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Ysf {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            int index = 0;
            while (true) {
                int random = new Random().nextInt(5);
                index += random;
                if (index >= list.size()) {
                    break;
                }
                list.remove(index);
            }
        }
        System.out.println("--生存元素--" + list.get(0));
    }

    public static int ysf(List<Integer> list) {
        while (list.size() > 1) {
            int index = 0;
            while (true) {
                int random = new Random().nextInt(5);
                index += random;
                if (index >= list.size()) {
                    break;
                }
                list.remove(index);
            }
        }
        return list.get(0);
    }
}
