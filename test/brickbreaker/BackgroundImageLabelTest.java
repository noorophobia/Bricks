package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundImageLabelTest {

    private BackgroundImageLabel backgroundImageLabel;

    // Setup before each test (JUnit 4)
    @Before
    public void setUp() {
        backgroundImageLabel = new BackgroundImageLabel();  // Create an instance before each test
    }

    /**
     * Test the constructor of BackgroundImageLabel.
     * Ensures the label is correctly initialized with the proper size and background image.
     */
    @Test
    public void testBackgroundImageLabelConstructor() {
        System.out.println("Testing BackgroundImageLabel constructor");
        
        // Test that the preferred size is correctly set
        Dimension preferredSize = backgroundImageLabel.getPreferredSize();
        assertEquals("Width should be 800", 800, preferredSize.width);
        assertEquals("Height should be 500", 500, preferredSize.height);
        
        // Test that the icon has been set (i.e., background image is loaded)
        Icon icon = backgroundImageLabel.getIcon();
        assertNotNull("Background image should be set", icon);
    }

    /**
     * Test the setBackgroundImage() method.
     * Ensures the background image is set correctly when the method is called.
     */
    @Test
    public void testSetBackgroundImage() {
        System.out.println("Testing setBackgroundImage()");

        // Check if the image file exists (precondition for the test)
        File imageFile = new File(BackgroundImageLabel.BACKGROUND_IMAGE_PATH);
        assertTrue("Background image file should exist", imageFile.exists());

        // Set the background image and check if the icon has been set
        backgroundImageLabel.setBackgroundImage();
        Icon icon = backgroundImageLabel.getIcon();
        assertNotNull("Background image should be set", icon);
    }

    /**
     * Test when the image file is missing or cannot be loaded (IOException case).
     * Verifies that no image is set when an error occurs.
     */
    @Test
    public void testIOExceptionHandling() {
        System.out.println("Testing IOException when loading background image");

        // Temporarily set the image path to an invalid file
        String invalidPath = "invalid/path/to/image.jpg";
        BackgroundImageLabel invalidBackgroundImageLabel = new BackgroundImageLabel() {
            @Override
            void setBackgroundImage() {
                try {
                    Image backgroundImage = ImageIO.read(new File(invalidPath));
                    setIcon(new ImageIcon(backgroundImage));
                } catch (IOException ex) {
                    // Catch the exception and do nothing (simulate failure in loading image)
                    System.err.println("[ERROR] Unable to load background image: " + invalidPath);
                }
            }
        };

        // Try setting the background image (this should fail silently)
        invalidBackgroundImageLabel.setBackgroundImage();
        
        // Since the image cannot be loaded, the icon should be null
        assertNull("Background image should not be set if an IOException occurs", invalidBackgroundImageLabel.getIcon());
    }

    /**
     * Test for checking the static constant BACKGROUND_IMAGE_PATH.
     * Ensures the path points to a valid file.
     */
    @Test
    public void testBackgroundImagePath() {
        System.out.println("Testing static BACKGROUND_IMAGE_PATH");

        // Check if the file exists at the specified static path
        File imageFile = new File(BackgroundImageLabel.BACKGROUND_IMAGE_PATH);
        assertTrue("Background image file should exist at path", imageFile.exists());
    }
}
