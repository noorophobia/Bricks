package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;
import java.awt.*;

public class BrickTest {

    private Brick brick;
    private Ball ball;

    // Set up the test environment
    @Before
    public void setUp() {
        // Create a ball instance with some initial position and velocity
        ball = new Ball();

        // Create a Brick instance with no image (should default to red background)
        brick = new Brick(null);  // No image provided, defaults to red background
        
        // Manually set the brick's position for testing
        brick.setBounds(0, 0, 70, 30); // Set brick position and size explicitly
    }

    // Test collision detection with the Ball
    @Test
    public void testCheckCollisionWithBall() {
        System.out.println("Testing collision detection with Ball");

        // Set up the ball to collide with the brick
        // Ball should be positioned inside the brick's bounds
        ball.x = 10;  // Ball x is within brick's x range
        ball.y = 10;  // Ball y is within brick's y range
        ball.yVelocity = -4;  // Ball is moving down towards the brick

        // Print out the ball and brick positions for debugging
        System.out.println("Ball Position: x=" + ball.x + ", y=" + ball.y);
        System.out.println("Brick Bounds: x=" + brick.getBounds().x + ", y=" + brick.getBounds().y +
                           ", width=" + brick.getBounds().width + ", height=" + brick.getBounds().height);

        // Ensure the ball's velocity before the collision
        int initialYVelocity = ball.yVelocity;

        // Check if the collision is detected
        boolean collided = brick.checkCollisionWithBall(ball);

        // Assert that the collision occurred and ball's Y velocity is inverted
        assertTrue("Ball should collide with the brick", collided);
        assertEquals("Ball Y velocity should be inverted", initialYVelocity * -1, ball.yVelocity);
    }
}
