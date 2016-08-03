package com.bignerdranch.android.thegaps.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bignerdranch.android.thegaps.TheGaps;

/**
 * Created by nafis on 02-Aug-16.
 */
public class Blocks {
    public static final int BLOCK_HEIGHT = 152;
    private Texture block;
    private Vector2 posBlock;
    private static final int MOVEMENT = -200;
    private Rectangle bound;

    public Texture getBlock() {
        return block;
    }

    public Vector2 getPosBlock() {
        return posBlock;
    }

    public Blocks(float y){

        block = new Texture("block.png");
        posBlock = new Vector2(TheGaps.WIDTH/2-block.getWidth()/2, y + TheGaps.HEIGHT);
        bound = new Rectangle(posBlock.x, posBlock.y, block.getWidth(), block.getHeight());
    }

    public void reposition(float x,float y){

//        posBlock.set(TheGaps.WIDTH/2 - block.getWidth()/2, y );
            posBlock.set(x,y);
            bound.setPosition(getPosBlock().x,getPosBlock().y);
    }

    public boolean collides(Rectangle player){

        return bound.overlaps(player);

    }

    public void update(float dt){
            posBlock.add(0,MOVEMENT*dt);
    }

}
