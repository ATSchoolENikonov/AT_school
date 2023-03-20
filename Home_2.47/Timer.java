import java.time.LocalDate;

public class Timer {
    private int seconds;

    public Timer(int seconds) {
        this.seconds = seconds;
    }

    void printTime() {
        int e = seconds / 60;
        int f = seconds % 60;
        System.out.printf("Осталось: %1$02d : %2$02d", e, f);
        System.out.println();
    }

    static void waitSecond() {
        long timeWait = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() < timeWait) {
        }
    }

    int start() {
        while (seconds > 0) {
            printTime();
            waitSecond();
            seconds--;
        }
        return seconds;
    }
}
