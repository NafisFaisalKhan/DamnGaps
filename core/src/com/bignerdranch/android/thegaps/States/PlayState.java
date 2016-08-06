package com.bignerdranch.android.thegaps.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bignerdranch.android.thegaps.TheGaps;
import com.bignerdranch.android.thegaps.sprites.Ball;
import com.bignerdranch.android.thegaps.sprites.Blocks;

import java.util.ArrayList;

/**
 * Created by nafis on 31-Jul-16.
 */
public class PlayState extends State {

    private static final int BLOCK_SPACING = 100;
    private static final int BLOCK_COUNTS =4;
    private Ball ball;
    private Texture background;
    private ArrayList<Blocks> block;
    public  int points;
    private String Score;
    BitmapFont font;
    public static Preferences prefs;


    public PlayState(GameStateManager gsm) {

         super(gsm);

         ball= new Ball(400,80);

         background = new Texture("background.png");

         cam.setToOrtho(false,TheGaps.WIDTH,TheGaps.HEIGHT);

         block = new ArrayList<Blocks>();

         for(int i = 0; i< BLOCK_COUNTS;i++){
            block.add(new Blocks(i*(BLOCK_SPACING + Blocks.BLOCK_HEIGHT )));
         }

            points = 0;
            Score= "0";
            font = new BitmapFont();
            font.getData().setScale(5,5);

            prefs = Gdx.app.getPreferences("saved_highscore");





    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            ball.move();

        }

    }

    @Override
    public void update(float dt) {

       if(Blocks.TEMP_COUNT == 1) {
           if ((TheGaps.WIDTH / 2) - 10 <= ball.getPostion().x && ball.getPostion().x <= (TheGaps.WIDTH / 2) + 10) {

               points++;
               Score = "" + points;

                if(points>prefs.getInteger("high")){
                    prefs.putInteger("high",points);
                    prefs.flush();
                }
           }
       }

        handleInput();
        ball.update(dt);


        for(int i=0 ; i<BLOCK_COUNTS ; i++){
            block.get(i).update(dt);
        }
        for(Blocks blocks : block){
              if(blocks.getPosBlock().y + Blocks.BLOCK_HEIGHT < 0){
                   blocks.reposition((TheGaps.WIDTH/2)-blocks.getBlock().getWidth()/2, blocks.getPosBlock().y +((Blocks.BLOCK_HEIGHT + BLOCK_SPACING )* BLOCK_COUNTS));

               //for random positioning of the blocks in the x-axis
                 // blocks.reposition((float) (Math.random()*(TheGaps.WIDTH-blocks.getBlock().getWidth()))  ,blocks.getPosBlock().y +((Blocks.BLOCK_HEIGHT + BLOCK_SPACING )* BLOCK_COUNTS));
                }
            if(blocks.collides(ball.getBounds())){
                System.out.println("colliding");
                gsm.set(new PlayState(gsm));
            }




        }

           cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0,TheGaps.WIDTH,TheGaps.HEIGHT);
        sb.draw(ball.getBall(), ball.getPostion().x, ball.getPostion().y);

            for(Blocks blocks : block){
                sb.draw(blocks.getBlock(),blocks.getPosBlock().x,blocks.getPosBlock().y);
            }
        font.setColor(Color.GOLD);
        font.draw(sb, Score, TheGaps.WIDTH -100, TheGaps.HEIGHT -10);

        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        ball.dispose();
        for(Blocks blocks : block){
            blocks.dispose();
        }

    }
}
