package com.mygame.gameshopengine.ui;

import static com.mygame.gameshopengine.ui.Selector.geometryScaler;
import static com.mygame.gameshopengine.ui.Selector.moveNode;
import static com.mygame.gameshopengine.ui.Selector.mover;
import static com.mygame.gameshopengine.ui.Selector.selected;
import static com.mygame.gameshopengine.ui.Selector.delta;
import com.jme3.collision.CollisionResults;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.TouchListener;
import com.jme3.input.event.TouchEvent;
import static com.jme3.input.event.TouchEvent.Type.DOWN;
import static com.jme3.input.event.TouchEvent.Type.MOVE;
import static com.jme3.input.event.TouchEvent.Type.SCROLL;
import static com.jme3.input.event.TouchEvent.Type.TAP;
import static com.jme3.input.event.TouchEvent.Type.UP;
import com.jme3.math.Ray;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;

import com.mygame.gameshopengine.app.App;
import static com.mygame.gameshopengine.ui.Selector.delta;
import static com.mygame.gameshopengine.ui.Selector.geometryScaler;
import static com.mygame.gameshopengine.ui.Selector.moveNode;
import static com.mygame.gameshopengine.ui.Selector.mover;
import static com.mygame.gameshopengine.ui.Selector.selected;

public class SelectMouseListener implements ActionListener, AnalogListener {

    //public int lastEventPointer = -1;

    public static int lastEventPointer = -1;

    public SelectMouseListener(){
      //  this.lastEventPointer = lastEventPointer;
    }
    
  
    
    public boolean clickLeft = false;

    @Override
    public void onAction(String name, boolean keyPressed, float tpf) {
       
         
        if (name.equals("ClickLeft") && keyPressed){ //TAP
          
            clickLeft = true;
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
//        }
//        else if (!keyPressed){ //DOWN
//            
//            
//            Vector2f scroll2d = App.app.getInputManager().getCursorPosition();
//            if (App.screenContainer.scroll(scroll2d).equals("")) {
//
//                if (App.screenContainer.selectedScreen.equals("uiScreen")) {
//
//                    if (geometryScaler.selected) {
//                         
//                        if (scroll2d.x > App.app.appSettings.getWindowWidth()/2) {
//                            geometryScaler.move(0.01f, -0.01f, 0.01f);
//                        }
//                        if (scroll2d.x < App.app.appSettings.getWindowWidth()/2) {
//                            geometryScaler.move(-0.01f, 0.01f, -0.01f);
//
//                        }
//                    }
//                    if (mover.selected) {
//                        if (mover.getName().contains("Up")) {
//                            if (scroll2d.x > App.app.appSettings.getWindowWidth()/2) {
//                                delta = delta.add(0, 0.01f, 0);
//                                moveNode.move(0, 0.01f, 0);
//                            }
//                            if (scroll2d.x < App.app.appSettings.getWindowWidth()/2) {
//                                delta = delta.add(0, -0.01f, 0);
//                                moveNode.move(0, -0.01f, 0);
//                            }
//                            System.out.println("X: " + scroll2d.x);
//                            
//                        }
//                        if (mover.getName().contains("Down")) {
//                            if (name.equals("MoveRight")) {
//                                delta = delta.add(0, 0.01f, 0);
//                                moveNode.move(0, 0.01f, 0);
//                            }
//                            if (name.equals("MoveLeft")) {
//                                delta = delta.add(0, -0.01f, 0);
//                                moveNode.move(0, -0.01f, 0);
//                            }
//                        }
//                        if (mover.getName().contains("Left")) {
//                            if (name.equals("MoveRight")) {
//                                delta = delta.add(0.01f, 0.0f, 0);
//                                moveNode.move(0.01f, 0, 0);
//                            }
//                            if (name.equals("MoveLeft")) {
//                                delta = delta.add(-0.01f, 0f, 0);
//                                moveNode.move(-0.01f, 0, 0);
//                            }
//                        }
//                        if (mover.getName().contains("Right")) {
//                            if (name.equals("MoveRight")) {
//                                delta = delta.add(0.01f, 0, 0);
//                                moveNode.move(0.01f, 0, 0);
//                            }
//                            if (name.equals("MoveLeft")) {
//                                delta = delta.add(-0.01f, 0f, 0);
//                                moveNode.move(-0.01f, 0, 0);
//                            }
//                        }
//                        if (mover.getName().contains("Front")) {
//                            if (name.equals("MoveRight")) {
//                                delta = delta.add(0, 0f, 0.01f);
//                                moveNode.move(0, 0, 0.01f);
//                            }
//                            if (name.equals("MoveLeft")) {
//                                delta = delta.add(0, 0.0f, -0.01f);
//                                moveNode.move(0, 0, -0.01f);
//                            }
//                        }
//                        if (mover.getName().contains("Back")) {
//                            if (name.equals("MoveRight")) {
//                                delta = delta.add(0, 0.0f, 0.01f);
//                                moveNode.move(0, 0, 0.01f);
//                            }
//                            if (name.equals("MoveLeft")) {
//                                delta = delta.add(0, 0.0f, -0.01f);
//                                moveNode.move(0, 0, -0.01f);
//                            }
//                        }
//                    }
//                } else if (App.screenContainer.selectedScreen.equals("uiScreenATMS")) {
//
//                }
//            }
//            
            
         //clickLeft = true;
        } else if (clickLeft && !keyPressed){ //UP
          
            clickLeft = false;
            
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
        } 
    }

    @Override
    public void onAnalog(String name, float value, float tpf) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       
        if (name.equals("MoveLeft") || name.equals("MoveRight") ||name.equals("MoveUp") ||name.equals("MoveDown")){
        Vector2f scroll2d = App.app.getInputManager().getCursorPosition();
        if (App.screenContainer.scroll(scroll2d).equals("")) {

            if (App.screenContainer.selectedScreen.equals("uiScreen")) {

                if (geometryScaler.selected) {

                    if (name.equals("MoveRight")) {
                        geometryScaler.move(0.01f, -0.01f, 0.01f);
                    }
                    if (name.equals("MoveLeft")) {
                        geometryScaler.move(-0.01f, 0.01f, -0.01f);

                    }
                }
                if (mover.selected) {
                    if (mover.getName().contains("Up")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0.01f, 0);
                            moveNode.move(0, 0.01f, 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, -0.01f, 0);
                            moveNode.move(0, -0.01f, 0);
                        }
                        System.out.println("X: " + scroll2d.x);

                    }
                    if (mover.getName().contains("Down")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0.01f, 0);
                            moveNode.move(0, 0.01f, 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, -0.01f, 0);
                            moveNode.move(0, -0.01f, 0);
                        }
                    }
                    if (mover.getName().contains("Left")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0.01f, 0.0f, 0);
                            moveNode.move(0.01f, 0, 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(-0.01f, 0f, 0);
                            moveNode.move(-0.01f, 0, 0);
                        }
                    }
                    if (mover.getName().contains("Right")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0.01f, 0, 0);
                            moveNode.move(0.01f, 0, 0);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(-0.01f, 0f, 0);
                            moveNode.move(-0.01f, 0, 0);
                        }
                    }
                    if (mover.getName().contains("Front")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0f, 0.01f);
                            moveNode.move(0, 0, 0.01f);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, 0.0f, -0.01f);
                            moveNode.move(0, 0, -0.01f);
                        }
                    }
                    if (mover.getName().contains("Back")) {
                        if (name.equals("MoveRight")) {
                            delta = delta.add(0, 0.0f, 0.01f);
                            moveNode.move(0, 0, 0.01f);
                        }
                        if (name.equals("MoveLeft")) {
                            delta = delta.add(0, 0.0f, -0.01f);
                            moveNode.move(0, 0, -0.01f);
                        }
                    }
                }
            } else if (App.screenContainer.selectedScreen.equals("uiScreenATMS")) {

            }
        }
        }
    }
}
