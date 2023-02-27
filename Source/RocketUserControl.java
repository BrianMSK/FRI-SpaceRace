public class RocketUserControl {

    private Rocket rocket;

    /**
     * Slúži na ovládanie raketky, je volaná pomocou shapesGE manažéra, ktorý na základe SBGE.ini volá tieto metódy
     * v každom tiku ak je stlačená priradená klávesa
     * @param rocket posielame raketku aby sme vedeli aký objekt ovládať
     */
    public RocketUserControl(Rocket rocket) {
        this.rocket = rocket;
    }

    // tieto triedy už len volajú pohyb raketky daným smerom
    public void moveDown() {
        this.rocket.moveRocket(RocketMovementDirection.DOWN);
    }
    public void moveUp() {
        this.rocket.moveRocket(RocketMovementDirection.UP);
    }

    public void moveLeft() {
        this.rocket.moveRocket(RocketMovementDirection.LEFT);
    }

    public void moveRight() {
        this.rocket.moveRocket(RocketMovementDirection.RIGHT);
    }

    /*public void posunVlavoHore() {
        this.rocket.moveRocket(RocketMovementDirection.UPLEFT);
    }

    public void posunVpravoHore() {
        this.rocket.moveRocket(RocketMovementDirection.DOWNLEFT);
    }*/
}
