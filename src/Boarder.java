import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Boarder {

    public String validateBoarderSize (int numberOfRows ,int numberOfColumns){
        int boarderSize = numberOfRows * numberOfColumns;
        String errorMessage= "";
        //validate value greater than zero and not empty
        if(numberOfRows<=0 )
            errorMessage ="Please Numer of Rows should be greater than or equal one ";
        if(numberOfColumns<=0)
            errorMessage ="Please Numer of Columns should be greater than or equal one ";
        //validate boarder size is even
        if(boarderSize % 2 !=0)
            errorMessage ="Please Board Size should be even";
        return  errorMessage;
    }

    public void createBorader(JFrame frame,boolean isFirstPanel){
        JPanel boarderPanel = new JPanel();
        boarderPanel.setPreferredSize(new Dimension(500, 500));
        boarderPanel.setVisible(true);
        frame.getContentPane().removeAll();
        frame.add(boarderPanel);
        frame.getContentPane().add(boarderPanel, BorderLayout.CENTER);
        frame.pack(); // Adjust the frame size to fit the preferred size of its components
        frame.revalidate();
        frame.repaint();
    }

}