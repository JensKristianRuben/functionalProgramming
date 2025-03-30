import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;

public class Soldier {


    private int rank;

    private String name;

    public Soldier(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Soldier(6, "Jens"));
        soldiers.add(new Soldier(2, "Jesper"));
        soldiers.add(new Soldier(3, "Soldier3"));
        soldiers.add(new Soldier(4, "Soldier4"));
        soldiers.add(new Soldier(1, "Soldier1"));
        soldiers.add(new Soldier(5, "Soldier5"));

        Predicate<Soldier> isHighRanked = soldier -> soldier.getRank() > 3;

        Predicate<Soldier> startsWithJ = s -> s.getName().startsWith("J");

        soldiers.forEach(s -> System.out.println(s));

        Stream<Soldier> highRankingSoldiers = soldiers.stream().filter(isHighRanked);

        System.out.println("------------");
        highRankingSoldiers.forEach(soldier -> System.out.println(soldier));

        System.out.println("-------------");
        Stream<Soldier> highAndJ = soldiers.stream().filter(startsWithJ).filter(isHighRanked);
        highAndJ.forEach(System.out::println);
        List<Soldier> soldierList = highAndJ.collect(Collectors.toList());


        Function<Soldier, String> getnames = soldier -> soldier.getName();
        List<String> list = soldierList.stream().map(getnames).collect(Collectors.toList());
    }
}
