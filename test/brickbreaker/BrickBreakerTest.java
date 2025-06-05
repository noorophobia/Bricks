package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.swing.*;

public class BrickBreakerTest {

    private GameFrame gameFrame;

    // Set up the test environment
    @Before
    public void setUp() {
        // We are simulating the game initialization
        gameFrame = new GameFrame();
    }

    // Test to ensure the GameFrame is instantiated
    @Test
    public void testGameFrameInitialization() {
        // Check if the GameFrame object is not null
        assertNotNull("GameFrame should be initialized", gameFrame);
    }

    // Test to ensure the GameFrame is visible
    @Test
    public void testGameFrameVisibility() {
        // Simulate calling the setVisible(true) method
        gameFrame.setVisible(true);
        
        // Since it's not easy to directly test visibility in Swing, we will check the state of the frame
        assertTrue("GameFrame should be visible", gameFrame.isVisible());
    }
}
