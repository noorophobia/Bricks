package brickbreaker;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AudioPlayback {

    // Logger instance for consistent logging across the class
    private static final Logger LOGGER = Logger.getLogger(AudioPlayback.class.getName());

    // Constants for file paths to audio resources
    private static final String MUSIC_PATH = "assets/bg-music.wav";
    private static final String SFX_PATH = "assets/break.wav";

    // extracted common code
    public static void playMusic() {
        playSound(MUSIC_PATH, true); // 'true' means loop the music
    }

    /**
     * Plays a one-time sound effect (e.g., brick breaking).
     */
    public static void playSoundEffect() {
        playSound(SFX_PATH, false); // 'false' means no looping
    }
    

    
    private static void playSound(String filePath, boolean loop) {
        // try-with-resources automatically closes the audio stream
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath))) {

            // Get the format of the audio file
            AudioFormat format = audioStream.getFormat();

            // Info object describes the kind of line we want (a Clip in this case)
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // Get a Clip (a short sound that can be loaded in memory and played)
            Clip audioClip = (Clip) AudioSystem.getLine(info);

            // Load audio data into the clip
            audioClip.open(audioStream);

             if (loop) {
                audioClip.loop(Clip.LOOP_CONTINUOUSLY); // Loop indefinitely
            } else {
                audioClip.start(); // Play once
            }

        } catch (UnsupportedAudioFileException e) {
            LOGGER.log(Level.SEVERE, "Unsupported audio file: " + filePath, e);
        } catch (LineUnavailableException e) {
            LOGGER.log(Level.SEVERE, "Audio line unavailable for: " + filePath, e);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading audio file: " + filePath, e);
        }
    }
}

//Extracted common audio-loading logic into playSound(String, boolean)	Duplicated code in both playMusic() and playSoundEffect()