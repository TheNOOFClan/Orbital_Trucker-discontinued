package com.thenoofclan.orbitaltrucker;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen
{
	final OrbitalTrucker game;
	Music mainMusic;

	public MainMenuScreen(final OrbitalTrucker gam)
	{
		game = gam;

		mainMusic = Gdx.audio.newMusic(Gdx.files.internal("Song1.mp3"));
		mainMusic.setLooping(true);
		mainMusic.play();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.camera.update();
		game.batch.setProjectionMatrix(game.camera.combined);

		game.batch.begin();
		game.font.draw(game.batch, "Space Trucker", 0, 144);
		game.batch.end();

		if (Gdx.input.isTouched())
		{
			game.setScreen(new GameScreen(game));
			dispose();
		}
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
		mainMusic.dispose();
	}
}
