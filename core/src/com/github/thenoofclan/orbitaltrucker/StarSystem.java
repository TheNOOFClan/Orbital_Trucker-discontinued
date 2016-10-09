package com.github.thenoofclan.orbitaltrucker;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StarSystem
{
    public int width;
    public int height;

    public Dockable center;
    public Player player;
    public ArrayList<Dockable> dockables;
    public ArrayList<Ship> ships;
    public ArrayList<Laser> lasers;

    public StarSystem(int width, int height, Dockable center)
    {
        center.sprite.setCenter(width / 2, height / 2);
        this.center = center;
        dockables = new ArrayList<Dockable>();
        ships = new ArrayList<Ship>();
        lasers = new ArrayList<Laser>();
        this.width = width;
        this.height = height;
    }

    public void add(Ship ship, int x, int y)
    {
        ship.x = x;
        ship.y = y;
        ship.sprite.setCenter(x, y);
        ships.add(ship);
    }

    public void add(Dockable target, int x, int y)
    {

    }

    public void update()
    {
        center.update();
        player.update();
        for (Ship s : ships)
            s.update();
        for (Laser l : lasers)
            l.update();
        for (Dockable d : dockables)
            d.update();
    }

    public void render(SpriteBatch batch, OrthographicCamera camera)
    {
        int dx = 0;
        int dy = 0;

        if (player.x < 0)
            dx = (int) (-player.x);
        else if (player.x > width)
            dx = (int) (width - player.x);
        if (player.y < 0)
            dy = (int) (-player.y);
        else if (player.y > height)
            dy = (int) (height - player.y);

        camera.position.x = (int) (player.x + dx);
        camera.position.y = (int) (player.y + dy);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();

        center.render(batch);
        player.render(batch);
        for (Dockable d : dockables)
        {
            d.render(batch);
        }
        for (Ship s : ships)
        {
            s.render(batch);
        }
    }
}
