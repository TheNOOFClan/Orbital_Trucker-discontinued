package com.thenoofclan.orbitaltrucker;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen
{
	final OrbitalTrucker game;
	Music mainMusic;
	Texture title;

	public MainMenuScreen(final OrbitalTrucker gam)
	{
		game = gam;

		mainMusic = Gdx.audio.newMusic(Gdx.files.internal("Song1.mp3"));
		mainMusic.setLooping(true);
		mainMusic.play();
		title = new Texture(Gdx.files.internal("placeholdertitle.png"));
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta)
	{
		game.camera.update();
		game.batch.setProjectionMatrix(game.camera.combined);

		game.batch.begin();
		game.batch.draw(title, 0, 97, 160, 48);
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
		title.dispose();
		mainMusic.dispose();
	}
}
