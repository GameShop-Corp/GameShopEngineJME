package com.mygame.gameshopengine.os.icons.supermesh;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

import com.mygame.gameshopengine.graphics.ATMS;

public class IconShow {

    public ATMS icon;
    public IconShow(){

        icon = new ATMS("Reset", 100,100);
        icon.layer.drawLine(new Vector2f(20, 80), new Vector2f(20, 20), (short) 1, new Vector4f(0,0,255,255));
        icon.layer.drawLine(new Vector2f(20, 20), new Vector2f(80, 20), (short) 1, new Vector4f(0,0,255,255));

        icon.layer.drawLine(new Vector2f(80, 20), new Vector2f(80, 80), (short) 1, new Vector4f(0,0,255,255));
        icon.layer.drawLine(new Vector2f(20, 80), new Vector2f(80, 80), (short) 1, new Vector4f(0,0,255,255));

        icon.layer.drawSquare(20, 80,  (short) 5, new Vector4f(255,0,0,255));
        icon.layer.drawSquare( 20, 20,  (short) 5, new Vector4f(255,0,0,255));

        icon.layer.drawSquare( 80, 20,  (short) 5, new Vector4f(255,0,0,255));
        icon.layer.drawSquare( 80, 80, (short) 5, new Vector4f(255,0,0,255));

    }
}
