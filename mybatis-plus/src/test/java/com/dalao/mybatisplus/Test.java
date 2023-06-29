package com.dalao.mybatisplus;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        try {
            System.out.print("请输入：");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            if (i < 0 || i > 2147483647){
                throw new Exception();
            }
            int count = Test.math(i);
            System.out.println(i + "以内一共有：" + count + "个素数");
        } catch (Exception e) {
            System.out.println("请输入0-2147483647范围内的整数");
            Test.main(args);
        }
    }

    private static int math(int i){

        int count = 0;

        for (int num = 2; num <= i; num++){
            for (int j = 1; j <= num; j++){
                if (num%j == 0){
                    if (j != 1 && j != num){
                        break;
                    }
                }
                if (num == j){
                    System.out.print(num + "\t");
                    count ++;
                }
                if (num == i){
                    System.out.println();
                }
            }
        }
        return count;
    }
}
