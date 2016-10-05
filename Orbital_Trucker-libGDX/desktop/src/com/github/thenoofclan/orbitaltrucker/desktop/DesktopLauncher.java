package com.github.thenoofclan.orbitaltrucker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.thenoofclan.orbitaltrucker.OrbitalTrucker;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Orbital_Trucker|libGDX";
		config.width = 320;
		config.height = 288;
		config.foregroundFPS = 60;
		config.resizable = true;
		new LwjglApplication(new OrbitalTrucker(), config);
	}
}
