import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {

    Timer gameTimer = new Timer();
    public GameTimer(long delay){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("GameOver");
            }
        };
        gameTimer.schedule(task, delay);
    }
    //gameTimer.schedulel();


}
