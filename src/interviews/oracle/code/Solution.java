package interviews.oracle.code;

// array of numbers [1,2,3,4,5,4,5,5,5]
// k integer - 1 - top frequent elements
//
// val, count

//1,1
//4,2
//5,4


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,4,5,5,5};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int freq = 0;
            if (map.containsKey(input[i])) {
                freq = map.get(input[i]);
            }
            freq++;
            map.put(input[i], freq);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int[] elem = new int[] {entry.getKey(), entry.getValue()};
            queue.offer(elem);

        }


    }

}
