package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

public class BaseTest {

    private Base base;
    private Ball ball;

    // Setup before each test (JUnit 4)
    @Before
    public void setUp() {
        base = new Base();  // Create an instance of the Base (paddle)
        ball = new Ball();  // Create a mock instance of the Ball
    }

    /**
     * Test the constructor and initial setup of the Base (paddle).
     * Ensures the Base is initialized with correct values.
     */
    @Test
    public void testBaseConstructor() {
        System.out.println("Testing Base constructor");

        // Test initial position of the base
        assertEquals("Initial x position should be 325", 325, base.getX());
        assertEquals("Initial y position should be 400", 400, base.getY());
        assertEquals("Base width should be 130", 130, base.getBASE_WIDTH());
        assertEquals("Base height should be 15", 15, base.getBASE_HEIGHT());
    }

    /**
     * Test movement of the Base (paddle).
     * Ensures that the Base moves correctly when arrow keys are pressed.
     */
    @Test
    public void testBaseMovement() {
        System.out.println("Testing Base movement");

        // Move the base to the right by simulating key press
        base.keyPressed(new KeyEvent(base, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED));
        base.move();
        assertTrue("Base should have moved to the right", base.getX() > 325); // Initial position was 325

          }

    /**
     * Test if the Base doesn't go out of bounds on the right side.
     */
  

    /**
     * Test if the Base doesn't go out of bounds on the left side.
     */
    @Test
    public void testBaseLeftBound() {
        System.out.println("Testing Base left bound");

        base.keyPressed(new KeyEvent(base, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED));

        // Simulate 200 movements to the left, should stop at left bound (5)
        for (int i = 0; i < 200; i++) {
            base.move();
        }

        assertEquals("Base should be at left bound", 5, base.getX());
    }

    /**
     * Test the collision detection between the Base and the Ball.
     */
    @Test
    public void testCollisionWithBall() {
        System.out.println("Testing collision detection between Base and Ball");

        // Set up ball position to be on top of the base
        ball.x = 320; // near the base
        ball.y = 400 - ball.getBALL_HEIGHT(); // just above the base

        // Check for collision (it should be true since ball is positioned above the base)
        assertTrue("Base should collide with the ball", base.isCollisionWithBall(ball));

        // Move ball away from the base (simulate no collision)
        ball.x = 1000; // Ball far away from the base
        assertFalse("Base should not collide with the ball", base.isCollisionWithBall(ball));
    }

    /**
     * Test that the Base doesn't move if no keys are pressed.
     */
    @Test
    public void testBaseNoMovement() {
        System.out.println("Testing no movement when no keys are pressed");

        int initialX = base.getX();
        base.move(); // Move without any key press

        assertEquals("Base should not have moved", initialX, base.getX());  // The x position should remain the same
    }
}
