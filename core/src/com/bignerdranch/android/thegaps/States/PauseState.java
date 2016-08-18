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
    public static Preferences soundstuff;
    public static int x ;

    protected PauseState(){}

    protected PauseState(int sound){

        soundstuff = Gdx.app.getPreferences("sound_onoff");

        soundstuff.putInteger("sound",sound);
        soundstuff.flush();
    }
    public void setsound(){

    }

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
        return blockposx.getFloat("posx");
    }
    public float getblockPosy(){
         return blockposy.getFloat("posy");
    }

    public int getsound(){
        return soundstuff.getInteger("sound");
    }

    protected void handleInput() {

    }

    public void update(float dt) {
        handleInput();
    }

    public void render(SpriteBatch sb) {

    }


    public void dispose() {

    }
}
