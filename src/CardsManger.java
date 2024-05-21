import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class CardsManger {

    private int numberOfRows;
    private int numberOfColumns;
    Card[] facedUpCards = new Card[2];
    JButton[] facedUpButtons = new JButton[2];


    public CardsManger(int numberOfRows,int numberOfColumns){
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

    }
    //Create an aray of Cards
    public Card[] createCardsCollection(int numberOfCards){
        Card[] cards = new Card[numberOfCards];
        for(int i=0 ; i<numberOfCards;i++) {
            Card newCard = new Card(i,0);
            cards[i]=newCard;
        }
        return cards;
    }

    public Card[] assignColorstoCards(Card[] cards){
        RandomColor cardColor = new RandomColor();
        Color[] randomColors = cardColor.generateRandomColors(this.numberOfRows*this.numberOfColumns);
        ArrayList<Card> cardsList = new ArrayList<>(Arrays.asList(cards));
        Collections.shuffle(cardsList);
        Card[] shuffledCards = cardsList.toArray(new Card[cardsList.size()]);

        for (int i=0;i<randomColors.length;i++){
            shuffledCards[i].setCardValue(randomColors[i].getRGB());
            shuffledCards[i].setCardValue(randomColors[i].getRGB());
            shuffledCards[i + randomColors.length].setCardValue(randomColors[i].getRGB());
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
        panel.setLayout(new GridLayout(this.numberOfRows,this.numberOfColumns,10,10));
   //     frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.add(panel);
        panel.add(turnDownButton);

        for(int i=0 ;i<cards.length;i++) {
            JButton cardButton = creatButtonCard();
            cardButtons[i]=cardButton;
            panel.add(cardButton);
            int cardIndex = i;
            cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(cardButton,cards,cardIndex);
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

    public void handleButtonClick(JButton cardButton,Card[] cards,int cardIndex){

        if (this.facedUpCards[0] == null&&this.facedUpCards[1] == null){
      //      System.out.println("Faced up cards = "+this.facedUpCards.size()+"in case of zero before add");
            turnonCard(cardButton,cards[cardIndex].getCardValue());
            this.facedUpCards[0]=cards[cardIndex];
            this.facedUpButtons[0] = cardButton;
        } else if (this.facedUpCards[0] != null &&this.facedUpCards[1] == null ) {
            this.facedUpCards[1]=cards[cardIndex];
            this.facedUpButtons[1] = cardButton;
            //Compare Cards Values
            int card1Color =this.facedUpCards[0].getCardValue();
            int card2Color =this.facedUpCards[1].getCardValue();
           System.out.println("comparison value = "+ card1Color+"      "+card2Color);
            if(card1Color == card2Color){
                System.out.println("AL hamdollah");
                turnonCard(cardButton,cards[cardIndex].getCardValue());
                facedUpCards[0] = null;
                facedUpCards[1] = null;
                //facedUpCards.clear();
            }else {
                // Turn down cards after 1 seconds
                Timer timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        turnDownCards(facedUpButtons);
                        facedUpCards[0] = null;
                        facedUpCards[1] = null;

                    }
                });
                timer.setRepeats(false);
                timer.start();
                turnonCard(cardButton, cards[cardIndex].getCardValue());
            }
        }
    }
    public void turnDownCards(JButton[] cardButtons){
        for(JButton cardButton : cardButtons){
            cardButton.setBackground(Color.WHITE);
          //  cardButton.setBackground(null);
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

    }
    public JButton creatButtonCard(){
        //  Color randomColor = generateRandomColor();
        JButton cardButton = new JButton();
        cardButton.setPreferredSize(new Dimension(100,50));
        cardButton.setBackground(Color.WHITE);
        cardButton.setBorderPainted(false);
        cardButton.setOpaque(true);
        cardButton.setBorder(new EmptyBorder(10, 10, 10, 10));
        return cardButton;
    }
}
