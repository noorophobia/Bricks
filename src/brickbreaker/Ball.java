package brickbreaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Ball extends JButton {

    private static final int BALL_WIDTH = 20;
    private static final int BALL_HEIGHT = 15;
    private static final int DEFAULT_X_VELOCITY = 4;
    private static final int DEFAULT_Y_VELOCITY = -4;

    protected int xVelocity = DEFAULT_X_VELOCITY;
    protected int yVelocity = DEFAULT_Y_VELOCITY;
    public int x = 325;
    public int y = 350;

    public Ball() {
        initializeBall();
    }

    private void initializeBall() {
        super.setPreferredSize(new Dimension(BALL_WIDTH, BALL_HEIGHT));
        super.setBounds(x, y, BALL_WIDTH, BALL_HEIGHT);
        super.setBackground(new Color(255, 255, 255, 0));
        super.setBorderPainted(false);
        super.setFocusable(false);

        loadBallImage();
    }

    private void loadBallImage() {
        try {
            Image ballImage = ImageIO.read(new File("assets/ball.png"))
                .getScaledInstance(BALL_WIDTH, BALL_HEIGHT, Image.SCALE_SMOOTH);
            super.setIcon(new ImageIcon(ballImage));
        } catch (IOException ex) {
            System.err.println("[ERROR] Unable to load ball image: " + ex.getMessage());
        }
    }

    public void moveBall() {
        // Update ball's position first
        this.x += this.xVelocity;
        this.y += this.yVelocity;

        // Then check wall collisions
        checkWallCollisions();

        // Set the bounds of the ball based on updated x and y values
        setBallBounds();
    }

    private void checkWallCollisions() {
        // Left and Right Wall Collision
        if (this.x < 0 || (this.x + BALL_WIDTH) > 790) {
            this.xVelocity *= -1;
        }

        // Top Wall Collision (inverted y velocity)
        if (this.y < 0) {
            this.yVelocity *= -1;  // Correct inversion
        }
        
        // Bottom Wall Collision (no y collision, assuming it’s a border)
        if (this.y + BALL_HEIGHT > 600) { // Assuming screen height is 600
            this.yVelocity *= -1;
        }
    }
    
    private void setBallBounds() {
        this.setBounds(this.x, this.y, BALL_WIDTH, BALL_HEIGHT);
    }

    public int getBALL_WIDTH() {
        return BALL_WIDTH;
    }

    public int getBALL_HEIGHT() {
        return BALL_HEIGHT;
    }
}
