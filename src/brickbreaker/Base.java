package brickbreaker;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Base extends JButton implements KeyListener {
    private static final int BASE_WIDTH = 130;
    private static final int BASE_HEIGHT = 15;
    private static final int MOVE_STEP = 5;
    private static final int LEFT_BOUND = 5;
    private static final int RIGHT_BOUND = 775;

    private int x = 325;
    private int y = 400;
    private boolean isRightKeyPressed = false;
    private boolean isLeftKeyPressed = false;

    public Base() {
        initializeBase();
    }

    private void initializeBase() {
        super.setPreferredSize(new Dimension(BASE_WIDTH, BASE_HEIGHT));
        super.setBounds(x, y, BASE_WIDTH, BASE_HEIGHT);
        super.setBorderPainted(false);
        super.setFocusable(true);
        super.addKeyListener(this);
        loadBaseImage();
    }

    private void loadBaseImage() {
        try {
            Image baseImage = ImageIO.read(new File("assets/base2.jpg")).getScaledInstance(BASE_WIDTH, BASE_HEIGHT, Image.SCALE_SMOOTH);
            super.setIcon(new ImageIcon(baseImage));
        } catch (IOException ex) {
            System.out.println("[ERROR] Unable to load base image");
        }
    }

  public void move() {
    if (isRightKeyPressed && canMoveRight()) {
        this.x += MOVE_STEP;
    } else if (isLeftKeyPressed && canMoveLeft()) {
        this.x -= MOVE_STEP;
    }

    // Ensure the base does not go beyond the left bound
    if (this.x < LEFT_BOUND) {
        this.x = LEFT_BOUND;
    }

    this.setBounds(this.x, this.y, BASE_WIDTH, BASE_HEIGHT);
}


    private boolean canMoveRight() {
        return this.x + BASE_WIDTH < RIGHT_BOUND;
    }

    private boolean canMoveLeft() {
        return this.x >= LEFT_BOUND;
    }

    // Collision detection with the ball
    

  public boolean isCollisionWithBall(Ball ball) {
    return ball.x + ball.getBALL_WIDTH() >= this.x && ball.x <= this.x + BASE_WIDTH &&
           ball.y + ball.getBALL_HEIGHT() >= this.y && ball.y <= this.y + BASE_HEIGHT;
}


    public int getBASE_WIDTH() {
        return BASE_WIDTH;
    }

    public int getBASE_HEIGHT() {
        return BASE_HEIGHT;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            isLeftKeyPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            isRightKeyPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            isLeftKeyPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            isRightKeyPressed = false;
        }
    } 
    
}
