import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Numbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        List<String> words = Arrays.asList("java", "lambda", "stream", "functional");

        words.stream().map(String::toUpperCase).forEach(System.out::println); // hvad gør parametrene i map?

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(numbers2.stream().reduce(0, Integer::sum));

        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Amalie");


        List<String> newList = names.stream().filter(name -> name.startsWith("A")).map(e -> e.toUpperCase()).collect(Collectors.toList());

        System.out.println(newList);

        List<Integer> numbers3 = Arrays.asList(3, 6, 9);

        Consumer<Integer> printDouble = d -> System.out.println(d*2);

        numbers3.stream().forEach(printDouble);


    }
}
