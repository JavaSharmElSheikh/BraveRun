package com.mygdx.game.Character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

public class Character {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 50;

    private Vector3 position;
    private Vector3 velocity;
    private Texture texture;

    public Character(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("rsz_sprite_mario_transparent.png");
    }

    public void update(float deltaTime){
        if (position.y > 0) {
        velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(deltaTime);
        position.add(velocity.x * deltaTime, velocity.y, 0);


        if (position.y < 0){
            position.y = 0;
        }

        velocity.scl(1 / deltaTime);
    }

    public void jump(){
        velocity.y = 250;
    }

    public void goRight(){
        velocity.x += 250;
        stopLeft();

    }

    public void stopLeft(){
        velocity.x -= 250;
    }


    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }

    public float getWidth(){
        return texture.getWidth();
    }

    public float getHeight(){
        return texture.getHeight();
    }

    public Texture getTexture(){
        return this.texture;
    }

    public Vector3 getPosition(){
        return position;
    }
}
