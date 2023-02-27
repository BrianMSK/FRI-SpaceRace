import fri.shapesge.FontStyle;
import fri.shapesge.Image;
import fri.shapesge.Manager;
import fri.shapesge.Text;

import java.io.IOException;

public class WelcomeScreen {

    private Image image;
    private boolean isFinished;
    private Manager manager;
    private WelcomeScreenDifficultySelection welcomeScreenDifficultySelection;
    private RocketPoints rocketPoints;
    private Text highScoreText;
    private Text highScoreUsernameText;

    /**
     * Slúži na zobrazenie welcome screen po zadaní mena a spustení programu
     * Vyberá sa obtiažnosť, kontroluje či je obtiažnosť vybratá, a vypisuje najvyššie dosiahnuté body
     * @throws IOException - kvôli práci so súbormi zo skóre
     */
    public WelcomeScreen() throws IOException {

        this.isFinished = false;

        this.image = new Image("./img/welcomescreen.png", 0, 0);
        this.image.makeVisible();

        this.manager = new Manager();
        this.manager.manageObject(this);

        this.showBestLocalScore();
    }

    /**
     * Na získanie vybranej obtiažnosti na začiatku
     * @return ENUM WelcomeScreenDifficultySelection
     */
    public WelcomeScreenDifficultySelection getWelcomeScreenDifficultySelection() {
        return this.welcomeScreenDifficultySelection;
    }

    /**
     * Zobrazí na plátne najlepšie lokálne skóre
     * @throws IOException - hádže kvôli práci s rocket points
     */
    private void showBestLocalScore() throws IOException {
        this.rocketPoints = new RocketPoints();

        this.highScoreText = new Text(
                String.format("Local best score: %d", this.rocketPoints.getHighScore()),
                            145, 760);

        this.highScoreText.changeFont("Sans", FontStyle.BOLD, 22);
        this.highScoreText.changeColor("white");
        this.highScoreText.makeVisible();

        this.highScoreUsernameText = new Text(
                String.format("Scored by: %s", this.rocketPoints.getHighScorePlayer()),
                            155, 790);
        this.highScoreUsernameText.changeFont("Sans", FontStyle.BOLD, 24);
        this.highScoreUsernameText.changeColor("white");
        this.highScoreUsernameText.makeVisible();
    }

    /**
     * Zavrie welcome screen a označí za dokonenčené, na základe čoho vieme spustiť hru
     */
    public void closeWelcomeScreen() {
        this.image.makeInvisible();
        this.highScoreText.makeInvisible();
        this.highScoreUsernameText.makeInvisible();
        this.isFinished = true;
    }

    /**
     * Getter na zistenie či je welcome screen ukončený
     * @return
     */
    public boolean isFinished() {
        return this.isFinished;
    }

    // metódy slúžia na výber obtiažnosti, a to na základe klávesnice alebo súradníc na, ktoré myš klikne
    public void selectEasy() {
        this.welcomeScreenDifficultySelection = this.welcomeScreenDifficultySelection.EASY;
        this.closeWelcomeScreen();
    }
    public void selectMedium() {
        this.welcomeScreenDifficultySelection = this.welcomeScreenDifficultySelection.MEDIUM;
        this.closeWelcomeScreen();
    }
    public void selectHard() {
        this.welcomeScreenDifficultySelection = this.welcomeScreenDifficultySelection.HARD;
        this.closeWelcomeScreen();
    }

    public void selectCoordination(int x, int y) {
        if ((x >= 90 && x <= 395) && (y >= 310 && y <= 410)) {
            this.welcomeScreenDifficultySelection = WelcomeScreenDifficultySelection.EASY;
            this.closeWelcomeScreen();
        }
        
        if ((x >= 90 && x <= 395) && (y >= 450 && y <= 550)) {
            this.welcomeScreenDifficultySelection = WelcomeScreenDifficultySelection.MEDIUM;
            this.closeWelcomeScreen();
        }
        
        if ((x >= 90 && x <= 395) && (y >= 590 && y <= 690)) {
            this.welcomeScreenDifficultySelection = WelcomeScreenDifficultySelection.HARD;
            this.closeWelcomeScreen();
        }
    }
}
