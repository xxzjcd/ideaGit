package com.lmm;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class insert_sort {
    private int[] array = new int[100000];

    @Before
    public void init() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000);
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void bubbleSort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);//24029
        //for (int i = 0; i < array.length; i++) {
        //    System.out.print(array[i] + " ");
        //}
    }

    @Test
    public void selectSort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            if (index != i) {//不相等说明i索引不是最小值
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);//9514
        //for (int i = 0; i < array.length; i++) {
        //    System.out.print(array[i] + " ");
        //}
    }

    @Test
    public void insetSort() {
        int index;
        int current;
        long start = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            index = i - 1;//当前值的前一个索引
            current = array[i];//当前值
            while (index >= 0 && array[index] > current) {//如果前一个值大于当前值 或者 index<0 (<0说明值比完了)
                array[index + 1] = array[index];//将前一个值往后推
                index--;//索引往前移一位
            }
            //前面的值小于当前值, 将当前值存在 index+1 的位置, 因为while里减多了一次, 所以加回来
            array[index + 1] = current;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);//1909
        //for (int i = 0; i < array.length; i++) {
        //    System.out.print(array[i] + " ");
        //}
    }
}
