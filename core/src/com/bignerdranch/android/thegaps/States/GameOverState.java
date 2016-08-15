package com.bignerdranch.android.thegaps.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
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
    private String[] exclamations = {"Noob","LOL!","Try again","Getting there.","“Not bad”","Quite impressive","GG","Try hard","Almost there","A winner is you"};
    private  Texture retry;


    protected GameOverState(GameStateManager gsm) {
        super(gsm);

        background = new Texture("background4.png");
        retry = new Texture("retry2.png");
        cam.setToOrtho(false,TheGaps.WIDTH,TheGaps.HEIGHT);
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
        fonttaunt.getData().setScale(3,4);
        Blocks.MOVEMENT = -300;
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){

            Vector3 tmp = new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
            cam.unproject(tmp);
            Rectangle textureBounds = new Rectangle((TheGaps.WIDTH/2)-(retry.getWidth()/2),20,retry.getWidth(),retry.getHeight());

            if(textureBounds.contains(tmp.x,tmp.y))
            {
                PlayState.x=0;
                gsm.set(new PlayState(gsm));
            }


        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        setTaunt();
    }

    public void setTaunt(){

        if (PlayState.points < 10){
            Taunt = exclamations[0];
        }else if(PlayState.points < 20){
            Taunt = exclamations[1];
        }else if(PlayState.points < 30){
            Taunt = exclamations[2];
        }else if(PlayState.points < 40){
            Taunt = exclamations[3];
        }else if(PlayState.points < 50){
            Taunt = exclamations[4];
        }else if(PlayState.points < 60){
            Taunt = exclamations[5];
        }else if(PlayState.points < 70){
            Taunt = exclamations[6];
        }else if(PlayState.points < 80){
            Taunt = exclamations[7];
        }else if(PlayState.points < 90){
            Taunt = exclamations[8];
        }else{
            Taunt = exclamations[9];
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0, TheGaps.WIDTH,TheGaps.HEIGHT);
        font.setColor(Color.BLACK);
        font.draw(sb, Gameover, 30, 600);
        fontscorern.setColor(Color.BLACK);
        fontscorern.draw(sb,Score,30,500);
        fontscore.setColor(Color.BLACK);
        fontscore.draw(sb,Highscore,30,400);
        fonttaunt.setColor(Color.BLACK);
        fonttaunt.draw(sb,Taunt,20,300);
        sb.draw(retry,TheGaps.WIDTH/2 - retry.getWidth()/2,20);
        //System.out.println(TheGaps.WIDTH/2 - retry.getWidth()/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        retry.dispose();
        font.dispose();
        fonttaunt.dispose();
        fontscore.dispose();
        fontscorern.dispose();


    }
}
