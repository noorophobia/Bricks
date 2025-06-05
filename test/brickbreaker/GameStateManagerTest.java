package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateManagerTest {

    private GameStateManager gameStateManager;
    private GameStateManager.MessageDialog mockDialog;

    @Before
    public void setUp() {
        // Create a mock MessageDialog
        mockDialog = new GameStateManager.MessageDialog() {
            @Override
            public void showMessage(String message) {
                // Capture the message for assertions
                capturedMessage = message;
            }
        };
        
        // Initialize the GameStateManager with the mock
        gameStateManager = new GameStateManager(mockDialog);
    }

    private String capturedMessage;

    @Test
    public void testHandleGameOver() {
        // Call the method that shows the "Game Over" dialog
        gameStateManager.handleGameOver();

        // Check the captured message
        assertEquals("Game Over", capturedMessage);
    }

    @Test
    public void testHandleNextLevel() {
        // Call the method that shows the "Level Complete" dialog
        gameStateManager.handleNextLevel();

        // Check the captured message
        assertEquals("Level Complete! Proceeding to the next level.", capturedMessage);
    }
}
