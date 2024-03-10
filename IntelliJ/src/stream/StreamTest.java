package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // tworzenie strumienia

        List<String> names = Arrays.asList("Tom", "John", "Kate", "Juliet");

        Stream<String> streamNames = names.stream();
        Stream<Integer> integerStream = Arrays.asList( new Integer[]{1,2,3,8,9}).stream();
        DoubleStream doubleStream = DoubleStream.of(8,5,3,6,89,1);
        IntStream intStream = IntStream.range(1,100);

        //przetwarzanie danych
        //filter - filtrowanie
        //map - zmiana elementu na coś innego
        //limit- zwaraca nam określoną liczbę elementów
        //peek- pozwala przeprowadzić operacje na każdym elemencie

        // forEach - wykonanie akcji dla każdego z elementów strumienia
        // count - zwróci liczbę elementów w strumieniu
        // allMatch - sprawdza czy elementy spełniają jakiś warunek
        // collect - zwraca nowy typ na podstawie strumienia

        /*streamNames.filter(el -> el.startsWith("T"))
                   .map(el ->el.toUpperCase())
                   .forEach(el -> System.out.println(el));*/

        long count= intStream.filter(el -> el>20)
                .map(el ->el*2)
                .limit(10)
                .count();
        System.out.println(count);

        List<String> listNames = streamNames.filter(el -> el.startsWith("T"))
                        .map(el -> el.toUpperCase())
                        .collect(Collectors.toList());
        System.out.println(listNames.get(0));
        System.out.println(listNames.size());

    }
}
