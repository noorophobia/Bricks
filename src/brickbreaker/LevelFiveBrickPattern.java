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

public class LevelFiveBrickPattern implements BrickPatternState {
    @Override
    public ArrayList<Brick> createBricks() {
        ArrayList<Brick> bricks = new ArrayList<>();

        // Triangle One
        int xPos = 150, yPos = 50, nextXPos = 150;
        int bricksCount = 1;
        while (bricksCount <= 5) {
            for (int i = 0; i < bricksCount; i++) {
                Brick brick = new Brick(null);
                brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos += brick.getBRICK_WIDTH();
            }
            bricksCount++;
            nextXPos -= 35;
            xPos = nextXPos;
            yPos += 30;
        }

        // Triangle Two
        int xPos2 = 550, yPos2 = 50, nextXPos2 = 550;
        int bricksCount2 = 1;
        while (bricksCount2 <= 5) {
            for (int i = 0; i < bricksCount2; i++) {
                Brick brick = new Brick(null);
                brick.setBounds(xPos2, yPos2, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos2 += brick.getBRICK_WIDTH();
            }
            bricksCount2++;
            nextXPos2 -= 35;
            xPos2 = nextXPos2;
            yPos2 += 30;
        }

        return bricks;
    }
}
