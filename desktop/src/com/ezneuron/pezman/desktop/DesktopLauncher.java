package com.ezneuron.pezman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ezneuron.pezman.PezmanMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PezmanMain";
		config.width = 480;
		config.height = 800;
		new LwjglApplication(new PezmanMain(), config);
	}
}
