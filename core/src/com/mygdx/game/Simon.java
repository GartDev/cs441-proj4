package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Simon extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture dogtex;
	private Texture cattex;
	private Texture cowtex;
	private Texture goattex;
	private Sprite dogsprite;
	private Sprite catsprite;
	private Sprite cowsprite;
	private Sprite goatsprite;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		dogtex = new Texture("dog.bmp");
		cattex = new Texture("cat.bmp");
		cowtex = new Texture("cow.bmp");
		goattex = new Texture("goat.bmp");
		dogsprite = new Sprite(dogtex);
		catsprite = new Sprite(cattex);
		cowsprite = new Sprite(cowtex);
		goatsprite = new Sprite(goattex);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		dogsprite.draw(batch);
		catsprite.draw(batch);
		cowsprite.draw(batch);
		goatsprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		dogtex.dispose();
		cattex.dispose();
		cowtex.dispose();
		goattex.dispose();
	}
}
