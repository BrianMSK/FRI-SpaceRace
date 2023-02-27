import java.util.Timer;
import java.util.TimerTask;


public class Countdown {
    private final Timer ghostTimer;
    private final Timer doublePointsTimer;
    private boolean ghostCountdownActive;
    private boolean doublePointsCountdownActive;

    /**
     * Zobrane z tohoto odkazu a upravene podla potrieb
     * https://docs.oracle.com/javase/8/docs/technotes/guides/lang/Countdown.java
     *
     * Sluzi na odpocet pre powerupy, a kontrolu ci je odpocet aktivny
     */
    public Countdown() {
        this.ghostTimer = new Timer();
        this.doublePointsTimer = new Timer();
        this.ghostCountdownActive = false;
        this.doublePointsCountdownActive = false;
    }

    /**
     * Booleany sluziace na zistovanie ci countdown stale prebieha, ak prebieha tak nase powerupy musia byt aktivne
     * @return vracia true alebo false na zaklade toho ci je countdown aktivny
     */
    public boolean isGhostCountdownActive() {
        return this.ghostCountdownActive;
    }

    /**
     * Booleany sluziace na zistovanie ci countdown stale prebieha, ak prebieha tak nase powerupy musia byt aktivne
     * @return vracia true alebo false na zaklade toho ci je countdown aktivny
     */
    public boolean isDoublePointsCountdownActive() {
        return this.doublePointsCountdownActive;
    }

    /**
     * Upraveny countdown, ten originalny nebol prisposobeny na opakovanie a dva sucasne countdowns
     * Toto funguje neustale a spravne bez hadzania errorov
     * @param timeInSeconds - je cas kolko bude countdown trvat
     */
    public void startGhostCountdown(int timeInSeconds) {
        this.ghostCountdownActive = true;
        this.ghostTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Countdown.this.ghostCountdownActive = false;
            }
        }, timeInSeconds * 1000);
    }

    /**
     * Upraveny countdown, ten originalny nebol prisposobeny na opakovanie a dva sucasne countdowns
     * Toto funguje neustale a spravne bez hadzania errorov
     * @param timeInSeconds - je cas kolko bude countdown trvat
     */
    public void startDoublePointsCountdown(int timeInSeconds) {
        this.doublePointsCountdownActive = true;
        this.doublePointsTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Countdown.this.doublePointsCountdownActive = false;
            }
        }, timeInSeconds * 1000);
    }
}
