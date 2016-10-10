package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Ship
{
    public boolean inCombat = false;
    public boolean nearObject = false;
    public boolean edge = false;

<<<<<<< HEAD
    public Player(Texture texture, Texture texture45, int width, int height, float x, float y, int rot, int turnTimeout, float maxVelocity, float maxAccel, float brakeRate, Object[] inventory)
    {
        super(texture, texture45, width, height, x, y, rot, turnTimeout, maxVelocity, maxAccel, brakeRate, inventory);
=======
    public Player(Texture texture, Texture texture45, int width, int height, float x, float y, int rot, int turnTimeout, float maxVelocity, float maxAccel, float brakeRate, float maxWarp)
    {
        super(texture, texture45, width, height, x, y, rot, turnTimeout, maxVelocity, maxAccel, brakeRate, maxWarp);
>>>>>>> origin/libGDX
    }

    @Override
    public void update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.turnTimeout <= 0)
        {
            this.rot = (rot + 315) % 360;
            this.turnTimeout = maxTurnTimeout;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.turnTimeout <= 0)
        {
            this.rot = (rot + 45) % 360;
            this.turnTimeout = maxTurnTimeout;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            this.acceleration.set(maxAccel * Gdx.graphics.getDeltaTime(), 0);
            this.acceleration.setAngle(this.rot);
        }
        /*
         * else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && velocity.len() >
         * 0) { acceleration.set(brakeRate * Gdx.graphics.getDeltaTime(), 0);
         * acceleration.setAngle(rot + 180);
         * 
         * }
         */
        else if (Gdx.input.isKeyPressed(Input.Keys.Z) && !(inCombat || nearObject || edge))
        {
            this.velocity.set(maxWarp, 0);
            this.velocity.setAngle(rot);
        }

        super.update();

    }
}
