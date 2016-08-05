package com.bignerdranch.android.thegaps.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bignerdranch.android.thegaps.TheGaps;

/**
 * Created by nafis on 31-Jul-16.
 */
public class MenuState extends State {
    private Texture background;
    private Texture playbtn;



    BitmapFont font;
    private String highscore ;


    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));

        }
    }

    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false,TheGaps.WIDTH,TheGaps.HEIGHT);
        background= new Texture("background.png");
        playbtn = new Texture("playbtn2.png");



//
//        font = new BitmapFont();
//        font.getData().setScale(5,5);





    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0, TheGaps.WIDTH,TheGaps.HEIGHT);
        sb.draw(playbtn,(TheGaps.WIDTH/2)-(playbtn.getWidth()/2),(TheGaps.HEIGHT/2)-(playbtn.getHeight()/2));


//                font.setColor(Color.GOLD);
//                font.draw(sb, highscore, TheGaps.WIDTH / 3, TheGaps.HEIGHT / 3);

        sb.end();
    }


    @Override
    public void dispose(){
        background.dispose();
        playbtn.dispose();

    }

}
