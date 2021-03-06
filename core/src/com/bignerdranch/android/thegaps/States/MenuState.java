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
import com.bignerdranch.android.thegaps.sprites.MenuBlocks;

import java.util.ArrayList;

/**
 * Created by nafis on 31-Jul-16.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playbtn,music;
    public ArrayList<MenuBlocks> block;
    private Sound sound;
    private static String mMusic ;
    public static int tempSound ;
    private BitmapFont titlefont;
    private String title = "ThemGaps!";


    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){

            Vector3 tmp = new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
            cam.unproject(tmp);
            Rectangle textureBounds= new Rectangle((TheGaps.WIDTH/2)-(playbtn.getWidth()/2),(TheGaps.HEIGHT/2)-(playbtn.getHeight()/2),playbtn.getWidth(),playbtn.getHeight());
            Rectangle textureBounds2= new Rectangle(TheGaps.WIDTH/2-music.getWidth()/2+10,300-music.getHeight(),music.getWidth(),music.getHeight()) ;
            if(textureBounds.contains(tmp.x,tmp.y)) {
                if(tempSound == 0) {
                    sound.play(.5f);
                }
                    gsm.set(new PlayState(gsm));
            }
            if(textureBounds2.contains(tmp.x,tmp.y)&& tempSound == 0){
                mMusic ="sound_off2.png";
                tempSound = 1;



            }else if (textureBounds2.contains(tmp.x,tmp.y)&& tempSound == 1){
                mMusic ="sound_on2.png";
                tempSound = 0;
                sound.play(.5f);

            }


        }
    }

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false,TheGaps.WIDTH,TheGaps.HEIGHT);
        background= new Texture("background.png");
        playbtn = new Texture("playbtn5.png");
        block = new ArrayList<MenuBlocks>();
        for(int i = 0; i < PlayState.BLOCK_COUNTS;i++){
            block.add(new MenuBlocks(i*(PlayState.BLOCK_SPACING + Blocks.BLOCK_HEIGHT )));
        }
        sound = Gdx.audio.newSound(Gdx.files.internal("menubtn2.mp3"));

        titlefont = new BitmapFont(Gdx.files.internal("font2.fnt"));
        titlefont.getData().setScale(2,3);

        if(PlayState.y == 1){
            if(tempSound == 0){
                mMusic = "sound_on2.png";
            }else{mMusic = "sound_off2.png";}
        }
        else{mMusic="sound_on2.png";}
        music = new Texture(mMusic);

    }

    @Override
    public void update(float dt) {
        handleInput();
        music = new Texture(mMusic);
        for(int i=0 ; i<PlayState.BLOCK_COUNTS ; i++){
            block.get(i).update(dt);

        }
        for(MenuBlocks blocks : block){
            if(blocks.getPosBlock().x + Blocks.BLOCK_HEIGHT > TheGaps.WIDTH + Blocks.BLOCK_HEIGHT) {
                blocks.reposition(0-(3*(50 + Blocks.BLOCK_HEIGHT )) , TheGaps.HEIGHT - 150);
            }
        }

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0, TheGaps.WIDTH,TheGaps.HEIGHT);
        sb.draw(playbtn,(TheGaps.WIDTH/2)-(playbtn.getWidth()/2),(TheGaps.HEIGHT/2)-(playbtn.getHeight()/2));
        sb.draw(music,TheGaps.WIDTH/2-music.getWidth()/2+10,300-music.getHeight());
        for(MenuBlocks blocks : block){
            sb.draw(blocks.getBlock(),blocks.getPosBlock().x,blocks.getPosBlock().y);
        }
        titlefont.setColor(Color.NAVY);
        titlefont.draw(sb,title,5, 640);
        sb.end();
    }


    @Override
    public void dispose(){
        background.dispose();
        playbtn.dispose();

        for(MenuBlocks blocks : block){
            blocks.dispose();
        }
        sound.dispose();
        music.dispose();


    }

}
