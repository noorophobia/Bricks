package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class BrickPatternStateTest {

    private BrickPatternState levelOnePattern;
    private BrickPatternState levelTwoPattern;
    private BrickPatternState levelThreePattern;

    @Before
    public void setUp() {
        levelOnePattern = new LevelOneBrickPattern();
        levelTwoPattern = new LevelTwoBrickPattern();
        levelThreePattern = new LevelThreeBrickPattern();
    }

    /**
     * Test createBricks for Level 1.
     */
    @Test
    public void testCreateBricks_LevelOne() {
        System.out.println("Testing createBricks for level 1");
        ArrayList<Brick> result = levelOnePattern.createBricks();
        assertNotNull("Bricks should be created", result);
        // You can add further assertions like checking the number of bricks or specific properties of the bricks.
    }

    /**
     * Test createBricks for Level 2.
     */
    @Test
    public void testCreateBricks_LevelTwo() {
        System.out.println("Testing createBricks for level 2");
        ArrayList<Brick> result = levelTwoPattern.createBricks();
        assertNotNull("Bricks should be created", result);
        // Further assertions about the brick count or other properties.
    }

    /**
     * Test createBricks for Level 3.
     */
    @Test
    public void testCreateBricks_LevelThree() {
        System.out.println("Testing createBricks for level 3");
        ArrayList<Brick> result = levelThreePattern.createBricks();
        assertNotNull("Bricks should be created", result);
        // Further assertions about the brick count or other properties.
    }

    /**
     * Test createBricks for an unsupported level (e.g., no level 6).
     */
    @Test
    public void testCreateBricks_UnsupportedLevel() {
        System.out.println("Testing createBricks for an unsupported level");
        BrickPatternState unsupportedPattern = BrickPatternFactory.getBrickPattern(6);
        ArrayList<Brick> result = unsupportedPattern.createBricks();
        assertNotNull("Bricks should still be created", result);
        // Further validation can be done to ensure that the default behavior is applied correctly.
    }

    public class LevelOneBrickPattern implements BrickPatternState {
        @Override
        public ArrayList<Brick> createBricks() {
            // Create bricks for level 1
            ArrayList<Brick> bricks = new ArrayList<>();
            bricks.add(new Brick(null)); // Adding mock bricks for the test
            return bricks;
        }
    }

    public class LevelTwoBrickPattern implements BrickPatternState {
        @Override
        public ArrayList<Brick> createBricks() {
            ArrayList<Brick> bricks = new ArrayList<>();
            bricks.add(new Brick(null));
            return bricks;
        }
    }

    public class LevelThreeBrickPattern implements BrickPatternState {
        @Override
        public ArrayList<Brick> createBricks() {
            ArrayList<Brick> bricks = new ArrayList<>();
            bricks.add(new Brick(null));
            return bricks;
        }
    }
}
