import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Stream;

import static java.util.List.of;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        arrangeInAscendingOrder();
        arrangeInDescendingOrder();
        separationOfEvenOddNumberInList();
        distinctElementsInList();
        secondLargestNumberFromList();
        calculatePersonAgeInYear();
        firstTenOddNumbers();
        removeDuplicateFromList();
        limitTest();
        limitTestWithMap();

    }
    private static void calculatePersonAgeInYear() {
        LocalDate birthDate = LocalDate.of(2001, 8, 17);
        LocalDate presentDate = LocalDate.now();
        int age = Period.between(birthDate,presentDate).getYears();
        System.out.print("Age of the person is:" +age);
    }
    public static void firstTenOddNumbers()
    {
       List<Integer>list = Stream.iterate(1,i->i+2)
                .limit(10).toList();
       System.out.println("\nFirst Ten Odd Numbers Are:");
       list.forEach(System.out::println);
    }

    public static void removeDuplicateFromList()
    {
        List<Integer>list = Arrays.asList(1,3,3,4,6,6,8,1);
        System.out.println("List after removing duplicates"+list.stream().distinct().collect(toList()));
    }


    public static void separationOfEvenOddNumberInList() {
        List<Integer> list = Arrays.asList(1, 5, 1001, 76, 3);
        Collection<List<Integer>> evenOdd = list.stream().collect(collectingAndThen(partitioningBy(i -> i % 2 == 0), Map::values));
        System.out.println(evenOdd);
    }

    public static void distinctElementsInList(){
        List<Integer> list = of(1, 2, 3, 4, 1, 6, 7, 8, 9, 10);
        System.out.println("Distinct elements are:");
        list.stream().distinct().toList().forEach(System.out::println);
    }
    public static void limitTest(){
        List<Integer> list = of(1, 9,9,60);
        System.out.println("Limit elements are:");
        list.stream().limit(2).forEach(System.out::println);
    }
    public static void limitTestWithMap(){
        List<Integer> list = of(1, 9,9,60);
        System.out.println("Limit  2 elements are:");
        Stream<Integer>result = list.stream().limit(2).map(i->i%2);
        System.out.println(result.toList());
    }
    public static void arrangeInAscendingOrder(){
        List<Integer> list = of(90,80, 9,9,60);
        System.out.println("Ascending Order Sequence Is:");
        list.stream().sorted().toList().forEach(System.out::println);
        list.sort(Comparator.naturalOrder());
    }
    public static void arrangeInDescendingOrder(){List<Integer> list = of(90, 9,9,60);
        System.out.println("Descending Order Sequence Is:");
        list.sort(Comparator.reverseOrder());
    }


    private static void secondLargestNumberFromList() {
        List<Integer> oneToTen = of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer secondMax = oneToTen.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(Integer.MAX_VALUE);
    }



}