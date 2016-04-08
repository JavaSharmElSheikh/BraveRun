package com.mygdx.game.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MenuStage extends Stage{
    private Texture texture;
    private Texture startButton;
    private Rectangle rect;

    public MenuStage(GameStageManager gsm){
        super(gsm);
        startButton = new Texture("startSprite.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            gsm.set(new PlayStage(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(startButton, 100, 100);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
