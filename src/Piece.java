/**
 * Created by Mikhail_Bobriashov on 6/9/2017.
 */
public class Piece {

    private int speed;
     int angle;

    public Piece(int speed, int angle) {
        this.speed = speed;
        this.angle = angle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
