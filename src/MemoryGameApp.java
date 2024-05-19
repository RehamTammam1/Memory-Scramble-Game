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
        JButton enterBtn = new JButton("Enter");
        frame = new JFrame("Welcome to Memory Game");
        frame.setVisible(true);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel columnLabel = new JLabel("Columns");
        JLabel rowLabel = new JLabel("Rows");
        JLabel timerLabel = new JLabel("Timer");

        frame.add(panel);
        panel.add(columnLabel);
        panel.add(numberOfColumns);
        panel.add(rowLabel);
        panel.add(numberOfrows);
        panel.add(timerLabel);
        panel.add(timerinput);
        panel.add(enterBtn);
        // Retrieve input value from text field

        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowsValue = Integer.parseInt(numberOfrows.getText());
                int columnsValue = Integer.parseInt(numberOfColumns.getText());
                int totalCards = rowsValue * columnsValue;
                if (!boarder.checkBoarderSize(rowsValue, columnsValue)) {
                    JOptionPane.showMessageDialog(null, "Boarder Size should be even");
                } else {
                    //Create a boarder
                    boarder.createBorader(frame, true);
                    //Create a array of cards
                    CardsManger manger = new CardsManger();
                    Card[] cards = manger.createCardsCollection(rowsValue, columnsValue, totalCards, frame);


                }
            }

        });
    }
}