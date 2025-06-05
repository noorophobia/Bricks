/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;

/**
 *
 * @author ADMIN
 */
 
public class BrickPatternFactory {
    
    public static BrickPatternState getBrickPattern(int level) {
        switch (level) {
            case 1: return new LevelOneBrickPattern();
            case 2: return new LevelTwoBrickPattern();
            case 3: return new LevelThreeBrickPattern();
            case 4: return new LevelFourBrickPattern();
            default: return new LevelFiveBrickPattern();
        }
    }
}
