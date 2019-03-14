package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.Point;


public class Simon extends ApplicationAdapter {
	private Texture dogtex;
	private Texture cattex;
	private Texture cowtex;
	private Texture goattex;
	private Sound woof;
	private Sound meow;
	private Sound moo;
	private Sound baa;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle doghit;
	private Rectangle cathit;
	private Rectangle cowhit;
	private Rectangle goathit;
	private int score;
	private int round;
	private int[] gameplay;
	@Override
	public void create () {
		dogtex = new Texture(Gdx.files.internal("dog.bmp"));
		cattex = new Texture(Gdx.files.internal("cat.bmp"));
		cowtex = new Texture(Gdx.files.internal("cow.bmp"));
		goattex = new Texture(Gdx.files.internal("goat.bmp"));
		woof = Gdx.audio.newSound(Gdx.files.internal("woof.ogg"));
		meow = Gdx.audio.newSound(Gdx.files.internal("meow.ogg"));
		moo = Gdx.audio.newSound(Gdx.files.internal("moo.ogg"));
		baa = Gdx.audio.newSound(Gdx.files.internal("baa.ogg"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);
		batch = new SpriteBatch();
		doghit = new Rectangle();
		doghit.x  = 0;
		doghit.y = 20;
		doghit.width = 64;
		doghit.height = 64;
		cathit = new Rectangle();
		cathit.x  = 200;
		cathit.y = 20;
		cathit.width = 64;
		cathit.height = 64;
		cowhit = new Rectangle();
		cowhit.x  = 400;
		cowhit.y = 20;
		cowhit.width = 64;
		cowhit.height = 64;
		goathit = new Rectangle();
		goathit.x  = 600;
		goathit.y = 20;
		goathit.width = 64;
		goathit.height = 64;
		gameplay = new int[10];
		score = 0;
		round = 0;
		gameplay[0] = 1;
		gameplay[1] = 2;
		gameplay[2] = 3;
		gameplay[3] = 4;
		gameplay[4] = 1;
		gameplay[5] = 2;
		gameplay[6] = 3;
		gameplay[7] = 4;
		gameplay[8] = 1;
		gameplay[9] = 2;

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(66/255f,131/255f,244/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(dogtex,doghit.x,doghit.y);
		batch.draw(cattex,cathit.x,cathit.y);
		batch.draw(cowtex,cowhit.x,cowhit.y);
		batch.draw(goattex,goathit.x,goathit.y);
		batch.end();
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			if(touchPos.x >= 0 && touchPos.x < 200 ){
				woof.play();
			}else if(touchPos.x >= 200 && touchPos.x <= 400 ){
				meow.play();
			}else if(touchPos.x >= 400 && touchPos.x <= 600 ){
				moo.play();
			}else if(touchPos.x >= 600 && touchPos.x <= 800 ){
				baa.play();
			}else{

			}
		}
	}

	@Override
	public void dispose () {

	}
}
