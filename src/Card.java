import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private int cardNumber ;
    private int cardValue ;// Card Constructor
    public Card(int cardNumber,int cardValue) {
        this.cardNumber = cardNumber;
        this.cardValue = cardValue;

    }
    public int getCardNumber() {
        return cardNumber;
    }

    // Setter for cardView
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getCardValue() {
        return cardValue;
    }
    // Setter for cardValue
    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
    // Getter for cardView

/*
    ArrayList<JButton> cardList = new ArrayList<>();
    public ArrayList<JButton> createCards (int cardsNumber){
        for(int i=0;i<cardsNumber;i++){
            JButton button = new JButton();
            button.setText("***");
            cardList.add(button);

        }
        return cardList;
    }*/


    public void showCard (){
        System.out.println(this.cardValue);
        System.out.println(this.cardNumber);
    }}
