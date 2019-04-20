import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by Mikhail_Bobriashov on 6/9/2017
 */
public class GameUI extends JPanel {

    private Game game;
    private ArrayList<PieceUI> pieceUIList;
    private Trapeze trapeze;

    private JFrame gameFrame;
    private JButton startButton;
    private JButton pauseButton;
    private JButton finishButton;
    private JTextField speedField;
    private JTextField numberOfPiecesFiled;



    public static void main(String[] args) {
        GameUI gameUI = new GameUI(1);
    }

    public Trapeze getTrapeze() {
        return trapeze;
    }

    GameUI(int numberOfPieces) {
        this.game = new Game(numberOfPieces);
        this.pieceUIList = new ArrayList<>();
        trapeze = new Trapeze(new ImageIcon("C:/Users/agent_000/Desktop/pad.jpg").getImage());

        // text fields
        speedField = new JTextField(10);
        speedField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        numberOfPiecesFiled = new JTextField(10);

        // start button
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // pause button
        pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // finish button
        finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        // adding buttons to panel
        this.setSize(500, 500);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(100, 50);
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(finishButton);


        // adding text fields to panel
        JPanel textPanel = new JPanel();
        textPanel.add(speedField);
        textPanel.add(numberOfPiecesFiled);


        // adjusting frame
        gameFrame = new JFrame("Arkanoid");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setSize(500, 500);
        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //gameFrame.setLocation(dim.width / 2 - gameFrame.getSize().width / 2,
                //dim.height / 2 - gameFrame.getSize().height / 2);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setAlwaysOnTop(true);
        gameFrame.setResizable(false);

        JPanel southPanel = new JPanel();
        southPanel.add(BorderLayout.NORTH, textPanel);
        southPanel.add(BorderLayout.SOUTH, buttonPanel);


        for (Piece piece : game.getLogicPieceList()) {
            createAndAddPieceUI(piece);
        }

        // adding panels to frame
        gameFrame.add(BorderLayout.CENTER, this);
        gameFrame.add(BorderLayout.SOUTH, southPanel);
        gameFrame.setVisible(true);

        for (PieceUI pieceUI:pieceUIList) {
            Thread ballThread = new Thread(pieceUI);
            ballThread.start();
        }


    }

    private void createAndAddPieceUI(Piece piece) {
        Image image = this.loadImage();
        PieceUI pieceUI = new PieceUI(piece, image, this);
        pieceUIList.add(pieceUI);
    }

    private Image loadImage() {
        return new ImageIcon("C:/Users/agent_000/Desktop/ball.png").getImage();
    }

    @Override
    public void paint(Graphics g) {
        //Image image = new ImageIcon("C:/Users/agent_000/Desktop/kek.jpg").getImage();
        //g.drawImage(image, 0, 0, null);
        //g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight() );

        for (PieceUI pieceUI : pieceUIList) {
            pieceUI.draw(g);
        }

        g.drawImage(trapeze.getTrapezeView(), 200, 400, null);
    }

}
