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
import com.jme3.math.Vector4f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.texture.Texture2D;
import com.mygame.app.App;
import com.mygame.app.SuperMeshApp;
import com.mygame.graphics.ATMS;
import com.mygame.niftygui.StartScreenController;
import com.mygame.supermesh.Base;
import com.mygame.ui.Selector;
import de.lessvoid.nifty.Nifty;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    private Nifty nifty;
    
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        App.getInstance().app = this;
        reportMemory();
 
        //InputManager ipm = new InputManager(new MouseInput(), new KeyInput(),new JoyInput(), new TouchInput());

        Base base = new Base(7, new Vector4f(255,255,255,255));
        SuperMeshApp.getInstance().superMeshes.put("base", base.superMesh);
         
        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
                assetManager,
                null,
                audioRenderer,
                guiViewPort);
        nifty = niftyDisplay.getNifty();
        nifty.loadStyleFile("nifty-default-styles.xml");
        nifty.loadControlFile("nifty-default-controls.xml");
        StartScreenController startScreen = new StartScreenController(this);
        nifty.fromXml("Interface/Nifty/HelloGameShop.xml", "start", startScreen);
        
        // attach the nifty display to the gui view port as a processor
        guiViewPort.addProcessor(niftyDisplay);
        
        // disable the fly cam
        flyCam.setEnabled(true);
        //flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
         
        Selector selector = new Selector(base.superMesh, base.superMesh.superMesh.get("front"), 0,0);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
        public void reportMemory(){
        
                long maxMemory = Runtime.getRuntime().maxMemory();
                long allocatedMemory = Runtime.getRuntime().totalMemory();
                long freeMemory = Runtime.getRuntime().freeMemory();
                
                System.out.println("max: " + maxMemory);
                System.out.println("allocated: " + allocatedMemory);
                System.out.println("free: " + freeMemory);
        }
        
        private void setUpKeys() {
    inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
    inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
    inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
    inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
    inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
    inputManager.addListener(analogListener, "Left");
    inputManager.addListener(analogListener, "Right");
    inputManager.addListener(analogListener, "Forward");
    inputManager.addListener(analogListener, "Backward");
     
}
        
           private final ActionListener actionListener = new ActionListener() {
        @Override
        public void onAction(String name, boolean keyPressed, float tpf) {
//            if (name.equals("Pause") && !keyPressed) {
//                isRunning = !isRunning;
//            }
        }
    };

    private final AnalogListener analogListener = new AnalogListener() {
        @Override
        public void onAnalog(String name, float value, float tpf) {
            if (name.equals("Forward")){
            
            
               // cam.get
            }
        }
    };
}

