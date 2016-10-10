package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class PirateShip extends Ship
{
    private float aggro;
    private float closest;
    private float range;

    public PirateShip(Texture texture, Texture texture45, int width, int height, float x, float y, int rot, int turnTimeout, float maxVelocity, float maxAccel, float brakeRate, float aggro, float range, float closest)
    {
        //super(texture, texture45, width, height, x, y, rot, turnTimeout, maxVelocity, maxAccel, brakeRate, 0);
        this.aggro = aggro;
        this.range = range;
        this.closest = closest;
    }

    public void update(Player player)
    {
        if (distTo(player) <= aggro)
            tickAI(player);
        else
        {
            velocity.set(0, 0);
        }
        super.update();
    }

    private void tickAI(Player player)
    {

        float ang = angleTo(player);
        float rAng = round45(ang);
        if (distTo(player) > range)
        {
            if (rAng - rot > 22.5)
                turnRight();
            else if (rAng - rot < -22.5)
                turnLeft();
        }

        acceleration.set(maxAccel * Gdx.graphics.getDeltaTime(), 0);
        acceleration.setAngle(rot);
    }

    private void turnLeft()
    {
        if (this.turnTimeout <= 0)
        {
            this.rot = (this.rot + 45) % 360;
            turnTimeout = maxTurnTimeout;
        }
    }

    private void turnRight()
    {
        if (this.turnTimeout <= 0)
        {
            this.rot = (this.rot + 315) % 360;
            turnTimeout = maxTurnTimeout;
        }
    }

    private float round45(float a)
    {
        return a + 22.5f - ((a + 22.5f) % 45);
    }
}
