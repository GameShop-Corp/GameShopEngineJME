package com.mygame.gameshopengine.ui;

import com.jme3.math.Vector3f;

import java.util.ArrayList;

public class ArrayGeometrySelector {

    public ArrayList<GeometrySelector> array;
    public Vector3f center;

    public boolean isSelected;

    public ArrayGeometrySelector(Vector3f center){

        array = new ArrayList<>();
        this.center = center;
        isSelected = false;

    }

    public void select(){
        isSelected = true;
        for (GeometrySelector gs: array){
            gs.select();
        }
    }

    public void deselect(){
        isSelected = false;
        for (GeometrySelector gs: array){
            gs.deselect();
        }
    }

    public void setSuperLines(Vector3f where){
        for (GeometrySelector gs: array){
            gs.setSuperLine(where);
        }
    }

    public void move(Vector3f where){
        for (GeometrySelector gs: array){
            gs.move(where);
            gs.setSuperLine(gs.getWorldTranslation());
        }
    }

    public void setGeometrySelectors(Vector3f where){

        for (GeometrySelector gs: array){
            System.out.println("Last Location " + gs.getWorldTranslation());
            gs.setLocalTranslation(where);
            System.out.println("New Location " + gs.getWorldTranslation());

            gs.setSuperLine(where);
        }

    }
}
