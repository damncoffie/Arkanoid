import java.awt.*;
import java.util.Map;

/**
 * Created by Mikhail_Bobriashov on 6/9/2017.
 */
public class PieceUI implements Runnable {

    private Piece piece;
    private Image image;
    private GameUI gameUI;
    private double x = 200;
    private double y = 370;

    private double difX;
    private double difY;

    PieceUI(Piece piece, Image image, GameUI gameUI) {
        this.piece = piece;
        this.image = image;
        this.gameUI = gameUI;

        difX = (int) (2 * Math.cos(Math.toRadians(piece.getAngle())));
        difY = (int) (-2 * (float)Math.sin(Math.toRadians(piece.getAngle())));
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Piece getPiece() {
        return piece;
    }

    public void move() {
        x = x + difX;
        y = y + difY;
    }

    @Override
    public void run() {
        System.out.println("ss");
        while (true) {
            move();

            try {
                Thread.sleep(100);
                gameUI.repaint();
            } catch (Exception ex) {
                ex.printStackTrace();
                //System.out.println("You're fucked");
            }
        }

    }

    void draw(Graphics g) {
        g.drawImage(this.getImage(), (int) x, (int) y, null );
    }
}
