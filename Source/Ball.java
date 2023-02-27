import fri.shapesge.Circle;
public class Ball {
    private final Circle circle;

    private final int speed;

    private final Coordinates coordinates;

    private final BallStartingPosition ballStartingPosition;

    public static final int DIAMETER = 10;
    public static final String COLOR = "white";

    /**
     *
     * Trieda Ball slúži, ako fasáda na triedu circle, umožní nam pridať a rozšíriť funkcionalitu objektu circle
     * z knižnice fri.shpaes.ge, Ball sa na základe parametrov, ktoré jej pošleme nastaví a zobrazí na plátne
     *
     * @param speed nastavuje rýchlosť guličky a jej pohybu po plátne
     * @param coordinates nastavuje súradnicový systém pre guličku, dôležité kvôli hitdetection
     * @param ballStartingPosition ENUM, ktorý určuje na ktorej strane loptička začína, kam bude smerovať a
     *                             odkiaľ sa bude reštartovať keď dosiahne okraj druhej strany
     */
    public Ball(int speed,
                Coordinates coordinates,
                BallStartingPosition ballStartingPosition) {

        this.ballStartingPosition = ballStartingPosition;
        this.speed = speed;
        this.coordinates = coordinates;

        this.circle = new Circle(this.coordinates.getX(),
                this.coordinates.getY());
        this.circle.changeColor(COLOR);
        this.circle.changeSize(DIAMETER);
        this.circle.makeVisible();
    }

    /**
     * Jenoduchý getter na získavanie objektu s koordináciami
     * @return vracia anonýmny objekt koordinácií žiadajúcej triede
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Trieda, ktorá posúva guličku na plátne o rýchlosť, ktorá jej bola nastavená a smer určujeme na základe
     * ENUMu, pokiaľ ide lopta z ľavá tak ju posúvame doprava a vice versa, return ball to start môžeme volať vďaka tomu,
     * že priamo v tej metóde kontrolujeme či je na začiatku alebo nie je, ak nie je tak sa nič nestane
     */
    public void moveCircle() {

        if (this.ballStartingPosition == BallStartingPosition.LEFT) {

            this.returnBallToStart(BallStartingPosition.LEFT);

            this.circle.moveHorizontal(this.speed);
            this.coordinates.setX(this.coordinates.getX() + this.speed);

        } else if (this.ballStartingPosition == BallStartingPosition.RIGHT) {

            this.returnBallToStart(BallStartingPosition.RIGHT);

            this.circle.moveHorizontal(-this.speed);
            this.coordinates.setX(this.coordinates.getX() - this.speed);

        }
    }

    /**
     * Metóda, ktorá nám vráti pri zavolaní loptičku na štart ak je splnená podmienka, že jej X-ová súradnica sa dostala
     * na miesto kedy je považovaná na konci svojej cesty
     * @param ballStartingPosition ENUM z ktorého vieme zistiť konečnú súradnicu pre ľavú alebo pravú stranu
     */
    private void returnBallToStart(BallStartingPosition ballStartingPosition) {

        if (this.coordinates.getX() >= BallStartingPosition.RIGHT.getCoordinate() &&
                ballStartingPosition == BallStartingPosition.LEFT) {

            this.circle.moveHorizontal(-480);
            this.coordinates.setX(this.coordinates.getX() - 480);

        } else if (this.coordinates.getX() <= BallStartingPosition.LEFT.getCoordinate() &&
                ballStartingPosition == BallStartingPosition.RIGHT) {

            this.circle.moveHorizontal(480);
            this.coordinates.setX(this.coordinates.getX() + 480);

        }
    }
}
