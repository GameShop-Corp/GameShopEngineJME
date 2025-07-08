/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.input;

/**
 *
 * @author gameshopengine
 */
import de.lessvoid.nifty.input.NiftyInputEvent;
   import de.lessvoid.nifty.input.NiftyInputMapping;
   import de.lessvoid.nifty.input.keyboard.KeyboardInputEvent;

   public class MyInputMapping implements NiftyInputMapping {
       @Override
       public NiftyInputEvent convert(KeyboardInputEvent inputEvent) {
           if (inputEvent.isKeyDown()) {
               if (inputEvent.getKey() == KeyboardInputEvent.KEY_ESCAPE) { // Example: disable Escape key
                   return null; // Ignore the event
               }
           }
           return null; // Or map to the appropriate NiftyInputEvent if needed
       }
   }
