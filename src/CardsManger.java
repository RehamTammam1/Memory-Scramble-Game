import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.border.EmptyBorder;

public class CardsManger {
    //Create an aray of Cards
    public Card[] createCardsCollection(int numberOfRows,int numberOfColumns,
                                        int numberOfCards,JFrame frame){
        Card[] cards = new Card[numberOfCards];
        JButton[] cardButtons = new JButton[numberOfCards];
        JPanel panel = new JPanel();
        int padding = 5;
        panel.setLayout(new GridLayout(numberOfRows+5,numberOfColumns+5,padding,padding));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(panel);

        for(int i=0 ; i<numberOfCards;i++) {
            JButton cardButton = new JButton();
            cardButton.setPreferredSize(new Dimension(100,50));
            Color randomColor = generateRandomColor();
            int colorIdntifier =randomColor.getRGB();
            cardButton.setBackground(randomColor);
            cardButton.setBorderPainted(false);
            cardButton.setOpaque(true);
            cardButton.setBorder(new EmptyBorder(padding, padding, padding, padding));
            cardButtons[i]=cardButton;
            panel.add(cardButtons[i]);
            cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardButton.setBackground(Color.white);
                }
            }
            );
        };
        frame.revalidate();
        frame.repaint();
        return  cards;
    }
    public Color generateRandomColor(){
        Random random = new Random();
        Color randomcolor = new Color(random.nextInt(256), random.nextInt(256),
                random.nextInt(256));
                return randomcolor ;
    }
}