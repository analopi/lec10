package com.practice;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        // Запрос со сбором данных в коллекцию
        List<Integer> list = random.ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Список собранных данных: " + list);

        // Запрос на подсчет количества
        long countPrimes = random.ints(1000, 10, 10000)
                .filter(Main::isPrime)
                .count();
        System.out.println("Количество простых чисел: " + countPrimes);

        // Запрос, где применяем редукцию множества значений к одному
        OptionalInt reducedSum = random.ints(1000, 10, 10000)
                .reduce((a, b) -> a + b);
        System.out.println("Сумма всех сгенерированных чисел: " + reducedSum.orElse(0));

        // Просто вывод на консоль
        random.ints(1000, 10, 10000)
                .limit(10)
                .forEach(System.out::println);

        // Запрос с формированием результата в карту
        Map<Integer, Long> numberFrequencyMap = random.ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Частота встречаемости каждого числа: " + numberFrequencyMap);
    }

    // Помощник метод для определения, является ли число простым
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
