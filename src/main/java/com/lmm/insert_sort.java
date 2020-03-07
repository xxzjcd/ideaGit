package com.lmm;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class insert_sort {
    private int[] array = new int[100000];

    @Before
    public void init() {
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            array[i] = random.nextInt(100000);
        }
    }

    @Test
    public void insetSort() {
        int index;
        int current;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
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
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
