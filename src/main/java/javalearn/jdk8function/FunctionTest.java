
package javalearn.jdk8function;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * JDK8 Function（功能型）接口
 * 作用就是转换作用，将输入数据转换成另一种形式的输出数据。
 * <p>
 * ① Function 接口是一个功能型接口，是一个转换数据的作用。
 * ② Function 接口实现 apply 方法来做转换。
 * <p>
 * 除此外还有 IntFunction 、DoubleFunction 、LongFunction 、ToIntFunction 、ToDoubleFunction 、DoubleToIntFunction
 *
 * @author wuduolin
 * @version $Id: FunctionTest.java, v 0.1 2022年01月08日 10:40 PM wuduolin Exp $
 */
public class FunctionTest {
    public static void main(String[] args) {
        //1 定义一个function,泛型的第一个参数是转换前的类型，第二个是转化后的类型
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        System.out.println("function : " + function.apply("abc"));

        //2 map方法就是使用funtion作为执行体
        Stream.of("a", "ab", "abc").map(function).forEach(System.out::println);
        System.out.println(" ----- map ----- ");

        //2 flatMap方法就是使用funtion作为执行体
        Stream.of("123", "1234", "12345").flatMap(new Function<String, Stream<Integer>>() {
            @Override
            public Stream<Integer> apply(String s) {
                // 返回新的流
                return Stream.of(s.length(), s.length() * 100);
            }
        }).forEach(System.out::println);
        System.out.println(" ----- flatMap ----- ");
    }
}