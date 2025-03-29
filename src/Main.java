import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {


    interface ZeroArgument {
        public void myFunc();
    }

    public interface OneArgument {
        public void myFunc(String str);
    }

    public interface TwoArgument {
        public int myFunc(int a, int b);
    }

    public static void printZero(ZeroArgument z0) {
        z0.myFunc();
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

//        ZeroArgument z = () -> System.out.println("Hello I am interface");
//        printZero(z);
//
//        OneArgument one = (j) -> System.out.println("Jeg er et interface med et parameter " + j);
//        one.myFunc("Jens");
//
//        TwoArgument two = (x, y) -> x + y;
//        int i1 = two.myFunc(5, 6);
//        System.out.println("i1=" + i1);
//        TwoArgument twomult = (x, y) -> x * y;
//        int i2 = twomult.myFunc(4, 5);
//        System.out.println("i2=" + i2);

//        Consumer<String> toUpper = x -> System.out.println(x.toUpperCase());
//        toUpper.accept("viggo");
//
//        Consumer<Long> square = t -> System.out.println(t * t);
//        square.accept(50L);
//
//        List<String> lstStr = Arrays.asList("hej", "du", "der");
//        List<Long> lstInt = Arrays.asList(10L, 20L, 30L);
//
//        forEachString(lstStr, toUpper);
//        forEach(lstStr, toUpper);
//        forEach(lstInt, square);


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        TwoArgument twoplus = (x, y) -> x + y;
        int ss = sumTwoArgFunction(list, twoplus);
        System.out.println(ss);
        TwoArgument twomult = (x, y) -> x * y;
        ss = sumTwoArgFunction(list, twomult);
        System.out.println(ss);

        List<Integer> dollarSedler = Arrays.asList(1, 5, 10);
        int pengedk = valutaomregner(dollarSedler, twomult, 6);
        System.out.println("du har dk=" + pengedk);


    }

    static void forEachString(List<String> listOfStrings, Consumer<String> consumer) {
        for (String element : listOfStrings) {
            consumer.accept(element);
        }
    }

    static <T> void forEach(List<T> lst, Consumer<T> consumer) {
        for (T element : lst) {
            consumer.accept(element);
        }
    }

    static int sumTwoArgFunction(List<Integer> list, TwoArgument two) {
        int sum = 0;
        for (int t : list) {
            sum += two.myFunc(t, t);
        }
        return sum;
    }

    static int valutaomregner(List<Integer> list, TwoArgument two, int kurs) {
        int sum = 0;
        for (int t : list) {
            sum += two.myFunc(t, kurs);
        }
        return sum;
    }
}
