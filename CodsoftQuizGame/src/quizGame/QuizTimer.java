//Name: Chanaya Gayle
//Date: Nov 30, 2024
//Task: Codsoft quiz. Task #4


package quizGame;

import java.util.concurrent.*;

public class QuizTimer {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void startTimer(Runnable task, int delayInSeconds) {
        scheduler.schedule(task, delayInSeconds, TimeUnit.SECONDS);
    }

    public void stopTimer() {
        scheduler.shutdown();
    }
}
