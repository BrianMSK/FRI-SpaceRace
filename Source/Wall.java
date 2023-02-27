import fri.shapesge.Rectangle;
// Trieda na vytvaranie stien na platne pomocou kniznice ShapesGE
public class Wall {

    private final Rectangle rectangle;
    private final int width;
    private final int height;
    private final String color;
    private Coordinates coordinates;

    /**
     * Je fasádová trieda pre rectangle, dovoľuje nám získavať výšku, šírku, a koordinácie
     * @param width nastavuje šírku steny
     * @param height nastavuje výšku steny
     * @param color nastavuje farbu steny
     * @param coordinates nastavuje koordinácie steny
     */
    public Wall(int width, int height, String color, Coordinates coordinates) {
        // Priradenie sprav k atributom
        this.width = width;
        this.height = height;
        this.color = color;
        this.coordinates = coordinates;

        // Vytvorenie steny pomocou atributov a sprav ktore nam posle objekt
        this.rectangle = new Rectangle(coordinates.getX(), coordinates.getY());
        this.rectangle.changeColor(this.color);
        this.rectangle.changeSize(this.width, this.height);
        this.rectangle.makeVisible();
    }

    /**
     * Getter na koordinácie
     * @return vráti objekt koordinácií
     */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    /**
     * Získa šírku steny
     * @return vráti int
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Získa výšku steny
     * @return vráti int
     */
    public int getHeight() {
        return this.height;
    }
}
