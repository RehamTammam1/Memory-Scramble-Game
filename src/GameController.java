import javax.swing.*;

public class GameController {


    //Game Over Function
    //Show Diaglouge Message
    public void checkSucess(int score, int target,JFrame fram,JPanel panel,Timer countDownTimer){
        if(score == target){
            countDownTimer.stop();
            JOptionPane.showMessageDialog(panel, "Bravo RIRI!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        }

    }


    // Sucess Fuction
}
