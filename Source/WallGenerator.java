import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

//Trieda na generovanie stien
public class WallGenerator {

    private ArrayList<Wall> listOfWalls;


    /**
     * Slúži na generovanie zoznamu stien, s ktorým môžeme pracovať pri hit detection
     *
     * Pri hladani rieseni na generovanie nahodnosti, som nasiel ze ThreadLocalRandom je novsia a lepsia metoda
     *
     * Niektore zdroje popisujuce problematiku:
     *     - https://www.geeksforgeeks.org/random-vs-threadlocalrandom-classes-in-java/
     *     - https://stackoverflow.com/questions/23396033/random-over-threadlocalrandom
     *     - https://www.baeldung.com/java-thread-local-random
     */
    public WallGenerator() {

        this.listOfWalls = new ArrayList<>();

    }

    /**
     * Vráti zoznam naších stien
     * @return ArrayList stien
     */
    public ArrayList<Wall> getListOfWalls() {
        return this.listOfWalls;
    }

    /**
     * Najdôležitejšia metóda, generuje steny na základe počtu, ktoré mu pošleme
     * @param numberOfWalls počet stien, ktorá metóda vygeneruje
     */
    public void generateWalls(int numberOfWalls) {

        // Lokalne premenne urcujuce vysku, sirku a farbu stien ktore generujeme
        int width = 50;
        int height = 10;
        String color = "white";

        // Iteracia v ktorej vytvorime steny na zaklade poctu ktore nam prisli pomocou spravy
        for (int i = 0; i < numberOfWalls; i++) {

            // Generacia nahodnych suradnic
            int suradnicaX = ThreadLocalRandom.current().nextInt(0, 455);
            int suradnicaY = ThreadLocalRandom.current().nextInt(0, 800);

            // Pridanie do zoznamu
            this.listOfWalls.add(new Wall(
                    width,
                    height,
                    color,
                    new Coordinates(suradnicaX, suradnicaY))
            );
        }
    }
}
