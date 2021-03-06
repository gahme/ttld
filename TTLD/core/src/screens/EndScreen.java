package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ttld.game.ttld;

public class EndScreen extends Screens {

    //UI Elements
    public Sound effect;
    public float effectVolume;
    private Table uiElements;

    public TextButton newGame, mainMenu, gameEndText;
    public Texture backgroundImage;

    public EndScreen(ttld ttldGame) {
        super(ttldGame);
        backgroundImage = new Texture("res/menu_background4.png");
        effect = Gdx.audio.newSound(Gdx.files.internal("sfx/rollOverSoundEff.wav"));
        font.getData().setScale(3, 3);
        effectVolume = 0.05f;
    }

    private EndScreen callClass() {
        return this;
    }


    @Override
    public void render(float delta) {

        ScreenUtils.clear(0, 0, 0, 1);
        ttld.batch.setProjectionMatrix(gameCam.combined);

        // Background Image
        ttld.batch.begin();
        ttld.batch.draw(backgroundImage, 0, 0);
        ttld.batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void show() {
        super.show();
        stage.clear();

        uiElements = new Table();
        uiElements.setFillParent(true);
        loadUI(300, 15);
        stage.addActor(uiElements);
    }


    private void loadUI(int length, int gapping) {


        gameEndText = addTextButton("GAME OVER!");
        newGame = addTextButton("NEW GAME");
        mainMenu = addTextButton("RETURN TO MAIN MENU");

        newGame.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                effect.play(effectVolume);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                ttldGame.setScreen(ttldGame.gameScreen);
                stage.clear();
            }
        });

        mainMenu.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                effect.play(effectVolume);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                ttldGame.setScreen(ttldGame.menuScreen);
                stage.clear();
            }
        });
        gameEndText.setTouchable(Touchable.disabled);
        gameEndText.setColor(Color.RED);
        uiElements.add(gameEndText).width(length).pad(4*gapping);
        uiElements.row();
        uiElements.add(newGame).width(length).padBottom(gapping);
        uiElements.row();
        uiElements.add(mainMenu).width(length).padBottom(gapping);
        uiElements.row();
    }

    //Done
    @Override
    public void resize(int width, int height) {
        port.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        backgroundImage.dispose();
        effect.dispose();
    }
}