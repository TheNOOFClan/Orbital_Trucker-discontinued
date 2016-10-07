package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ship
{
	public Texture texture;
	public Texture texture45;
	public Sprite sprite;
	//private Rectangle rectangle;
	public Sound engine;
	public Sound die;
	public Sound talk;

	public int width;
	public int height;
	public int x;
	public int y;
	public float rot;
	public Vector2 vec;
	public Vector2 tmpVec;

	public int hp;


	public Ship(Texture texture, Texture texture45, int width, int height, int x, int y, float rot)
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
		this.vec = new Vector2(0, 0);
		this.tmpVec = new Vector2(this.vec);

		this.sprite = new Sprite(texture, width, height);
		this.sprite.setPosition(x, y);
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
		this.vec = new Vector2(0, 0);
		this.tmpVec = new Vector2(this.vec);

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

//	public void die()
//	{
//		this.die.play();
//		this.drop();
//		this.dispose();
//	}

	public void update()
	{
		this.vec.setAngle(this.rot);
		this.x += ((int) this.vec.x);
		this.y += ((int) this.vec.y);
		this.sprite.setPosition(this.x, this.y);
		this.sprite.setRotation(this.rot);

		if (this.hp >= 0)
		{
			//this.die();
		}
	}
}
