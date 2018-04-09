import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class ConnectFour extends JFrame {
    Board board;

    // create Panel to tell each players turn
    JPanel PlayerPanel = new JPanel();
    JLabel Playerturn = new JLabel("Start");

    ConnectFour() throws IOException{
        super("Connect Four");

        getContentPane();
        setResizable(false);
        setSize(440,440);
        setLocation(500,100);

        //intialize board
        board = new Board();

        // Players Turn Panel
        PlayerPanel.add(board.playerturntext);
        PlayerPanel.setBackground(Color.black);

        // add components to frame
        add(board, BorderLayout.CENTER);
        add(PlayerPanel, BorderLayout.NORTH);

        // set board in the middle of the screen
        setLocationRelativeTo(null);

        // set visible
        setVisible(true);

    }

    // Main function
    public static void main(String args[]) throws IOException{
        ConnectFour C = new ConnectFour();
        C.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        C.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }
}
