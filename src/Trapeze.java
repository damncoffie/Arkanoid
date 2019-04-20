import java.awt.*;

/**
 * Created by Mikhail_Bobriashov on 6/9/2017.
 */
public class Trapeze {

    public Image getTrapezeView() {
        return trapezeView;
    }

    private Image trapezeView;
    private int x;
    private int y;

    Trapeze(Image trapezeView) {
        this.trapezeView = trapezeView;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
