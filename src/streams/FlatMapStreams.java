package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//  Use map() for 1:1 transformations. Use flatMap() when the mapping function returns collections/streams that need
//  flattening
public class FlatMapStreams {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java is great",
                "Streams are powerful",
                "Functional programming rocks"
        );

        List<List<String>> nestedWords = sentences.stream()
                .map(s -> Arrays.asList(s.split(" ")))  // Each sentence → array of words
                .collect(Collectors.toList());

        System.out.println(nestedWords);

        List<String> allWords = sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))  // Each sentence → stream of words
                .collect(Collectors.toList());

        System.out.println(allWords);
    }
}
