package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Ship
{
    private Texture spriteTexture;

    public Player(Texture texture, Texture texture45, int width, int height, float x, float y, int rot, int turnTimeout, float maxVelocity, float maxAccel, float brakeRate)
    {
        super(texture, texture45, width, height, x, y, rot, turnTimeout, maxVelocity, maxAccel, brakeRate);
    }

    @Override
    public void update()
    {
        super.update();
        if (this.rot % 90 == 0)
        {
            if (this.spriteTexture != this.texture)
            {
                this.sprite.setTexture(this.texture);
                this.spriteTexture = this.texture;
            }
        }
        else
        {
            if (this.spriteTexture != this.texture45)
            {
                this.sprite.setTexture(this.texture45);
                this.spriteTexture = this.texture45;
            }
        }
        this.sprite.setRotation((rot - (rot % 90)));

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.turnTimeout == 0)
        {
            this.rot = (rot + 315) % 360;
            this.turnTimeout = maxTurnTimeout;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.turnTimeout == 0)
        {
            this.rot = (rot + 45) % 360;
            this.turnTimeout = maxTurnTimeout;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            this.acceleration.set(maxAccel * Gdx.graphics.getDeltaTime(), maxAccel * Gdx.graphics.getDeltaTime());
            this.acceleration.setAngle(this.rot);
            this.velocity.add(this.acceleration);
            if (velocity.len() > this.maxVelocity)
                velocity.setLength(maxVelocity);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            // activate SPACE BRAKES
        }

        if (this.turnTimeout > 0)
            turnTimeout--;
    }
}
