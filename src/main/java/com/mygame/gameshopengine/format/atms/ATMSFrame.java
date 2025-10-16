package com.mygame.gameshopengine.format.atms;

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.export.Savable;

import java.io.IOException;
import java.util.ArrayList;

public class ATMSFrame implements Savable{

    public ArrayList<ATMSLayer> atmsLayers;
    public ATMSFrame(){
        atmsLayers = new ArrayList<>();
        atmsLayers.add(new ATMSLayer("Default"));
    }
    @Override
    public void write(JmeExporter jmeExporter) throws IOException {
        OutputCapsule capsule = jmeExporter.getCapsule(this);
        capsule.writeSavableArrayList(atmsLayers, "ATMSLayer", new ArrayList<ATMSLayer>());
    }

    @Override
    public void read(JmeImporter jmeImporter) throws IOException {
        InputCapsule capsule = jmeImporter.getCapsule(this);
        capsule.readSavableArrayList("ATMSLayer", new ArrayList<ATMSLayer>());

    }
}
