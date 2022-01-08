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
    static class Test {
        private String a = "";

        /**
         * Getter method for property <tt>a</tt>.
         *
         * @return property value of a
         */
        public String getA() {
            return a;
        }

        /**
         * Setter method for property <tt>a</tt>.
         *
         * @param a value to be assigned to property a
         */
        public void setA(String a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");

        stringSet.forEach(s -> s = "c");

        stringSet.forEach(System.out::println);

        Test test = new Test();
        test.setA("AAA");
        testFinal(test);
        System.out.println(test.getA());
    }

    static void testFinal(final Test test) {
        test.setA("A");
        System.out.println(test.getA());
    }
}
