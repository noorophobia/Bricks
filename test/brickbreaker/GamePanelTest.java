package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GamePanelTest {

    private GamePanel gamePanel;
    private Base base;
    private Ball ball;
    private ArrayList<Brick> bricks;
    private LevelManager levelManager;
    private AudioPlayback audioPlayback;
    private BackgroundImageLabel backgroundImageLabel;
    

@Before
public void setUp() {
    gamePanel = new GamePanel();  // Initialize GamePanel
    assertNotNull("GamePanel should not be null", gamePanel);  // Assert gamePanel is initialized
    base = gamePanel.base;
    ball = gamePanel.ball;
    levelManager = gamePanel.levelManager;
    assertNotNull("LevelManager should not be null", levelManager);  // Assert levelManager is initialized
    audioPlayback = gamePanel.audioPlayback;
    bricks = gamePanel.bricks;
    assertNotNull("Bricks should not be null", bricks);  // Assert bricks list is initialized
}


    @Test
    public void testGamePanelInitialization() {
        gamePanel.revalidate();
        gamePanel.repaint();

        // Test that the GamePanel is initialized with the expected size
       SwingUtilities.invokeLater(() -> {
    // Now that the component has been laid out, you can check the size
    assertEquals("GamePanel width should be 800", 800, gamePanel.getWidth());
    assertEquals("GamePanel height should be 500", 500, gamePanel.getHeight());
            assertTrue("Bricks should be added to the panel", gamePanel.getComponentCount() > 2);  // Ball and Base are also added, so more than 2 components

});

      }

   
 
 

   
}
