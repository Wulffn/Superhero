import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {


    public void saveData(ArrayList<Superhero> superheroes) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("data/SuperheroData.csv"));

        for (Superhero superhero : superheroes) {
            output.print("");
            output.print(superhero.getSuperheroName() + ";");
            output.print(superhero.getSuperPowers() + ";");
            output.print(superhero.getRealName() + ";");
            output.print(superhero.getYearCreated() + ";");
            output.print(superhero.getIsHuman() + ";");
            output.print(superhero.getStrength() + ";");

            output.println("");

            //superheroes.add(superhero);

        }
        output.close();

    }

    public void loadData(ArrayList<Superhero> superheroes) throws FileNotFoundException {

        Scanner scanList = new Scanner(new File("data/SuperheroData.csv"));

        superheroes.clear();

        while (scanList.hasNextLine()) {
            String scan = scanList.nextLine();

            Superhero superhero = splitLines(scan);

            superheroes.add(superhero);
        }

    }

    private Superhero splitLines(String scan) {
        String[] split = scan.split(";");
        Superhero superhero = new Superhero();

        superhero.setSuperheroName(split[0]);
        superhero.setSuperPowers(split[1]);
        superhero.setRealName(split[2]);
        superhero.setYearCreated(Integer.parseInt(split[3]));
        superhero.setIsHuman(split[4]);
        superhero.setStrength(Double.parseDouble(split[5]));

        return superhero;
    }



}