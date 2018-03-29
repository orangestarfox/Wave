package com.example.orangestarfox.wave;

import android.content.res.Resources;
import android.graphics.Canvas;

/**
 * Created by orangestarfox on 2018/3/25.
 */

public class Planets {
    private  int n=0;
    private Planet[] planet=new Planet[100];
    public Planets(){

    }
    public void add(Planet planet0){
        if(n<100){
                    planet[n]=planet0;
                    n++;
        }
    }
    public int Count(){
        return n;
    }
    public Planet getPlanet(int i){
        return planet[i];
    }
    public void Change(Canvas c, Resources res,int G){
        for (int k=0;k<Count();k++) {
            if ( !planet[k].exist) {
                planet[k].distory(c, res);

            }
            if ( planet[k].exist) {
                for (int kk = 0; kk < Count(); kk++) {
                    if (planet[kk].exist && planet[k].exist && kk != k) {
                        planet[k].F(planet[kk].x, planet[kk].y, planet[kk].m, planet[kk].r,G);
                        if (!planet[k].exist&&planet[kk].ModelDeadBitmap!=null) {
                            planet[kk].exist = false;
                            break;
                        }
                        planet[k].move();

                    }
                }
                planet[k].show(c, res);

            }

        }
    }
}
