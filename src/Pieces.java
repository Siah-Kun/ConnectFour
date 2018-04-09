import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Pieces extends JToggleButton{


    // self made images
    private ImageIcon white = new ImageIcon("/Users/shermiah/IdeaProjects/ConnectFour/src/Pictures/WhitePiece.png");
    private ImageIcon color;

    Pieces() throws IOException {
        // add the white as the orginal background
        setIcon(white);

        // get rid of button borders
        setBorderPainted(false);
        setContentAreaFilled(false);
    }

    public void setColor(ImageIcon color) {
        this.color = color;
    }

    public ImageIcon getColor() {
        return color;
    }
}
