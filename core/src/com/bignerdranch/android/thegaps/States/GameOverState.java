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

    protected GameOverState(GameStateManager gsm) {
        super(gsm);
        background= new Texture("background.png");

        Gameover = "Gameover Bhog!";
        font = new BitmapFont();
        font.getData().setScale(3,5);

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
        Blocks.MOVEMENT = -300;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, TheGaps.WIDTH,TheGaps.HEIGHT);
        font.setColor(Color.CYAN);
        font.draw(sb, Gameover, 30, 600);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
