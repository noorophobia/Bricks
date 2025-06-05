package brickbreaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Brick extends JButton {
    private final int BRICK_WIDTH = 70;
    private final int BRICK_HEIGHT = 30;

    public Brick(ImageIcon brickImage) {
        super.setPreferredSize(new Dimension(BRICK_WIDTH, BRICK_HEIGHT));
        super.setBorderPainted(true);
        super.setFocusable(false);

        if (brickImage != null) {
            super.setIcon(brickImage);
        } else {
            super.setBackground(Color.red);
        }
    }

    // Collision detection with the ball
    public boolean checkCollisionWithBall(Ball ball) {
        Rectangle bounds = this.getBounds();
        if (ball.x >= bounds.x && ball.x <= bounds.x + bounds.width &&
            ball.y <= bounds.y + bounds.height && ball.y >= bounds.y) {
            ball.yVelocity *= -1;  // Reverse the ball's Y velocity on collision
            return true;  // Collision occurred
        }
        return false;  // No collision
    }

    public int getBRICK_WIDTH() {
        return BRICK_WIDTH;
    }

    public int getBRICK_HEIGHT() {
        return BRICK_HEIGHT;
    }
}
