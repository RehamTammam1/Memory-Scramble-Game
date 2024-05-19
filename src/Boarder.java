import javax.swing.*;
import java.awt.*;

public class Boarder {

    public boolean checkBoarderSize (int numberOfRows ,int numberOfColumns){
        int boarderSize = numberOfRows * numberOfColumns;
        return (boarderSize % 2 == 0);
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