package com.mygame.gameshopengine.graphics;

import com.jme3.texture.Image;
import com.jme3.texture.image.ColorSpace;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import com.mygame.gameshopengine.app.App;
import com.mygame.gameshopengine.format.atms.ATMSFrame;
import com.mygame.gameshopengine.format.atms.Parser;

public class ATMS {

    public int width;
    public int height;
    public Layer layer;
    public String name;
    public Parser parser;

    public ArrayList<ATMSFrame> frames;

    public ATMS(String name, int width, int height){

        ATMSFrame frame = new ATMSFrame();
       // frame.atmsLayers.get(0).name = "Default";
        this.frames = new ArrayList<>();
        this.frames.add(frame);
        this.parser = new Parser(this, frames);
        this.name = name;
        //this.name = name;
        this.width = width;
        this.height = height;
        this.layer = new Layer(width, height);

        App.allATMS.put(name, this);
    }

//    public ATMS (ATMS clone){
//
//        this.name = clone.name;
//        this.width = clone.width;
//        this.height = clone.height;
//        this.layer = clone.layer;
//    }

    public Image makeATMS(){

//        if (texture2D != null){
//
//            return texture2D.getImage();
//        }
        ArrayList<ByteBuffer> pixels = new ArrayList<>();
        ByteBuffer pixel = ByteBuffer.allocateDirect(width * height *4);
        pixel.put(layer.outputLayer());
        pixels.add(pixel);
        return new Image(Image.Format.RGBA8, width, height, 8, pixels, ColorSpace.Linear);
    }


    public ATMS copy()  {

        ATMS clone = new ATMS(name, width, height);
        //clone.layer = new Layer(width, height);
        clone.layer = layer.copy();
        return clone;
    }

}
