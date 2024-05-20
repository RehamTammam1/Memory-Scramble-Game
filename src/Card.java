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
    // Setter and Getter  for card Number
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    // Setter and Getter for cardValue
    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }
    public int getCardValue() {
        return cardValue;
    }
}
