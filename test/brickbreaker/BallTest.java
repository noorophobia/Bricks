package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BallTest {

    private Ball ball;

    // Setup before each test (JUnit 4)
    @Before
    public void setUp() {
        ball = new Ball();  // Create an instance before each test
    }

    /**
     * Test the constructor of Ball.
     * Ensures the ball is initialized with the correct default values.
     */
    @Test
    public void testBallConstructor() {
        System.out.println("Testing Ball constructor");

        // Test that the preferred size is correctly set
        Dimension preferredSize = ball.getPreferredSize();
        assertEquals("Width should be 20", 20, preferredSize.width);
        assertEquals("Height should be 15", 15, preferredSize.height);

        // Test initial x and y positions
        assertEquals("Initial x position should be 325", 325, ball.x);
        assertEquals("Initial y position should be 350", 350, ball.y);

        // Test that the x and y velocities are set to default values
        assertEquals("Initial x velocity should be 4", 4, ball.xVelocity);
        assertEquals("Initial y velocity should be -4", -4, ball.yVelocity);

        // Test that the icon has been set (i.e., ball image is loaded)
        Icon icon = ball.getIcon();
        assertNotNull("Ball image should be set", icon);
    }

    /**
     * Test the image loading functionality of the Ball class.
     * Ensures the ball image is loaded correctly when the Ball is initialized.
     */
    @Test
    public void testLoadBallImage() {
        System.out.println("Testing loadBallImage()");

        // Verify that the ball image is loaded (the icon should not be null)
        Icon icon = ball.getIcon();
        assertNotNull("Ball image should be set", icon);
    }

    /**
     * Test the moveBall() method.
     * Ensures the ball moves correctly and collides with walls.
     */
    @Test
    public void testMoveBall() {
        System.out.println("Testing moveBall()");

        // Test initial position
        int initialX = ball.x;
        int initialY = ball.y;

        // Move the ball (should update position based on velocity)
        ball.moveBall();

        // Ball should have moved based on its velocity
        assertNotEquals("X position should change after move", initialX, ball.x);
        assertNotEquals("Y position should change after move", initialY, ball.y);
    }

    /**
     * Test wall collision detection in moveBall().
     * Ensures the ball bounces off the walls when it hits the edges.
     */
    @Test
    public void testWallCollision() {
        System.out.println("Testing wall collision detection");

        // Set the ball's x and y position to a point near the right edge
        ball.x = 780;
        ball.y = 10;  // Top of the screen
        ball.xVelocity = 4;
        ball.yVelocity = -4;

        // Move the ball and check if it changes direction upon collision
        ball.moveBall();

        // After hitting the right wall, the x velocity should be inverted
        assertEquals("Ball should have inverted x velocity after hitting the wall", -4, ball.xVelocity);

        // Test collision with the top of the screen
        ball.x = 10; // Left side of the screen
        ball.y = 0; // Top of the screen
        ball.xVelocity = 4;
        ball.yVelocity = -4;
        ball.moveBall();
System.out.println("Ball position after move: x=" + ball.x + ", y=" + ball.y);
System.out.println("Ball velocity after move: xVelocity=" + ball.xVelocity + ", yVelocity=" + ball.yVelocity);

// After hitting the top, the y velocity should be inverted
assertEquals("Ball should have inverted y velocity after hitting the top", 4, ball.yVelocity);


    }

    /**
     * Test getBALL_WIDTH() method.
     * Ensures the method returns the correct ball width.
     */
    @Test
    public void testGetBallWidth() {
        System.out.println("Testing getBALL_WIDTH()");

        int ballWidth = ball.getBALL_WIDTH();
        assertEquals("Ball width should be 20", 20, ballWidth);
    }

    /**
     * Test getBALL_HEIGHT() method.
     * Ensures the method returns the correct ball height.
     */
    @Test
    public void testGetBallHeight() {
        System.out.println("Testing getBALL_HEIGHT()");

        int ballHeight = ball.getBALL_HEIGHT();
        assertEquals("Ball height should be 15", 15, ballHeight);
    }

    
}
