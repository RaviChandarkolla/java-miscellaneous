package streams;

import java.util.Arrays;
import java.util.stream.Stream;

//  the stream is created from an existing array, which is a data source that already stores the data in memory.
//  The stream itself does not store or hold the data; instead, it provides a view or pipeline over the underlying
//  array, allowing you to process the elements sequentially or in parallel.

// It’s also worth noting that operations on streams don’t change the source.
public class ArrayStreams {

    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b", "c"};
        // When you do Arrays.stream(arr), it does not copy or store the array elements but creates a stream that
        // references the original array as the source. The elements are accessed on-demand when operations like
        // forEach are performed.
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
    }
}
