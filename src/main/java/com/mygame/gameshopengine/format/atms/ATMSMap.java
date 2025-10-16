package com.mygame.gameshopengine.format.atms;

import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.export.Savable;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;

import java.io.IOException;

import com.mygame.gameshopengine.graphics.SuperLine;

public class ATMSMap implements Savable {

    public String command;
    public SuperLine superLine;
    public Vector2f pointA;
    public Vector2f pointB;
    public short radius;
    public Vector4f color;
    
    public ATMSMap(){
        
    }
    
    public ATMSMap(String command, SuperLine superLine, short radius, Vector4f color){
        
        this.command = new String(command);
        this.superLine = superLine;
        this.radius = radius;
        this.color = color;
    }
    
    public ATMSMap(String command, Vector2f pointA, short radius, Vector4f color){
        
        this.command = command;
        this.pointA = pointA;
        this.radius = radius;
        this.color = color;
    }
    
        public ATMSMap(String command, Vector2f pointA,Vector2f pointB, short radius, Vector4f color){
        
        this.command = command;
        this.pointA = pointA;
        this.pointB = pointB;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void write(JmeExporter jmeExporter) throws IOException {

        OutputCapsule capsule = jmeExporter.getCapsule(this);

        if (command.equals("drawCircle")){

            capsule.write(command, "command", "");
            capsule.write(pointA, "pointA",new Vector2f());
            capsule.write(radius, "radius", 0);
            capsule.write(color, "color", new Vector4f());
            
        } else if (command.equals("drawSquare")){

            capsule.write(command, "command", "");
            capsule.write(pointA, "pointA",new Vector2f());
            capsule.write(radius, "radius", 0);
            capsule.write(color, "color", new Vector4f());
            
        } else if (command.equals("drawLine")){

            capsule.write(command, "command", "");
            capsule.write(pointA, "pointA",new Vector2f());
            capsule.write(pointB, "pointB",new Vector2f());
            capsule.write(radius, "radius", 0);
            capsule.write(color, "color", new Vector4f());

        } else if (command.equals("drawSuperLine")){

            capsule.write(command, "command", "");
            capsule.write(superLine.points[0], "pointA",new Vector2f());
            capsule.write(superLine.points[1], "pointB",new Vector2f());
            capsule.write(superLine.points[2], "pointC", new Vector2f());
            capsule.write(superLine.points[3], "pointD", new Vector2f());
            capsule.write(superLine.numPoints, "numPoints", 0);
            capsule.write(radius, "radius", 0);
            capsule.write(color, "color", new Vector4f());

               
        }

    }

    @Override
    public void read(JmeImporter jmeImporter) throws IOException {

        InputCapsule capsule = jmeImporter.getCapsule(this);

        command = capsule.readString("command", "");

        if (command.equals("drawCircle")){
            
            pointA = (Vector2f) capsule.readSavable("pointA", new Vector2f());
            radius = capsule.readShort("radius", (short) 0);
            color = (Vector4f) capsule.readSavable("color", new Vector4f());
        
        } else if (command.equals("drawSquare")){
            
            pointA = (Vector2f) capsule.readSavable("pointA", new Vector2f());
            radius = capsule.readShort("radius", (short) 0);
            color = (Vector4f) capsule.readSavable("color", new Vector4f());
        
        } else if (command.equals("drawLine")){
            
            pointA = (Vector2f) capsule.readSavable("pointA", new Vector2f());
            pointB = (Vector2f) capsule.readSavable("pointB", new Vector2f());
            radius = capsule.readShort("radius", (short) 0);
            color = (Vector4f) capsule.readSavable("color", new Vector4f());
        
        } else if (command.equals("drawSuperLine")){

            Vector2f pointA = (Vector2f) capsule.readSavable("pointA", new Vector2f());
            Vector2f pointB = (Vector2f) capsule.readSavable("pointB", new Vector2f());
            Vector2f pointC = (Vector2f) capsule.readSavable("pointC", new Vector2f());
            Vector2f pointD = (Vector2f) capsule.readSavable("pointD", new Vector2f());
            int numPoints = capsule.readInt("numPoints", 0);

            superLine = new SuperLine(new Vector3f[]{new Vector3f(pointA.x, pointA.y, 0), new Vector3f(pointB.x, pointB.y, 0), new Vector3f(pointC.x, pointC.y, 0), new Vector3f(pointD.x, pointD.y, 0)}, numPoints);

            radius = capsule.readShort("radius", (short) 0);
            color = (Vector4f) capsule.readSavable("color", new Vector4f());
        
        }
    }
}
