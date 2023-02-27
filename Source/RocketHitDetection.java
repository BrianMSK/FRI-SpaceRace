import java.util.ArrayList;

public class RocketHitDetection {

    private final Rocket rocket;

    private WallGenerator walls;

    private BallGenerator balls;

    private RocketPowerups rocketPowerups;

    private Countdown countdown;

    /**
     * Trieda, ktorá kontroluje detekciu hitu so stenami, loptičkami a powerupmi
     *
     * @param rocket         posielame objekt rakety aby sme vedeli získavať cez coord getter kde sa raketa nachádza
     * @param walls          posielame objekt zoznamu stien, ktorý vieme prechádzať a porovnávať s lokalitou rakety
     * @param balls          posielame objekt zoznamu loptičiek, ktorý vieme prechádzať a porovnávať s lokalitou rakety
     * @param rocketPowerups posielame booly powerupov a ich súradnice pre kontrolu detekcie lokality s raketou
     */
    public RocketHitDetection(Rocket rocket, WallGenerator walls, BallGenerator balls, RocketPowerups rocketPowerups) {
        this.rocket = rocket;
        this.walls = walls;
        this.balls = balls;
        this.rocketPowerups = rocketPowerups;
        this.countdown = new Countdown();
    }

    /**
     * Verejná metóda na kontrolu zbierania powerupov, kontroluje či sú objekty spawnuté, či majú nastavené
     * koordinácie a taktiež ich polohu vzhľadom na polohu rakety
     *
     * @return vracia boolean
     */
    public boolean collectPowerup() {

        int sizeOfRocket = 60;
        int rocketX = this.rocket.getCoordinates().getX();
        int rocketY = this.rocket.getCoordinates().getY();

        if (this.rocketPowerups.isGhostSpawned() && this.rocketPowerups.getGhostCoordinates() != null) {
            int ghostX = this.rocketPowerups.getGhostCoordinates().getX();
            int ghostY = this.rocketPowerups.getGhostCoordinates().getY();

            if ((rocketY <= ghostY + 32 &&
                    rocketY >= ghostY - sizeOfRocket)
                    &&
                    (rocketX >= ghostX - 32 &&
                            rocketX <= ghostX + 32)) {
                this.rocketPowerups.despawnGhost();
                this.rocketPowerups.setActiveGhost(true);
                this.countdown.startGhostCountdown(15);
                return true;
            }

        }
        if (this.rocketPowerups.isDoublePointsSpawned() && this.rocketPowerups.getDoublePointsCoordinates() != null) {

            int doublePointsX = this.rocketPowerups.getDoublePointsCoordinates().getX();
            int doublePointsY = this.rocketPowerups.getDoublePointsCoordinates().getY();

            if ((rocketY <= doublePointsY + 32 &&
                    rocketY >= doublePointsY - sizeOfRocket)
                    &&
                    (rocketX >= doublePointsX - 32 &&
                            rocketX <= doublePointsX + 32)) {

                this.rocketPowerups.despawnDoublePoints();
                this.rocketPowerups.setActiveDoublePoints(true);
                this.countdown = new Countdown();
                this.countdown.startDoublePointsCountdown(30);
                return true;
            }
        }
        if (!this.countdown.isGhostCountdownActive()) {
            this.rocketPowerups.setActiveGhost(false);
        }
        if (!this.countdown.isDoublePointsCountdownActive()) {
            this.rocketPowerups.setActiveDoublePoints(false);
        }
        return false;
    }

    /**
     * Metóda na kontrolu hitu s loptičkami a stenami, kontroluje či nie je aktívny ghost, ak nie je, tak prejde zoznam
     * a porovná s lokalitou rakety
     * @return vracia boolena v prípade, že hit nastal
     */
    public boolean isHit() {

        if (this.rocketPowerups.isActiveGhost()) {
            return false;
        }

        //      Nasa raketka je 60x60
        int sizeOfRocket = 60;

        //        Pri kazdom zavolani si ulozime koordinacie do lokalnych premennych aby sme ich nemuseli kazdy krat volat
        //        Je to prehladnejsie a lepsie sa s tym robi
        int rocketX = this.rocket.getCoordinates().getX();
        int rocketY = this.rocket.getCoordinates().getY();

        //        Ulozenie zoznamov do lokalnych zoznamov aby sme mohli foreach iteraciami kontrolovat kontakt
        ArrayList<Ball> ballList = this.balls.getListOfBalls();
        ArrayList<Wall> wallList = this.walls.getListOfWalls();


        for (Ball ball : ballList) {
            /*    Magic numbers su vysledkom vyladovania dotyku s loptou, nevieme ich vyjadrit pomocou premennych
                  Odrazame sa vsak od relativneho polomeru alebo priemeru lopty ktora je teda 5 a 10
                  Podmienka vznikla z vela testovania a kreslenia grafov na papier, robilo vsak problemy ze hra ide od
                  najvyssej koordinacie k tej najnizsej */
            if ((ball.getCoordinates().getY() + 10 >= rocketY &&
                    ball.getCoordinates().getY() <= rocketY + sizeOfRocket)
                    &&
                    (ball.getCoordinates().getX() - 5 >= rocketX &&
                            ball.getCoordinates().getX() + 15 <= rocketX + sizeOfRocket)
            ) {
                return true;
            }
        }

        for (Wall wall : wallList) {
            // Pri kontrole dotyku so stenou som zistil ze suradnica ktoru mam ulozenu je presne v strede?
            // Neviem ci je to sposobene kniznicou ale na zaklade toho som musel pripocitavat a odpocitavat sirku steny
            // Pri Ycku je tam vyska len kvolu tomu aby bola pokryta cela plocha steny a nevznikli divne situacie
            // Size of rocket odratavame aby to detekovalo celu vysku rakety a nie len nos
            // 3/4 steny, ako hitbox funguju lepšia, ako cela stena, je to citlivé na milimeter dotyku ale viac nie

            double threeQuatersOfWall = wall.getWidth() * 0.75;

            if ((rocketY <= wall.getCoordinates().getY() + wall.getHeight() &&
                    rocketY >= wall.getCoordinates().getY() - sizeOfRocket)
                    &&
                    (rocketX >= wall.getCoordinates().getX() - wall.getWidth() &&
                            rocketX <= wall.getCoordinates().getX() + threeQuatersOfWall)
            ) {
                return true;
            }
        }
        return false;
    }
}
