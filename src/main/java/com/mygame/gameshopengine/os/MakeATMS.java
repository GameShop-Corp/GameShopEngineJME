package com.mygame.gameshopengine.os;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector4f;

import com.mygame.gameshopengine.app.App;
import com.mygame.gameshopengine.graphics.ATMS;
import com.mygame.gameshopengine.os.icons.atms.IconATMS;
import com.mygame.gameshopengine.os.icons.positions.IconBack;
import com.mygame.gameshopengine.os.icons.positions.IconBottom;
import com.mygame.gameshopengine.os.icons.positions.IconFront;
import com.mygame.gameshopengine.os.icons.positions.IconLeft;
import com.mygame.gameshopengine.os.icons.positions.IconRight;
import com.mygame.gameshopengine.os.icons.positions.IconTop;
import com.mygame.gameshopengine.os.icons.supermesh.IconHide;
import com.mygame.gameshopengine.os.icons.supermesh.IconReset;
import com.mygame.gameshopengine.os.icons.supermesh.IconShow;
import com.mygame.gameshopengine.os.icons.supermesh.IconSuperMesh;

public class MakeATMS {

    public MakeATMS(){
        IconSuperMesh iconSuperMesh = new IconSuperMesh();
        IconATMS iconATMS = new IconATMS();
        IconReset iconReset = new IconReset();
        IconHide iconHide = new IconHide();
        IconShow iconShow = new IconShow();

        IconBack iconBack = new IconBack();
        IconBottom iconBottom = new IconBottom();
        IconFront iconFront = new IconFront();
        IconLeft iconLeft = new IconLeft();
        IconRight iconRight = new IconRight();
        IconTop iconTop = new IconTop();

        ATMS atmsButton = new ATMS("ATMSButton", 100,100);
        atmsButton.layer.drawCircle(50,50,100,new Vector4f(20,20,20,200));

        ATMS buttonMesh = new ATMS("ATMSButtonMesh", 100,100);
        buttonMesh.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        buttonMesh.layer.putLayer(iconSuperMesh.icon.layer, new Vector2f(), new Vector2f(100,100));


        ATMS buttonATMS = new ATMS("ATMSButtonATMS", 100,100);
        buttonATMS.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        buttonATMS.layer.putLayer(iconATMS.icon.layer, new Vector2f(), new Vector2f(100,100));

        ATMS buttonReset = new ATMS("ATMSButtonReset", 100,100);
        buttonReset.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        buttonReset.layer.putLayer(iconReset.icon.layer, new Vector2f(), new Vector2f(100,100));

        ATMS buttonHide = new ATMS("ATMSButtonHide", 100,100);
        buttonHide.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        buttonHide.layer.putLayer(iconHide.icon.layer, new Vector2f(), new Vector2f(100,100));

        ATMS buttonShow = new ATMS("ATMSButtonShow", 100,100);
        buttonShow.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        buttonShow.layer.putLayer(iconShow.icon.layer, new Vector2f(), new Vector2f(100,100));


        ATMS atmsLabel = new ATMS("ATMSLabel", 100, 100);
        atmsLabel.layer.drawCircle(50,50,100,new Vector4f(150,150,150,200));


        ATMS atmsPaint = new ATMS("ATMSPaint", 128,128);
        atmsPaint.layer.drawCircle(64,64,128, new Vector4f(255,255,255,255));
        atmsPaint.layer.drawCircle(64,64,64, App.paintColor);

        ATMS atmsSliderRed = new ATMS("ATMSSliderRed", 255,100);
        atmsSliderRed.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(255,0,0,255));
        atmsSliderRed.layer.drawCircle((int) App.paintColor.x, 47, (short)25, new Vector4f(255,0,0,255));

        ATMS atmsSliderGreen = new ATMS("ATMSSliderGreen", 255,100);
        atmsSliderGreen.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,255,0,255));
        atmsSliderGreen.layer.drawCircle((int) App.paintColor.y, 47, (short)25, new Vector4f(0,255,0,255));


        ATMS atmsSliderBlue = new ATMS("ATMSSliderBlue", 255,100);
        atmsSliderBlue.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,0,255,255));
        atmsSliderBlue.layer.drawCircle((int) App.paintColor.z, 47, (short)25, new Vector4f(0,0,255,255));

        ATMS atmsSliderAlpha = new ATMS("ATMSSliderAlpha", 255,100);
        atmsSliderAlpha.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,0,0,128));
        atmsSliderAlpha.layer.drawCircle((int) App.paintColor.w, 47, (short)25, new Vector4f(0,0,0,128));


        ATMS atmsSliderRadius = new ATMS("ATMSSliderRadius", 255,100);
        atmsSliderRadius.layer.drawLine(new Vector2f(5,47), new Vector2f(250,47), (short) 5, new Vector4f(0,0,0,255));
        atmsSliderRadius.layer.drawCircle((int) App.radius.x, 47, (short)25, new Vector4f(0,0,0,255));

        ATMS atmsAnalogMove = new ATMS("ATMSAnalogMove", 128,128);
        atmsAnalogMove.layer.drawCircle(64,64,256, new Vector4f(128,128,128,128));
        atmsAnalogMove.layer.drawCircle(64,64,32, new Vector4f(200,200,200,128));
        atmsAnalogMove.layer.drawCircle(64,64,16, new Vector4f(255,255,255,128));

        ATMS atmsAnalogRotate = new ATMS("ATMSAnalogRotate", 128,128);
        atmsAnalogRotate.layer.drawCircle(64,64,256, new Vector4f(128,128,128,128));
        atmsAnalogRotate.layer.drawCircle(64,64,32, new Vector4f(200,200,200,128));
        atmsAnalogRotate.layer.drawCircle(64,64,16, new Vector4f(255,255,255,128));

        ATMS atmsFront = new ATMS("ATMSCameraFront",128,128);
        atmsFront.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        atmsFront.layer.putLayer(iconFront.icon.layer, new Vector2f(), new Vector2f(100, 100));

        ATMS atmsBack = new ATMS("ATMSCameraBack",128,128);
        atmsBack.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        atmsBack.layer.putLayer(iconBack.icon.layer, new Vector2f(), new Vector2f(100, 100));

        ATMS atmsLeft = new ATMS("ATMSCameraLeft",128,128);
        atmsLeft.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        atmsLeft.layer.putLayer(iconLeft.icon.layer, new Vector2f(), new Vector2f(100, 100));

        ATMS atmsRight = new ATMS("ATMSCameraRight",128,128);
        atmsRight.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        atmsRight.layer.putLayer(iconRight.icon.layer, new Vector2f(), new Vector2f(100, 100));

        ATMS atmsTop = new ATMS("ATMSCameraTop",128,128);
        atmsTop.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        atmsTop.layer.putLayer(iconTop.icon.layer, new Vector2f(), new Vector2f(100, 100));

        ATMS atmsBottom = new ATMS("ATMSCameraBottom",128,128);
        atmsBottom.layer.putLayer(atmsButton.layer, new Vector2f(), new Vector2f(100,100));
        atmsBottom.layer.putLayer(iconBottom.icon.layer, new Vector2f(), new Vector2f(100, 100));

    }
}
