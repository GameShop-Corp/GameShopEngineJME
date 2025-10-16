package com.mygame.gameshopengine.ui;

import static com.mygame.gameshopengine.ui.Selector.geometryScaler;
import static com.mygame.gameshopengine.ui.Selector.moveNode;
import static com.mygame.gameshopengine.ui.Selector.mover;
import static com.mygame.gameshopengine.ui.Selector.selected;
import static com.mygame.gameshopengine.ui.Selector.delta;
import com.jme3.collision.CollisionResults;
import com.jme3.input.controls.TouchListener;
import com.jme3.input.event.TouchEvent;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

import com.mygame.gameshopengine.app.App;

public class SelectorTouchListener implements TouchListener {

    //public int lastEventPointer = -1;

    public static int lastEventPointer = -1;

    public SelectorTouchListener(){
      //  this.lastEventPointer = lastEventPointer;
    }

    @Override
    public void onTouch(String name, TouchEvent event, float tpf) {


//                  if (lastEventPointer == -1) {
//           // if (lastEventPointer != event.getPointerId()) {
//                lastEventPointer = event.getPointerId();
//                      //event.setPointerId(lastEventPointer);
//           // }
//        }

//                  if (lastEventPointer == 0){
//                      lastEventPointer = 1;
//                  } else if (lastEventPointer == 1){
//                      lastEventPointer = 0;
//                  }


       // System.out.println("Event Pointer " + event.getPointerId());

        touch(name, event, tpf);
//        if (lastTouch.equals("")){
//            lastTouch = name;
//        } else {
//            if (!lastTouch.equals(name)){
//                touch(lastTouch, event, tpf);
//            }
//        }
//        if (event.getX() > 960){
//            event.setPointerId(1);
//        } else {
//            event.setPointerId(0);
//        }

//        if (event.getPointerId() == 0) {
//            touch("MyTouch", event, tpf);
//        }
//        if (event.getPointerId() == 1) {
//            touch("MyTouch1", event, tpf);
//        }
//        } else {
//
//            touch("MyTouch1", event, tpf);
//        }
//        if ( event.getPointerId() == 0) {
//            touch(name, event, tpf);
//            first = name;
//        }
//        if (event.getPointerId() == 1){
//            if (first.equals("MyTouch")) {
//                touch("MyTouch1", event, tpf);
//            } else if (first.equals("MyTouch1")){
//
//                touch("MyTouch", event, tpf);
//            }
//        }

    }



    public void touch(String name, TouchEvent event, float tpf){
        switch (event.getType()) {
            case DOWN:


                // Handle touch down event
               // System.out.println("Touch Down at: " + event.getX() + ", " + event.getY());
                // Example: Check if a game object was touched
                // Vector2f touchPoint = new Vector2f(event.getX(), event.getY());
                // CollisionResults results = new CollisionResults();
                // Ray ray = cam.get:**WorldCoordinates**(touchPoint, 0f).clone();
                // ... (rest of your picking logic)
                break;
            case UP:



                Vector2f release2d = App.app.getInputManager().getCursorPosition();
                App.screenContainer.release(release2d);
//                    for (SuperMesh s: AppSuperMesh.superMeshes.values()){
//                        s.update();
//                    }
//                    if (!movers.isEmpty()) {
                if (App.screenContainer.selectedScreen.equals("uiScreen")) {

                    if (geometryScaler.selected) {
                       App.selector.moveAllSelectedPointsRelativeToCenter();
                       // App.selector.moveAllSelectedPoints();
                        geometryScaler.deselect();
                        App.selector.makeScaler();
                    }
                    if (!selected.isEmpty()) {
                        App.selector.moveAllSelectedPoints();
                      //  App.selector.removeFromMoveNode();
//                        App.selector.moveAllSelectedPoints();
                        if (selected.size() > 1) {
                            App.selector.makeScaler();
                        }
                    }
                   // lastMoveNode.setLocalTranslation(moveNode.getWorldTranslation());
                } else if (App.screenContainer.selectedScreen.equals("uiScreenATMS")) {

                }

                // Handle touch up event
               // System.out.println("Touch Up at: " + event.getX() + ", " + event.getY());
                break;
            case MOVE:

                Vector2f scroll2d = App.app.getInputManager().getCursorPosition();
                if (App.screenContainer.scroll(scroll2d).equals("")) {


                    if (App.screenContainer.selectedScreen.equals("uiScreen")) {

                        if (geometryScaler.selected) {
                            if (event.getDeltaX() > 0) {
                                geometryScaler.move(0.01f, -0.01f, 0.01f);
                            }
                            if (event.getDeltaX() < 0) {
                                geometryScaler.move(-0.01f, 0.01f, -0.01f);

                            }
                        }
                        if (mover.selected) {
                            if (mover.getName().contains("Up")) {
                                if (event.getDeltaX() > 0) {
                                    delta = delta.add(0, 0.01f, 0);
                                    moveNode.move(0, 0.01f, 0);
                                }
                                if (event.getDeltaX() < 0) {
                                    delta = delta.add(0, -0.01f, 0);
                                    moveNode.move(0, -0.01f, 0);
                                }
                            }
                            if (mover.getName().contains("Down")) {
                                if (event.getDeltaX() > 0) {
                                    delta = delta.add(0, 0.01f, 0);
                                    moveNode.move(0, 0.01f, 0);
                                }
                                if (event.getDeltaX() < 0) {
                                    delta = delta.add(0, -0.01f, 0);
                                    moveNode.move(0, -0.01f, 0);
                                }
                            }
                            if (mover.getName().contains("Left")) {
                                if (event.getDeltaX() > 0) {
                                    delta = delta.add(0.01f, 0.0f, 0);
                                    moveNode.move(0.01f, 0, 0);
                                }
                                if (event.getDeltaX() < 0) {
                                    delta = delta.add(-0.01f, 0f, 0);
                                    moveNode.move(-0.01f, 0, 0);
                                }
                            }
                            if (mover.getName().contains("Right")) {
                                if (event.getDeltaX() > 0) {
                                    delta = delta.add(0.01f, 0, 0);
                                    moveNode.move(0.01f, 0, 0);
                                }
                                if (event.getDeltaX() < 0) {
                                    delta = delta.add(-0.01f, 0f, 0);
                                    moveNode.move(-0.01f, 0, 0);
                                }
                            }
                            if (mover.getName().contains("Front")) {
                                if (event.getDeltaX() > 0) {
                                    delta = delta.add(0, 0f, 0.01f);
                                    moveNode.move(0, 0, 0.01f);
                                }
                                if (event.getDeltaX() < 0) {
                                    delta = delta.add(0, 0.0f, -0.01f);
                                    moveNode.move(0, 0, -0.01f);
                                }
                            }
                            if (mover.getName().contains("Back")) {
                                if (event.getDeltaX() > 0) {
                                    delta = delta.add(0, 0.0f, 0.01f);
                                    moveNode.move(0, 0, 0.01f);
                                }
                                if (event.getDeltaX() < 0) {
                                    delta = delta.add(0, 0.0f, -0.01f);
                                    moveNode.move(0, 0, -0.01f);
                                }
                            }
                        }
                    } else if (App.screenContainer.selectedScreen.equals("uiScreenATMS")) {

                    }
                }

                // Handle touch move event
                //System.out.println("Touch Move to: " + event.getX() + ", " + event.getY());
                // Example: Move an object based on touch movement
                // float deltaX = event.getDeltaX();
                // float deltaY = event.getDeltaY();
                // myObject.move(deltaX * someSpeed, deltaY * someSpeed, 0);
                break;
            case TAP:

                // Reset results list.
                CollisionResults results = new CollisionResults();
                // Convert screen click to 3d position
                Vector2f click2d = App.app.getInputManager().getCursorPosition();
                App.screenContainer.click(click2d);

                Vector3f click3d = App.app.getCamera().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 0f).clone();
                Vector3f dir = App.app.getCamera().getWorldCoordinates(new Vector2f(click2d.x, click2d.y), 1f).subtractLocal(click3d).normalizeLocal();
                // Aim the ray from the clicked spot forwards.
                Ray ray = new Ray(click3d, dir);
                // Collect intersections between ray and all nodes in results list.
                App.app.getRootNode().collideWith(ray, results);
                // (Print the results so we see what is going on:)
                for (int i = 0; i < results.size(); i++) {
                    // (For each "hit", we know distance, impact point, geometry.)
                    float dist = results.getCollision(i).getDistance();
                    Vector3f pt = results.getCollision(i).getContactPoint();
                    String target = results.getCollision(i).getGeometry().getName();
//                        if (results.getCollision(i).getGeometry().getName().contains("Box")){
//                            selected.add(results.getCollision(i).getGeometry())
//                        }
              //      System.out.println("Selection #" + i + ": " + target + " at " + pt + ", " + dist + " WU away.");
                }

                if (App.screenContainer.selectedScreen.equals("uiScreen")) {


                    // Use the results -- we rotate the selected geometry.
                    if (results.size() > 0) {
                        // The closest result is the target that the player picked:
                        Target target = null;

                        for (int i = 0; i < results.size(); i++) {
                            String targetName = results.getCollision(i).getGeometry().getName();

                            if (!targetName.contains("Box") && !targetName.contains("Move") && !targetName.contains("Scale")) {
                                continue;
                            }
                            if (targetName.contains("Box")) {
                                target = (GeometrySelector) results.getCollision(i).getGeometry();
                            }
                            if (targetName.contains("Move")) {
                                target = (GeometryMover) results.getCollision(i).getGeometry();
                            }
                            if (targetName.contains("Scale")) {
                                target = (GeometryScaler) results.getCollision(i).getGeometry();
                            }
                            break;
                        }
                        if (target != null) {
                            //forresults.getClosestCollision().getGeometry();
                            // Here comes the action:
                            if (target.getName().contains("Box")) {

                                target.select();
                                if (target instanceof GeometrySelector) {
                                    App.selector.addSelectors((GeometrySelector) target);
                                }

                                //if (geometryMovers.isEmpty()){
                                App.selector.clearMovers();
                                App.selector.populateMovers();
//                                if (selected.size() > 1) {
//                                    App.selector.makeScaler();
//                                }
                               // App.selector.addToSelectedNode();

                            }

                            if (target.getName().contains("Move")) {

                                geometryScaler.deselect();
                                App.selector.resetMovers();
                                target.select();
                                if (target instanceof GeometryMover) {
                                    mover = (GeometryMover) target;
                                }

                            }
                            if (target.getName().contains("Scale")) {
                                App.selector.resetMovers();
                                mover.deselect();
                                target.select();

                            }
                        }
                    }
                }

                /*
                else if (App.screenContainer.selectedScreen.equals("uiScreenATMS")) {
                    if (results.size() > 0) {

                        SimpleGeometry g = (SimpleGeometry) results.getClosestCollision().getGeometry();
                        if (g.simpleMesh != null && g.superSurface != null){


                            Vector3f pt = results.getClosestCollision().getContactPoint();
                            Vector2f cp = g.simpleMesh.get2DContactPointFrom3D(pt);
                            Vector2f positionOnSurface = g.superSurface.getVector2FromSimpleMesh(g.simpleMesh);
                            System.out.println("Surface: " + positionOnSurface);
                            float pointX = ((positionOnSurface.x + cp.x) * g.superSurface.atms.width)/g.superSurface.maxX;
                            float pointY = ((positionOnSurface.y + cp.y) * g.superSurface.atms.height)/g.superSurface.maxY;

                            System.out.println("XY" + pointX + " " + pointY);
                            g.superSurface.atms.layer.drawCircle((int) pointX, (int) pointY, (int) App.radius.x, App.paintColor);
                            g.superSurface.updateSimpleMeshes();
                        }
                    }
                    // g.superSurface.atms.layer.drawCircle();
                }

                */

                // Handle a tap gesture
                //System.out.println("Tap detected at: " + event.getX() + ", " + event.getY());
                break;
            case SCROLL:

                break;
        }

    }
}
