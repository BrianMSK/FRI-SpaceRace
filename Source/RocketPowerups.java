import fri.shapesge.Image;
import java.util.concurrent.ThreadLocalRandom;

public class RocketPowerups {
    private boolean activeGhost;
    private boolean isGhostSpawned;
    private boolean activeDoublePoints;
    private boolean isDoublePointsSpawned;
    private Image ghostImage;
    private Image doublePointImage;
    private Coordinates ghostCoordinates;
    private Coordinates doublePointsCoordinates;

    /**
     * Stará sa o powerupy, inicializuje ich a následne pomocou ďalších metód sa vytvárajú/skrývajú a nastavuju sa im
     * booleany pre prácu v iných triedach
     */
    public RocketPowerups() {

        this.activeGhost = false;
        this.isGhostSpawned = false;
        this.activeDoublePoints = false;
        this.isDoublePointsSpawned = false;

        // https://cdn-icons-png.flaticon.com/512/2432/2432926.png
        this.ghostImage = new Image("./img/ghost.png");

        // https://cdn-icons-png.flaticon.com/512/5659/5659797.png
        this.doublePointImage = new Image("./img/doublepoints.png");
    }

    /**
     * Kontrola na to či je zobrazený duch na plátne
     * @return vracia boolean
     */
    public boolean isGhostSpawned() {
        return this.isGhostSpawned;
    }

    /**
     * Kontrola či je zobrazený double points powerup na plátne
     * @return vracia boolean
     */
    public boolean isDoublePointsSpawned() {
        return this.isDoublePointsSpawned;
    }

    /**
     * Získava koordinácie na ktorých sa nachádza duch
     * @return vracia objekt Coordinates
     */
    public Coordinates getGhostCoordinates() {
        return this.ghostCoordinates;
    }

    /**
     * Získava koordinácie na ktorých sa nachádza double points powerup
     * @return vracia objekt koordinácie
     */
    public Coordinates getDoublePointsCoordinates() {
        return this.doublePointsCoordinates;
    }

    /**
     * Slúži na zobrazenie ducha na plátne, kontroluje či už nie je spawnutý alebo aktívny
     * Ak nie je, tak zobrazí ducha na náhodných súradniciach vymedzených pre x od 0-400 a pre y od 0-800
     */
    public void spawnGhost() {

        if (this.isGhostSpawned || this.isActiveGhost()) {
            return;
        }

        this.isGhostSpawned = true;

        this.ghostImage.makeInvisible();
        this.ghostImage = new Image("./img/ghost.png", 0, 0);

        int suradnicaX = ThreadLocalRandom.current().nextInt(0, 400);
        int suradnicaY = ThreadLocalRandom.current().nextInt(0, 800);
        this.ghostImage.moveHorizontal(suradnicaX);
        this.ghostImage.moveVertical(suradnicaY);
        this.ghostCoordinates = new Coordinates(suradnicaX, suradnicaY);
        this.ghostImage.makeVisible();
    }

    /**
     * V prípade, že chceme ducha z plátna dať preč, zavoláme túto metódu, ktorá vypne jeho spawn bool,
     * spraví z neho invisible obrázok a vypne koordinácie
     */
    public void despawnGhost() {
        this.isGhostSpawned = false;
        this.ghostImage.makeInvisible();
        this.ghostCoordinates = null;
    }


    /**
     * Zobrazuje na plátne double points powerup v prípade ak nie je už zobrazený alebo aktívny
     * Ak nie je, na základe náhodne vygenerovaných súradníc, zobrazí na plátne
     */
    public void spawnDoublePoints() {

        if (this.isDoublePointsSpawned || this.isActiveDoublePoints()) {
            return;
        }

        this.isDoublePointsSpawned = true;

        this.doublePointImage.makeInvisible();
        this.doublePointImage = new Image("./img/doublepoints.png", 0, 0);

        int suradnicaX = ThreadLocalRandom.current().nextInt(0, 400);
        int suradnicaY = ThreadLocalRandom.current().nextInt(0, 800);
        this.doublePointImage.moveHorizontal(suradnicaX);
        this.doublePointImage.moveVertical(suradnicaY);
        this.doublePointsCoordinates = new Coordinates(suradnicaX, suradnicaY);
        this.doublePointImage.makeVisible();
    }

    /**
     * V prípade, že chceme double points powerup z plátna skryť, zavoláme túto metódu, nastaví bool na false, skryje
     * z plátna a koordinácie nastaví na null
     */
    public void despawnDoublePoints() {

        this.isDoublePointsSpawned = false;

        this.doublePointImage.makeInvisible();
        this.doublePointsCoordinates = null;

    }

    /**
     * Zistuje či je ghost aktívny
     * @return vracia boolean
     */
    public boolean isActiveGhost() {
        return this.activeGhost;
    }

    /**
     * Nastavuje či je ghost aktívny alebo nie je
     * @param activeGhost posiela bool true alebo false
     */
    public void setActiveGhost(boolean activeGhost) {
        this.activeGhost = activeGhost;
    }

    /**
     * Zistuje či je double points powerup aktívny
     * @return vracia bool
     */
    public boolean isActiveDoublePoints() {
        return this.activeDoublePoints;
    }

    /**
     * Nastavuje či je double point aktívny alebo nie je
     * @param activeDoublePoints posiela bool true alebo false
     */
    public void setActiveDoublePoints(boolean activeDoublePoints) {
        this.activeDoublePoints = activeDoublePoints;
    }
}
