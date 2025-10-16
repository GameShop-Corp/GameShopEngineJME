package com.mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.InputManager;
import com.jme3.input.JoyInput;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.TouchInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.control.CameraControl.ControlDirection;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture2D;
import com.mygame.gameshopengine.app.App;
//import com.mygame.app.App;
//import com.mygame.app.SuperMeshApp;
//import com.mygame.gameshopengine.app.App;
//import com.mygame.graphics.ATMS;
//import com.mygame.niftygui.StartScreenController;
//import com.mygame.supermesh.Base;
//import com.mygame.ui.Selector;
import de.lessvoid.nifty.Nifty;
//import gameshop.gameshopcorp.gameshopengine.MainActivity;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class MyGame extends SimpleApplication implements ActionListener {

    private Nifty nifty;
    
    public static void main(String[] args) {
        MyGame app = new MyGame();
        app.start();
    }

//   public Nifty nifty;
    public NiftyJmeDisplay niftyDisplay;

    public AppSettings appSettings;

    //public MainActivity mainActivity;

//    public MyGame(MainActivity mainActivity){
//        this.mainActivity = mainActivity;
//    }
    //public Screen uiScreen;


    //public float radius;
    @Override
    public void simpleInitApp() {
        this.setDisplayFps(false);
        this.setDisplayStatView(false);
        //inputManager.setSimulateMouse(true);
        appSettings = this.settings;
        //appSettings.setEmulateMouse(true);
        App myApp = new App(this);


        flyCam.setEnabled(false);

        getViewPort().setBackgroundColor(ColorRGBA.White);

        inputManager.setCursorVisible(true);
    }


    float elapsedTime = 0f;
    public boolean adLoaded = false;
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code

//        if (mainActivity.release) {
//            if (mainActivity.interstitialAd == null) {
//                elapsedTime += tpf;
//                if (elapsedTime >= 60f) {
//                    elapsedTime = 0f;
//                    mainActivity.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            mainActivity.serveAd();
//                        }
//                    });
//                }
//            } else {
//                elapsedTime = 0f;
//            }
//        }
    }

//    @Override
//    public void onAction(String string, boolean bln, float f) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public void onAction(String string, boolean bln, float f) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

