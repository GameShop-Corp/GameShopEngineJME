/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.niftygui;

/**
 *
 * @author gameshopengine
 */
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.mygame.app.SuperMeshApp;
import com.mygame.graphics.SuperLine;
import com.mygame.graphics.SuperMesh;
import com.mygame.input.MyInputMapping;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ListBox;
import de.lessvoid.nifty.controls.ListBoxSelectionChangedEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import java.util.List;

/**
 * A ScreenController for the "start" screen defined in
 * "Interfaces/Nifty/HelloJme.xml", which is used in the TestAppStates and
 * TestNiftyGui applications.
 */
public class StartScreenController implements ScreenController {

    final private SimpleApplication application;

    Nifty nifty;
    Screen screen;
    /**
     * Instantiate a ScreenController for the specified Application.
     *
     * @param app the Application
     */
    public StartScreenController(SimpleApplication app) {
        this.application = app;
    }

    /**
     * Nifty invokes this method when the screen gets enabled for the first
     * time.
     *
     * @param nifty (not null)
     * @param screen (not null)
     */
    @Override
    public void bind(Nifty nifty, Screen screen) {
        System.out.println("bind(" + screen.getScreenId() + ")");
        this.nifty = nifty;
        this.screen = screen;
        screen.addKeyboardInputHandler(new MyInputMapping(), null);
    }

    /**
     * Nifty invokes this method each time the screen starts up.
     */
    @Override
    public void onStartScreen() {
        System.out.println("onStartScreen");
        fillMyListBox();
    }

    /**
     * Nifty invokes this method each time the screen shuts down.
     */
    @Override
    public void onEndScreen() {
        System.out.println("onEndScreen");
    }

    /**
     * Stop the Application. Nifty invokes this method (via reflection) after
     * the user clicks on the flashing orange panel.
     */
    public void quit() {
        System.out.println("Quit");
        application.stop();
    }
    
    /**
   * Fill the listbox with items. In this case with Strings.
   */
  public void fillMyListBox() {
    ListBox listBox = screen.findNiftyControl("myListBox", ListBox.class);
//    listBox.addItem("a");
//    listBox.addItem("b");
//    listBox.addItem("c");

      for (String sm: SuperMeshApp.getInstance().superMeshes.keySet()){
      
          listBox.addItem("[SuperMesh] " + sm);
          
          for (String surf: SuperMeshApp.getInstance().superMeshes.get(sm).superMesh.keySet()){
          
              listBox.addItem("[SuperSurface] " + surf);
              int i = 0;
              for (SuperLine s: SuperMeshApp.getInstance().superMeshes.get(sm).superMesh.get(surf).currencyLines){
              listBox.addItem("[SuperLine]");
              int j = 0;
              for (Vector3f v: SuperMeshApp.getInstance().superMeshes.get(sm).superMesh.get(surf).currencyLines[i].points)
              
                  listBox.addItem("[Vector3f] " + v);
                  j++;
              }
              i++;
          }
      }
  }

  /**
   * When the selection of the ListBox changes this method is called.
   */
  @NiftyEventSubscriber(id="myListBox")
  public void onMyListBoxSelectionChanged(final String id, final ListBoxSelectionChangedEvent<String> event) {
    List<String> selection = event.getSelection();
    for (String selectedItem : selection) {
      System.out.println("listbox selection [" + selectedItem + "]");
    }
  }
}
