package com.imood.string;

import java.util.Arrays;

/**
 * @description:
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/23/0023
 * @version: 1.0
 */
public class StringTest {

    public static void main(String[] args) {
        String str="hello,word";
        String[] split = str.split(",");
        System.out.println(split[0]);
        System.out.println(split[1]);

    }

   /* public String(char value[], int offset, int count) {
        if (offset < 0) {
            throw new StringIndexOutOfBoundsException(offset);
        }
        if (count <= 0) {
            if (count < 0) {
                throw new StringIndexOutOfBoundsException(count);
            }
            if (offset <= value.length) {
                this.value = "".value;
                return;
            }
        }
        // Note: offset or count might be near -1>>>1.
        if (offset > value.length - count) {
            throw new StringIndexOutOfBoundsException(offset + count);
        }
        this.value = Arrays.copyOfRange(value, offset, offset+count);
    }*/



}
