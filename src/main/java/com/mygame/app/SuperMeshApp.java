/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.app;

//import com.jme3.app.SimpleApplication;
import com.mygame.graphics.SuperMesh;
import java.util.HashMap;

/**
 *
 * @author gameshopengine
 */
public class SuperMeshApp {
    
    public HashMap<String, SuperMesh> superMeshes;
    private static SuperMeshApp _instance;

    private SuperMeshApp(){

        superMeshes = new HashMap<>();
    }

    public static SuperMeshApp getInstance(){

        if (_instance == null){
            _instance = new SuperMeshApp();
        }
        return _instance;
    }
}
