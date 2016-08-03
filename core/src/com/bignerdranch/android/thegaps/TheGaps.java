package com.bignerdranch.android.thegaps;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bignerdranch.android.thegaps.States.GameStateManager;
import com.bignerdranch.android.thegaps.States.MenuState;

public class TheGaps extends ApplicationAdapter {

	public static final int WIDTH = 400;
	public static final int HEIGHT= 800;
	public static final String TTILE="Damn Gaps ! ";
	private SpriteBatch batch;

	private GameStateManager gsm;
	@Override
	public void create () {
		batch = new SpriteBatch();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
