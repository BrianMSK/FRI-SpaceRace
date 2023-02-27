public class Coordinates {

    private int x;
    private int y;

    /**
     *
     * Trieda na ukladanie koordinácií pre akekolvek objekty na našom platne, aktualizujeme pri akomkoľvek pohybe
     * a bez tejto triedy by sme nevedeli používať hit detekciu našej raketky s platformami a guličkami
     *
     * @param x slúži, ako X na grafe - vyjadruje šírku
     * @param y slúži ako Y na grafe - vyjadruje výšku
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
