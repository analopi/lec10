package com.practice;
import java.util.*;
import java.util.stream.*;

class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 23, "London"),
                new Person("Bob", 30, "Paris"),
                new Person("Charles", 25, "New York"),
                new Person("Diana", 32, "London"),
                new Person("Elise", 20, "Paris")
        );

        // Запрос 1: Получить список имен людей старше 25 лет
        List<String> names = people.stream()
                .filter(p -> p.getAge() > 25)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println("Имена людей старше 25: " + names);

        // Запрос 2: Посчитать количество людей, живущих в Лондоне
        long countLondon = people.stream()
                .filter(p -> p.getCity().equals("London"))
                .count();
        System.out.println("Кол-во людей живущих в Лондоне " + countLondon);

        // Запрос 3: Проверить, есть ли в списке хотя бы один человек с именем "Alice"
        boolean hasAlice = people.stream()
                .anyMatch(p -> p.getName().equals("Alice"));
        System.out.println("Здесь есть Alice? " + hasAlice);

        // Запрос 4: Отсортировать людей по возрасту
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("Люди отсртированные по возрасту: " + sortedByAge);

        // Запрос 5: Получить список уникальных городов, в которых живут люди
        List<String> cities = people.stream()
                .map(Person::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Города: " + cities);
    }
}