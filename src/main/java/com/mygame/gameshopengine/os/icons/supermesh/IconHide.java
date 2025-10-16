package com.mygame.gameshopengine.os.icons.supermesh;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

import com.mygame.gameshopengine.graphics.ATMS;

public class IconHide {

    public ATMS icon;

    public IconHide(){

        icon = new ATMS("Hide", 100,100);
        icon.layer.drawLine(new Vector2f(20, 80), new Vector2f(20, 20), (short) 1, new Vector4f(0,0,255,255));
        icon.layer.drawLine(new Vector2f(20, 20), new Vector2f(80, 20), (short) 1, new Vector4f(0,0,255,255));

        icon.layer.drawLine(new Vector2f(80, 20), new Vector2f(80, 80), (short) 1, new Vector4f(0,0,255,255));
        icon.layer.drawLine(new Vector2f(20, 80), new Vector2f(80, 80), (short) 1, new Vector4f(0,0,255,255));

    }
}
