package com.mygame.gameshopengine.format.atms;

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.export.Savable;

import java.io.IOException;
import java.util.ArrayList;

public class ATMSCanvas implements Savable {

    public ArrayList<ATMSArray> atmsArrays;

    public ATMSCanvas(){

        atmsArrays = new ArrayList<>();
        atmsArrays.add(new ATMSArray());
    }
    @Override
    public void write(JmeExporter jmeExporter) throws IOException {
        OutputCapsule capsule = jmeExporter.getCapsule(this);

        capsule.writeSavableArrayList(atmsArrays,"ATMSArray", new ArrayList<ATMSArray>());

    }

    @Override
    public void read(JmeImporter jmeImporter) throws IOException {
        InputCapsule capsule = jmeImporter.getCapsule(this);

        atmsArrays = capsule.readSavableArrayList("ATMSArray", new ArrayList<ATMSArray>());
    }
}
