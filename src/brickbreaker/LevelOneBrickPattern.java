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

public class LevelOneBrickPattern implements BrickPatternState {
    @Override
    public ArrayList<Brick> createBricks() {
        ArrayList<Brick> bricks = new ArrayList<>();
        int xPos = 0, yPos = 50;
        for (int i = 0; i < 28; i++) {
            Brick brick = new Brick(null);
            if (i % 7 == 0) {
                xPos = 0;
                yPos += brick.getBRICK_HEIGHT() + 20;
            }
            brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
            bricks.add(brick);
            xPos += brick.getBRICK_WIDTH() + 20;
        }
        return bricks;
    }
}

