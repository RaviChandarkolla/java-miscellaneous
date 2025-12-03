package streams;

import java.util.Arrays;
import java.util.List;

// Stream API allows reducing a sequence of elements to some value according to a specified function with the help of
// the reduce() method of the type Stream. This method takes two parameters: first – start value, second – an
// accumulator function.
public class ReduceStream {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
        System.out.println(reduced);
    }
}
