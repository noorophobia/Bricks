package brickbreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 500;
    public final Base base;
    public final Ball ball;
    public ArrayList<Brick> bricks;
    private final BackgroundImageLabel backgroundImageLabel;
    public final Timer timer;
    public final LevelManager levelManager;
    private final GameStateManager gameStateManager;
    private final CollisionManager collisionManager;
    public final AudioPlayback audioPlayback;

    public GamePanel() {
        super.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        super.setLayout(new BorderLayout());

        backgroundImageLabel = new BackgroundImageLabel();
        base = new Base();
        ball = new Ball();
        backgroundImageLabel.add(ball);
        backgroundImageLabel.add(base);

        levelManager = new LevelManager();
        bricks = levelManager.getBricksForLevel();
        bricks.forEach(backgroundImageLabel::add);
        super.add(backgroundImageLabel, BorderLayout.NORTH);

        gameStateManager = new GameStateManager();
        collisionManager = new CollisionManager();
        audioPlayback = new AudioPlayback();

        timer = new Timer(16, this);
        timer.start();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        super.repaint();
        base.move();
        ball.moveBall();
        
        // Check for collisions
        collisionManager.checkCollisionsWithBase(base, ball);
        Brick collidedBrick = collisionManager.checkCollisionsWithBricks(bricks, ball);

        if (collidedBrick != null) {
            audioPlayback.playSoundEffect();
            backgroundImageLabel.remove(collidedBrick);
        }

        // Level management
        if (bricks.isEmpty()) {
            levelManager.nextLevel();
            bricks = levelManager.getBricksForLevel();
            bricks.forEach(backgroundImageLabel::add);
            gameStateManager.handleNextLevel();
        }

        // Game over check
        if (ball.y >= PANEL_HEIGHT) {
            gameStateManager.handleGameOver();
            timer.stop();  // Stop the timer when game is over
         }
    }
}
