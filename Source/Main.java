import java.io.IOException;

public class Main {

    /**
     * Spúšťač našeho programu – spustí výber mena, welcome screen a následne hru
     * @param args klasické main argumenty
     * @throws IOException - IOException potiahnutý z RocketPoints
     */
    public static void main(String[] args) throws IOException {

        NameSelector nameSelector = new NameSelector();
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        // Spustenie hry
        Game game = new Game(nameSelector, welcomeScreen);
    }
}