 
package brickbreaker;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackgroundImageLabel extends JLabel {
    //Before: The dimensions (800, 500) were hardcoded multiple times throughout the code.
//After: You introduced constants WIDTH and HEIGHT to store these values, making the code more reusable and easier to modify.
// extracted setBackgrounfimage method
    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    public static final String BACKGROUND_IMAGE_PATH = "assets/bg.jpg";

    public BackgroundImageLabel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBounds(0, 0, WIDTH, HEIGHT);
        setBackgroundImage();
    }

    void setBackgroundImage() {
        try {
            Image backgroundImage = ImageIO.read(new File(BACKGROUND_IMAGE_PATH));
            setIcon(new ImageIcon(backgroundImage));
        } catch (IOException ex) {
            System.err.println("[ERROR] Unable to load background image: " + BACKGROUND_IMAGE_PATH);
         }
    }

     
}
 