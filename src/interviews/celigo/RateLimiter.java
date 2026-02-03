package interviews.celigo;

import java.util.*;

public class RateLimiter {
    public static void main(String[] args) {
        Map<String, List<Long>> map = new HashMap<>();

    }

    // make request
    public boolean makeRequest(Map<String, Queue<Long>> map, String user, Integer maxRequests) {
        if (map.containsKey(user)) {
            Queue<Long> queue = map.get(user);

            // 1...60
            Long currTime = System.currentTimeMillis();
            Long startTime = currTime-(60*1000);


            while(!queue.isEmpty()) {
                if (queue.peek() < startTime) {
                    queue.poll();
                }
            }
            if (queue.size() > maxRequests) {
//                map.put(user, queue);
                return false;
            } else {
                queue.add(currTime);
//                map.put(user, queue);
            }

        } else {
            Queue<Long> qe = new ArrayDeque<>();
            qe.add(System.currentTimeMillis());
            map.put(user, qe);
        }

        return true;
    }
}
