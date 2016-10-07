package com.thenoofclan.orbitaltrucker;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player extends Ship
{
	public Player(Texture texture, int width, int height, int x, int y, float rot)
	{
		this.texture = texture;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.hp = 100;
		this.rot = rot;

		this.sprite = new Sprite(texture, width, height);
		this.sprite.setPosition(x, y);
		this.sprite.setRotation(rot);
	}

	@Override
	public void update()
	{
		this.x += this.vec.x;
		this.y += this.vec.y;
		this.sprite.setPosition(this.x, this.y);
		this.sprite.setRotation(this.rot);

		if (this.hp >= 0)
		{
			//this.die();
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.A))
		{
			this.rot += 45;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.D))
		{
			this.rot -= 45;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W))
		{
			this.tmpVec.set(20 * Gdx.graphics.getDeltaTime(), 20 * Gdx.graphics.getDeltaTime());
			this.tmpVec.setAngle(this.rot + 90);
			this.vec.add(this.tmpVec);
		}
	}
}
