package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Ship
{
    public boolean inCombat = false;
    public boolean nearObject = false;
    public boolean edge = false;
    public GameScreen parent;

    public Player(Texture texture, Texture texture45, int width, int height, float x, float y, int rot, int turnTimeout, float maxVelocity, float maxAccel, float brakeRate, float maxWarp, Object[] inventory, GameScreen parent)
    {
        super(texture, texture45, width, height, x, y, rot, turnTimeout, maxVelocity, maxAccel, brakeRate, maxWarp, inventory);
        this.parent = parent;
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
        else if (Gdx.input.isKeyJustPressed(Input.Keys.Z) && edge)
        {
            if (parent.sys == parent.sys1)
            {
                parent.sys = parent.sys2;
                this.parent.sys.player = this;
                this.velocity.set(0, 0);
                this.x = 0;
                this.y = 512;
                this.rot = 315;
            }
            else
            {
                parent.sys = parent.sys1;
                this.parent.sys.player = this;
                this.velocity.set(0, 0);
                this.x = 0;
                this.y = 0;
                this.rot = 45;
            }
        }

        super.update();

    }
}
