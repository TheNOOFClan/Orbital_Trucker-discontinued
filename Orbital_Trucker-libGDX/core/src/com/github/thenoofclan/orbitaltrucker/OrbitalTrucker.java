package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class OrbitalTrucker extends ApplicationAdapter
{
	private Texture truckZero;
	private Texture truckFortyFive;
	private Music mainMusic;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle truck;

	@Override
	public void create()
	{
		truckZero = new Texture(Gdx.files.internal("truck0.png"));
		truckFortyFive = new Texture(Gdx.files.internal("truck45.png"));

		mainMusic = Gdx.audio.newMusic(Gdx.files.internal("Song1.mp3"));

		mainMusic.setLooping(true);
		mainMusic.play();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 160, 144);

		batch = new SpriteBatch();

		truck = new Rectangle();
		truck.x = 160 /2 - 64 / 2;
		truck.y = 20;
		truck.width = 16;
		truck.height = 16;
	}

	@Override
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(truckZero, truck.x, truck.y);
		batch.end();

		if(Gdx.input.isKeyPressed(Input.Keys.A))
		{
			truck.x -= 200 * Gdx.graphics.getDeltaTime();
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.D))
		{
			truck.x += 200 * Gdx.graphics.getDeltaTime();
		}

		if(truck.x < 0)
		{
			truck.x = 0;
		}
		else if (truck.x > 160 - 16)
		{
			truck.x = 160 - 16;
		}
	}

	@Override
	public void dispose()
	{
		truckZero.dispose();
		truckFortyFive.dispose();
		mainMusic.dispose();
		batch.dispose();
	}
}
