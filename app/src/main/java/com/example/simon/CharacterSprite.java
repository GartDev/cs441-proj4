package com.example.simon;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterSprite {
    private Bitmap image;
    private int x,y,xright,ybot,xcent,ycent;

    public CharacterSprite(Bitmap bmp,int xloc, int yloc, int xsize, int ysize){
        image = bmp;
        x = xloc;
        y = yloc;
        xright = xloc + xsize;
        ybot = yloc + ysize;
        xcent = xloc + (xsize/2);
        ycent = yloc + (ysize/2);


    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(int xvel,int yvel){
        y += yvel;
        x += xvel;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getXcent(){
        return xcent;
    }
    public int getYcent(){
        return ycent;
    }
    public int getXright(){
        return xright;
    }
    public int getYbot(){
        return ybot;
    }
}
