import fri.shapesge.Image;
import java.io.IOException;

public class Rocket {

    private final Image image;
    private final RocketPowerups rocketPowerups;
    private final RocketLives rocketLives;
    private final RocketPoints rocketPoints;
    private Coordinates coordinates;


    /**
     * Trieda slúžiacia na vytvorenie rakety na plátne, inicializuje taktiež body pre raketu, životy a powerupy
     * @throws IOException - vyhadzuje IOException kvôli Points classe, kde pracujeme so súborom
     */

    public Rocket() throws IOException {

        // Zdroj obrazku https://freesvg.org/img/rocket-297573.png
        this.image = new Image("./img/rocket.png", 220, 940);
        this.coordinates = new Coordinates(220, 940);
        this.image.makeVisible();

        this.rocketPoints = new RocketPoints();
        this.rocketPoints.writeScoreOnScreen();

        this.rocketLives = new RocketLives();

        this.rocketPowerups = new RocketPowerups();
    }

    /**
     * Getter na powerupy
     * @return vracia objekt powerupov
     */
    public RocketPowerups getRocketPowerups() {
        return this.rocketPowerups;
    }

    /**
     * Getter na súradnice
     * @return vracia objekt súradníc
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * V prípade, že potrebujeme upraviť alebo zmeniť súradníce, tak nam na to slúži tento setter, kedy prepíšeme
     * objekt pre našu raketu na nové súradnice.
     * @param coordinates posielame anonýmný objekt, ktorý priradíme našemu atribútu
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Trieda, ktorá sa zavolá, v prípade, že sa naša raketa dostala do kontaktu s objektom na plátne,
     * funguje iba ak nie je aktívny ghost powerup, pošle raketu na súradnice 0,0 a následne na začiatok
     * @param game
     * @throws IOException
     */
    public void gotHit(Game game) throws IOException {

        if (this.rocketPowerups.isActiveGhost()) {
            return;
        }

        this.rocketLives.removeLife();

        if (this.rocketLives.getLives() <= 0) {
            this.rocketPoints.savePoints(game);
            this.rocketPoints.resetPoints();
            this.rocketPoints.writeScoreOnScreen();
            this.rocketLives.resetLives();
        }

        if (this.getCoordinates().getX() > 0 && this.getCoordinates().getY() > 0) {
            this.image.moveVertical(-this.getCoordinates().getY());
            this.image.moveHorizontal(-this.getCoordinates().getX());
            this.setCoordinates(new Coordinates(0, 0));
        }
        if (this.getCoordinates().getX() < 0 && this.getCoordinates().getY() < 0) {
            this.image.moveVertical(this.getCoordinates().getY());
            this.image.moveHorizontal(this.getCoordinates().getX());
            this.setCoordinates(new Coordinates(0, 0));
        }
        this.image.moveHorizontal(200);
        this.image.moveVertical(940);
        this.setCoordinates(new Coordinates(200, 940));
    }

    /**
     * Trieda na posúvanie rakety, na základe smeru, ktorý jej pošleme z ENUMu
     * @param rocketMovementDirection ENUM na určenie smeru rakety
     */
    public void moveRocket(RocketMovementDirection rocketMovementDirection) {
        int movement = 6;
        switch (rocketMovementDirection) {
            case UP: {
                if (this.hitTop()) {
                    break;
                }
                this.image.moveVertical(-movement);
                this.setCoordinates(new Coordinates(this.getCoordinates().getX(), this.getCoordinates().getY() - movement));
                break;
            }
            case DOWN: {
                if (this.getCoordinates().getY() >= 940) {
                    break;
                }
                this.image.moveVertical(movement);
                this.setCoordinates(new Coordinates(this.getCoordinates().getX(), this.getCoordinates().getY() + movement));
                break;
            }
            case LEFT: {
                if (this.getCoordinates().getX() <= 0) {
                    break;
                }
                this.image.moveHorizontal(-movement);
                this.setCoordinates(new Coordinates(this.getCoordinates().getX() - movement, this.getCoordinates().getY()));
                break;
            }
            case RIGHT: {
                if (this.getCoordinates().getX() >= 420) {
                    break;
                }
                this.image.moveHorizontal(movement);
                this.setCoordinates(new Coordinates(this.getCoordinates().getX() + movement, this.getCoordinates().getY()));
                break;
            }
        }
    }

    /**
     * Lokálna metóda na kontrolu, či sa raketka dostala na vrchol a či jej pridelíme bod.
     * @return
     */
    private boolean hitTop() {
        if (this.getCoordinates().getY() <= 0) {
            this.image.moveVertical(940);
            this.setCoordinates(new Coordinates(this.getCoordinates().getX(), this.getCoordinates().getY() + 940));
            this.rocketPoints.addPoint(this);
            this.rocketPoints.writeScoreOnScreen();
            return true;
        }
        return false;
    }
}
