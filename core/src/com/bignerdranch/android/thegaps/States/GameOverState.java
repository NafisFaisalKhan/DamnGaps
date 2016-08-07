package com.bignerdranch.android.thegaps.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bignerdranch.android.thegaps.TheGaps;
import com.bignerdranch.android.thegaps.sprites.Blocks;

/**
 * Created by nafis on 06-Aug-16.
 */
public class GameOverState extends State {
    private Texture background;
    private String Gameover;
    BitmapFont font;
    BitmapFont fontscore;
    BitmapFont fontscorern;
    BitmapFont fonttaunt;
    private String Highscore,Score,Taunt;
    private String[] exclamations = {"LMFAO!","LMAO!","LOL!","HEHE!","TRIED!","OK!","SHIT GOT REAL!","DAMN!","DAMN SON!"};
    private  Texture retry;


    protected GameOverState(GameStateManager gsm) {
        super(gsm);

        background= new Texture("background.png");
        retry = new Texture("retry_icon.png");

        Gameover = "Gameover!";
        font = new BitmapFont();
        font.getData().setScale(5,5);

        if (PlayState.prefs.contains("high")) {

            Highscore = "HighScore: " + PlayState.prefs.getInteger("high");
            fontscore= new BitmapFont();
            fontscore.getData().setScale(3,5);

        }

        Score ="Score: " + PlayState.points;
        Taunt = exclamations[0];
        fontscorern = new BitmapFont();
        fontscorern.getData().setScale(3,5);
        fonttaunt = new BitmapFont();
        fonttaunt.getData().setScale(7,7);
        Blocks.MOVEMENT = -300;
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        setTaunt();

    }

    public void setTaunt(){
        if (PlayState.points < 5){
            Taunt = exclamations[0];
        }else if(PlayState.points < 10){
            Taunt = exclamations[1];
        }else if(PlayState.points<20){
            Taunt = exclamations[2];
        }

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        sb.draw(background,0,0, TheGaps.WIDTH,TheGaps.HEIGHT);
        font.setColor(Color.WHITE);
        font.draw(sb, Gameover, 30, 600);
        fontscorern.setColor(Color.WHITE);
        fontscorern.draw(sb,Score,30,500);
        fontscore.setColor(Color.WHITE);
        fontscore.draw(sb,Highscore,30,400);
        fonttaunt.setColor(Color.WHITE);
        fonttaunt.draw(sb,Taunt,20,300);
        sb.draw(retry,TheGaps.WIDTH/2 - retry.getWidth()/2,20);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
