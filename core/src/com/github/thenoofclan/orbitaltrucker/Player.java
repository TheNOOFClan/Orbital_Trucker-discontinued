package com.github.thenoofclan.orbitaltrucker;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player extends Ship
{
	private Texture spriteTexture;
	public Player(Texture texture, Texture texture45, int width, int height, int x, int y, float rot)
	{
		this.texture = texture;
		this.texture45 = texture45;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.hp = 100;
		this.rot = rot;

		this.sprite = new Sprite(texture, width, height);
		this.sprite.setPosition(x, y);
		this.sprite.setRotation(rot);

		this.spriteTexture = texture;
	}

	@Override
	public void update()
	{
		this.x += this.vec.x;
		this.y += this.vec.y;
		this.sprite.setPosition(this.x, this.y);
		//this.sprite.setRotation(this.rot);
		if (((int) this.rot) % 90 == 0 && this.spriteTexture != this.texture)
		{
			this.sprite.setTexture(this.texture);
			this.spriteTexture = this.texture;
			try
			{
				if(((int) this.rot) / 90 == 1)
				{
					this.sprite.setRotation(90);
				}
				if(((int) this.rot) / 90 == 2)
				{
					this.sprite.setRotation(180);
				}
				if(((int) this.rot) / 90 == 3)
				{
					this.sprite.setRotation(270);
				}
			}
			catch (Exception e)
			{
				this.sprite.setRotation(0);
			}
		}
		else if(((int) this.rot) % 45 == 0 && this.spriteTexture != this.texture45 && ((int) this.rot) != 0)
		{
			this.sprite.setTexture(this.texture45);
			this.spriteTexture = this.texture45;
			try
			{
				if(((int) this.rot) / 45 == 2)
				{
					this.sprite.setRotation(90);
				}
				if(((int) this.rot) / 45 == 3)
				{
					this.sprite.setRotation(180);
				}
				if(((int) this.rot) / 45 == 4)
				{
					this.sprite.setRotation(270);
				}
			}
			catch (Exception e)
			{
				this.sprite.setRotation(0);
			}
		}




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
		if (this.rot >= 360)
		{
			this.rot -= 360;
		}
		if (this.rot < 0)
		{
			this.rot *= -1;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W))
		{
			this.tmpVec.set(10 * Gdx.graphics.getDeltaTime(), 10 * Gdx.graphics.getDeltaTime());
			this.tmpVec.setAngle(this.rot + 90);
			this.vec.add(this.tmpVec);
		}
	}
}
