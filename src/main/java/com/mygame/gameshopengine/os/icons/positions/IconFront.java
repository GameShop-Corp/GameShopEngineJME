package com.mygame.gameshopengine.os.icons.positions;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

import com.mygame.gameshopengine.graphics.ATMS;

public class IconFront {

    public ATMS icon;

    public IconFront(){

        icon = new ATMS("Front", 100,100);
        icon.layer.drawLine(new Vector2f(20, 80), new Vector2f(20, 20), (short) 1, new Vector4f(255,255,255,255));
        icon.layer.drawLine(new Vector2f(20, 20), new Vector2f(80, 20), (short) 1, new Vector4f(255,255,255,255));

        icon.layer.drawLine(new Vector2f(80, 20), new Vector2f(80, 80), (short) 1, new Vector4f(255,255,255,255));
        icon.layer.drawLine(new Vector2f(20, 80), new Vector2f(80, 80), (short) 1, new Vector4f(255,255,255,255));

        icon.layer.drawCircle(50,50,15,new Vector4f(0,0,255,255));

    }
}
