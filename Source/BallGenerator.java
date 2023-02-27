import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class BallGenerator {

    private ArrayList<Ball> listOfBalls;

    /**
     * Je trieda sluzacia na generovanie zoznamu guličiek/lôpt, s ktorým budeme môcť neskôr pracovať, ako celkom
     * v rámci hry a nemuseli tak ukladať každú loptičku samostatne, v prípade, že by sa počas hry pridávali ďalšie lopty
     * je pre danú sitáciu vhodnejší arraylist, Array nemôžeme použiť lebo je tu zabudovaná funkcionalita na dogenerovanie
     *
     * Pri hladani rieseni na generovanie nahodnosti, som nasiel ze ThreadLocalRandom je novsia a lepsia metoda
     *
     * Niektore zdroje popisujuce problematiku:
     *     - https://www.geeksforgeeks.org/random-vs-threadlocalrandom-classes-in-java/
     *     - https://stackoverflow.com/questions/23396033/random-over-threadlocalrandom
     *     - https://www.baeldung.com/java-thread-local-random
     */
    public BallGenerator() {
        this.listOfBalls = new ArrayList<>();
    }

    /**
     * Jednoduchý getter na vrátenie našeho zoznamu loptičiek
     * @return vracia ArrayList s objektami Ball
     */
    public ArrayList<Ball> getListOfBalls() {
        return this.listOfBalls;
    }

    /**
     * Najdôležitejšia metóda celej triedy, stará sa o generáciu loptičiek na základe zaslaného čísla
     * Pomocou ThreadLocalRandom určime na základe parametrov zo SBGE.ini naše limity pre našu náhodnosť
     * a následne pridáme a uložíme do zoznamu
     * @param numberOfBalls určuje koľko guličiek vygenerujeme
     */
    public void generateBalls(int numberOfBalls) {

        for (int i = 0; i < numberOfBalls; i++) {

            int speed = ThreadLocalRandom.current().nextInt(2, 6);

            int suradnicaX = ThreadLocalRandom.current().nextInt(0, 480);
            int suradnicaY = ThreadLocalRandom.current().nextInt(0, 800);

            this.listOfBalls.add(new Ball(
                    speed,
                    new Coordinates(suradnicaX, suradnicaY),
                    this.randomStartingPosition())
            );
        }
    }

    /**
     * Lokálna metóda určujúca kde loptička bude začínať, je volaná pri každej generácií nanovo, čiže
     * je 50% šanca, že loptička bude naľavo alebo napravo.
     * @return
     */
    private BallStartingPosition randomStartingPosition() {
        if (ThreadLocalRandom.current().nextInt(0, 2) == 1) {
            return BallStartingPosition.RIGHT;
        } else {
            return BallStartingPosition.LEFT;
        }
    }
}
