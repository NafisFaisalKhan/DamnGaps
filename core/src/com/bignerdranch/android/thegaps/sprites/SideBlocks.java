package com.bignerdranch.android.thegaps.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by nafis on 06-Aug-16.
 */
public class SideBlocks extends Blocks {
    @Override
    public Texture getBlock() {
        return getBlock();
    }

    @Override
    public Vector2 getPosBlock() {
        return getPosBlock();
    }

    public SideBlocks(float y) {
        super(y);
    }

    @Override
    public void reposition(float x, float y) {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public boolean collides(Rectangle player) {
        return collides(player);
    }

    @Override
    public void dispose() {
       dispose();
    }
}
