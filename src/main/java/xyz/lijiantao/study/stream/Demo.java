package xyz.lijiantao.study.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * java stream demo
 *
 * @author Jiantao Li
 * @date 2020/3/13 16:11
 */
public class Demo {

    public static void main(String[] args) {
        /**
         * filter
         */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);

        /**
         * foreach
         */
        Random random = new Random(1);
        random.ints().limit(10).sorted().forEach(System.out::println);

        /**
         * map
         */
        List<Integer> integers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squareList = integers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squareList.forEach(System.out::println);


        /**
         * Collectors
         */
        List<String> stringss = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        String ss = stringss.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(","));
        System.out.println("Collectors: " + ss);

        /**
         * Statistics
         */
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics summaryStatistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + summaryStatistics.getMax());
        System.out.println("列表中最小的数 : " + summaryStatistics.getMin());
        System.out.println("所有数之和 : " + summaryStatistics.getSum());
        System.out.println("平均数 : " + summaryStatistics.getAverage());
    }


}
