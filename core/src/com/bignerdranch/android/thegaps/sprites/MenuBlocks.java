package com.bignerdranch.android.thegaps.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.bignerdranch.android.thegaps.TheGaps;



/**
 * Created by nafis on 10-Aug-16.
 */
public class MenuBlocks  {

    private Texture block;
    private Vector2 posBlock;

    public Texture getBlock() {
         return block;
    }


    public Vector2 getPosBlock() {
        return posBlock;
    }

    public MenuBlocks(float x) {

        block = new Texture("Menublock.png");
        posBlock = new Vector2( 0-x, TheGaps.HEIGHT - 150);

    }


    public void reposition(float x, float y) {
        posBlock.set(x,y);

    }


    public void update(float dt) {
        posBlock.add(-Blocks.MOVEMENT*dt,0);
    }


    public void dispose() {
        block.dispose();
    }
}
