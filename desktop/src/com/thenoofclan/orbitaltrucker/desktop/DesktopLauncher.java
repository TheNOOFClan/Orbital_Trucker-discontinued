package com.thenoofclan.orbitaltrucker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.thenoofclan.orbitaltrucker.OrbitalTrucker;
import com.github.thenoofclan.orbitaltrucker.Text;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.foregroundFPS = 60;
        config.width = 160 * 4;
        config.height = 144 * 4;
        config.title = "Orbital_Trucker|GBJam 5";
        new LwjglApplication(new OrbitalTrucker(), config);
    }
}
