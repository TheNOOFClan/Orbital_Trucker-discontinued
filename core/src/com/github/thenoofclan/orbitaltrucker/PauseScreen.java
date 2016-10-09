package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class PauseScreen implements Screen
{
	final OrbitalTrucker game;
	Sound pauseMusic;
	Sound resumeSound;
	Text pauseText;

	public PauseScreen(final OrbitalTrucker game)
	{
		this.game = game;

		pauseMusic = Gdx.audio.newSound(Gdx.files.internal("Pause.wav"));
		resumeSound = Gdx.audio.newSound(Gdx.files.internal("Resume.wav"));
		pauseText = new Text(0 ,0, "Pause", OrbitalTrucker.GREEN);
	}


	@Override
	public void show()
	{
		pauseMusic.play();
	}

	@Override
	public void render(float delta)
	{
		game.camera.update();
		game.batch.setProjectionMatrix(game.camera.combined);

		game.batch.begin();
		pauseText.render(game.batch);
		game.batch.end();
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{
		resumeSound.play();
	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{
		pauseMusic.dispose();
		resumeSound.play();
		resumeSound.dispose();
	}
}
