import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomColor {

    public Color generateRandomColor(){
        Random random = new Random();
        Color randomcolor = new Color(random.nextInt(256), random.nextInt(256),
                random.nextInt(256));
        return randomcolor ;
    }

    public Color[] generateRandomColors(int numberOfCards){
        Color[] arrayOfColor = new Color[numberOfCards/2];
        Set<Color> colorSet= new HashSet<>();

        while (colorSet.size() < arrayOfColor.length){
            Color randomColor = this.generateRandomColor();
            colorSet.add(randomColor);
        }
        arrayOfColor = colorSet.toArray(new Color[0]);
        return  arrayOfColor;
    }
}