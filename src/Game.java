import java.util.ArrayList;

/**
 * Created by Mikhail_Bobriashov on 6/9/2017.
 */
class Game {

    private ArrayList<Piece> logicPieceList;

    Game(int numberOfPieces) {
        logicPieceList = new ArrayList<>();

        for (int i = 0; i < numberOfPieces; i++) {
            createAndAddLogicPiece();
        }
    }

    private void createAndAddLogicPiece() {
        Piece piece = new Piece((int) (Math.random()*10) + 1, (int) (Math.random()*180) + 1);
        System.out.println(piece.angle);
        System.out.println(Math.cos(piece.getAngle()) + " " + Math.sin(piece.getAngle()));
        System.out.println(piece.getSpeed());
        logicPieceList.add(piece);
    }

    ArrayList<Piece> getLogicPieceList() {
        return logicPieceList;
    }

}
