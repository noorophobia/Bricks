/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
package brickbreaker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Group all test classes here
@RunWith(Suite.class)
@Suite.SuiteClasses({
    AudioPlaybackTest.class,
    BackgroundImageLabelTest.class,
    BallTest.class,
    BaseTest.class,
    BrickBreakerTest.class,
    BrickPatternFactoryTest.class,
    BrickPatternStateTest.class,
    BrickTest.class,
    CollisionManagerTest.class,
    GameFrameTest.class,
    GamePanelTest.class,
    GameStateManagerTest.class,
    LevelManagerTest.class,
    SettingsTest.class
})
public class AllTests {
    // This class remains empty, it is used only as a holder for the above annotations
}

