package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ADMIN
 */
public class BrickPatternFactoryTest {

    public BrickPatternFactoryTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of getBrickPattern method, of class BrickPatternFactory.
     */
    @Test
    public void testGetBrickPattern_Level1() {
        System.out.println("Testing getBrickPattern for level 1");
        BrickPatternState result = BrickPatternFactory.getBrickPattern(1);
        assertTrue(result instanceof LevelOneBrickPattern);
    }

    @Test
    public void testGetBrickPattern_Level2() {
        System.out.println("Testing getBrickPattern for level 2");
        BrickPatternState result = BrickPatternFactory.getBrickPattern(2);
        assertTrue(result instanceof LevelTwoBrickPattern);
    }

    @Test
    public void testGetBrickPattern_Level3() {
        System.out.println("Testing getBrickPattern for level 3");
        BrickPatternState result = BrickPatternFactory.getBrickPattern(3);
        assertTrue(result instanceof LevelThreeBrickPattern);
    }

    @Test
    public void testGetBrickPattern_Level4() {
        System.out.println("Testing getBrickPattern for level 4");
        BrickPatternState result = BrickPatternFactory.getBrickPattern(4);
        assertTrue(result instanceof LevelFourBrickPattern);
    }

    @Test
    public void testGetBrickPattern_Default() {
        System.out.println("Testing getBrickPattern for default (level > 4)");
        BrickPatternState result = BrickPatternFactory.getBrickPattern(5); // Assuming this level is default
        assertTrue(result instanceof LevelFiveBrickPattern);
    }
}
