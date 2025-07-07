/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.app;

import java.util.HashMap;

/**
 *
 * @author gameshopengine
 */
public class SelectorApp {

       public HashMap<String, SelectorApp> selectors;
    private static SelectorApp _instance;

    private SelectorApp(){

        selectors = new HashMap<>();
    }

    public static SelectorApp getInstance(){

        if (_instance == null){
            _instance = new SelectorApp();
        }
        return _instance;
    }
}
