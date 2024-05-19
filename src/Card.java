import javax.swing.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Card {

    private String cardValue ;
    private String cardView ;
    // Card Constructor
    public Card(String cardValue, String cardView) {
        this.cardValue = cardValue;
        this.cardView = cardView;
    }
    public String getCardValue() {
        return cardValue;
    }
    // Setter for cardValue
    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }
    // Getter for cardView
    public String getCardView() {
        return cardView;
    }

    // Setter for cardView
    public void setCardView(String cardView) {
        this.cardView = cardView;
    }

    ArrayList<JButton> cardList = new ArrayList<>();
    public ArrayList<JButton> createCards (int cardsNumber){
        for(int i=0;i<cardsNumber;i++){
            JButton button = new JButton();
            button.setText("***");
            cardList.add(button);

        }
        return cardList;
    }
    public void showCard (){
        System.out.println(this.cardValue);
        System.out.println(this.cardView);
    }


    }

}
