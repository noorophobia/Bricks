package brickbreaker;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LevelManagerTest {

    private LevelManager levelManager;

    @Before
    public void setUp() {
        levelManager = new LevelManager();
    }

    @Test
    public void testInitialLevel() {
        // Test the initial level (should be level 1)
        assertEquals("Initial level should be 1", 1, levelManager.getLevel());
    }

    @Test
    public void testLevelProgression() {
        // Initially, the level should be 1
        assertEquals("Initial level should be 1", 1, levelManager.getLevel());

        // Increment the level
        levelManager.nextLevel();

        // After calling nextLevel, the level should be 2
        assertEquals("Level should increment to 2", 2, levelManager.getLevel());
    }

    @Test
    public void testGetBricksForLevel() {
        // Get the bricks for the initial level (level 1)
        ArrayList<Brick> bricksLevel1 = levelManager.getBricksForLevel();

        // Verify that bricks are returned for level 1
        assertNotNull("Bricks should be returned for level 1", bricksLevel1);

        // Check that there is a non-zero number of bricks for level 1
        assertTrue("There should be bricks for level 1", bricksLevel1.size() > 0);

        // Move to the next level
        levelManager.nextLevel();

        // Get the bricks for level 2
        ArrayList<Brick> bricksLevel2 = levelManager.getBricksForLevel();

        // Verify that bricks are returned for level 2
        assertNotNull("Bricks should be returned for level 2", bricksLevel2);

        // Check that there is a non-zero number of bricks for level 2
        assertTrue("There should be bricks for level 2", bricksLevel2.size() > 0);
    }

    @Test
    public void testNextLevel() {
        // Initially, the level should be 1
        assertEquals("Initial level should be 1", 1, levelManager.getLevel());

        // Call nextLevel() and verify the level increments
        levelManager.nextLevel();
        assertEquals("Level should increment to 2", 2, levelManager.getLevel());

        // Call nextLevel() again and verify the level increments
        levelManager.nextLevel();
        assertEquals("Level should increment to 3", 3, levelManager.getLevel());
    }
}
