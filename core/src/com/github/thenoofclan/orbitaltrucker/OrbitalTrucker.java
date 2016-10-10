package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OrbitalTrucker extends Game
{
    public SpriteBatch batch;
    public BitmapFont font;
    public OrthographicCamera camera;
    public boolean fight;
    public boolean end;

    public static final Color RED = new Color(1, 0, 0, 1);
    public static final Color GREEN = new Color(0.043137255f, 0.854901961f, 0.317647059f, 1);
    public static final Color BLUE = new Color(0, 1, 1, 1);
    public static final Color BLACK = new Color(0, 0, 0, 1);

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        font = new BitmapFont();
        camera = new OrthographicCamera(512, 512);
        camera.position.x = 80;
        camera.position.y = 72;
        // camera.setToOrtho(false, 160, 144);
        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        font.dispose();
    }
}
