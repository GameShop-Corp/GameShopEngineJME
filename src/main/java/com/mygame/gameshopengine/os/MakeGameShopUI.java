package com.mygame.gameshopengine.os;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl;
import com.jme3.scene.shape.Box;

import java.util.ArrayList;

import com.mygame.gameshopengine.app.App;
import com.mygame.gameshopengine.format.atms.ATMSMap;
import com.mygame.gameshopengine.gameshopui.Omni;
import com.mygame.gameshopengine.gameshopui.Screen;
//import gameshop.gameshopcorp.gameshopengine.os.icons.atms.IconATMS;
//import gameshop.gameshopcorp.gameshopengine.os.icons.supermesh.IconHide;
//import gameshop.gameshopcorp.gameshopengine.os.icons.supermesh.IconReset;
//import gameshop.gameshopcorp.gameshopengine.os.icons.supermesh.IconShow;
//import gameshop.gameshopcorp.gameshopengine.os.icons.supermesh.IconSuperMesh;
import com.mygame.gameshopengine.utility.PercentVector;

public class MakeGameShopUI {


    public MakeGameShopUI(){


        App.screenContainer.selectedScreen = "uiScreen";

        PercentVector percentVector = new PercentVector(new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight()));

       // MakeATMS makeATMS = new MakeATMS();

        Screen uiScreen = new Screen(){
            @Override
            public void onDraw() {
                super.onDraw();
                App.selector.showSelectors();
            }
        };
        Screen uiScreenATMS = new Screen(){
            @Override
            public void onDraw() {
                super.onDraw();
                App.selector.hideSelectors();
            }
        };

        App.screenContainer.screens.put("uiScreen", uiScreen);
        App.screenContainer.screens.put("uiScreenATMS", uiScreenATMS);

        Omni omniReset = new Omni("", App.allATMS.get("ATMSButtonReset"), percentVector.percent(new Vector2f(20,0)), percentVector.percent(25,10)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
//                App.selector.resetSelectors();
//                App.selector.clearMovers();
                App.selector.resetSelectors();
                return "Reset";
            }
        };

        Omni omniClear = new Omni("", App.allATMS.get("ATMSButtonHide"), percentVector.percent(new Vector2f(25,0)), percentVector.percent(30,10)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
//                App.selector.clearSelectors();
//                App.selector.hideMovers();
                App.selector.hideSelectors();
                return "Hide";
            }
        };

        Omni omniShow = new Omni("", App.allATMS.get("ATMSButtonShow"), percentVector.percent(new Vector2f(30,0)), percentVector.percent(35,10)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
//                App.selector.showSelectors();
//                App.selector.showMovers();
                App.selector.showSelectors();
                return "Show";
            }
        };

//        Omni omniMode = new Omni("Mode: ", atmsLabel, percentVector.percent(new Vector2f(0,90)), percentVector.percent(10,100)){
//
//            @Override
//            public String onClick(Vector2f position) {
//                super.onClick(position);
//                System.out.println("OMNI CLICKED");
//                return "Mode";
//            }
//        };


        Omni omniMesh = new Omni("", App.allATMS.get("ATMSButtonMesh"), percentVector.percent(new Vector2f(0,90)), percentVector.percent(5,100)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                App.screenContainer.changeScreen("uiScreen");
                return "Mesh";
            }
        };

       // omniMesh.atms.layer.putLayer(iconSuperMesh.icon.layer, new Vector2f(), new Vector2f(100,100));

        Omni omniATMS = new Omni("", App.allATMS.get("ATMSButtonATMS"), percentVector.percent(new Vector2f(5,90)), percentVector.percent(10,100)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                App.screenContainer.changeScreen("uiScreenATMS");
                return "ATMS";
            }
        };

//        Omni omniSideFront = new Omni(""){
//
//        };

        Omni omniSuperMesh = new Omni("SuperMesh: ", App.allATMS.get("ATMSLabel"), percentVector.percent(new Vector2f(0,80)), percentVector.percent(10,90)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                return "SuperMesh";
            }
        };

        Omni omniNewMesh = new Omni("New Mesh", App.allATMS.get("ATMSLabel"), percentVector.percent(new Vector2f(10,80)), percentVector.percent(20,90)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                return "NewMesh";
            }
        };

        Omni omniMoveMesh = new Omni("Move Mesh", App.allATMS.get("ATMSLabel"), percentVector.percent(new Vector2f(20,80)), percentVector.percent(30,90)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                return "MoveMesh";
            }
        };



        ArrayList<Omni> superMeshContainer = new ArrayList<>();
        float f = 70;
        for (String s: App.allSuperMeshes.keySet()){
            Omni superMesh = new Omni(s, App.allATMS.get("ATMSLabel"), percentVector.percent(new Vector2f(0,f)), percentVector.percent(10,f + 10)){

                @Override
                public String onClick(Vector2f position) {
                    super.onClick(position);
                    System.out.println("SUPERMESH CLICKED");
                    return "SuperMeshContainer";
                }
            };
            superMeshContainer.add(superMesh);
            f -= 10f;
        }



        float near = 85f;
        float far = 95f;
        /// ATMS Screen
        Omni omniPaint = new Omni("", App.allATMS.get("ATMSPaint"), percentVector.percent(near,80), percentVector.percent(far,100)){//new Vector2f(App.app.appSettings.getWidth() - 200, App.app.appSettings.getHeight() - 200), new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight())){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                return "Paint";
            }
        };

        Omni omniRed = new Omni("Red: " + App.paintColor.x, App.allATMS.get("ATMSLabel"), percentVector.percent(near,75), percentVector.percent(90,80)){//new Vector2f(App.app.appSettings.getWidth() - 200, App.app.appSettings.getHeight() - 250), new Vector2f(App.app.appSettings.getWidth() - 100, App.app.appSettings.getHeight() - 200)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                return "Red";
            }
        };

        Omni omniSliderRed = new Omni("", App.allATMS.get("ATMSSliderRed"), percentVector.percent(near,70), percentVector.percent(far,75)){//new Vector2f(App.app.appSettings.getWidth() - 400, App.app.appSettings.getHeight() - 300), new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight() - 250)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
//                float colorLocation = ((position.x - start.x)/200f) * 255f;
//                App.paintColor.setX(colorLocation);

                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.x <= 1f){
                    App.paintColor.setX(1f);
                } else if (App.paintColor.x >= atms.width){
                    App.paintColor.setX(atms.width);
                }
                omniRed.text = "Red: " + App.paintColor.x;
                omniRed.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(255,0,0,255));
                atms.layer.drawCircle((int) App.paintColor.x, 47, (short)25, new Vector4f(255,0,0,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderRed";
            }

            @Override
            public String onScroll(Vector2f position) {
                 super.onScroll(position);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.x <= 1f){
                    App.paintColor.setX(1f);
                } else if (App.paintColor.x >= atms.width){
                    App.paintColor.setX(atms.width);
                }
                omniRed.text = "Red: " + App.paintColor.x;
                omniRed.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(255,0,0,255));
                atms.layer.drawCircle((int) App.paintColor.x, 47, (short)25, new Vector4f(255,0,0,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderRed";
            }
        };

        Omni omniGreen = new Omni("Green: " + App.paintColor.y, App.allATMS.get("ATMSLabel"), percentVector.percent(near,65), percentVector.percent(90,70)){//new Vector2f(App.app.appSettings.getWidth() - 200, App.app.appSettings.getHeight() - 350), new Vector2f(App.app.appSettings.getWidth() - 100, App.app.appSettings.getHeight() - 300)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);

                System.out.println("OMNI CLICKED");
                return "Green";
            }
        };

        Omni omniSliderGreen = new Omni("", App.allATMS.get("ATMSSliderGreen"), percentVector.percent(near,60), percentVector.percent(far,65)){//new Vector2f(App.app.appSettings.getWidth() - 400, App.app.appSettings.getHeight() - 400), new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight() - 350)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                //App.paintColor.setY(colorLocation);

                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setY(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setY(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.y <= 1f){
                    App.paintColor.setY(1f);
                } else if (App.paintColor.y >= atms.width){
                    App.paintColor.setY(atms.width);
                }

                omniGreen.text = "Green: " + App.paintColor.y;
                omniGreen.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,255,0,255));
                atms.layer.drawCircle((int) App.paintColor.y, 47, (short)25, new Vector4f(0,255,0,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderGreen";
            }

            @Override
            public String onScroll(Vector2f position) {
                super.onScroll(position);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setY(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setY(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.y <= 1f){
                    App.paintColor.setY(1f);
                } else if (App.paintColor.y >= atms.width){
                    App.paintColor.setY(atms.width);
                }

                omniGreen.text = "Green: " + App.paintColor.y;
                omniGreen.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,255,0,255));
                atms.layer.drawCircle((int) App.paintColor.y, 47, (short)25, new Vector4f(0,255,0,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderGreen";
            }
        };

//        Omni omniGreenPlus = new Omni(" + " , atmsButton, new Vector2f(App.app.appSettings.getWidth() - 100, App.app.appSettings.getHeight() - 400), new Vector2f(App.app.appSettings.getWidth() - 50, App.app.appSettings.getHeight() - 300)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };
//
//        Omni omniGreenMinus = new Omni(" - ", atmsButton, new Vector2f(App.app.appSettings.getWidth() - 50, App.app.appSettings.getHeight() - 400), new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight() - 300)){
//
//            @Override
//            public void onClick() {
//                super.onClick();
//                System.out.println("OMNI CLICKED");
//            }
//        };

        Omni omniBlue = new Omni("Blue: " + App.paintColor.z, App.allATMS.get("ATMSLabel"), percentVector.percent(near,55), percentVector.percent(90,60)){//new Vector2f(App.app.appSettings.getWidth() - 200, App.app.appSettings.getHeight() - 450), new Vector2f(App.app.appSettings.getWidth() - 100, App.app.appSettings.getHeight() - 400)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                System.out.println("OMNI CLICKED");
                return "Blue";
            }
        };

        Omni omniSliderBlue = new Omni("", App.allATMS.get("ATMSSliderBlue"), percentVector.percent(near,50), percentVector.percent(far,55)){//new Vector2f(App.app.appSettings.getWidth() - 400, App.app.appSettings.getHeight() - 500), new Vector2f(App.app.appSettings.getWidth() , App.app.appSettings.getHeight() - 450)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                //float colorLocation = ((position.x - start.x)/400f) * 255f;
               // App.paintColor.setZ(colorLocation);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setZ(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setZ(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.z <= 1f){
                    App.paintColor.setZ(1f);
                } else if (App.paintColor.z >= atms.width){
                    App.paintColor.setZ(atms.width);
                }
                omniBlue.text = "Blue: " + App.paintColor.z;
                omniBlue.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,0,255,255));
                atms.layer.drawCircle((int) App.paintColor.z, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderBlue";
            }

            @Override
            public String onScroll(Vector2f position) {
                 super.onScroll(position);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setZ(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setZ(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.z <= 1f){
                    App.paintColor.setZ(1f);
                } else if (App.paintColor.z >= atms.width){
                    App.paintColor.setZ(atms.width);
                }
                omniBlue.text = "Blue: " + App.paintColor.z;
                omniBlue.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,0,255,255));
                atms.layer.drawCircle((int) App.paintColor.z, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderBlue";
            }
        };

        Omni omniAlpha = new Omni("Alpha: " + App.paintColor.w, App.allATMS.get("ATMSLabel"), percentVector.percent(near,45), percentVector.percent(90,50)){//new Vector2f(App.app.appSettings.getWidth() - 200, App.app.appSettings.getHeight() - 550), new Vector2f(App.app.appSettings.getWidth() - 100, App.app.appSettings.getHeight() - 500)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);

                System.out.println("OMNI CLICKED");
                return "Alpha";
            }
        };

        Omni omniSliderAlpha = new Omni("", App.allATMS.get("ATMSSliderAlpha"), percentVector.percent(near,40), percentVector.percent(far,45)){//new Vector2f(App.app.appSettings.getWidth() - 400, App.app.appSettings.getHeight() - 600), new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight() - 550)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                //App.paintColor.setW(colorLocation);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setW(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setW(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.w <= 1f){
                    App.paintColor.setW(1f);
                } else if (App.paintColor.w >= atms.width){
                    App.paintColor.setW(atms.width);
                }
                omniAlpha.text = "Alpha: " + App.paintColor.w;
                omniAlpha.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,0,0,128));
                atms.layer.drawCircle((int) App.paintColor.w, 47, (short)25, new Vector4f(0,0,0,128));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderAlpha";
            }

            @Override
            public String onScroll(Vector2f position) {
                super.onScroll(position);
                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                //App.paintColor.setW(colorLocation);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.paintColor.setW(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.paintColor.setW(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.paintColor.w <= 1f){
                    App.paintColor.setW(1f);
                } else if (App.paintColor.w >= atms.width){
                    App.paintColor.setW(atms.width);
                }
                omniAlpha.text = "Alpha: " + App.paintColor.w;
                omniAlpha.drawText();
                App.allATMS.get("ATMSPaint").layer.drawCircle(64,64,64, App.paintColor);
                omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,0,0,128));
                atms.layer.drawCircle((int) App.paintColor.w, 47, (short)25, new Vector4f(0,0,0,128));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderAlpha";
            }
        };

        Omni omniRadius = new Omni("Radius: " + App.radius.x, App.allATMS.get("ATMSLabel"), percentVector.percent(near,35), percentVector.percent(90,40)){//new Vector2f(App.app.appSettings.getWidth() - 200, App.app.appSettings.getHeight() - 650), new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight() - 600)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);

                System.out.println("OMNI CLICKED");
                return "Radius";
            }
        };

        Omni omniSliderRadius = new Omni("", App.allATMS.get("ATMSSliderRadius"), percentVector.percent(near,30), percentVector.percent(far,35)){//new Vector2f(App.app.appSettings.getWidth() - 400, App.app.appSettings.getHeight() - 700), new Vector2f(App.app.appSettings.getWidth(), App.app.appSettings.getHeight() - 650)){

            @Override
            public String onClick(Vector2f position) {
                super.onClick(position);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;

                if (percentVector.percent(movementPercent).x < 0) {

                    App.radius.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.radius.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 10f);
                }

                if (App.radius.x <= 1f){
                    App.radius.setX(1f);
                } else if (App.radius.x >= atms.width){
                    App.radius.setX(atms.width);
                }
                omniRadius.text = "Radius: " + App.radius.x;
                omniRadius.drawText();
                //atmsPaint.layer.drawCircle(64,64,64, paintColor);
                //omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
                atms.layer.drawCircle((int) App.radius.x, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderRadius";
            }

            @Override
            public String onScroll(Vector2f position) {
                super.onScroll(position);
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);

                //float colorLocation = ((position.x - start.x)/400f) * 255f;
                if (percentVector.percent(movementPercent).x < 0) {

                    App.radius.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) - 10f);
                } else {
                    App.radius.setX(((percentVector.percent(movementPercent).x * 1.25f) + (float) atms.width / 2) + 15f);
                }

                if (App.radius.x <= 1f){
                    App.radius.setX(1f);
                } else if (App.radius.x >= atms.width){
                    App.radius.setX(atms.width);
                }
                omniRadius.text = "Radius: " + App.radius.x;
                omniRadius.drawText();
                //atmsPaint.layer.drawCircle(64,64,64, paintColor);
                //omniPaint.draw();
                atms.layer.drawCircle(64,64,400, new Vector4f());
                atms.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(128,128,128,255));
                atms.layer.drawCircle((int) App.radius.x, 47, (short)25, new Vector4f(0,0,255,255));
                draw();
                System.out.println("OMNI CLICKED");
                return "SliderRadius";
            }
        };


        Box b = new Box(0.1f, 0.1f, 0.1f);
        Geometry g = new Geometry("TargetMesh", b);
        Geometry gLeft = new Geometry("TargetMesh", b);
        Geometry gRight = new Geometry("TargetMesh", b);
        Geometry gUp = new Geometry("TargetMesh", b);
        Geometry gDown = new Geometry("TargetMesh", b);

        Material m = new Material(App.app.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");

        m.setColor("Color", ColorRGBA.fromRGBA255(0,0,0,255));
        g.setMaterial(m);
        gLeft.setMaterial(m);
        gRight.setMaterial(m);
        gUp.setMaterial(m);
        gDown.setMaterial(m);

        Node xAxisLeftTarget = new Node("xAxisLeftTarget");
        Node xAxisRightTarget = new Node("xAxisRightTarget");
        Node yAxisUpTarget = new Node("yAxisUpTarget");
        Node yAxisDownTarget = new Node("yAxisDownTarget");

        xAxisLeftTarget.attachChild(gLeft);
        xAxisRightTarget.attachChild(gRight);
        yAxisUpTarget.attachChild(gUp);
        yAxisDownTarget.attachChild(gDown);

        xAxisLeftTarget.move(-0.25f, 0f, 0f);
        xAxisRightTarget.move(0.25f, 0, 0);
        yAxisUpTarget.move(0f, 0.25f, 0);
        yAxisDownTarget.move(0f, -0.25f, 0);

        Node target = new Node("target");
        target.attachChild(xAxisLeftTarget);
        target.attachChild(xAxisRightTarget);
        target.attachChild(yAxisUpTarget);
        target.attachChild(yAxisDownTarget);

        target.attachChild(g);
        App.app.getRootNode().attachChild(target);
//create the camera Node
        CameraNode camNode = new CameraNode("Camera Node", App.app.getCamera());
//This mode means that camera copies the movements of the target:
        camNode.setControlDir(CameraControl.ControlDirection.SpatialToCamera);
//Attach the camNode to the target:
        target.attachChild(camNode);
//Move camNode, e.g. behind and above the target:
        camNode.setLocalTranslation(new Vector3f(0, 0, -10));
//Rotate the camNode to look at the target:
        camNode.lookAt(target.getWorldTranslation(), Vector3f.UNIT_Y);

        Omni omniAnalogMove = new Omni("", App.allATMS.get("ATMSAnalogMove"), percentVector.percent(0,0), percentVector.percent(20,20)){

            @Override
            public String onClick(Vector2f position) {
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);
                //Vector2f totalPercent = new Vector2f((percentageClick.x + (percentageStart.x))/percentageEnd.x, (percentageClick.y + (percentageStart.y)/percentageEnd.y ));//.divide(percentageClick.add(percentageEnd));
                // System.out.println("Movement Percent: " + movementPercent);
                Vector3f towards = new Vector3f(target.getWorldTranslation().subtract(camNode.getWorldTranslation())).mult(movementPercent.y/100f);
                // Vector3f strafe =  (new Vector3f(-(movementPercent.x), 0 , (movementPercent.x)));
                atms.layer.drawCircle(64,64,256, new Vector4f(128,128,128,128));
//                atmsAnalogMove.layer.drawCircle((int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).x * 128), (int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).y * 128),32, new Vector4f(200,200,200,128));
//                atmsAnalogMove.layer.drawCircle((int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).x * 128), (int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).y * 128),16, new Vector4f(255,255,255,128));
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),32, new Vector4f(200,200,200,128));
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),16, new Vector4f(255,255,255,128));

                draw();
                camNode.move(towards.divide(4));//.add(strafe));
                target.rotate(0, (movementPercent.x/180f),0);
                // camNode.move(strafe);
                camNode.lookAt(target.getWorldTranslation(), Vector3f.UNIT_Y);
                return "AnalogMove";
            }

            @Override
            public String onScroll(Vector2f position) {
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);
                //Vector2f totalPercent = new Vector2f((percentageClick.x + (percentageStart.x))/percentageEnd.x, (percentageClick.y + (percentageStart.y)/percentageEnd.y ));//.divide(percentageClick.add(percentageEnd));
                //System.out.println("Movement Percent: " + movementPercent);
                Vector3f towards = new Vector3f(target.getWorldTranslation().subtract(camNode.getWorldTranslation())).mult(movementPercent.y/100f);
                // Vector3f strafe =  (new Vector3f(-(movementPercent.x), 0 , (movementPercent.x)));
                atms.layer.drawCircle(64,64,256, new Vector4f(128,128,128,128));
                //System.out.println ("ATMS Move Percent " + ( (movementPercent)).x );

//                atmsAnalogMove.layer.drawCircle((int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).x * 128), (int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).y * 128),32, new Vector4f(200,200,200,128));
//                atmsAnalogMove.layer.drawCircle((int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).x * 128), (int) (64 + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).y * 128),16, new Vector4f(255,255,255,128));
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),32, new Vector4f(200,200,200,128));
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),16, new Vector4f(255,255,255,128));

                draw();
                camNode.move(towards.divide(4));//.add(strafe));
                target.rotate(0, (movementPercent.x/180f),0);
                // camNode.move(strafe);
                camNode.lookAt(target.getWorldTranslation(), Vector3f.UNIT_Y);
                return "AnalogMove";
                //return super.onScroll(position);
            }
        };


        Omni omniAnalogRotate = new Omni("", App.allATMS.get("ATMSAnalogRotate"), percentVector.percent(80,0), percentVector.percent(100,20)){

            @Override
            public String onClick(Vector2f position) {
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);
                //Vector2f totalPercent = new Vector2f((percentageClick.x + (percentageStart.x))/percentageEnd.x, (percentageClick.y + (percentageStart.y)/percentageEnd.y ));//.divide(percentageClick.add(percentageEnd));
                //System.out.println("Movement Percent: " + movementPercent);
                Vector3f towards = new Vector3f(target.getWorldTranslation().subtract(camNode.getWorldTranslation())).mult(movementPercent.y/100f);
                // Vector3f strafe =  (new Vector3f(-(movementPercent.x), 0 , (movementPercent.x)));
                atms.layer.drawCircle(64,64,256, new Vector4f(128,128,128,128));
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),32, new Vector4f(200,200,200,128));
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),16, new Vector4f(255,255,255,128));
                draw();
                target.move(0,(movementPercent.y/180),0);
                if (movementPercent.x > 0){
                    target.move(xAxisLeftTarget.getWorldTranslation().subtract(target.getWorldTranslation()).divide(4));
                } else if (movementPercent.x < 0) {
                    target.move(xAxisRightTarget.getWorldTranslation().subtract(target.getWorldTranslation()).divide(4));

                }
                // target.move(target.getWorldTranslation().add(camNode.getWorldTranslation()).normalize());
//                camNode.move(towards.divide(4));//.add(strafe));
//                target.rotate(0, (movementPercent.x/180f),0);
                // camNode.move(strafe);
                camNode.lookAt(target.getWorldTranslation(), Vector3f.UNIT_Y);
                return "AnalogMove";


            }

            @Override
            public String onScroll(Vector2f position) {
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);
                //Vector2f totalPercent = new Vector2f((percentageClick.x + (percentageStart.x))/percentageEnd.x, (percentageClick.y + (percentageStart.y)/percentageEnd.y ));//.divide(percentageClick.add(percentageEnd));
                //System.out.println("Movement Percent: " + movementPercent);
                Vector3f towards = new Vector3f(target.getWorldTranslation().subtract(camNode.getWorldTranslation())).mult(movementPercent.y/100f);
                // Vector3f strafe =  (new Vector3f(-(movementPercent.x), 0 , (movementPercent.x)));
                atms.layer.drawCircle(64,64,256, new Vector4f(128,128,128,128));
//                System.out.println ("ATMS Move Percent " + (percentageStart.add(movementPercent)).divide(percentageEnd.x, percentageEnd.y).x );
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),32, new Vector4f(200,200,200,128));
                atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),16, new Vector4f(255,255,255,128));
                draw();
                target.move(0,(movementPercent.y/180),0);
                //target.move(0,(movementPercent.y/180),0);
                if (movementPercent.x > 0){
                    target.move(xAxisLeftTarget.getWorldTranslation().subtract(target.getWorldTranslation()).divide(4));
                } else if (movementPercent.x < 0) {
                    target.move(xAxisRightTarget.getWorldTranslation().subtract(target.getWorldTranslation()).divide(4));

                }
                // target.move(target.getWorldTranslation().add(camNode.getWorldTranslation()).normalize());
//                camNode.move(towards.divide(4));//.add(strafe));
//                target.rotate(0, (movementPercent.x/180f),0);
                // camNode.move(strafe);
                camNode.lookAt(target.getWorldTranslation(), Vector3f.UNIT_Y);
                return "AnalogMove";            }
        };

      //  SuperSurface selectedSuperSurface = App.allSuperMeshes.get("SuperCube").superMesh.get("back");//new ATMS("ATMSScreen", 256,256);

        Omni omniEdit = new Omni("",App.selectedSuperSurface.atms, percentVector.percent(25,15), percentVector.percent(75,85 )){
            @Override
            public String onClick(Vector2f position) {
                PercentVector percentLocal = new PercentVector(new Vector2f(end.x - start.x, end.y - start.y));
                //Vector2f percentage = percentVector.wholeToPercentage(position);
                //Vector2f adjusted = new Vector2f(Clamp.clamp(-25f,125f, percentage.x), Clamp.clamp (-15f, 100f, percentage.y));
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);
                Vector2f total = percentLocal.percent(movementPercent);
                total.mult(-1);
                System.out.println("Total" + " X: " + total.x + " Y:" + total.y);
                //atms.layer.drawCircle(atms.width/2 + (int) (total.x/2), atms.height/2 + (int) ((total.y/2)), (int) App.radius.x, App.paintColor);
               // atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),16, new Vector4f(255,255,255,128));
                //selectedSuperSurface.updateSimpleMeshes();
                atms.parser.atmsFrames.get(0).atmsLayers.get(0).atmsCanvases.get(0).atmsArrays.get(0).atmsMaps.add(new ATMSMap("drawCircle", new Vector2f(atms.width/2 + (int) (total.x/2), atms.height/2 + (int) ((total.y/2))), (short) App.radius.x, App.paintColor));
                atms.parser.draw();

                draw();
                return "Edit";
            }

            @Override
            public String onScroll(Vector2f position) {
                // super.onScroll(position);
                PercentVector percentLocal = new PercentVector(new Vector2f(end.x - start.x, end.y - start.y));
                //Vector2f percentage = percentVector.wholeToPercentage(position);
                //Vector2f adjusted = new Vector2f(Clamp.clamp(-25f,125f, percentage.x), Clamp.clamp (-15f, 100f, percentage.y));
                Vector2f percentageClick = percentVector.wholeToPercentage(position);
                Vector2f percentageStart = percentVector.wholeToPercentage(start);
                Vector2f percentageEnd = percentVector.wholeToPercentage(end);
                Vector2f percentageMid = new Vector2f(percentageEnd.add(percentageStart)).divide(2);
                Vector2f movementPercent = percentageClick.subtract(percentageMid);
                Vector2f total = percentLocal.percent(movementPercent);
                total.mult(-1);
                System.out.println("Total" + " X: " + total.x + " Y:" + total.y);
                //atms.layer.drawCircle(atms.width/2 + (int) (total.x/2), atms.height/2 + (int) ((total.y/2)), (int) App.radius.x, App.paintColor);
                atms.parser.atmsFrames.get(0).atmsLayers.get(0).atmsCanvases.get(0).atmsArrays.get(0).atmsMaps.add(new ATMSMap("drawCircle", new Vector2f(atms.width/2 + (int) (total.x/2), atms.height/2 + (int) ((total.y/2))), (short) App.radius.x, App.paintColor));
                atms.parser.draw();
                // atms.layer.drawCircle((int) (64 + (movementPercent.x * 64)/10), (int) (64 +  (movementPercent.y * 64)/10),16, new Vector4f(255,255,255,128));
                //selectedSuperSurface.updateSimpleMeshes();
                draw();
                return "Edit";
            }


            @Override
            public String onRelease(Vector2f position) {
                 super.onRelease(position);
                App.selectedSuperSurface.updateSimpleMeshes();
                return "Edit";
            }
        };

        Omni omniFront = new Omni("", App.allATMS.get("ATMSCameraFront"), percentVector.percent(25,90), percentVector.percent(30,100)){
            @Override
            public String onClick(Vector2f position) {
                //return super.onClick(position);
                App.selectedSuperSurface = App.selectedSuperMesh.superMesh.get("front");
                omniEdit.atms = App.selectedSuperSurface.atms;
                Quaternion q = new Quaternion();
                q.fromAngles(FastMath.DEG_TO_RAD * -180, FastMath.DEG_TO_RAD * 0, FastMath.DEG_TO_RAD * 180);
                target.setLocalRotation(q);
                return "Front";
            }
        };

        Omni omniBack = new Omni("", App.allATMS.get("ATMSCameraBack"), percentVector.percent(30,90), percentVector.percent(35,100)){
            @Override
            public String onClick(Vector2f position) {
                //return super.onClick(position);
                App.selectedSuperSurface = App.selectedSuperMesh.superMesh.get("back");
                omniEdit.atms = App.selectedSuperSurface.atms;
                Quaternion q = new Quaternion();
                q.fromAngles(FastMath.DEG_TO_RAD * 0, FastMath.DEG_TO_RAD * 0, FastMath.DEG_TO_RAD * 0);
                target.setLocalRotation(q);
                return "Back";
            }
        };

        Omni omniLeft = new Omni("", App.allATMS.get("ATMSCameraLeft"), percentVector.percent(35,90), percentVector.percent(40,100)){
            @Override
            public String onClick(Vector2f position) {
                //return super.onClick(position);
                App.selectedSuperSurface = App.selectedSuperMesh.superMesh.get("left");
                omniEdit.atms = App.selectedSuperSurface.atms;
                Quaternion q = new Quaternion();
                q.fromAngles(FastMath.DEG_TO_RAD * 0, FastMath.DEG_TO_RAD * 90, FastMath.DEG_TO_RAD * 0);
                target.setLocalRotation(q);
                return "Left";
            }
        };

        Omni omniRight = new Omni("", App.allATMS.get("ATMSCameraRight"), percentVector.percent(40,90), percentVector.percent(45,100)){
            @Override
            public String onClick(Vector2f position) {
                //return super.onClick(position);
                App.selectedSuperSurface = App.selectedSuperMesh.superMesh.get("right");
                omniEdit.atms = App.selectedSuperSurface.atms;
                Quaternion q = new Quaternion();
                q.fromAngles(FastMath.DEG_TO_RAD * 0, FastMath.DEG_TO_RAD * -90, FastMath.DEG_TO_RAD * 0);
                target.setLocalRotation(q);
                return "Right";
            }
        };

        Omni omniTop = new Omni("", App.allATMS.get("ATMSCameraTop"), percentVector.percent(45,90), percentVector.percent(50,100)){
            @Override
            public String onClick(Vector2f position) {
                //return super.onClick(position);
                App.selectedSuperSurface = App.selectedSuperMesh.superMesh.get("top");
                omniEdit.atms = App.selectedSuperSurface.atms;
                Quaternion q = new Quaternion();
                q.fromAngles(FastMath.DEG_TO_RAD * 90, FastMath.DEG_TO_RAD * 0, FastMath.DEG_TO_RAD * 0);
                target.setLocalRotation(q);
                return "Top";
            }
        };

        Omni omniBottom = new Omni("", App.allATMS.get("ATMSCameraBottom"), percentVector.percent(50,90), percentVector.percent(55,100)){
            @Override
            public String onClick(Vector2f position) {
                //return super.onClick(position);
                App.selectedSuperSurface = App.selectedSuperMesh.superMesh.get("bottom");
                omniEdit.atms = App.selectedSuperSurface.atms;
                Quaternion q = new Quaternion();
                q.fromAngles(FastMath.DEG_TO_RAD * -90, FastMath.DEG_TO_RAD * 0, FastMath.DEG_TO_RAD * 0);
                target.setLocalRotation(q);
                return "Bottom";
            }
        };


        //uiScreen.omnis.add(omniMode);
        uiScreen.omnis.add(omniMesh);
        uiScreen.omnis.add(omniATMS);
        uiScreen.omnis.add(omniReset);
        uiScreen.omnis.add(omniClear);
        uiScreen.omnis.add(omniShow);
        //uiScreen.omnis.add(omniSuperMesh);
        //uiScreen.omnis.addAll(superMeshContainer);
        uiScreen.omnis.add(omniAnalogMove);
        uiScreen.omnis.add(omniAnalogRotate);

        uiScreen.omnis.add(omniFront);
        uiScreen.omnis.add(omniBack);
        uiScreen.omnis.add(omniRight);
        uiScreen.omnis.add(omniLeft);
        uiScreen.omnis.add(omniTop);
        uiScreen.omnis.add(omniBottom);
        
        
        uiScreen.draw();

        //uiScreenATMS.omnis.add(omniMode);
        uiScreenATMS.omnis.add(omniEdit);
        uiScreenATMS.omnis.add(omniMesh);
        uiScreenATMS.omnis.add(omniATMS);
        uiScreenATMS.omnis.add(omniPaint);

        uiScreenATMS.omnis.add(omniRed);
        uiScreenATMS.omnis.add(omniGreen);
        uiScreenATMS.omnis.add(omniBlue);
        uiScreenATMS.omnis.add(omniAlpha);
        uiScreenATMS.omnis.add(omniRadius);

        uiScreenATMS.omnis.add(omniSliderRed);
        uiScreenATMS.omnis.add(omniSliderGreen);
        uiScreenATMS.omnis.add(omniSliderBlue);
        uiScreenATMS.omnis.add(omniSliderAlpha);
        uiScreenATMS.omnis.add(omniSliderRadius);

        uiScreenATMS.omnis.add(omniAnalogMove);
        uiScreenATMS.omnis.add(omniAnalogRotate);

        uiScreenATMS.omnis.add(omniFront);
        uiScreenATMS.omnis.add(omniBack);
        uiScreenATMS.omnis.add(omniRight);
        uiScreenATMS.omnis.add(omniLeft);
        uiScreenATMS.omnis.add(omniTop);
        uiScreenATMS.omnis.add(omniBottom);
    }
}
