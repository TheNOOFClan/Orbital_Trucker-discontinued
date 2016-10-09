package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dockable
{
    public Sprite sprite;

    public Dockable(Texture texture, int width, int height)
    {
        this.sprite = new Sprite(texture, width, height);
    }

    public void render(SpriteBatch batch)
    {
        sprite.draw(batch);
    }

    public void update()
    {
        // TODO Auto-generated method stub

    }
}
