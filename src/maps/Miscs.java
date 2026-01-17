package maps;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Miscs {
    public static void main(String[] args) {
        char[] c = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 3;
        int count = leastInterval(c, n);
        System.out.println(count);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(map.isEmpty());
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
                continue;
            }
            map.put(tasks[i], 1);
            set.add(tasks[i]);
        }

//        for (Character element : set) {
//            System.out.println(map.containsKey(element));
//            if (map.containsKey(element)) {
//                if (map.get(element) - 1 == 0) {
//                    map.remove(element);
//                } else {
//                    map.put(element, map.get(element) - 1);
//                }
//            }
//        }

        System.out.println(map);
        System.out.println(map.isEmpty());


        int count = 0;

        while (!map.isEmpty()) {
            int i = 0;
            System.out.println(map);
            for (Character element : set) {
                if (map.containsKey(element)) {
                    if (map.get(element) - 1 == 0) {
                        map.remove(element);
                    } else {
                        map.put(element, map.get(element) - 1);
                    }
                    i++;
                    count++;
                }
            }
            while (i < n) {
                count++;
                i++;
            }
        }
        return count;
    }
}
