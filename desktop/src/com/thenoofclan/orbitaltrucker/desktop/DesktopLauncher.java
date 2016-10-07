package com.thenoofclan.orbitaltrucker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.thenoofclan.orbitaltrucker.OrbitalTrucker;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = 60;
		config.width = 160 * 2;
		config.height = 144 * 2;
		config.title = "Orbital_Trucker|libGDX";
		new LwjglApplication(new OrbitalTrucker(), config);
	}
}
