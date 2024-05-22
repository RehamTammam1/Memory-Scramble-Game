import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryGameApp extends JFrame {
    public static void main(String[] args) {

        // Memory Game app
        JFrame frame;
        Boarder boarder = new Boarder();
        JTextField numberOfrows = new JTextField();
        JTextField numberOfColumns = new JTextField();
        JTextField timerinput = new JTextField();
        numberOfrows.setPreferredSize(new Dimension(100, 30));
        numberOfColumns.setPreferredSize(new Dimension(100, 30));
        timerinput.setPreferredSize(new Dimension(100, 30));
        //Labels
        JLabel columnLabel = new JLabel("Columns");
        JLabel rowLabel = new JLabel("Rows");
        JLabel timerLabel = new JLabel("Timer");
        JButton enterBtn = new JButton("Enter");
        frame = new JFrame("Welcome to Memory Game");
        //Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.add(panel);
        Component[] panelCompments={rowLabel,numberOfrows,columnLabel,numberOfColumns,timerLabel,timerinput,enterBtn};
        for(Component labelComponet : panelCompments){
            panel.add(labelComponet);
        }
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input value from text field
                String rowsInput =numberOfrows.getText().trim();
                String columnsInput = numberOfColumns.getText().trim();
                String timerInput = timerinput.getText().trim();
                if(rowsInput.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Please Enter a row Value" );
                    return;
                }
                if(columnsInput.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Please Enter a column Value" );
                    return;
                }
                if(timerInput.isEmpty() ){
                    JOptionPane.showMessageDialog(null,"Please Enter a Timer Value" );
                    return;
                }


                int rowsValue = Integer.parseInt(rowsInput);
                int columnsValue = Integer.parseInt(columnsInput);
                int timerValue = Integer.parseInt(timerinput.getText());
                int totalCards = rowsValue * columnsValue;
                //Map resultMap = boarder.validateBoarderSize(rowsValue,columnsValue);
                String validationMessage =boarder.validateBoarderSize(rowsValue,columnsValue) ;
                if ( validationMessage.length()!=0) {
                    JOptionPane.showMessageDialog(null,validationMessage );
                } else {
                    //Create a boarder
                    boarder.createBorader(frame, true);
                    //Create a array of cards
                    CardsManger manger = new CardsManger(rowsValue,columnsValue);
                    Card[] cards = manger.createCardsCollection(totalCards);
                    //assign colors to cards Randomly
                    manger.assignColorstoCards(cards);
                    //create cards buttons
                    manger.createCardsbuttons(cards,frame);
                    //Create a Timer
                    GameTimer timer = new GameTimer(timerValue);
                }
            }
        });
    }
}