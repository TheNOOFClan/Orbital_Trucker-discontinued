package com.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen
{
	final OrbitalTrucker game;
	Texture truckT;
	Music battleMusic;
	Player truck;

	public GameScreen(final OrbitalTrucker game)
	{
		this.game = game;
		truckT = new Texture(Gdx.files.internal("truck0.png"));
		battleMusic = Gdx.audio.newMusic(Gdx.files.internal("space_brawl.mp3"));
		battleMusic.setLooping(true);

		truck = new Player(truckT, 16, 16, 0, 0, 0);
	}

	@Override
	public void show()
	{
		battleMusic.play();
	}

	@Override
	public void render(float delta)
	{
		game.camera.update();

		game.batch.setProjectionMatrix(game.camera.combined);

		game.batch.begin();
		truck.sprite.draw(game.batch);
		game.batch.end();

		truck.update();

//		if (Gdx.input.isKeyPressed(Input.Keys.A))
//		{
//			truck.x -= 200 * Gdx.graphics.getDeltaTime();
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.D))
//		{
//			truck.x += 200 * Gdx.graphics.getDeltaTime();
//		}
//
//		if (truck.x < 0)
//		{
//			truck.x = 144;
//		}
//		if (truck.x > 144)
//		{
//			truck.x = 0;
//		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose()
	{
		truckT.dispose();
		battleMusic.dispose();

	}
}
