package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ship
{
    public Texture texture;
    public Texture texture45;
    public Sprite sprite;
    // private Rectangle rectangle;
    public Sound engine;
    public Sound die;
    public Sound talk;

    private Texture spriteTexture;

    public int width;
    public int height;
    public float x;
    public float y;
    public int rot;
    public Vector2 velocity;
    public Vector2 acceleration;

    public int maxTurnTimeout;
    public int turnTimeout;

    public float maxVelocity;
    public float maxAccel;
    public float brakeRate;
    public float maxWarp;

    public Object[] inventory;

    public int hp;

<<<<<<< HEAD
    public Ship(Texture texture, Texture texture45, int width, int height, float x, float y, int rot, int turnTimeout,
                float maxVelocity, float maxAccel, float brakeRate, Object[] inventory)
=======
    public Ship(Texture texture, Texture texture45, int width, int height, float x, float y, int rot, int turnTimeout, float maxVelocity, float maxAccel, float brakeRate, float maxWarp)
>>>>>>> origin/libGDX
    {
        this.texture = texture;
        this.texture45 = texture45;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.hp = 100;
        this.rot = rot;
        this.engine = null;
        this.die = null;
        this.talk = null;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(this.velocity);
        this.inventory = inventory;

        this.maxTurnTimeout = turnTimeout;
        this.turnTimeout = 0;

        this.maxVelocity = maxVelocity;
        this.maxAccel = maxAccel;
        this.brakeRate = brakeRate;
        this.maxWarp = maxWarp;

        this.sprite = new Sprite(texture, width, height);
        this.sprite.setCenter(x, y);
        this.sprite.setRotation(rot);
    }

    public Ship()
    {
        this.texture = null;
        this.texture45 = null;
        this.width = 16;
        this.height = 16;
        this.x = 0;
        this.y = 0;
        this.hp = 100;
        this.rot = 0;
        this.engine = null;
        this.die = null;
        this.talk = null;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(this.velocity);

        this.sprite = null;
    }

    public void dispose()
    {
        this.texture.dispose();
        this.engine.dispose();
        this.die.dispose();
        this.talk.dispose();
    }

    public void drop()
    {

    }

    // public void die()
    // {
    // this.die.play();
    // this.drop();
    // this.dispose();
    // }

    public void render(SpriteBatch batch)
    {
        sprite.draw(batch);
    }

    public void update()
    {
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
        this.x += (this.velocity.x);
        this.y += (this.velocity.y);
        this.sprite.setCenter((int) this.x, (int) this.y);

        if (velocity.len() > this.maxVelocity)
            velocity.setLength(maxVelocity);
        this.velocity.add(this.acceleration);
        this.acceleration.set(0, 0);

        if (this.turnTimeout > 0)
            turnTimeout--;

        if (this.hp >= 0)
        {
            // this.die();
        }
    }

    public float distTo(Ship s)
    {
        return (float) Math.sqrt(Math.pow(s.x - x, 2) + Math.pow(s.y - y, 2));
    }

    public float angleTo(Ship s)
    {
        float ans = (float) Math.atan((s.y - y) / (s.x - x));
        ans = ans * 180 / (float) Math.PI;
        if (s.x - x < 0)
            ans += 180;
        else if (ans < 0)
            ans += 360;
        return ans;
    }
}
