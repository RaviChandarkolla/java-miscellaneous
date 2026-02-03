package interviews.celigo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Imagine we are building an application that is used by many different customers.
 * We want to avoid one customer being able to overload
 * the system by sending too many requests, so we enforce a per-customer rate limit.
 * The rate limit is defined as:
 * “Each customer can make X requests per Y seconds”
 * // Perform rate limiting logic for provided customer ID. Return true if the
 *
 * // request is allowed, and false if it is not.
 *
 * boolean rateLimit(int customerId)
 */

class RequestDetails {

    private final Queue<Long> times = new LinkedList<>();
    private final AtomicInteger count = new AtomicInteger(0);

    private static final int MAX_REQ = 5; // x requests
    private static final int TIME_WINDOW = 10; // y seconds ~

    synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        long windowStartTime = currentTime  - TIME_WINDOW  * 1000l;

        while (!times.isEmpty() && times.peek() < windowStartTime) {
            times.poll();
            count.decrementAndGet();
        }

        // allowing customer
        if(count.get() < MAX_REQ) {
            times.offer(currentTime);
            count.incrementAndGet();
            return true;
        }

        return false;

    }
}

public class RateLimiterReference {

    // map which contains customer id and request details
    private final Map<Integer, RequestDetails> customerRequestDetails = new ConcurrentHashMap<>();


    // check rate limit to weather allow customer or not
    boolean rateLimit(int customerId) {

        return customerRequestDetails.computeIfAbsent(customerId, id -> new RequestDetails())
                .allowRequest();
    }


    public static void main(String[] args) throws InterruptedException {
        RateLimiterReference testRateLimit = new RateLimiterReference();

        List<Integer> customerIDs = new ArrayList<>();
        customerIDs.add(111);
        customerIDs.add(222);
        customerIDs.add(333);
        customerIDs.add(444);

        customerIDs.parallelStream().forEach(customerId -> {
            // Test the rate limit
            for(int index = 0; index <20; index++) {
                try {
                    boolean customerAllowed = testRateLimit.rateLimit(customerId);
                    System.out.println("Customer ID:"+ customerId + " - Request " + (index+1) + ":" + customerAllowed);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }

            }
        });


    }
}
