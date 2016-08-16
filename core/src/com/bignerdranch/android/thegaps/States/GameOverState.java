package com.bignerdranch.android.thegaps.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
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
    private String[] exclamations = {"Noob!","LOL!","HEHE!","Almost!","Not bad!","Impressive!","Damn!","Try hard!","Almost there!","A winner is you!"};
    private  Texture retry;
    public Sound sound;


    protected GameOverState(GameStateManager gsm) {
        super(gsm);

        background = new Texture("background4.png");
        retry = new Texture("retry_icon.png");
        cam.setToOrtho(false,TheGaps.WIDTH,TheGaps.HEIGHT);
        Gameover = "Gameover!";
        font = new BitmapFont(Gdx.files.internal("font2.fnt"));
        font.getData().setScale(2,4);
        sound = Gdx.audio.newSound(Gdx.files.internal("menubtn2.mp3"));


        if (PlayState.prefs.contains("high")) {

            Highscore = "HighScore:" + PlayState.prefs.getInteger("high");
            fontscore= new BitmapFont(Gdx.files.internal("font.fnt"));
            fontscore.getData().setScale(2,2);

        }

        Score ="Score: " + PlayState.points;
        Taunt = exclamations[0];
        fontscorern = new BitmapFont(Gdx.files.internal("font.fnt"));
        fontscorern.getData().setScale(2,2);
        fonttaunt = new BitmapFont(Gdx.files.internal("font.fnt"));
        fonttaunt.getData().setScale(2,2);
        Blocks.MOVEMENT = -300;
        PlayState.temptap = 1;
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){

            Vector3 tmp = new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
            cam.unproject(tmp);
            Rectangle textureBounds = new Rectangle((TheGaps.WIDTH/2)-(retry.getWidth()/2),20,retry.getWidth(),retry.getHeight());

            if(textureBounds.contains(tmp.x,tmp.y)){
             if(MenuState.tempSound == 0) {
                sound.play(.5f);
            }
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
        font.setColor(Color.MAROON);
        font.draw(sb, Gameover, 5, 700);
        fontscorern.setColor(Color.MAROON);
        fontscorern.draw(sb,Score,5,500);
        fontscore.setColor(Color.MAROON);
        fontscore.draw(sb,Highscore,3 ,400);
        fonttaunt.setColor(Color.MAROON);
        fonttaunt.draw(sb,Taunt,10,300);
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
        sound.dispose();
    }
}
