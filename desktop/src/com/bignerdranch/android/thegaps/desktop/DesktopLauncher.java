package com.bignerdranch.android.thegaps.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bignerdranch.android.thegaps.TheGaps;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=TheGaps.WIDTH;
		config.height=TheGaps.HEIGHT;
		config.title=TheGaps.TTILE;

		new LwjglApplication(new TheGaps(), config);

	}
}
