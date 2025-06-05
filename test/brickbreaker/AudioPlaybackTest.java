/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package brickbreaker;import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for AudioPlayback.
 * Ensures that the audio functions execute without exceptions.
 * 
 * @author ADMIN
 */
public class AudioPlaybackTest {

    public AudioPlaybackTest() {
    }

    // Setup before each test (JUnit 4)
    @Before
    public void setUp() {
        System.out.println("Setting up before each test.");
    }

    // Teardown after each test (JUnit 4)
    @After
    public void tearDown() {
        System.out.println("Cleaning up after each test.");
    }

    /**
     * Test of playMusic method, of class AudioPlayback.
     */
    @Test
    public void testPlayMusic() {
        System.out.println("Testing playMusic()");
        try {
            AudioPlayback.playMusic();  // Call the method
            assertTrue("No exceptions thrown", true);  // Pass if no exception
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());  // Fail if exception is thrown
        }
    }

    /**
     * Test of playSoundEffect method, of class AudioPlayback.
     */
    @Test
    public void testPlaySoundEffect() {
        System.out.println("Testing playSoundEffect()");
        try {
            AudioPlayback.playSoundEffect();  // Call the method
            assertTrue("No exceptions thrown", true);  // Pass if no exception
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());  // Fail if exception is thrown
        }
    }
}
