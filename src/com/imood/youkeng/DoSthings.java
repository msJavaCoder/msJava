package com.imood.youkeng;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/18
 * @version: 1.0
 */
public class DoSthings {

    public static void doSomething( int[][] mat)
    {
        for( int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print(mat[row][col] = mat[row][mat[0].length - 1 - col]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
      int[][] mat={
                   {1  ,3 , 5 , 7 , 9 , 11},
                   { 0 , 2 , 4 , 6 , 8 , 10}
                  };
      DoSthings.doSomething(mat);
    }
}
