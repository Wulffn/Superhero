import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    private Database database = new Database();
    private FileHandler fileHandler = new FileHandler();

    public void createSuperhero(String superheroName, String superPowers, String realName, int yearCreated, String isHuman, double strength) {
        database.createSuperhero(superheroName, superPowers, realName, yearCreated, isHuman, strength);
    }

    //Sorteringsobjekt med oplysninger om hvordan der skal sorteres
    //Switch på typen og sæt en comparator
    //Sorter
    //Reverse hvis det skal være desc
    public ArrayList<Superhero> superHeroOverview(SuperheroSortingV1 sorting) {
        var sortType = sorting.getSort();
        Comparator<Superhero> comparator = null;
        switch (sortType) {
            case NAME -> comparator = new SuperheroNameComparator();
            case STRENGTH -> comparator = new SuperheroStrengthComparator();
        }
        if (comparator != null) {
            database.getSuperheroes().sort(comparator);
            if(!sorting.isAscending()) {
                Collections.reverse(database.getSuperheroes());
            }
        }
        return database.getSuperheroes();
    }

    //Sorteringsobjekt med oplysninger om hvordan der skal sorteres
    //Tager en liste og klarer det hele der
    public ArrayList<Superhero> superHeroOverview(SuperheroSortingV2 sorting) {
        sorting.sort(database.getSuperheroes());
        return database.getSuperheroes();
    }

    //Den lækre
    //Det er med lambda og metode referencer. Kræver nok at du sætter dig ind i streams
    public List<Superhero> superHeroOverview(SortType sortType) {
        var superheroes = database.getSuperheroes();
        switch (sortType) {
            case NAME -> {
                return superheroes.stream()
                        .sorted(Comparator.comparing(Superhero::getSuperheroName))
                        .collect(Collectors.toList());
            }
            case STRENGTH -> {
                return superheroes.stream()
                        .sorted(Comparator.comparing(Superhero::getStrength))
                        .collect(Collectors.toList());
            }
        }
        return database.getSuperheroes();
    }

    public ArrayList<Superhero> searchSuperhero(String superheroName) {
        return database.searchSuperhero(superheroName);
    }

    public void editSuperhero(int index, String superheroName, String superPowers, String realName, int yearCreated, String isHuman, double strength) {
        database.editSuperhero(index, superheroName, superPowers, realName, yearCreated, isHuman, strength);
    }

    public void deleteSuperhero(int index) {
        database.deleteSuperhero(index);
    }

    public void saveData() throws FileNotFoundException {
        fileHandler.saveData(database.getSuperheroes());
    }

    public void loadData() throws FileNotFoundException {
        fileHandler.loadData(database.getSuperheroes());
    }
}
