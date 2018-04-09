import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Board extends JPanel {

    private Pieces[][] piece;
    private int playerturn;
    private boolean isWon;

    public JLabel playerturntext;


    //Self Made Images
    private ImageIcon red = new ImageIcon(getClass().getResource("Pictures/RedPiece.png"));
    private ImageIcon yellow = new ImageIcon(getClass().getResource("Pictures/YellowPiece.png"));
    private ImageIcon white = new ImageIcon(getClass().getResource("Pictures/WhitePiece.png"));
    private ImageIcon color;


    Board() throws IOException {
        // initializing the board and setting its background
        setBackground(Color.BLUE);
        setLayout(new GridLayout(6, 7));

        // Initialize the player turn
        playerturn = 0;

        // ENCAPSULATION ERROR (FIX)
        playerturntext = new JLabel("RED STARTS");
        playerturntext.setForeground(Color.RED);

        // create pieces
        piece = new Pieces[6][7];


        // adding the pieces to the board
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {
                piece[i][j] = new Pieces();

                // Set all pieces above the first row not clickable
                if(i < 5 && j <= 6){
                    piece[i][j].setEnabled(false);
                }

                // add action listener to each of the pieces
                piece[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // increase player turn each click
                        playerturn++;

                        // loop through again and get each button clicked
                        for (int i = 0; i < piece.length; i++) {
                            for (int j = 0; j < piece[i].length; j++) {

                                // If One of the players one then disable all the other buttons
                                if(isWon){
                                    if(color == red){
                                        playerturntext.setText("RED PLAYER HAS WON!");
                                        playerturntext.setForeground(Color.RED);
                                    }
                                    else{
                                        playerturntext.setText("YELLOW PLAYER HAS WON!");
                                        playerturntext.setForeground(Color.YELLOW);
                                    }
                                    playerWon(piece);
                                }

                                // Gets the exact button that the player clicked
                                // And runs the logic to the game (SPAGHETTI CODE!!)
                                if (e.getSource().equals(piece[i][j])) {
                                    // Open the button above the one that is clicked for next player
                                    if(i <= 5 && i > 0){
                                        piece[i-1][j].setEnabled(true);
                                    }

                                    // Change icon color and  player turn
                                    if(playerturn % 2 == 0){
                                        color = yellow;
                                        piece[i][j].setEnabled(false);
                                        piece[i][j].setDisabledIcon(yellow);
                                        setPlayerturntext();
                                    }
                                    else{
                                        color = red;
                                        piece[i][j].setEnabled(false);
                                        piece[i][j].setDisabledIcon(red);
                                        setPlayerturntext();
                                    }

                                    // HERE IS THE LOGIC FOR THE GAME!!
                                    // IT CHECKS THE COLOR OF THE ICON WITH EACH CLICK!!
                                    if (i == 0 && j == 0) {
                                        //CheckRight
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckBelow
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckRightBelow
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                    }

                                    if (i == 0 && j == 6) {
                                        //CheckLeft
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckBelow
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckLeftBelow
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j - 1].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                    }

                                    if (i == 5 && j == 0) {
                                        //CheckRight
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckUp
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckRightUP
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j + 1].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                    }

                                    if (i < 3 && j < 3) {
                                        // Check Right
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        // CheckBelow
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        // CheckRightDiagonal
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                    }

                                    if (i >= 3 && j < 3) {
                                        //CheckUP
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckUpRightDiagonalUp
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckRight
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }


                                    }

                                    if (i < 3 && j > 3) {
                                        //CheckBelow
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckLeft
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckLeftDiagonalDown
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }

                                    }

                                    if (i > 2 && j > 3) {
                                        //CheckUp
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckLeft
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckLeftDiagaonalUP
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                    }

                                    if (i < 3 && j == 3) {
                                        //CheckLeft
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckRight
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckRightDiagonalDown
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckLeftDiagonalDown
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i + 1][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i + 2][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i + 3][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                    }

                                    if (i >= 3 && j == 3) {
                                        //CheckLeft
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckRight
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckUp
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckRightDiagonalUp
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j + 1].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j + 2].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j + 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                        //CheckLeftDiagonalUp
                                        if (piece[i][j].getDisabledIcon().equals(color) &&
                                                piece[i - 1][j - 1].getDisabledIcon().equals(color) &&
                                                piece[i - 2][j - 2].getDisabledIcon().equals(color) &&
                                                piece[i - 3][j - 3].getDisabledIcon().equals(color)
                                                ) {
                                            isWon = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                });

                add(piece[i][j]);
            }
        }
    }

    // If isWon is true then disable all the buttons
    public void playerWon(Pieces pieces[][]){
        for(int i = 0; i < pieces.length; i++){
            for(int j = 0; j < pieces[i].length; j++){
                pieces[i][j].setEnabled(false);
            }
        }
    }


    public void setPlayerturntext() {
        if(color == yellow){
            playerturntext.setText("RED PLAYER'S TURN");
            playerturntext.setForeground(Color.RED);
        }
        if(color == red){
            playerturntext.setText("YELLOW PLAYER'S TURN");
            playerturntext.setForeground(Color.YELLOW);
        }
    }

    public String getPlayerTurntext(){
        return playerturntext.getText();
    }

}