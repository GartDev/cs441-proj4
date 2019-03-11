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
	private float dogx = 200;
	private float catx = 400;
	private float cowx = 600;
	private float goatx = 800;
	private float dogy = 200;
	private float caty = 200;
	private float cowy = 200;
	private float goaty = 200;

	
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
		dogsprite.setPosition(dogx,dogy);
		catsprite.draw(batch);
		catsprite.setPosition(catx,caty);
		cowsprite.draw(batch);
		cowsprite.setPosition(cowx,cowy);
		goatsprite.draw(batch);
		goatsprite.setPosition(goatx,goaty);
		batch.end();
		update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		dogtex.dispose();
		cattex.dispose();
		cowtex.dispose();
		goattex.dispose();
	}

	public void update(){
		dogx++;
		dogy++;
		caty++;
		cowx++;
		goatx--;
		goaty++;
	}
}
