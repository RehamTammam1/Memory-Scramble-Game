import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        //Create Cards after clicking enter and entering card numbers
       // Card c1 = new Card();
        //ArrayList<JButton> cardList = c1.createCards(6);
        //System.out.println(cardList.size());
        //cardList.forEach(card -> panel.add(card));
        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve input value from text field
                int rowsValue = Integer.parseInt(numberOfrows.getText());
                int columnsValue = Integer.parseInt(numberOfColumns.getText());
                // Display input value
            //    JOptionPane.showMessageDialog(frame, "Input value: " + rowsValue);

                if (!boarder.checkBoarderSize(rowsValue,columnsValue)) {
                    JOptionPane.showMessageDialog(null, "Boarder Size should be even");
                }else{
                    boarder.createBorader();
                }



            }
        });

    }
}