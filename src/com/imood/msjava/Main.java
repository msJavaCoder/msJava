package com.imood.msjava;

/**
 * @description: 三次反转实现字符串循环右边移动N位
 * @author: msJava
 * @createDate: 2020/07/02
 * @version: 1.0
 */
public class Main {

    /**
     * 交换位置
     *
     * @param chars
     * @param begin
     * @param end
     */
    public void swap(char[] chars, int begin, int end) {
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

    public String moveString(String str, int n) {
        char[] chars = str.toCharArray();
        swap(chars, 0, chars.length - 1);
        swap(chars, 0, n - 1);
        swap(chars, n, chars.length - 1);
        return new String(chars);
    }
      /*  public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            String str = input.nextLine();
            //移动位数
            int N = input.nextInt();
            System.out.println(new Main().moveString(str,N));
        }*/


    public static void main(String[] args) {
        System.out.println(3 * 0.1);
    }
}
