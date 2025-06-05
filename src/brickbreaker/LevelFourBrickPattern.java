/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;

/**
 *
 * @author ADMIN
 */
 
import java.util.ArrayList;

public class LevelFourBrickPattern implements BrickPatternState {
    @Override
    public ArrayList<Brick> createBricks() {
        ArrayList<Brick> bricks = new ArrayList<>();
        int xPos = 120, yPos = 20;
        int nextXPos = 120;
        int bricksCount = 8;

        while (bricksCount != 0) {
            for (int i = 0; i < bricksCount; i++) {
                Brick brick = new Brick(null);
                brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos += brick.getBRICK_WIDTH();
            }
            bricksCount -= 1;
            nextXPos += 35;
            xPos = nextXPos;
            yPos += 30;
        }

        return bricks;
    }
}
