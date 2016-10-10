package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
    Object[] inventory;
    String[] invText;
    Screen parent;

    public PauseScreen(final OrbitalTrucker game, Object[] inventory, GameScreen parent)
    {
        this.game = game;
        this.inventory = inventory;
        this.parent = parent;

        pauseMusic = Gdx.audio.newSound(Gdx.files.internal("Pause.wav"));
        resumeSound = Gdx.audio.newSound(Gdx.files.internal("Resume.wav"));
        int x = (int) parent.truck.x - 24;
        int y = (int) parent.truck.y - 4;
        if (parent.truck.x < 0)
            x = -24;
        else if (parent.truck.x > parent.sys.width)
            x = parent.sys.width - 24;
        if (parent.truck.y < 0)
            y = -4;
        else if (parent.truck.y > parent.sys.height)
            y = parent.sys.height - 4;

        pauseText = new Text(x, y, "Pause", OrbitalTrucker.GREEN);

        try
        {
            Fuel fuel = ((Fuel) inventory[0]);
            Wepon wepon = ((Wepon) inventory[1]);
            Raws raws = ((Raws) inventory[2]);

            String fuelText = String.format("{0}: Amount: {1}, Description: {2}", fuel.name, fuel.amount, fuel.desc);
            String weponText = String.format("{0}: Amount: {1}, Description: {2}", wepon.name, wepon.amount, wepon.desc);
            String rawsText = String.format("{0}: Amount: {1}, Description: {2}", raws.name, raws.amount, raws.desc);
            String[] invText = { "Inventory:", fuelText, weponText, rawsText };
        } catch (Exception e)
        {

        }

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
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
        {
            game.setScreen(parent);
            parent.resume();
            this.dispose();
        }
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
