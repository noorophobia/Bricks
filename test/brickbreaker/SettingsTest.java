package brickbreaker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SettingsTest {

    private Settings settings;

    @Before
    public void setUp() {
        settings = Settings.getInstance();
    }

    @Test
    public void testSingletonInstance() {
        // Verify that Settings returns the same instance every time it's called
        Settings anotherInstance = Settings.getInstance();
        assertSame("Settings should be the same instance", settings, anotherInstance);
    }

    @Test
    public void testDefaultSettings() {
        // Test the default values of the settings
         assertFalse("Sound effects should be disabled by default", settings.isSoundEffectsOn());
    }

    @Test
    public void testSetBackgroundMusicOn() {
        // Change the background music setting
        settings.setBackgroundMusicOn(false);

        // Verify the change
        assertFalse("Background music should be turned off", settings.isBackgroundMusicOn());

        // Revert the setting back
        settings.setBackgroundMusicOn(true);
        assertTrue("Background music should be turned on", settings.isBackgroundMusicOn());
    }

    @Test
    public void testSetSoundEffectsOn() {
        // Change the sound effects setting
        settings.setSoundEffectsOn(true);

        // Verify the change
        assertTrue("Sound effects should be turned on", settings.isSoundEffectsOn());

        // Revert the setting back
        settings.setSoundEffectsOn(false);
        assertFalse("Sound effects should be turned off", settings.isSoundEffectsOn());
    }
}

