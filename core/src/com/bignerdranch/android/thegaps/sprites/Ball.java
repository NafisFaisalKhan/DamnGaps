package com.bignerdranch.android.thegaps.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bignerdranch.android.thegaps.TheGaps;

/**
 * Created by nafis on 31-Jul-16.
 */
public class Ball {
    private Sound sound;
    private Vector3 postion;
    private Vector3 velocity;

    private Texture ball;

    private float temp1 ;

    public Texture getBall() {
        return ball;
    }

    public Vector3 getPostion() {
        return postion;
    }

    private Rectangle boundball;

    public Ball(int x, int y) {
        sound = Gdx.audio.newSound(Gdx.files.internal("Blop_sound.mp3"));

        postion = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        ball = new Texture("aqua.png");

        boundball = new Rectangle(postion.x, postion.y, ball.getWidth(), ball.getHeight());


    }



    public void update(float dt) {


        velocity.scl(dt);
        postion.add(velocity.x, 0, 0);
        velocity.scl(1/dt);

        if (postion.x > TheGaps.WIDTH-ball.getWidth()) {
            postion.x = TheGaps.WIDTH-ball.getWidth();
            // neds work
            if (postion.x == TheGaps.WIDTH-ball.getWidth()) {
              //  sound.play(.5f);
            }
        }
        if (postion.x < 0) {
            postion.x = 0;
            //needs work
            if(postion.x == -3) {
              //  sound.play(.5f);
            }
        }
        boundball.setPosition(postion.x, postion.y);
      //for debugg
        //  System.out.println(boundball.x+"bound,"+postion.x+"ball ");


    }


    public float move() {

        if (postion.x < TheGaps.WIDTH / 2) {
            velocity.x = 2500;
        } else if (postion.x >= TheGaps.WIDTH / 2){
            velocity.x = -2500;
        }
        return 0;
    }

    public Rectangle getBounds(){
        return boundball;
    }




    public void dispose(){
        ball.dispose();
        sound.dispose();


    }



}
