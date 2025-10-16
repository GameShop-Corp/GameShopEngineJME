package com.mygame.gameshopengine.format.atms;

import java.util.ArrayList;

import com.mygame.gameshopengine.graphics.ATMS;

public class Parser {

    public ArrayList<ATMSFrame> atmsFrames;
    public ATMS atms;
    public Parser(ATMS atms, ArrayList<ATMSFrame> atmsFrames){

        this.atms = atms;
       this.atmsFrames = atmsFrames;
    }

    public void draw(){

        for (ATMSFrame frame: atmsFrames){
            for (ATMSLayer layer: frame.atmsLayers){
                for (ATMSCanvas canvas: layer.atmsCanvases){
                    for (ATMSArray array: canvas.atmsArrays){
                        for (ATMSMap map: array.atmsMaps){

                            if (map.command.equals("drawCircle")){

                                atms.layer.drawCircle((int) map.pointA.x, (int) map.pointA.y, map.radius, map.color);

                            } else if (map.command.equals("drawSquare")){

                                atms.layer.drawSquare((int) map.pointA.x, (int) map.pointA.y, map.radius, map.color);

                            } else if (map.command.equals("drawLine")){

                                atms.layer.drawLine(map.pointA, map.pointB, map.radius, map.color);

                            } else if (map.command.equals("drawSuperLine")){

                                atms.layer.drawSuperLine(map.superLine, map.radius, map.color);

                            }
                        }
                    }
                }
            }

        }

    }
}
