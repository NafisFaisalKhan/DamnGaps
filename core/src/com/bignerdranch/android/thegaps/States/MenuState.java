package com.bignerdranch.android.thegaps.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
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
    private Texture playbtn;
    public ArrayList<MenuBlocks> block;
    private Sound sound;


    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){

            Vector3 tmp = new Vector3(Gdx.input.getX(),Gdx.input.getY(), 0);
            cam.unproject(tmp);
            Rectangle textureBounds=new Rectangle((TheGaps.WIDTH/2)-(playbtn.getWidth()/2),(TheGaps.HEIGHT/2)-(playbtn.getHeight()/2),playbtn.getWidth(),playbtn.getHeight());

            if(textureBounds.contains(tmp.x,tmp.y))
            {
                sound.play(.5f);
                gsm.set(new PlayState(gsm));
            }


        }
    }

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false,TheGaps.WIDTH,TheGaps.HEIGHT);
        background= new Texture("background.png");
        playbtn = new Texture("playbtn4.png");
        block = new ArrayList<MenuBlocks>();
        for(int i = 0; i < PlayState.BLOCK_COUNTS;i++){
            block.add(new MenuBlocks(i*(PlayState.BLOCK_SPACING + Blocks.BLOCK_HEIGHT )));
        }
        sound = Gdx.audio.newSound(Gdx.files.internal("menubtn2.mp3"));
    }

    @Override
    public void update(float dt) {
        handleInput();

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

        for(MenuBlocks blocks : block){
            sb.draw(blocks.getBlock(),blocks.getPosBlock().x,blocks.getPosBlock().y);
        }
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


    }

}
