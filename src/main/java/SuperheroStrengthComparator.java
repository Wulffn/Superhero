import java.util.Comparator;

public class SuperheroStrengthComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Double.compare(o1.getStrength(), o2.getStrength());
    }
}
