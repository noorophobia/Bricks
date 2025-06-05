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

public class LevelManager {
    private int level = 1;

    public ArrayList<Brick> getBricksForLevel() {
        return BrickPatternFactory.getBrickPattern(level).createBricks();
    }

    public void nextLevel() {
        level++;
    }

    public int getLevel() {
        return level;
    }
}

