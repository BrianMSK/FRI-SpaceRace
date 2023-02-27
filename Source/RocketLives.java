import fri.shapesge.Image;


public class RocketLives {

    private int lives;
    private final Image[] image;


    /**
     * Trieda na správu životov rakety
     * Inicializuje na začiatku pole troch srdci, ktoré zobrazí
     */
    public RocketLives() {
        this.lives = 3;
        this.image = new Image[3];
        int spacing = 10;
        for (int i = 0; i < this.image.length; i++) {
            // https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Love_Heart_symbol.svg/1125px-Love_Heart_symbol.svg.png
            this.image[i] = new Image("./img/heart.png", spacing, 955);
            this.image[i].makeVisible();
            spacing = spacing + 40;
        }
    }

    public int getLives() {
        return this.lives;
    }

    /**
     * Pri úmrtí voláme túto metódu, postará sa o reset životov a nastaví obrázky na plné
     */
    public void resetLives() {
        this.lives = 3;
        for (int i = 0; i < this.image.length; i++) {
            this.image[i].changeImage("./img/heart.png");
        }
    }

    /**
     * Odoberie jeden život z rakety a zmení obrázok na prázdne srdce
     */
    public void removeLife() {
        this.lives = this.lives - 1;
        // Predosle srdce upravene vo Photoshope (vyrezany stred)
        this.image[this.lives].changeImage("./img/heart_empty.png");
    }
}
