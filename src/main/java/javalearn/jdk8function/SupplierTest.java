
package javalearn.jdk8function;

import java.util.Optional;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * JDK8 Supplier（供给型）接口
 * 是一个容器，可以用来存储数据，然后可以供其他方法使用的这么一个接口
 * <p>
 * 还有 IntSupplier 、DoubleSupplier 、LongSupplier 、BooleanSupplier
 *
 * @author wuduolin
 * @version $Id: SupplierTest.java, v 0.1 2022年01月08日 9:03 PM wuduolin Exp $
 */
public class SupplierTest {
    public static void main(String[] args) {
        //1 使用Supplier接口实现方法
        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return new Random().nextInt();
            }
        };
        System.out.println("supplier : " + supplier.get());

        //2 使用lambda表达式
        Supplier supplierLambda = () -> new Random().nextInt();
        System.out.println("supplierLambda : " + supplierLambda.get());

        //
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Optional<Integer> integerOptional = integerStream.filter(integer -> integer > 3).findFirst();
        System.out.println("integerOptional.orElse : " + integerOptional.orElse(0));

        // 直接返回100
        Supplier supplier1 = () -> 100;
        //3 Optional.orElseGet的参数类型为 Supplier
        System.out.println("Optional.orElseGet : " + integerOptional.orElseGet(supplier1));

        // IntSupplier 、DoubleSupplier 、LongSupplier 、BooleanSupplier
        IntSupplier intSupplier = () -> 999;
        System.out.println("intSupplier : " + intSupplier.getAsInt());
    }
}