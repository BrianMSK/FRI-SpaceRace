import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

import fri.shapesge.FontStyle;
import fri.shapesge.Text;

public class RocketPoints {

    private int points;
    private FileWriter fileWriter;
    private File pointsFile;
    private File highscoreFile;
    private Scanner scanner;
    private Timestamp timestamp;
    private Text text;

    /**
     * Stará sa o počet bodov raketky, zapisuje do súboru všetky výsledky a aj najlepší výsledok
     * @throws IOException
     */
    public RocketPoints() throws IOException {
        this.points = 0;
        this.pointsFile = new File("points.txt");
        this.highscoreFile = new File("highscore.txt");
        if (this.highscoreFile.length() == 0) {
            this.fileWriter = new FileWriter(this.highscoreFile, false);
            this.fileWriter.write("0");
            this.fileWriter.close();
        }
        this.text = new Text("", 0, 0);
    }

    /**
     * Zapisuje text na obraz, najskôr ho spraví neviditeľným, potom prepíše, zmení font, nastaví farbu a zobrazí
     */
    public void writeScoreOnScreen() {
        this.text.makeInvisible();
        this.text = new Text(String.format("%05d", this.points), 390, 980);
        this.text.changeFont("Sans", FontStyle.BOLD, 30);
        this.text.changeColor("white");
        this.text.makeVisible();
    }

    /**
     * Vracia najvyššie skóre zaznamenané v súbore
     * @return vracia int najväčšieho skóre
     * @throws IOException hádže kvôli práci so súborom
     */
    public int getHighScore() throws IOException {
        this.scanner = new Scanner(this.highscoreFile);
        if (this.highscoreFile.length() == 0) {
            return 0;
        }
        return this.scanner.nextInt();
    }

    /**
     * Získa mneno hráča s najvyšším skóre, môže však nastať issue, ak si dá hráč v strede mena medzeru
     * @return vracia String mena
     * @throws IOException hádže kvôli práci so súborom
     */
    public String getHighScorePlayer() throws IOException {
        if (this.getHighScore() == 0) {
            return null;
        }
        this.scanner = new Scanner(this.highscoreFile);
        String line = this.scanner.nextLine();
        String[] tokens = line.split(" ");
        String name = tokens[1];
        if (name.isEmpty() || name.isBlank() || name == null || name.trim().equals("")) {
            return "No-one";
        }
        return name;
    }

    /**
     * Uloží body do súboru points.txt a zároveň ak je nové najvyššie skóre tak uloží do highscore.txt
     * @param game posielame game aby sme vedeli získať názov hráča
     * @throws IOException hádže kvôli práci so súborom
     */
    public void savePoints(Game game) throws IOException {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.fileWriter = new FileWriter(this.pointsFile, true);
        this.fileWriter.write(String.format("%s %s %d %n", this.timestamp, game.getName(), this.points));
        this.fileWriter.close();


        if (this.points < this.getHighScore()) {
            return;
        }

        this.fileWriter = new FileWriter(this.highscoreFile);
        this.fileWriter.write(String.format("%d %s %s %n", this.points, game.getName(), this.timestamp));
        this.fileWriter.close();
    }

    /**
     * Pridá body ak je funkcia zavolaná, zistuje či je aktívny powerup na double points, vtedy pridá dva body
     * @param rocket
     */
    public void addPoint(Rocket rocket) {
        if (rocket.getRocketPowerups().isActiveDoublePoints()) {
            this.points = this.points + 2;
        } else {
            this.points = this.points + 1;
        }

    }

    /**
     * Resetuje body na nulu, väčšinou pri stráte troch životov
     */
    public void resetPoints() {
        this.points = 0;
    }
}
