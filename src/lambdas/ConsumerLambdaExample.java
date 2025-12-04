package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// A consumer is used to consume a value. It has a method accept which returns void, i.e. doesn’t return anything.
// No, System.out.println() itself is not a Consumer. It is a static method of the PrintStream class.
// However, System.out::println (method reference) can be used as a Consumer when the target type expects a Consumer<T>.
public class ConsumerLambdaExample {
    public static void main(String[] args) {
        List<String> pets = Arrays.asList("Dog", "Cat");
//        Consumer<String> printPet = x -> System.out.println(x);
        Consumer<String> printPet = System.out::println;
        pets.forEach(printPet);
    }
}
