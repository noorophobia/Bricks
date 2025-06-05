package brickbreaker;

import javax.swing.*;

public class GameStateManager {

    private MessageDialog messageDialog;

    public GameStateManager() {
        // Use a default JOptionPane wrapper
        this.messageDialog = new MessageDialog();
    }

    // Constructor for testing purposes
    public GameStateManager(MessageDialog messageDialog) {
        this.messageDialog = messageDialog;
    }

    public void handleGameOver() {
        messageDialog.showMessage("Game Over");
    }

    public void handleNextLevel() {
        messageDialog.showMessage("Level Complete! Proceeding to the next level.");
    }

    // A simple wrapper for JOptionPane for easier testing
    public static class MessageDialog {
        public void showMessage(String message) {
            JOptionPane.showMessageDialog(null, message);
        }
    }
}
