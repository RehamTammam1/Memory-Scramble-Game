import java.awt.*;
import java.util.Random;

public class RandomColor {

    public Color generateRandomColor(){
        Random random = new Random();
        Color randomcolor = new Color(random.nextInt(256), random.nextInt(256),
                random.nextInt(256));
        return randomcolor ;
    }
}
