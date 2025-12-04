package lambdas;

import java.util.Arrays;
import java.util.List;

// Lambdas, also known as anonymous functions and closures, are blocks of code that can be passed around and executed
public class LambdaExample {
    public static void main(String[] args) {
        List<String> pets = Arrays.asList("Dog", "Cat");
//        pets.forEach(x -> System.out.println(x));
        pets.forEach(System.out::println);

        pets.forEach(x -> {
            System.out.println("Pet name: " + x);
            System.out.println("Pet number: " + pets.indexOf(x));
        });

    }
}

/*
* Lambdas are powerful in Java because they enable concise, expressive, and functional-style programming with less
* boilerplate. They transform verbose anonymous inner classes into short anonymous functions, improving readability and developer productivity.
*
* Seamless Integration with Streams API
* Increased Code Reuse: Lambdas can be assigned to variables and passed around, promoting reusability of behavior.
* */
