package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionLambdaExample {
    public static void main(String[] args) {
        List<String> pets = Arrays.asList("Dog", "Cat");
//        Function<String, String> toUpperCase = x -> x.toUpperCase();
//        pets.stream().map(x -> toUpperCase.apply(x)).forEach(System.out::println);
        Function<String, String> toUpperCase = String::toUpperCase;
        pets.stream().map(toUpperCase).forEach(System.out::println);
    }
}
