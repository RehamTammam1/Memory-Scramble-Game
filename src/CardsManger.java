import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.border.EmptyBorder;

public class CardsManger {
    int padding = 10;
   private int numberOfRows;
   private int numberOfColumns;
    int numberOfCards;
    RandomColor cardColor = new RandomColor();
    public CardsManger(int numberOfRows,int numberOfColumns){
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    //Create an aray of Cards
    public Card[] createCardsCollection(int numberOfCards){
        Card[] cards = new Card[numberOfCards];
        for(int i=0 ; i<numberOfCards;i++) {
            Color randomColor =  cardColor.generateRandomColor();
            int colorIdntifier =randomColor.getRGB();
            Card newCard = new Card(i,colorIdntifier);
            newCard.setCardNumber(i);
            newCard.setCardValue(colorIdntifier);
            cards[i]=newCard;
        }
        return cards;
    }

    //Create Cards Buttons
    public JButton[] createCardsbuttons(Card[] cards,JFrame frame){
        JButton[] cardButtons = new JButton[cards.length];
        JPanel panel = new JPanel();
        JButton turnDownButton = new JButton();
        turnDownButton.setText("Trun Down");
        turnDownButton.setPreferredSize(new Dimension(100,100));
        panel.setLayout(new GridLayout(this.numberOfRows+10,this.numberOfColumns+10,padding,padding));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(panel);
        panel.add(turnDownButton);
        for(int i=0 ; i<cards.length;i++) {

            JButton cardButton = creatButtonCard();
            cardButtons[i]=cardButton;
            panel.add(cardButton);
            int cardNumber = cards[i].getCardNumber();
            int cardValue = cards[i].getCardValue();

            cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cardButton.setBackground(new Color(cardValue));
                }
            });
        }

        turnDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnDownCards(cardButtons);
            }
        });
        frame.revalidate();
        frame.repaint();
        return cardButtons;
    }
    public void turnDownCards(JButton[] cardButtons){
        for(JButton cardButton : cardButtons){
            cardButton.setBackground(Color.white);
            cardButton.setOpaque(true);
            cardButton.setBorderPainted(false);
        }}

    public JButton creatButtonCard(){
        //  Color randomColor = generateRandomColor();
        JButton cardButton = new JButton();
        cardButton.setPreferredSize(new Dimension(100,50));
        //cardButton.setBackground(randomColor);
        cardButton.setBorderPainted(false);
        cardButton.setOpaque(true);
        cardButton.setBorder(new EmptyBorder(padding, padding, padding, padding));
        return cardButton;
    }
}
