package com.bignerdranch.android.thegaps.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bignerdranch.android.thegaps.TheGaps;

/**
 * Created by nafis on 31-Jul-16.
 */
public class Ball {
    private Vector3 postion;
//  private Vector3 velocity;

    private Texture ball;

    private Rectangle bounds;

    public Texture getBall() {
        return ball;
    }

    public Vector3 getPostion() {
        return postion;
    }

    public Ball(int x, int y) {

        postion = new Vector3(x, y, 0);
//      velocity = new Vector3(0,0,0);
        ball = new Texture("aqua.png");

        bounds = new Rectangle(x, y, ball.getWidth(), ball.getHeight());


    }

    public void update(float dt) {

        postion.add(move(), 0, 0);

        if (postion.x > 368) {
            postion.x = 368;
        }
        if (postion.x < 0) {
            postion.x = -3;
        }
        bounds.setPosition(postion.x, postion.y);

    }


    public float move() {

        if (Gdx.input.getX() > TheGaps.WIDTH / 2) {
            return 20;
        } else {
            return -20;
        }

    }

    public Rectangle getBounds() {
         return bounds;
        }
}
