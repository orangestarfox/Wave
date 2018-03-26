package com.example.orangestarfox.wave;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Graph extends AppCompatActivity implements OnTouchListener {
    public static int n=0;

    private  Resources res;
    private float xDown=0,yDown=0,xUp=0,yUp=0;
    public static Planet planet;
    public static int[] stars;
    public static Planets planets;
    public static Bitmap[] bitmaps=new Bitmap[6];
    class MyThread extends Thread {
        private SurfaceHolder holder;
        private boolean isRun = true;
        private MyThread(SurfaceHolder holder) {
            this.holder = holder;
        }


        public void run() {
            while (this.isRun) {
                try {
                    Canvas c;
                    synchronized (this.holder) {

                        c = this.holder.lockCanvas();
                        c.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

                        Paint p = new Paint();

                        p.setColor(stars[2]);
                        int a=c.getWidth();
                        int b=c.getHeight();
                        if(planets.Count()==0){

                            planet=new Planet((double)a/stars[3],(double) b/stars[4],0,0,stars[0],stars[1],R.drawable.pic2,123456);
                            planets.add(planet);
                            planet.show(c,res);
                        }
                        Rect rect=new Rect(0,0,a,b);
                        c.drawColor(0);
                        if(planets.Count()>1){
                            planets.Change(c,res);
                      }
                    }

                    if (c != null) {
                        this.holder.unlockCanvasAndPost(c);
                    }
                } catch (Exception e) {
                    try {
                        e.printStackTrace();
                        if (null != null) {
                            this.holder.unlockCanvasAndPost(null);
                        }
                    } catch (Throwable th) {
                        if (null != null) {
                            this.holder.unlockCanvasAndPost(null);
                        }
                    }
                }
            }
        }
    }

    class MyView extends SurfaceView implements Callback {
        private SurfaceHolder holder = getHolder();
        private MyThread myThread;

        public MyView(Context context) {
            super(context);
            this.holder.addCallback(this);
            this.myThread = new MyThread(this.holder);
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }

        public void surfaceCreated(SurfaceHolder holder) {
            this.myThread.isRun = true;
            this.myThread.start();
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            this.myThread.isRun = false;

        }
    }
    @Override
public void onBackPressed(){
        Intent intent = getIntent();
        setResult(RESULT_OK, intent);
        finish();
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView v = new MyView(this);
        setContentView(v);
        v.setOnTouchListener(this);
        planets=new Planets();
        Intent intent=getIntent();
        stars=intent.getIntArrayExtra("stars");
        res=getResources();
      //  Toast.makeText(this,String.valueOf(stars[1]),Toast.LENGTH_LONG).show();


    }

    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN /*0*/:
                 xDown = event.getX();
                 yDown = event.getY();
                break;
            case  MotionEvent.ACTION_UP /*pic*/:
                 xUp = event.getX();
                 yUp = event.getY();
                planet=new Planet(xDown,yDown,(xUp-xDown)/500,(yUp-yDown)/500,70,10,R.drawable.pic3,R.drawable.pic12);
                n++;
                planets.add(planet);
                break;


        }

        return true;
    }


}
