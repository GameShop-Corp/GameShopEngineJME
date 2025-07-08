/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.ui;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture2D;
import com.mygame.app.App;
import com.mygame.graphics.SuperLine;
import com.mygame.graphics.SuperMesh;
import com.mygame.graphics.SuperSurface;

/**
 *
 * @author gameshopengine
 */
public class Selector {
    
    public SuperMesh selectedMesh;
    public SuperSurface selectedSurf;
    public int selectedLine;
    public int selectedVector;
    
    public Selector(SuperMesh sm, SuperSurface ss, int sl, int sv){
    
        this.selectedMesh = sm;
        this.selectedSurf = ss;
        this.selectedLine = sl;
        this.selectedVector = sv;
        
        System.out.println(ss.width);

        Box b = new Box((ss.width + ss.height)/200,(ss.width + ss.height)/200,(ss.width + ss.height)/200);
        Geometry geom = new Geometry("Box", b);
 
        Material mat = new Material(App.getInstance().app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
       // mat.setTexture("ColorMap", new Texture2D(atms.makeATMS()));
        geom.setMaterial(mat);
        Vector3f position = new Vector3f(sm.superMesh.get("front").currencyLines[sl].points[sv]);
        geom.setLocalTranslation(position);
        App.getInstance().app.getRootNode().attachChild(geom);
        
    }
}
