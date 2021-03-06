package com.example.simon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private CharacterSprite jonny;
    private CharacterSprite goal;
    private int xVelocity = 5;
    private int yVelocity = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private CharacterSprite ball;
    private CharacterSprite garbage;

    public GameView(Context context) {
        super(context);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
        getHolder().addCallback(this);
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
        jonny = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.jonnyblue),((screenWidth/2)-50),(screenHeight-100),100,100);
        goal = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.goal),((screenWidth/2)-100),screenHeight/8,200,75);
        ball = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.ball),(screenWidth/2)-25,screenHeight/2,50,50);
        garbage = new CharacterSprite(BitmapFactory.decodeResource(getResources(),R.drawable.garbage),((screenWidth/4)-32),screenHeight/2,75,75);

    }
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            canvas.drawColor(Color.GREEN);
            jonny.draw(canvas);
            goal.draw(canvas);
            ball.draw(canvas);
            garbage.draw(canvas);
        }
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry){
            try{
                thread.setRunning(false);
                thread.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            retry = false;
        }
    }
    public void update(){
        jonny.update(0,-1);
        int xdelt = 0;
        int ydelt = -3;
        if((jonny.getXcent() >= ball.getX())&&(jonny.getXcent()<= ball.getXright())&&(jonny.getYcent() <= ball.getYbot())&&(jonny.getYcent() >= ball.getY())){
                xdelt = ball.getXcent() - jonny.getXcent();
                ydelt = ball.getYcent() - jonny.getYcent();
        }
        ball.update(xdelt,ydelt);
    }
}
