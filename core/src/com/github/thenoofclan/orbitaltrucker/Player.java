package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends Ship
{
    private Texture spriteTexture;

    public Player(Texture texture, Texture texture45, int width, int height, int x, int y, int dir)
    {
        this.texture = texture;
        this.texture45 = texture45;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.dir = dir;
        this.rot = 45 * dir;

        this.sprite = new Sprite(texture, width, height);
        this.sprite.setPosition(x, y);
        this.sprite.setRotation(rot);

        this.spriteTexture = texture;
    }

    @Override
    public void update()
    {
        super.update();
        if (this.dir % 2 == 0)
        {
            if (this.spriteTexture != this.texture)
            {
                this.sprite.setTexture(this.texture);
                this.spriteTexture = this.texture;
            }
            if (this.dir == 0)
            {
                this.sprite.setRotation(0);
            } else if (this.dir == 2)
            {
                this.sprite.setRotation(90);
            } else if (this.dir == 4)
            {
                this.sprite.setRotation(180);
            } else if (this.dir == 6)
            {
                this.sprite.setRotation(270);
            }
        } else
        {
            if (this.spriteTexture != this.texture45)
            {
                this.sprite.setTexture(this.texture45);
                this.spriteTexture = this.texture45;
            }
            if (this.dir == 1)
            {
                this.sprite.setRotation(0);
            } else if (this.dir == 3)
            {
                this.sprite.setRotation(90);
            } else if (this.dir == 5)
            {
                this.sprite.setRotation(180);
            } else if (this.dir == 7)
            {
                this.sprite.setRotation(270);
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
        {
            this.dir = (dir + 7) % 8;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
        {
            this.dir = (dir + 1) % 8;
        }
        this.rot = dir * 45;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            this.acceleration.set(10 * Gdx.graphics.getDeltaTime(), 10 * Gdx.graphics.getDeltaTime());
            this.acceleration.setAngle(this.rot);
            this.velocity.add(this.acceleration);
        }
    }
}
