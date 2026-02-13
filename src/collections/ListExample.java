package collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        if (list.get(2) == null) {
            System.out.println("no data at index");
        }
    }
}
