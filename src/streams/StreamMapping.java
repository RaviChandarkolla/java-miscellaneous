package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Mapping in Java Streams is done using the map() method, which transforms each element in the stream by applying a
// given function, creating a new stream with the results.
public class StreamMapping {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");

// Convert each String to an Integer using map, then collect the results into a List
        List<Integer> intNumbers = numbers.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(intNumbers);
    }
}
