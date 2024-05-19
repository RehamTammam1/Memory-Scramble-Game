import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemoryGameApp extends JFrame {
    public static void main (String[] args) {

        // Memory Game app
        JFrame frame;
        Boarder boarder = new Boarder();
        JTextField numberOfrows = new JTextField();
        JTextField numberOfColumns = new JTextField();
        numberOfrows.setPreferredSize(new Dimension(100,30));
        numberOfColumns.setPreferredSize(new Dimension(100,30));

        JButton enterBtn = new JButton("Enter");
        frame = new JFrame("WELVOME");
        frame.setVisible(true);
        frame.setSize(500,500);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("My label");
        panel.add(label);
        frame.add(panel);
        panel.add(enterBtn);
        panel.add(numberOfColumns);
        panel.add(numberOfrows);
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input value from text field
                int rowsValue = Integer.parseInt(numberOfrows.getText());
                int columnsValue = Integer.parseInt(numberOfColumns.getText());
                int totalCards = rowsValue* columnsValue ;
                if (!boarder.checkBoarderSize(rowsValue,columnsValue)) {
                    JOptionPane.showMessageDialog(null, "Boarder Size should be even");
                }else{
                    //Create a boarder
                   boarder.createBorader(frame,true);
                    //Create a array of cards
                    CardsManger manger = new CardsManger();
                    Card[] cards=manger.createCardsCollection(rowsValue,columnsValue,totalCards,frame);
                    //create array of buttons with similar backgounds
                    System.out.println(cards.length);
                    System.out.println(cards[1].getCardValue());
                    System.out.println(cards[1].getCardView());
                }
            }
            //on cliking any of the buttons
        });
    }
}