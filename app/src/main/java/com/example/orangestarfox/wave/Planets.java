package com.example.orangestarfox.wave;

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
}
