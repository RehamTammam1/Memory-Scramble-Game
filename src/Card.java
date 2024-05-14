import javax.swing.*;
import java.util.ArrayList;

public class Card {


    ArrayList<JButton> cardList = new ArrayList<>();
    public ArrayList<JButton> createCards (int cardsNumber){
        for(int i=0;i<cardsNumber;i++){
            JButton button = new JButton();
            button.setText("***");
            cardList.add(button);

        }
        return cardList;
    }

}
