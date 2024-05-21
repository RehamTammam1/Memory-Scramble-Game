import javax.swing.*;

public class GameController {


    //Game Over Function
    //Show Diaglouge Message
    public void checkSucess(int score, int target,JFrame fram,JPanel panel){
        if(score == target)
        JOptionPane.showMessageDialog(panel, "Bravo RIRI!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
    }


    // Sucess Fuction
}
