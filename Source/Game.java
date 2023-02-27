import fri.shapesge.Manager;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private BallGenerator balls;
    private WallGenerator walls;
    private Rocket rocket;
    private Manager manager;
    private RocketUserControl userControl;
    private RocketHitDetection rocketHitDetection;
    private RocketPowerups rocketPowerups;
    private NameSelector nameSelector;
    private WelcomeScreen welcomeScreen;
    private boolean isStarted;

    /**
     * Je spustac hry, spusti nam celu hru a spoji ju do kopy
     * @param nameSelector - z mainu nam posle vystup z vyberu mena
     * @param welcomeScreen - posiela kvoli kontrole booelanu na spustenie hry
     */
    public Game(NameSelector nameSelector, WelcomeScreen welcomeScreen) {

        this.isStarted = false;

        this.nameSelector = nameSelector;

        this.welcomeScreen = welcomeScreen;

        this.manager = new Manager();
        this.manager.manageObject(this);

    }

    /**
     * Metóda, ktorá by mala byť zavolaná len jeden jediný krát
     * Stará sa o spustenie hry, vytvorí raketku, spustí ovládanie, manažéra, vygeneruje lopty a steny na základe
     * obtiažnosti a spustí kontrolu dotykov s objektami
     * @throws IOException - hádže kvôli práci s points, ktoré sa nachádzajú v inej triede
     */
    public void startGame() throws IOException {

        if (this.isStarted) {
            return;
        }

        this.isStarted = true;

        this.rocket = new Rocket();

        this.userControl = new RocketUserControl(this.rocket);
        this.manager.manageObject(this.userControl);

        this.rocketPowerups = this.rocket.getRocketPowerups();

        this.balls = new BallGenerator();
        this.walls = new WallGenerator();

        switch (this.welcomeScreen.getWelcomeScreenDifficultySelection()) {
            case EASY: {
                this.walls.generateWalls(2);
                this.balls.generateBalls(5);
                break;
            }
            case MEDIUM: {
                this.walls.generateWalls(5);
                this.balls.generateBalls(10);
                break;
            }
            case HARD: {
                this.walls.generateWalls(10);
                this.balls.generateBalls(20);
                break;
            }
        }

        this.rocketHitDetection = new RocketHitDetection(this.rocket, this.walls, this.balls, this.rocketPowerups);
    }

    /**
     * Používane hlavne pri zápise mena do súborov, získa nám z input boxu pri spustení programu meno hráča
      * @return vracia String
     */
    public String getName() {
        return this.nameSelector.getName();
    }

    /**
     * Vďaka knižnici shapesGE je volaná každý 25 milisekúnd nastavených v konfiguračnom súbore sbge.ini
     * Stará sa o to či už je WelcomeScreen zavretá, či je hra spustená, a následne posúva lopticky, kontrolu detekciu
     * hitu, zbiera a spawnuje powerupy
     * @throws IOException
     */
    public void gameTick() throws IOException {

        if (this.welcomeScreen.isFinished() && !this.isStarted) {
            this.startGame();
        }

        if (!this.isStarted) {
            return;
        }

        for (Ball ball : this.balls.getListOfBalls()) {
            ball.moveCircle();
        }

        if (this.rocketHitDetection.isHit()) {
            this.rocket.gotHit(this);
        }

        this.rocketHitDetection.collectPowerup();

        this.spawnPowerUps();

    }

    /**
     * Lokálna metóda určená na náhodené spawnované powerupov
     * Momentálne nastavené na 0.2% šanca, že sa spawwne powerup každých 25ms
     * Taktiež náhodne spawnuje jedno alebo druhé, na plátne však môže byť len jeden powerup,
     * čiže sa môže stať že ak aj 0.2% šanca prejde, nemusí spawnuť nič, pretože to už bolo spawnuté
     */
    private void spawnPowerUps() {
        double rand = ThreadLocalRandom.current().nextDouble(0, 1);
        if (rand < 0.002) {
            int rand2 = ThreadLocalRandom.current().nextInt(0, 2);
            switch (rand2) {
                case 0: {
                    this.rocketPowerups.spawnDoublePoints();
                    break;
                }
                case 1: {
                    this.rocketPowerups.spawnGhost();
                    break;
                }
            }
        }
    }
}