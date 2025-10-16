package com.mygame.gameshopengine.utility;

public class Clamp {

    public Clamp(){

    }

    public static float clamp(float start, float end, float percentage){

        float increase = (end - start)/100;

        return start + (percentage * increase);
    }
}
