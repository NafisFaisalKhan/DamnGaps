package com.bignerdranch.android.thegaps.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.bignerdranch.android.thegaps.TheGaps;

/**
 * Created by nafis on 02-Aug-16.
 */
public class Blocks {
    public static int TEMP_COUNT;
    public static final int BLOCK_HEIGHT = 152;
    public static final int BLOCK_WIDTH=56;
    private Texture block;

    private Vector2 posBlock;

    public static int MOVEMENT = -300;
    public static String mBlocks;

    private Rectangle boundblock;


    public Texture getBlock() {
        return block;
    }

    public Vector2 getPosBlock() {
        return posBlock;
    }

    public Blocks(float y){

        block = new Texture(mBlocks);

        posBlock = new Vector2(TheGaps.WIDTH/2-block.getWidth()/2, y + TheGaps.HEIGHT);

        //for random initial positioning
       // posBlock = new Vector2((float) (Math.random()*(TheGaps.WIDTH-block.getWidth())) , y + TheGaps.HEIGHT);
        boundblock = new Rectangle(getPosBlock().x,getPosBlock().y, block.getWidth(), block.getHeight());

        //reseting points when new playstate is called
        TEMP_COUNT = 0;

    }
    public Blocks(float x, float y){
        block = new Texture(mBlocks);

        posBlock = new Vector2(x, y + TheGaps.HEIGHT);

        boundblock = new Rectangle(getPosBlock().x,getPosBlock().y, block.getWidth(), block.getHeight());
    }

    public void reposition(float x,float y){
            posBlock.set(x,y);
            boundblock.setPosition(getPosBlock().x,getPosBlock().y);

    }



    public void update(float dt){

            posBlock.add(0,MOVEMENT*dt);

            boundblock.setPosition(getPosBlock().x,getPosBlock().y);

            //used for scoring
            if( posBlock.y>80-10 && posBlock.y<80+10){

                TEMP_COUNT =1;
            }
        //for debugg
//        System.out.println(boundblock.getX()+"bound,"+posBlock.x+"block");

    }
    public boolean collides(Rectangle player){

            return player.overlaps(boundblock);
    }

        public void dispose() {
            block.dispose();


        }

}
