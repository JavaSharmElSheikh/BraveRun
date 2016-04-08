package com.mygdx.game.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Character.Character;

public class PlayStage extends Stage{
    Texture bg;
    Character player;

    public PlayStage(GameStageManager gsm){
        super(gsm);
        player = new Character(100,100);
        bg = new Texture("badlogic.jpg");
        cam.setToOrtho(false, 700, 700);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            player.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        cam.position.x = player.getPosition().x + 80;
        player.update(dt);

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.jump();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.goRight();
        }

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 100, 0);
        sb.draw(player.getTexture(), player.getPosition().x, player.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
