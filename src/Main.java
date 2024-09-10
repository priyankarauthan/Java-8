import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.partitioningBy;

public class Main {
    public static void main(String[] args) {
        separationOfEvenOddNumberInList();

    }

    public static void separationOfEvenOddNumberInList()
    {
        List<Integer>list = Arrays.asList(1,5,1001,76,3);
        Collection<List<Integer>> evenOdd=list.stream().collect(collectingAndThen(partitioningBy(i->i%2==0), Map::values));
        System.out.println(evenOdd);
    }
}