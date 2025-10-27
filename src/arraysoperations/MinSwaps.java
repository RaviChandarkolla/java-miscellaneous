package arraysoperations;

import java.util.*;

public class MinSwaps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(37, 4, 89, 62, 23, 94, 15, 77, 48, 56);
        int count = minSwaps(list);
        System.out.println(count);
    }

    public static int minSwaps(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        int n = list.size();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sortedList.get(i), i);
        }

        int[] targetPositions = new int[n];

        for (int i = 0; i < n; i++) {
            targetPositions[i] = map.get(list.get(i));
        }

        for (int i = 0; i < targetPositions.length; i++) {
            System.out.print(targetPositions[i] + " ");
        }
        System.out.println();

        int swap = 0;

        for (int i = 0; i < n; i++) {
            while (targetPositions[i] != i) {
                swap++;
                int tmp = targetPositions[i];
                targetPositions[i] = targetPositions[targetPositions[i]];
                targetPositions[tmp] = tmp;
                printArr(targetPositions);
            }
        }

        return swap;
    }

    public static void printArr(int[] targetPositions) {
        for (int j = 0; j < targetPositions.length; j++) {
            System.out.print(targetPositions[j] + " ");
        }
        System.out.println();
    }
}


