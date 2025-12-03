package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListStreams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("6");
        list.add("61");

        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        // prints out of order because parallel streams process elements concurrently
        list.parallelStream().forEach(element -> doWork(element));


        long count = list.stream().distinct().count();
        System.out.println("count=" + count);

        boolean isExist = list.stream().anyMatch(element -> element.contains("1"));
        System.out.println("isExist=" + isExist);


        // filtering
        Stream<String> newStream = list.stream().filter(element -> element.contains("1"));
        newStream.forEach(System.out::println);
    }

    private static void doWork(String element) {
        System.out.println(element);
    }
}
