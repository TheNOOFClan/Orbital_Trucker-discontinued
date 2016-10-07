package com.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.backends.lwjgl.audio.Wav;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import java.lang.reflect.Array;
import java.util.Random;

public class GameScreen implements Screen
{
	final OrbitalTrucker game;
	Texture truckT;
	Music battleMusic;
	Player truck;
	Random rng;

	Music bIntro;
	Music bOutro;
	Music bD;
	Music bD2;
	Music bU;
	Music bU2;
	Music[] musicArray;
	int musicNum = 5;

	boolean stopMusic = false;

	public GameScreen(final OrbitalTrucker game)
	{
		this.game = game;
		truckT = new Texture(Gdx.files.internal("truck0.png"));
		battleMusic = Gdx.audio.newMusic(Gdx.files.internal("space_brawl.mp3"));
		battleMusic.setLooping(true);
		rng = new Random();

		truck = new Player(truckT, 16, 16, 0, 0, 0);

		bIntro = Gdx.audio.newMusic(Gdx.files.internal("SF_Battle_Intro.mp3"));
		bOutro = Gdx.audio.newMusic(Gdx.files.internal("SF_Battle_Outro.mp3"));
		bD = Gdx.audio.newMusic(Gdx.files.internal("SF_Downbeat_Midsection.mp3"));
		bD2 = Gdx.audio.newMusic(Gdx.files.internal("SF_Downbeat_Midsection_2.mp3"));
		bU = Gdx.audio.newMusic(Gdx.files.internal("SF_Upbeat_Midsection.mp3"));
		bU2 = Gdx.audio.newMusic(Gdx.files.internal("SF_Upbeat_Midsection_2.mp3"));

		musicArray = new Music[]{bD, bD2, bU, bU2, bOutro, bIntro};
	}

//	private boolean musicPlaying()
//	{
//		boolean play = false;
//
//		for (int i = 0; i >= musicArray.length; i++)
//		{
//			if (musicArray[i].isPlaying())
//			{
//				play = true;
//			}
//		}
//		return play;
//	}

	@Override
	public void show()
	{
		musicArray[musicNum].play();
	}

	@Override
	public void render(float delta)
	{
		if (!musicArray[musicNum].isPlaying() && !stopMusic)
		{
			musicNum = rng.nextInt(musicArray.length - 2);
			if (musicNum == 4)
			{
				stopMusic = true;
			}
			musicArray[musicNum].play();
		}

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
		bU2.dispose();
		bU.dispose();
		bIntro.dispose();
		bOutro.dispose();
		bD2.dispose();
	}
}
