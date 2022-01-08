
package javalearn.jdk8function;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * JDK8 Predicate（谓词型）接口
 * 是一个类似于 bool 类型的判断的接口
 *
 * @author wuduolin
 * @version $Id: PredicateTest.java, v 0.1 2022年01月08日 10:27 PM wuduolin Exp $
 */
public class PredicateTest {
    public static void main(String[] args) {
        //1 使用Predicate接口实现方法
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i > 10;
            }
        };
        System.out.println("predicate : " + predicate.test(11));

        //2 使用lambda表达式
        predicate = (i) -> i > 100;
        System.out.println("lambda : " + predicate.test(99));

        //2 filter通过使用predicate判断条件来过滤
        predicate = (i) -> i > 20;
        Stream.of(10, 20, 30).filter(predicate).forEach(System.out::println);
    }
}