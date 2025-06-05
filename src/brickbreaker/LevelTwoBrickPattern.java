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

public class LevelTwoBrickPattern implements BrickPatternState {
    @Override
    public ArrayList<Brick> createBricks() {
        ArrayList<Brick> bricks = new ArrayList<>();
        int xPos = 70, yPos = 50;
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0) {
                    Brick brick = new Brick(null);
                    brick.setBounds(xPos, yPos, brick.getBRICK_WIDTH(), brick.getBRICK_HEIGHT());
                    bricks.add(brick);
                }
                xPos += new Brick(null).getBRICK_WIDTH();
            }
            xPos = 70;
            yPos += 30;
        }
        return bricks;
    }
}
