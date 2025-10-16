package com.mygame.gameshopengine.format.atms;

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.export.Savable;

import java.io.IOException;
import java.util.ArrayList;

public class ATMSLayer implements Savable {

    public ArrayList<ATMSCanvas> atmsCanvases;
    public String name;
    public ATMSLayer(){
        
        
        atmsCanvases = new ArrayList<>();
    }
    
    public ATMSLayer(String name){
        
        this.name = name;
        atmsCanvases = new ArrayList<>();
        atmsCanvases.add(new ATMSCanvas());
    }
    @Override
    public void write(JmeExporter jmeExporter) throws IOException {
        OutputCapsule capsule = jmeExporter.getCapsule(this);
        capsule.write(name ,"name", "");
        capsule.writeSavableArrayList(atmsCanvases, "ATMSCanvas", new ArrayList<ATMSCanvas>());
    }

    @Override
    public void read(JmeImporter jmeImporter) throws IOException {
        InputCapsule capsule = jmeImporter.getCapsule(this);
        name = capsule.readString("name", "");
        atmsCanvases = capsule.readSavableArrayList("ATMSCanvas", new ArrayList<ATMSCanvas>());
    }
}
