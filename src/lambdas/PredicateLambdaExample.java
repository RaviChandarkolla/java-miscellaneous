package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateLambdaExample {
    public static void main(String[] args) {
        List<String> pets = Arrays.asList("Dog", "Cat");
        Predicate<String> filterPets = x -> x.startsWith("D");
//        pets.stream().filter(t -> filterPets.test(t)).forEach(System.out::println);
//        pets.stream().filter(filterPets::test).forEach(System.out::println);
        pets.stream().filter(filterPets).forEach(System.out::println);
    }
}
