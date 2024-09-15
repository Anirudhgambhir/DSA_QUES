package learn.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Streams {
    public static void main(String[] args) {
        testingStreams();
    }

    public static void streamsParallel() {
        long now = System.nanoTime();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sum of all numbers using parallel stream
        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);

        System.out.println("Parallel - " + sum);// Output: 55
        long end = System.nanoTime();
        System.out.println("Time Taken - " +  (end - now));
    }

    public static void streams() {
        long now = System.nanoTime();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Sum of all numbers using parallel stream
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("SINGLE - " + sum); // Output: 55
        long end = System.nanoTime();
        System.out.println("Time Taken - " +  (end - now));
    }

    public static void testingStreams() {
        List<Integer> numbers = IntStream.rangeClosed(1, 100000000).boxed().collect(Collectors.toList());

        // Sequential Stream
        long startTime = System.currentTimeMillis();
        int sequentialSum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        long sequentialTime = System.currentTimeMillis() - startTime;
        System.out.println("Sequential sum: " + sequentialSum + " in " + sequentialTime + " ms");

        // Parallel Stream
        startTime = System.currentTimeMillis();
        int parallelSum = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();
        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("Parallel sum: " + parallelSum + " in " + parallelTime + " ms");
    }
}
