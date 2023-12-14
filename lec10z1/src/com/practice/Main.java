package com.practice;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        // ������ �� ������ ������ � ���������
        List<Integer> list = random.ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("������ ��������� ������: " + list);

        // ������ �� ������� ����������
        long countPrimes = random.ints(1000, 10, 10000)
                .filter(Main::isPrime)
                .count();
        System.out.println("���������� ������� �����: " + countPrimes);

        // ������, ��� ��������� �������� ��������� �������� � ������
        OptionalInt reducedSum = random.ints(1000, 10, 10000)
                .reduce((a, b) -> a + b);
        System.out.println("����� ���� ��������������� �����: " + reducedSum.orElse(0));

        // ������ ����� �� �������
        random.ints(1000, 10, 10000)
                .limit(10)
                .forEach(System.out::println);

        // ������ � ������������� ���������� � �����
        Map<Integer, Long> numberFrequencyMap = random.ints(1000, 10, 10000)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("������� ������������� ������� �����: " + numberFrequencyMap);
    }

    // �������� ����� ��� �����������, �������� �� ����� �������
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
