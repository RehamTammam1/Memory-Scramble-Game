import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.border.EmptyBorder;

public class CardsManger {
    int padding = 10;
   private int numberOfRows;
   private int numberOfColumns;
    int numberOfCards = this.numberOfRows*this.numberOfColumns;
    RandomColor cardColor = new RandomColor();
    public CardsManger(int numberOfRows,int numberOfColumns){
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    //Create an aray of Cards
    public Card[] createCardsCollection(int numberOfCards){
        Card[] cards = new Card[numberOfCards];
        Color[] randomColors = cardColor.generateRandomColors(numberOfCards);
        for(int i=0 ; i<numberOfCards;i++) {
            Card newCard = new Card(i,0);
            cards[i]=newCard;
        }
        return cards;
    }
    public Card[] assignColorstoCards(Card[] cards){
        Color[] randomColors = cardColor.generateRandomColors(this.numberOfRows*this.numberOfColumns);
        ArrayList<Card> cardsList = new ArrayList<>(Arrays.asList(cards));
        Collections.shuffle(cardsList);
        Card[] shuffledCards = cardsList.toArray(new Card[cardsList.size()]);
        int numberOfCards = cards.length;
        for (int i=0;i<randomColors.length;i++){
            shuffledCards[i].setCardValue(randomColors[i].getRGB());
        }
        for (int i=0;i<randomColors.length;i++){
            shuffledCards[i+(numberOfCards/2)].setCardValue(randomColors[i].getRGB());
        }
        return shuffledCards;
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
            cardButton.setBackground(new Color(cardValue));

            cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //cardButton.setBackground(new Color(cardValue));
                    turnonCard(cardButton,cardValue);

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
            cardButton.setBackground(null);
            cardButton.setOpaque(true);
            cardButton.setBorderPainted(false);
        }}
    public void turnonCard(JButton cardButton,int cardValue){
        if(cardButton.getBackground().getRGB() != cardValue){
            cardButton.setBackground(new Color(cardValue));
            // add it to the array and check
        }else{
            cardButton.setBackground(null);
        }
        //if turnedOnCards == 2 , doon't trun on any colors

    }
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
