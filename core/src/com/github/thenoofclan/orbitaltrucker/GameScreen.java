package com.github.thenoofclan.orbitaltrucker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import java.lang.reflect.Array;
import java.util.Random;

public class GameScreen implements Screen
{
    boolean active;
    final OrbitalTrucker game;
    Texture truckT;
    Texture truckT45;
    Texture pirateT;
    Texture pirateT45;
    // Music battleMusic;
    Player truck;
    Random rng;
    PauseScreen pauseScreen;

    /*
     * Music bIntro; Music bOutro; Music bD; Music bD2; Music bU; Music bU2;
     * Music[] musicArray; int musicNum = 5;
     */

    Music mainMusic;

    public StarSystem sys;
    public StarSystem sys1;
    public StarSystem sys2;

    HUD hud;

    boolean stopMusic = false;

    public GameScreen(final OrbitalTrucker game)
    {
        active = true;
        this.game = game;
        truckT = new Texture(Gdx.files.internal("truck0.png"));
        truckT45 = new Texture(Gdx.files.internal("truck45.png"));
        // battleMusic =
        // Gdx.audio.newMusic(Gdx.files.internal("space_brawl.mp3"));
        // battleMusic.setLooping(true);
        rng = new Random();

        mainMusic = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        mainMusic.setLooping(true);

        Fuel tmpF = new Fuel(10);
        Wepon tmpW = new Wepon(0);
        Raws tmpR = new Raws(10);
        Object[] inv = { tmpF, tmpW, tmpR };
        truck = new Player(truckT, truckT45, 16, 16, 0, 0, 0, 15, 2, 0.5f, 1, 10, inv, this);
        // pirateT = new Texture(Gdx.files.internal("pirate.png"));
        // pirateT45 = new Texture(Gdx.files.internal("pirate45.png"));
        // PirateShip pirate1 = new PirateShip(pirateT, pirateT45, 16, 16, 256,
        // 256, 225, 10, 5, 2, 1, 156, 128, 32);
        // PirateShip pirate2 = new PirateShip(pirateT, pirateT45, 16, 16, 256,
        // 0, 180, 10, 5, 2, 1, 156, 128, 32);
        // PirateShip pirate3 = new PirateShip(pirateT, pirateT45, 16, 16, 0,
        // 256, 270, 10, 5, 2, 1, 156, 128, 32);
        Star star = new Star(new Texture(Gdx.files.internal("star.png")), 96, 96);
        Planet planet = new Planet(new Texture(Gdx.files.internal("planet.png")), 48, 48);
        Station station = new Station(new Texture(Gdx.files.internal("station.png")), 24, 24);
        sys1 = new StarSystem(512, 512, star);
        sys1.player = truck;
        sys1.add(planet, 128, 128);
        sys1.add(station, 384, 384);
        sys = sys1;

        sys2 = new StarSystem(512, 512, new Star(new Texture(Gdx.files.internal("star2.png")), 96, 96));
        sys2.add(new Planet(new Texture(Gdx.files.internal("planet2.png")), 32, 32), 384, 128);
        sys2.add(new Station(new Texture(Gdx.files.internal("station2.png")), 32, 16), 128, 384);
        // sys.add(pirate1, 256, 256);
        // sys.add(pirate2, 256, 0);
        // sys.add(pirate3, 0, 256);

        /*
         * bIntro =
         * Gdx.audio.newMusic(Gdx.files.internal("SF_Battle_Intro.mp3")); bOutro
         * = Gdx.audio.newMusic(Gdx.files.internal("SF_Battle_Outro.mp3")); bD =
         * Gdx.audio.newMusic(Gdx.files.internal("SF_Downbeat_Midsection.mp3"));
         * bD2 =
         * Gdx.audio.newMusic(Gdx.files.internal("SF_Downbeat_Midsection_2.mp3")
         * ); bU =
         * Gdx.audio.newMusic(Gdx.files.internal("SF_Upbeat_Midsection.mp3"));
         * bU2 =
         * Gdx.audio.newMusic(Gdx.files.internal("SF_Upbeat_Midsection_2.mp3"));
         * 
         * musicArray = new Music[] { bD, bD2, bU, bU2, bOutro, bIntro };
         */
        // Text.init("font/");
    }

    // private boolean musicPlaying()
    // {
    // boolean play = false;
    //
    // for (int i = 0; i >= musicArray.length; i++)
    // {
    // if (musicArray[i].isPlaying())
    // {
    // play = true;
    // }
    // }
    // return play;
    // }

    @Override
    public void show()
    {
        mainMusic.play();
    }

    @Override
    public void render(float delta)
    {
        if (active)
        {
            /*
             * if (!musicArray[musicNum].isPlaying() && !stopMusic) { musicNum =
             * rng.nextInt(musicArray.length - 1); if (musicNum == 4) {
             * stopMusic = true; } musicArray[musicNum].play(); }
             */

            if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            {
                pause();
            }

            sys.render(game.batch, game.camera);
            // hud.render();
            game.batch.end();

            sys.update();
        }

        // if (Gdx.input.isKeyPressed(Input.Keys.A))
        // {
        // truck.x -= 200 * Gdx.graphics.getDeltaTime();
        // }
        // if (Gdx.input.isKeyPressed(Input.Keys.D))
        // {
        // truck.x += 200 * Gdx.graphics.getDeltaTime();
        // }
        //
        // if (truck.x < 0)
        // {
        // truck.x = 144;
        // }
        // if (truck.x > 144)
        // {
        // truck.x = 0;
        // }
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {
        pauseScreen = new PauseScreen(game, truck.inventory, this);
        game.setScreen(pauseScreen);
        active = false;
        mainMusic.pause();
    }

    @Override
    public void resume()
    {
        active = true;
        mainMusic.play();
    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        truckT.dispose();
        truckT45.dispose();
        pirateT.dispose();
        pirateT45.dispose();
        sys1.center.sprite.getTexture().dispose();
        for (Dockable d : sys1.dockables)
            d.sprite.getTexture().dispose();
        sys2.center.sprite.getTexture().dispose();
        for (Dockable d : sys2.dockables)
            d.sprite.getTexture().dispose();
        /*
         * battleMusic.dispose(); bU2.dispose(); bU.dispose(); bIntro.dispose();
         * bOutro.dispose(); bD2.dispose();
         */
    }
}
