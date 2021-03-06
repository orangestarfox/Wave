package com.example.orangestarfox.wave;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by orangestarfox on 2018/3/24.
 */

public class Planet {
    public double x,y;
    private double vx,vy;
    private double ax,ay;
    public int m;
    public int r;
    private Bitmap ModelBitmap;
    public Bitmap ModelDeadBitmap;
    public int alpha;
    public boolean exist;
    public int exp=255;
    public Planet(double x0,double y0,double vx0,double vy0,int m0,int r0,Bitmap modelBitmap,Bitmap modelDeadBitmap){

        x=x0;
        y=y0;
        vx=vx0;
        vy=vy0;
        m=m0;
        r=r0;
        ModelBitmap=modelBitmap;
        ModelDeadBitmap=modelDeadBitmap;
        exist=true;
    }
    public void show(Canvas c,Resources res){
        Paint p=new Paint();
        p.setAlpha(255);
        Rect rect=new Rect((int)(x-r),(int)(y-r),(int)(x+r),(int)(y+r));


        c.drawBitmap(   ModelBitmap,null,rect,p);

    }
    public void distory(Canvas c,Resources res){
        if(exp>0) {
            int scale = (int) (255- exp +0.2*r+0.01*m * (vx * vx + vy * vy));
            Paint p = new Paint();
            p.setAlpha(exp);
            Rect rect = new Rect((int) x - scale, (int) y - scale, (int) x + scale, (int) y + scale);

            c.drawBitmap(ModelDeadBitmap, null, rect, p);
            exp-=5;
        }
    }
    public void move(){
        x=x+vx;
        y=y+vy;
        vx=vx+ax;
        vy=vy+ay;
    }
    public void F(double X,double Y,int M,int r,int G){
       double R=(Math.pow((X-x),2)+Math.pow((Y-y),2));
       if(R<(r+this.r)*(r+this.r)&&ModelDeadBitmap!=null){
           exist=false;
       }
        double a=((double) G/1000)*(float)M/R;

        ax=a*(X-x)/Math.sqrt(R);
        ay=a*(Y-y)/Math.sqrt(R);
    }

}
