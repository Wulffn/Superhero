import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SuperheroSortingV2{
    private Comparator<Superhero> comparator;
    private boolean ascending;

    public SuperheroSortingV2(Comparator<Superhero> comparator, boolean ascending) {
        this.comparator = comparator;
        this.ascending = ascending;
    }

    public static SuperheroSortingV2 nameSort(boolean ascending) {
        return new SuperheroSortingV2(new SuperheroNameComparator(), ascending);
    }

    public static SuperheroSortingV2 strengthSort(boolean ascending) {
        return new SuperheroSortingV2(new SuperheroStrengthComparator(), ascending);
    }

    public void sort(ArrayList<Superhero> superheroes) {
        superheroes.sort(comparator);
        if(!ascending) {
            Collections.reverse(superheroes);
        }
    }
}
