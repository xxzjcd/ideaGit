package com.lmm;

public class ClassInitTest {
    static {
        i = 0;
        //System.out.println(i);//报错,非法向前引用
    }

    static int i = 1;

    public static void main(String[] args) {
        System.out.println(i);//值为1
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        //true -128到127之间从 static final Integer cache[]里取，其他就新new一个，所以地址值相同（看valueOf方法）
        System.out.println(c == d);
        System.out.println(e == f);//false 因为是新new的，地址值不同
        System.out.println(c == (a + b));//true 包装类的 == 在不遇到算术运算的情况下不会自动拆箱,这里自动拆箱
        System.out.println(c.equals(a + b));//true 看equals方法
        System.out.println(g == (a + b));//true 自动拆箱
        System.out.println(g.equals(a + b));//false 看equals方法，不进行类型处理
    }
}


class Sub {

}