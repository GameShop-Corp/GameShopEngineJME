package com.mygame.gameshopengine.app;

import com.jme3.input.TouchInput;
import com.jme3.input.controls.TouchTrigger;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;
import com.mygame.MyGame;

import java.util.HashMap;

//import gameshop.gameshopcorp.gameshopengine.MyGame;
import com.mygame.gameshopengine.animation.join.SuperJoin;
import com.mygame.gameshopengine.animation.join.SuperJoinGroup;
import com.mygame.gameshopengine.gameshopui.ScreenContainer;
import com.mygame.gameshopengine.graphics.ATMS;
import com.mygame.gameshopengine.graphics.SuperMesh;
import com.mygame.gameshopengine.graphics.SuperSurface;
import com.mygame.gameshopengine.os.MakeATMS;
import com.mygame.gameshopengine.os.MakeBlueBox;
import com.mygame.gameshopengine.os.MakeGameShopUI;
import com.mygame.gameshopengine.ui.Selector;
import com.mygame.gameshopengine.ui.SelectorTouchListener;
//import gameshop.gameshopcorp.gameshopengine.MyGame;

public class App {

    public static MyGame app;
    public static HashMap<String, SuperMesh> allSuperMeshes;
    public static HashMap<String, SuperJoin> allSuperJoins;
    public static HashMap<String, SuperJoinGroup> allSuperJoinGroups;

    public static HashMap<String, ATMS> allATMS;

    public static Selector selector;

    public static ScreenContainer screenContainer;
    public static Vector2f radius;
    public static Vector4f paintColor;

    public static SuperMesh selectedSuperMesh;
    public static SuperSurface selectedSuperSurface;
//    private static App _instance;

    public App(MyGame mygame){

        app = mygame;

        allSuperMeshes = new HashMap<>();
        allSuperJoins = new HashMap<>();
        allSuperJoinGroups = new HashMap<>();
        allATMS = new HashMap<>();
        screenContainer = new ScreenContainer();
        paintColor = new Vector4f(0,0,255,128);
        radius = new Vector2f(10f, 0f);
        makeOS();

        App.app.getInputManager().addMapping("MyTouch", new TouchTrigger(TouchInput.ALL));
        App.app.getInputManager().addListener(new SelectorTouchListener(), "MyTouch");
        App.app.getInputManager().addMapping("MyTouch1", new TouchTrigger(TouchInput.ALL));
        App.app.getInputManager().addListener(new SelectorTouchListener(), "MyTouch1");

//        selector = new Selector();
    }

    public static void makeOS(){

        MakeATMS makeATMS = new MakeATMS();
        MakeBlueBox makeBlueBox = new MakeBlueBox();
        selectedSuperMesh = allSuperMeshes.get("SuperCube");
        selectedSuperSurface = selectedSuperMesh.superMesh.get("back");

        selector = new Selector();
        MakeGameShopUI makeGameShopUI = new MakeGameShopUI();

    }

//    public static App getInstance(){
//
//        if (_instance == null){
//            _instance = new App();
//        }
//        return _instance;
//    }

}
