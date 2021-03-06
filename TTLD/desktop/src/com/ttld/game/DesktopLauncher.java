package com.ttld.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Till the Last Drop");
		//config.setMaximized(true);
		config.setResizable(false);

		config.setWindowedMode(ttld.width,ttld.height);
		config.setWindowIcon("res/gameObjects/icon.png");
		new Lwjgl3Application(new ttld(), config);

	}
}
