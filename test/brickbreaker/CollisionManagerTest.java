package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the CollisionManager class.
 */
public class CollisionManagerTest {
    
    private CollisionManager collisionManager;
    private Base base;
    private Ball ball;
    
    @Before
    public void setUp() {
        collisionManager = new CollisionManager();
        base = new Base();  // Create a base
        ball = new Ball();  // Create a ball
    }

    /**
     * Test that the ball's velocity is inverted when it collides with the base.
     */
    @Test
    public void testCollisionWithBase() {
        // Position the ball above the base for collision
        ball.x = 350;  // Middle of the screen
        ball.y = 395;  // Slightly above the base
        ball.xVelocity = 4;
        ball.yVelocity = -4;

        // Set the base position
        base.setBounds(325, 400, base.getBASE_WIDTH(), base.getBASE_HEIGHT());
        
        // Perform collision check
        collisionManager.checkCollisionsWithBase(base, ball);
        
        // Assert that the ball's Y velocity has been inverted
        assertEquals("Ball's Y velocity should be inverted after collision with base", 4, ball.yVelocity);
        
        // Assert that the ball's X velocity might be inverted if it hits the right side
        assertEquals("Ball's X velocity should change if the ball is on the right side", 4, ball.xVelocity);
    }

    /**
     * Test for collision when no collision occurs.
     */
    @Test
    public void testNoCollisionWithBase() {
        // Set ball position away from the base (no collision)
        ball.x = 350;
        ball.y = 500; // Below the base
        ball.xVelocity = 4;
        ball.yVelocity = -4;

        // Set the base position
        base.setBounds(325, 400, base.getBASE_WIDTH(), base.getBASE_HEIGHT());

        // Perform collision check
        collisionManager.checkCollisionsWithBase(base, ball);

        // Assert that the ball's velocity hasn't changed
        assertEquals("Ball's Y velocity should remain the same if there's no collision", -4, ball.yVelocity);
        assertEquals("Ball's X velocity should remain the same if there's no collision", 4, ball.xVelocity);
    }
}
