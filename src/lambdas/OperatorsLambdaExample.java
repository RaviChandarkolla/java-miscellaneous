package lambdas;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorsLambdaExample {
    public static void main(String[] args) {
//        UnaryOperator<String> toUpperCase = x -> x.toUpperCase();
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("dog"));

//        BinaryOperator<Integer> addition = (x, y) -> x + y;
        BinaryOperator<Integer> addition = Integer::sum;
        System.out.println(addition.apply(2, 3));
    }
}
