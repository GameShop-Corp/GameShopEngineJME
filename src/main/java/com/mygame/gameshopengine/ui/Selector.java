package com.mygame.gameshopengine.ui;

import com.mygame.gameshopengine.app.App;
//import gameshop.gameshopcorp.gameshopengine.app.AppSuperMesh;
import com.mygame.gameshopengine.graphics.SuperLine;
import com.mygame.gameshopengine.graphics.SuperMesh;
import com.mygame.gameshopengine.graphics.SuperSurface;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

import java.util.ArrayList;
import java.util.HashMap;

public class Selector {

    public ArrayList<ArrayGeometrySelector> geometrySelectors;
    public static ArrayList<ArrayGeometrySelector> selected;
    public static ArrayList<GeometryMover> geometryMovers;

    public static GeometryMover mover;
    public static GeometryScaler geometryScaler;
    public static Node moveNode;
    public static Node selectedNode;
    public static Vector3f center;
    public static Node geometrySelectorsNode;

    public static Vector3f delta;
    public Selector() {

        mover = new GeometryMover();
        geometrySelectorsNode = new Node("Geometry Selectors");
        moveNode = new Node("Move");
        selectedNode = new Node("SelectedNode");
        selected = new ArrayList<>();
        geometrySelectors = new ArrayList<>();
        geometryMovers = new ArrayList<>();
        geometryScaler = new GeometryScaler();
        Box b = new Box(.1f, .1f, .1f);
        //gs.setName("Box" + sm + s + sl + v);
        geometryScaler.setMesh(b);
        geometryScaler.deselect();
        geometryScaler.setName("Scaler");

        delta = new Vector3f();
//        selectorNode = new Node("Selector");
//        moveNode = new Node("Mover");
//        scaleNode = new Node("Scaler");
        // Set up touch input

//        App.app.getInputManager().addMapping("MyTouch1", new TouchTrigger(TouchInput.ALL));
//        App.app.getInputManager().addListener(this, "MyTouch1");


        populateGeometrySelectors();



    }

    public void populateGeometrySelectors(){

//        ArrayGeometrySelector ags = new ArrayGeometrySelector();
//
//        geometrySelectors.add(ags);
        HashMap<ArrayGeometrySelector, Vector3f> map = new HashMap<>();

        for (SuperMesh sm: App.allSuperMeshes.values()){
            for (SuperSurface s: sm.superMesh.values()){
                byte row = 0;
                for (SuperLine sl: s.currencyLines){
                    byte column = 0;
                    for (Vector3f v: sl.points){
                        ArrayGeometrySelector ags = new ArrayGeometrySelector(v);
                        for (ArrayGeometrySelector ag: geometrySelectors){
                            if (ag.center.equals(v)){
                                ags = ag;
                                break;
                            }
                        }

                        GeometrySelector gs = new GeometrySelector(s, row, column, ags);

                        Box b = new Box(.1f, .1f, .1f);
                        gs.setName("Box" + sm + s + sl + v);
                        gs.setMesh(b);

                        gs.deselect();
                        gs.setLocalTranslation(v);

//                        boolean hasDuplicate = false;
//                      //  ags.array.add(gs);
//
//                        ArrayGeometrySelector select = null;
//                        for (ArrayGeometrySelector selector: geometrySelectors){
//                            for (GeometrySelector g: selector.array){
//                                if (g.getWorldTranslation().equals(gs.getWorldTranslation())){
//                                    //selector.array.add(gs);
//                                    select = selector;
//                                    hasDuplicate = true;
//                                }
//                            }
//                        }

                        //if (!hasDuplicate){
                            ags.array.add(gs);
                            geometrySelectors.add(ags);
                            geometrySelectorsNode.attachChild(gs);
//                        } else {
//                            select.array.add(gs);
//
//                        }

                        column++;
                       // geometrySelectors.add(ags);
                    }
                    row++;
                }

            }
        }

        //for (ArrayGeometrySelector ags: geometrySelectors){
          //  for (GeometrySelector gs: ags.array){
                App.app.getRootNode().attachChild(geometrySelectorsNode);
           // }
        //}

//        for (ArrayGeometrySelector ags: geometrySelectors){
//         System.out.println("Center " + ags.center);
//         System.out.println("Size " + ags.array.size());
//         for (GeometrySelector gs: ags.array){
//             System.out.println("Location " + gs.getWorldTranslation());
//         }
//        }
        //System.out.println("SIZE " + geometrySelectors.size());
      //  mergeGeometrySelectorArrays();


    }

    public void populateMovers(){

        center = new Vector3f();
        int d = 0;
        for (ArrayGeometrySelector ags: selected){
            center = center.add(ags.array.get(0).getWorldTranslation());
        d++;
        }
        if (d > 0) {
           center = center.divide(d);
        }
        moveNode.setLocalTranslation(center);
        if (geometryMovers.isEmpty()) {
            for (int i = 0; i < 6; i++) {
                GeometryMover geom = new GeometryMover();
                Box b = new Box(.1f, .1f, .1f);
                //gs.setName("Box" + sm + s + sl + v);
                geom.setMesh(b);
                geom.deselect();

                if (i == 0) { //up
                    //moverDirection = "up";
                    //geom.moveDirection = "up";
                    geom.setName("Mover" + "Up");
                    geom.setLocalTranslation((new Vector3f(0, .33f, 0f)));
                } else if (i == 1) { //down
                    //moverDirection = "down";
                    // geom.moveDirection = "up";
                    geom.setName("Mover" + "Down");
                    geom.setLocalTranslation((new Vector3f(0, -.33f, 0f)));
                } else if (i == 2) { //left
                    // moverDirection = "left";
                    geom.setName("Mover" + "Left");
                    geom.setLocalTranslation((new Vector3f(-.33f, 0, 0f)));

                } else if (i == 3) {
                    geom.setName("Mover" + "Right");
                    // moverDirection = "right";
                    geom.setLocalTranslation((new Vector3f(.33f, 0, 0f)));

                } else if (i == 4) {//front
                    //moverDirection = "front";
                    geom.setName("Mover" + "Front");
                    geom.setLocalTranslation((new Vector3f(0, 0, .33f)));

                } else if (i == 5) {
                    //moverDirection = "down";
                    geom.setName("Mover" + "Back");
                    geom.setLocalTranslation((new Vector3f(0, 0, -.33f)));

                }
                geometryMovers.add(geom);
                moveNode.attachChild(geom);
            }
        }
        //App.app.getRootNode().attachChild(moveNode);
        geometrySelectorsNode.attachChild(moveNode);
        //App.app.getRootNode().attachChild(moveNode);

    }

    public void makeScaler(){

        geometryScaler.setLocalTranslation(moveNode.getWorldTranslation().add(-1,1,-1));
       if(!App.app.getRootNode().hasChild(geometryScaler)) {
           //App.app.getRootNode().attachChild(geometryScaler);
           geometrySelectorsNode.attachChild(geometryScaler);
       }
    }
//        for ()

    public void hideSelectors(){
        //clearMovers();
        App.app.getRootNode().detachChild(geometrySelectorsNode);
    }

    public void showSelectors(){
        App.app.getRootNode().attachChild(geometrySelectorsNode);

    }
    public void clearMovers(){

        resetMovers();

            geometrySelectorsNode.detachChild(moveNode);
            //geometryMovers.clear();
       // }
    }

    public void resetMovers(){
        for (GeometryMover g: geometryMovers) {
            g.deselect();
        }
        mover.deselect();

    }

    public void hideScaler(){
        geometrySelectorsNode.detachChild(geometryScaler);
    }

    public void showScaler(){
        geometrySelectorsNode.attachChild(geometryScaler);
    }


    public void resetSelectors(){

        hideScaler();
        clearMovers();
        for (ArrayGeometrySelector ags: selected){
            for (GeometrySelector gs: ags.array){
                gs.deselect();
            }
        }
        selected.clear();
    }


    public void addSelectors(GeometrySelector add){

//        for (ArrayGeometrySelector ags: geometrySelectors){
//            if (ags.array.contains(add)){
//                ags.select();
//        for (ArrayGeometrySelector ags: selected){
//            if (ags.equals(add.ags)){
//                ags.select();
//                selected.add(ags);
//                break;
//            }
//        }
//                add.ags.select();

                if (!add.ags.isSelected) {
                    add.ags.select();

                    selected.add(add.ags);
                }
        System.out.println("Center " + add.ags.center);
         System.out.println("Size " + add.ags.array.size());
         for (GeometrySelector gs: add.ags.array){
             System.out.println("Location " + gs.getWorldTranslation());
         }
         //   }
       // }
        System.out.println("Selected " + selected.size());
    }


//    public void addToSelectedNode(){
//
//        //removeFromMoveNode();
//        for (ArrayGeometrySelector ags: selected){
//
//            for (GeometrySelector gs: ags.array) {
//               // gs.removeFromParent();
//               // App.app.getRootNode().detachChild(gs);
//               // gs.move(moveNode.getWorldTranslation().mult(-1));
//                selectedNode.attachChild(gs);
//            }
//        }
//       // moveAndSelectorsNode.attachChild(moveNode);
//        geometrySelectorsNode.attachChild(selectedNode);
//
//    }

//    public void removeFromMoveNode(){
//        for (ArrayGeometrySelector ags: selected){
//
//            for (GeometrySelector gs: ags.array) {
//                selectedNode.detachChild(gs);
//            }
//        }
//    }


    public void moveAllSelectedPoints(){

        //Vector3f cDelta = delta;

        System.out.println("Selected " + selected.size());
        for (ArrayGeometrySelector ags: selected){

            System.out.println("Delta " + delta);
          ags.move(delta);
          //delta = new Vector3f(delta);
            }
        delta = new Vector3f();
        for (SuperMesh sm: App.allSuperMeshes.values()){
            for (SuperSurface s: sm.superMesh.values()){
                s.updateSimpleMeshes();
            }
        }

    }

    public void moveAllSelectedPointsRelativeToCenter(){

        Vector3f startingPoint = moveNode.getWorldTranslation().add(-1,1,-1);
        if (startingPoint.distance(geometryScaler.getWorldTranslation()) > 0.01f) {
            Vector3f totalPercentage = new Vector3f((startingPoint).subtract((geometryScaler.getWorldTranslation())));
            //Vector3f totalPercentage = new Vector3f((center.add(geometryScaler.getWorldTranslation()).divide(((center.add(-1,1,-1))))));

            totalPercentage = totalPercentage.mult(1, -1, 1);

           // System.out.println("TOTAL PERCENTAGE " + totalPercentage);
            for (ArrayGeometrySelector ags : selected) {
                //ags.setGeometrySelectors();


//                Vector3f distanceFromCenter = g.getLocalTranslatinslation().add(center);
                Vector3f total = new Vector3f(ags.array.get(0).getWorldTranslation().subtract(moveNode.getWorldTranslation())).mult(totalPercentage);
                // totalPercentage = totalPercentage.mult(-1);
              //  total = new Vector3f(total.x, total.y, total.z * -1f);
                //ags.setGeometrySelectors(ags.array.get(0).getWorldTranslation().add(total));

                ags.move(total);
            }


        }

    }



    String first = "";

}

