import java.util.*;
import java.util.stream.Collectors;
import static java.util.List.of;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.partitioningBy;

public class Main {
    public static void main(String[] args) {
        separationOfEvenOddNumberInList();
        secondLargestNumberFromList();

    }

    public static void separationOfEvenOddNumberInList() {
        List<Integer> list = Arrays.asList(1, 5, 1001, 76, 3);
        Collection<List<Integer>> evenOdd = list.stream().collect(collectingAndThen(partitioningBy(i -> i % 2 == 0), Map::values));
        System.out.println(evenOdd);
    }

    private static void secondLargestNumberFromList() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer secondMax = oneToTen.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(Integer.MAX_VALUE);
    }
}