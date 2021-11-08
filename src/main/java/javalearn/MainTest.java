package javalearn;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: test1111
 * @author: leo
 * @createDate: 2021/7/23 16:57
 * @version: 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");

        stringSet.forEach(s -> s = "c");

        stringSet.forEach(System.out::println);

    }
}
