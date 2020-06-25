package com.imood.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 *     判断一个string是否是另一个string的子串是一个普遍且重要的问题。
 *     现在你也要来解决一个关于子串的小问题。我们现在有一个数量不是很大的string库(0<N <= 500)，
 *     并且每个string(1<=len <= 20)都不是很长。对给定的string（0<M <= 1000），
 *      你要写一个程序算出它是库中多少个string的子串。
 * @author: 微信公众号：码上Java
 * @createDate: 2020/6/25/0025
 * @version: 1.0
 */
public class Test_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<String> lib = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String input = scanner.next();
                lib.add(input);
            }

            int m = scanner.nextInt();
            List<String> toCheck = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String input = scanner.next();
                toCheck.add(input);
            }

            for (int i = 0; i < toCheck.size(); i++) {
                int count = 0;
                for (int j = 0; j < lib.size(); j++) {
                    if (lib.get(j).contains(toCheck.get(i)))
                        ++count;
                }
                System.out.println(count);
            }
        }
        scanner.close();
    }
}
