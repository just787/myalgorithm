
package javalearn.jdk8function;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * JDK8 Consumer（消费型）接口
 * <p>
 * ① Consumer是一个接口，并且只要实现一个 accept 方法，就可以作为一个“消费者”输出信息。
 * ② 其实，lambda 表达式、方法引用的返回值都是 Consumer 类型，所以，他们能够作为 forEach 方法的参数，并且输出一个值
 * <p>
 * 除了上面使用的 Consumer 接口，还可以使用下面这些 Consumer 接口。
 * IntConsumer、DoubleConsumer、LongConsumer、BiConsumer
 *
 * @author wuduolin
 * @version $Id: ConsumerTest.java, v 0.1 2022年01月08日 8:33 PM wuduolin Exp $
 */
public class ConsumerTest {
    public static void main(String[] args) {
        //1 使用Consumer接口实现方法
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("accept : " + s);
            }
        };

        Stream<String> stringStream = Stream.of("aaa", "bbb", "ccc");
        // forEach需要的参数就是一个Consumer
        stringStream.forEach(consumer);

        //2 lambda表达式其实就是一个Consumer
        Consumer<String> consumerLambda = s -> {
            System.out.println("lambda : " + s);
        };
        stringStream = Stream.of("aaa1", "bbb1", "ccc1");
        stringStream.forEach(consumerLambda);
        //stringStream.forEach(s -> System.out.println("lambda : " + s));

        //3 方法引用其实就是一个Consumer
        Consumer<String> consumer1 = System.out::println;
        stringStream = Stream.of("aaa2", "bbb2", "ccc2");
        stringStream.forEach(consumer1);
        //stringStream.forEach(System.out::println);

        // IntConsumer、DoubleConsumer、LongConsumer、BiConsumer
        IntConsumer integerIntConsumer = System.out::println;
        integerIntConsumer.accept(111);
    }
}