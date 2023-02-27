/**
 * Enum slúžiaci na určenie, z ktorej strany a kam sa bude loptička posúvať
 */
public enum BallStartingPosition {

    LEFT(0),
    RIGHT(480);

    private final int coordinate;
    /**
     * Konštruktor priradujuci koordinaciu
     */
    BallStartingPosition(int coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Getter starajúci sa o vracanie súradnice napravo a naľavo
     * @return vracia integer
     */
    public int getCoordinate() {
        return this.coordinate;
    }
}
