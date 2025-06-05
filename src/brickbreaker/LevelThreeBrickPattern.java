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

public class LevelThreeBrickPattern implements BrickPatternState {
    @Override
    public ArrayList<Brick> createBricks() {
        ArrayList<Brick> bricks = new ArrayList<>();

        // Box 1
        int xPos1 = 30, yPos1 = 20;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                Brick brick = new Brick(null);
                brick.setBounds(xPos1, yPos1, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos1 += brick.getBRICK_WIDTH();
            }
            xPos1 = 30;
            yPos1 += 30;
        }

        // Box 2
        int xPos2 = 400, yPos2 = 20;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                Brick brick = new Brick(null);
                brick.setBounds(xPos2, yPos2, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                bricks.add(brick);
                xPos2 += brick.getBRICK_WIDTH();
            }
            xPos2 = 400;
            yPos2 += 30;
        }

        return bricks;
    }
}
