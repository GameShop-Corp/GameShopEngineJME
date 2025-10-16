package com.mygame.gameshopengine.os;

import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.Node;
import com.jme3.texture.Texture2D;

import com.mygame.gameshopengine.app.App;
import com.mygame.gameshopengine.graphics.ATMS;
import com.mygame.gameshopengine.supermesh.SuperCube;
import com.mygame.gameshopengine.supermesh.SuperSquare;

public class MakeBlueBox {

    public MakeBlueBox(){

        ATMS atmsTop = new ATMS("ATMSBlueBoxTop", 256, 256);
        atmsTop.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsBottom = new ATMS("ATMSBlueBoxBottom", 256, 256);
        atmsBottom.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsFront = new ATMS("ATMSBlueBoxFront", 256, 256);
        atmsFront.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsBack = new ATMS("ATMSBlueBoxBack", 256, 256);
        atmsBack.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsLeft = new ATMS("ATMSBlueBoxLeft", 256, 256);
        atmsLeft.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));
        ATMS atmsRight = new ATMS("ATMSBlueBoxRight", 256, 256);
        atmsRight.layer.drawCircle(128,128,256, new Vector4f(0,0,255,128));

        Texture2D tex = (Texture2D) App.app.getAssetManager().loadTexture("Textures/Rune.jpeg");


        SuperSquare top = new SuperSquare("Display", atmsTop, new Node("UI"), 8, new Vector3f(-3,3,-3), new Vector3f(3,3,-3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );

        SuperSquare bottom = new SuperSquare("Display", atmsBottom, new Node("UI"), 8, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(3,-3,3), null );

        SuperSquare front = new SuperSquare("Display", atmsFront, new Node("UI"), 8, new Vector3f(-3,-3,3), new Vector3f(3,-3,3), new Vector3f(-3,3,3), new Vector3f(3,3,3), null );

        SuperSquare back = new SuperSquare("Display", atmsBack, new Node("UI"), 8, new Vector3f(-3,-3,-3), new Vector3f(3,-3,-3), new Vector3f(-3,3,-3), new Vector3f(3,3,-3), null );

        SuperSquare left = new SuperSquare("Display", atmsLeft, new Node("UI"), 8, new Vector3f(-3,-3,-3), new Vector3f(-3,-3,3), new Vector3f(-3,3,-3), new Vector3f(-3,3,3), null );

        SuperSquare right = new SuperSquare("Display", atmsRight, new Node("UI"), 8, new Vector3f(3,-3,-3), new Vector3f(3,-3,3), new Vector3f(3,3,-3), new Vector3f(3,3,3), null );

        SuperCube superCube = new SuperCube(top, bottom, front, back, left, right);

        App.allSuperMeshes.put("SuperCube", superCube.superMesh);

    }
}
