package com.bignerdranch.android.thegaps.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bignerdranch.android.thegaps.TheGaps;

import java.util.Random;

/**
 * Created by nafis on 31-Jul-16.
 */
public class Ball {
    private Sound sound;
    private Vector3 postion;
    private Vector3 velocity;
    private static String mBall;
    private Texture ball;
    public int x = 1;
    public int y = 0;



    public Texture getBall() {
        return ball;
    }

    public void setPosition(float x){
        postion.x = x;
    }

    public Vector3 getPostion() {
        return postion;
    }

    private Rectangle boundball;

    public Ball(int x, int y) {
        randomizer();
        sound = Gdx.audio.newSound(Gdx.files.internal("Blop_sound.mp3"));
        postion = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        ball = new Texture(mBall);
        boundball = new Rectangle(postion.x, postion.y, ball.getWidth()-5, ball.getHeight()-5);
    }

    public void update(float dt) {

        velocity.scl(dt);
        postion.add(velocity.x, 0, 0);
        velocity.scl(1/dt);

        if (postion.x > TheGaps.WIDTH-ball.getWidth()) {
            postion.x = TheGaps.WIDTH-ball.getWidth();

        }
        if (postion.x < 0) {
            postion.x = 0;

        }
        boundball.setPosition(postion.x, postion.y);

        if (postion.x < TheGaps.WIDTH/2+150 && postion.x > TheGaps.WIDTH/2+100 && x == 0 && y==1){
                sound.play(.5f);

            x=1;
            y=0;

        }
       else if (postion.x < TheGaps.WIDTH/2-150 && postion.x > TheGaps.WIDTH/2-200 && x==1 && y==0){
                sound.play(.5f);

           x=0;
           y=1;
        }
    }

    public float move() {

        if (postion.x < TheGaps.WIDTH / 2) {

            velocity.x = 2500;
        } else if (postion.x >= TheGaps.WIDTH / 2){

            velocity.x = -2500;
        }
        return 0;
    }

    private void randomizer(){
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;

        switch (randomNum){
            case 1: {
                mBall = "8ball.png";
                break;
            }
            case 2: {
                mBall = "aqua.png";
                break;
            }
            case 5: {
                mBall = "nice.png";
                break;
            }
            case 6: {
                mBall = "poke.png";
                break;
            }
            case 7: {
                mBall = "red.png";
                break;
            }
            case 8: {
                mBall = "volley.png";
                break;
            }
            case 9: {
                mBall = "yellow.png";
                break;
            }
            case 10: {
                mBall = "yellow2.png";
                break;
            }
            default: {
                mBall = "poke.png";
                break;
            }
        }
    }

    public Rectangle getBounds(){
        return boundball;
    }

    public void dispose(){
        ball.dispose();
        sound.dispose();

    }



}
