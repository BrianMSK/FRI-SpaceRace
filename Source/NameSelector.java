import javax.swing.JOptionPane;

public class NameSelector {

    private String name;

    /**
     * Trieda na vyberanie mena pri spustení programu
     * V prípade, že použivateľ zadá white-space, nebude to uznané a musí tam zadať valídny znak podľa funkcie trim()
     */
    public NameSelector() {
        this.setName();
    }

    /**
     * Spustí JOption dialóg a požiada o nastavenie mena, následne vstup trimne a skontroluje či je prázdny
     */
    public void setName() {
        this.name = JOptionPane.showInputDialog("Nastav meno");
        this.name = this.name.trim();
        if (this.name.isEmpty()) {
            this.setName();
        }
    }

    /**
     * Jednoduchý geter na získanie mena
     * @return vracia String
     */
    public String getName() {
        return this.name;
    }
}
