package com.bignerdranch.android.thegaps.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by nafis on 13-Aug-16.
 */
public class PauseState {

    public static Preferences ballpos;
    public static Preferences blockposx;
    public static Preferences blockposy;

    protected PauseState(){}

    protected PauseState(float ballx) {
        ballpos = Gdx.app.getPreferences("ball_pos");

        ballpos.putFloat("pos",ballx);
        ballpos.flush();
    }
    protected PauseState(float blockx,float blocky) {
        blockposx = Gdx.app.getPreferences("blockx_pos");
        blockposy = Gdx.app.getPreferences("blocky_pos");

        blockposx.putFloat("posx",blockx);
        blockposx.flush();
        blockposy.putFloat("posy",blocky);
        blockposy.flush();
    }

    public float getblockPosx(){
        System.out.println("calledx");
        return blockposx.getFloat("posx");
    }
    public float getblockPosy(){
        System.out.println("calledy");
        return blockposy.getFloat("posy");
    }

    protected void handleInput() {

    }

    public void update(float dt) {
        handleInput();
    }

    public void render(SpriteBatch sb) {
//        Gdx.graphics.getGL20().glEnable(GL20.GL_BLEND);
//        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
//
//        sb.setProjectionMatrix(cam.combined);
//        sb.begin();
//        sb.enableBlending();
//       // sb.draw(bk,0,0,TheGaps.WIDTH,TheGaps.HEIGHT);
//        //sb.draw(playbtn,(TheGaps.WIDTH/2)-(playbtn.getWidth()/2),(TheGaps.HEIGHT/2)-(playbtn.getHeight()/2));
//        //background
//
//        Color c = sb.getColor();
//        sb.setColor(c.r, c.g, c.b, .6f); //set alpha to 1
//        sb.draw(bk, 0, 0, 400, 800);
//        //foreground
//        c = sb.getColor();
//        sb.setColor(c.r, c.g, c.b, 1f);//set alpha to 0.3
//        sb.draw(playbtn,(TheGaps.WIDTH/2)-(playbtn.getWidth()/2),(TheGaps.HEIGHT/2)-(playbtn.getHeight()/2));
//
//        sb.end();
    }


    public void dispose() {

    }
}
