package brickbreaker;

import java.util.ArrayList;
import java.util.Iterator;

public class CollisionManager {
    private static final long COLLISION_COOLDOWN = 100;
    private long lastCollisionTime = 0;

    // Check collision with Base
    public void checkCollisionsWithBase(Base base, Ball ball) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastCollisionTime) > COLLISION_COOLDOWN) {
            if (base.isCollisionWithBall(ball)) {
                ball.yVelocity *= -1;
                if (ball.x > 800 / 2) {
                    ball.xVelocity *= -1;
                }
                lastCollisionTime = currentTime;
            }
        }
    }

    // Check collision with Bricks
    public Brick checkCollisionsWithBricks(ArrayList<Brick> bricks, Ball ball) {
        Iterator<Brick> iterator = bricks.iterator();
        while (iterator.hasNext()) {
            Brick brick = iterator.next();
            if (brick.checkCollisionWithBall(ball)) {
                iterator.remove();
                ball.yVelocity *= -1;
                return brick;
            }
        }
        return null;
    }
}
