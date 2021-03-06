// Credits to : HollowBit YouTube Channel
// Link to his playlist: https://www.youtube.com/playlist?list=PLrnO5Pu2zAHKAIjRtTLAXtZKMSA6JWnmf

package com.ttld.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import levels.Level1;
import screens.*;

//Trying to merge this with merge-trail

public class ttld extends Game {

	public static final int width = 1280;
	public static final int height = 720;

	public static SpriteBatch batch;

	//Screens
	public SplashScreen splashScreen;
	public MenuScreen menuScreen;
	public GameScreen gameScreen;
	public PauseMenu pauseScreen;


	@Override
	public void create () {
		batch = new SpriteBatch();

		// Init screens
		splashScreen = new SplashScreen(this);
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this, new Level1());
		pauseScreen = new PauseMenu(this);

		this.setScreen(splashScreen);
	}

	@Override
	public void render () {
		super.render(); //calls the render method of the active screens
	}
	
	@Override
	public void dispose () {
		splashScreen.dispose();
		menuScreen.dispose();
		gameScreen.dispose();
		batch.dispose();
	}
}
