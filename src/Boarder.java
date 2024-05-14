import javax.swing.*;

public class Boarder {

    public boolean checkBoarderSize (int numberOfRows ,int numberOfColumns){
        int boarderSize = numberOfRows * numberOfColumns;
        return (boarderSize % 2 == 0);
    }
    public void createBorader(){
        JPanel boarderPanel = new JPanel();
        boarderPanel.setSize(500,500);

        boarderPanel.setVisible(true);

    }
}


