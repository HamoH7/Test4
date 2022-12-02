package com.example.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.view.SurfaceHolder;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

import java.util.List;
import java.util.Timer;

public class DrawThread extends Thread {
    private SurfaceHolder surfaceHolder;
    public float lastTouchX = 0;
    public float lastTouchY = 0;
    public int m = 0, n = 0, m1 = 0, m2 = 0, m3 = 0, m4 = 0, eat = 0, e = 0, eatTimer = 10, m5 = 0;
    public double h = (float)1/36;
    public double s = (float) 1 / 96;
    public double q = (float) 1 / 54;
    public double k = (float) 1 / 60;
    public double food = (float) 1 / 10;
    public float hungryRight = 0, happyRight = 0, sleepRight = 0, dirtRight = 0, lifeRight = 0;
    public int life, dirt, hungry, sleep,happy;
    public boolean dontEat = false;
    public boolean eating = false;
    public boolean eatChecker = true;
    public boolean checkEatButton = false;
    public boolean drawEatButton = false;
    public boolean eatingTimeIsPassed = false;
    public boolean eatingNeedToDrawNow = false;
    public boolean hungryTimeIsPassed = false;
    public boolean hungryNeedToDrawNow = false;
    public boolean happyTimeIsPassed = false;
    public boolean happyNeedToDrawNow = false;
    public boolean sleepTimeIsPassed = false;
    public boolean sleepNeedToDrawNow = false;
    public boolean dirtTimeIsPassed = false;
    public boolean dirtNeedToDrawNow = false;
    public boolean timeIsPassed1 = false;
    public boolean needToDrawNow1 = false;
    public boolean timeIsPassed2 = false;
    public boolean needToDrawNow2 = false;
    public boolean check = false;
    public Bitmap eat1Bitmap, eat2Bitmap, eat3Bitmap, eat4Bitmap, eat5Bitmap, eat6Bitmap, eat7Bitmap, eat8Bitmap, eat9Bitmap, eat10Bitmap;
    public Bitmap eat1DarkBitmap, eat2DarkBitmap, eat3DarkBitmap, eat4DarkBitmap, eat5DarkBitmap, eat6DarkBitmap, eat7DarkBitmap, eat8DarkBitmap, eat9DarkBitmap, eat10DarkBitmap;
    public Bitmap bitmapGrass,bitmapbg,bitmapkust,bitmapHeart, bitmapDirt, bitmapHungry,bitmapSleep, bitmapHappy, eatButtonBitmap, eatButtonBitmap2, highScoreBitmap, scoreBitmap;
    public Bitmap bitmap, bitmapDTSH1, bitmapDTSH2, bitmapDTS1, bitmapDTS2, bitmapDTH1, bitmapDTH2, bitmapDSH1, bitmapDSH2, bitmapTSH1, bitmapTSH2,
            bitmapDH1, bitmapDH2, bitmapDS1, bitmapDS2, bitmapDT1, bitmapDT2, bitmapSH1, bitmapSH2, bitmapTH1,bitmapTH2,bitmapTS1,bitmapTS2
            ,bitmapD1,bitmapD2,bitmapT1,bitmapT2,bitmapS1,bitmapS2,bitmapH1,bitmapH2,bitmapSmile1,bitmapSmile2,bitmapUsual1,bitmapUsual2, bitmap1, bitmap2;
    private volatile boolean running = true;
    Paint paint = new Paint();
    Paint paintLife = new Paint();
    Paint paintDirt = new Paint();
    Paint paintHungry = new Paint();
    Paint paintSleep = new Paint();
    Paint paintHappy = new Paint();
    Paint paintBlack = new Paint();
    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
        bitmapUsual1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovorakan1);
        bitmapUsual2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovorakan2);
        bitmapDTSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_h_1);
        bitmapDTSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_h_2);
        bitmapDTS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_1);
        bitmapDTS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_s_2);
        bitmapDTH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_h_1);
        bitmapDTH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_h_2);
        bitmapDSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_h_1);
        bitmapDSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_h_2);
        bitmapTSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_h_1);
        bitmapTSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_h_2);
        bitmapDH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_h_1);
        bitmapDH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_h_2);
        bitmapDS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_1);
        bitmapDS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_s_2);
        bitmapDT1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_1);
        bitmapDT2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.d_t_2);
        bitmapSH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.s_h_1);
        bitmapSH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.s_h_2);
        bitmapTH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_h_1);
        bitmapTH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_h_2);
        bitmapTS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_1);
        bitmapTS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.t_s_2);
        bitmapD1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.kextot1);
        bitmapD2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.kextot2);
        bitmapT1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.hognac1);
        bitmapT2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.hognac2);
        bitmapS1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.txur1);
        bitmapS2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.txur2);
        bitmapH1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovac1);
        bitmapH2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.sovac2);
        bitmapSmile1 = BitmapFactory.decodeResource(context.getResources(),R.drawable.urax1);
        bitmapSmile2 = BitmapFactory.decodeResource(context.getResources(),R.drawable.urax2);
        eat1Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox1);
        eat2Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox2);
        eat3Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox3);
        eat4Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox4);
        eat5Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox5);
        eat6Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox6);
        eat7Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox7);
        eat8Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox8);
        eat9Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox9);
        eat10Bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.utox10);
        eat1DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug1);
        eat2DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug2);
        eat3DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug3);
        eat4DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug4);
        eat5DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug5);
        eat6DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug6);
        eat7DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug7);
        eat8DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug8);
        eat9DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug9);
        eat10DarkBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.mug10);
        bitmapGrass = BitmapFactory.decodeResource(context.getResources(), R.drawable.xot);
        bitmapbg = BitmapFactory.decodeResource(context.getResources(), R.drawable.erkinq);
        bitmapkust = BitmapFactory.decodeResource(context.getResources(), R.drawable.kustik);
        bitmapHeart = BitmapFactory.decodeResource(context.getResources(), R.drawable.srtik);
        bitmapDirt = BitmapFactory.decodeResource(context.getResources(),R.drawable.kextik);
        bitmapHungry = BitmapFactory.decodeResource(context.getResources(),R.drawable.tarelka);
        bitmapSleep = BitmapFactory.decodeResource(context.getResources(),R.drawable.zzz);
        bitmapHappy = BitmapFactory.decodeResource(context.getResources(),R.drawable.smilik);
        eatButtonBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.chervyak);
        eatButtonBitmap2 =  BitmapFactory.decodeResource(context.getResources(),R.drawable.chervyak);
        highScoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.highscore);
        scoreBitmap =  BitmapFactory.decodeResource(context.getResources(),R.drawable.score);
        bitmap = bitmapSmile1;
        life = ResourcesCompat.getColor(context.getResources(),R.color.life,null);
        dirt = ResourcesCompat.getColor(context.getResources(),R.color.dirt,null);
        hungry = ResourcesCompat.getColor(context.getResources(),R.color.hungry,null);
        sleep = ResourcesCompat.getColor(context.getResources(),R.color.sleep,null);
        happy = ResourcesCompat.getColor(context.getResources(),R.color.happy,null);
    }

    public DrawThread() {}

    public void setTouch(int x, int y){
        lastTouchX = x;
        lastTouchY = y;
    }
    public void requestStop() {
        running = false;
    }
    @Override
    public void run() {
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                try {
                    paintBlack.setColor(Color.BLACK);
                    paintBlack.setStyle(Paint.Style.STROKE);
                    paintBlack.setStrokeWidth((float) canvas.getWidth()/540);
                    // background
                    bitmapGrass = Bitmap.createScaledBitmap(bitmapGrass,canvas.getWidth(),canvas.getHeight()/2,true);
                    bitmapbg = Bitmap.createScaledBitmap(bitmapbg,canvas.getWidth(),canvas.getHeight(),true);
                    bitmapkust = Bitmap.createScaledBitmap(bitmapkust,canvas.getWidth()*245/1050,canvas.getHeight()*180/540,true);
                    paint.setSubpixelText(true);paint.setAntiAlias(true);paintLife.setSubpixelText(true);paintLife.setAntiAlias(true);paintBlack.setSubpixelText(true);paintBlack.setAntiAlias(true);
                    //hetevi fon
                    canvas.drawBitmap(bitmapbg,0,0,paint);
                    canvas.drawBitmap(bitmapGrass,0,(float)canvas.getHeight() / 2,paint);
                    canvas.drawBitmap(bitmapkust,(float) canvas.getWidth()*29/1050,(float)canvas.getHeight() *230/540,paint);
                    // highscore/score
                    highScoreBitmap = Bitmap.createScaledBitmap(highScoreBitmap,canvas.getWidth()*212/1050,canvas.getHeight()*53/540,true);
                    canvas.drawBitmap(highScoreBitmap,0,(float)canvas.getHeight()*10/540,paint);
                    scoreBitmap = Bitmap.createScaledBitmap(scoreBitmap,canvas.getWidth()*119/1050,canvas.getHeight()*43/540,true);
                    canvas.drawBitmap(scoreBitmap,0,(float)canvas.getHeight()*67/540,paint);
                    // kyanqy
                    float lifeLeft = (float) canvas.getWidth()*844/1050;
                    float lifeTop = (float)canvas.getHeight()*8/540;
                    if(m2 == 0){lifeRight = (float)canvas.getWidth()*1040/1050; m2 = 1;}
                    float lifeRight2 = (float)canvas.getWidth()*1040/1050;
                    float lifeBottom = (float)canvas.getHeight()*42/540;
                    paintLife.setColor(life);
                    canvas.drawRect((float) canvas.getWidth()*843/1050,(float)canvas.getHeight()*7/540,
                            (float)canvas.getWidth()*1041/1050,(float)canvas.getHeight()*43/540,paintBlack);
                    canvas.drawRect(lifeLeft,lifeTop,lifeRight,lifeBottom,paintLife);
                    // kextotutyun
                    paintDirt.setColor(dirt);
                    float dirtLeft = (float) canvas.getWidth()*877/1050;
                    float dirtTop = (float) canvas.getHeight()*55/540;
                    float dirtRight2 = (float) canvas.getWidth()*1040/1050;
                    float dirtWeight = dirtRight2 - dirtLeft;
                    if(m3 == 0){dirtRight = (float) canvas.getWidth()*1040/1050;m3 = 1;}
                    float dirtBottom = (float) canvas.getHeight()*79/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*54/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*80/540,paintBlack);
                    canvas.drawRect(dirtLeft,dirtTop,dirtRight,dirtBottom,paintDirt);
                    // kexti timer
                    if(!dirtTimeIsPassed){
                        new DirtTimerThread().start();
                        dirtTimeIsPassed = true;
                    }
                    if (dirtNeedToDrawNow){
                        if(dirtRight - k* dirtWeight >= dirtLeft) {
                            k *= dirtWeight;
                            dirtRight -= k;
                            canvas.drawRect(dirtLeft,dirtTop,dirtRight,dirtBottom,paintDirt);
                            k/=  dirtWeight;
                        }
                        if(dirtRight >= dirtLeft && dirtRight - k* dirtWeight < dirtLeft) {
                            dirtRight = dirtLeft;
                            canvas.drawRect(dirtLeft,dirtTop,dirtRight,dirtBottom,paintDirt);
                        }
                        dirtNeedToDrawNow = false;
                    }
                    // sov
                    paintHungry.setColor(hungry);
                    float hungryLeft = (float) canvas.getWidth()*877/1050;
                    float hungryTop = (float) canvas.getHeight()*92/540;
                    if(n == 0) {hungryRight = (float) canvas.getWidth()*1040/1050;n = 1;}
                    float hungryRight2 = (float) canvas.getWidth()*1040/1050;
                    float hungryWeight = hungryRight2 - hungryLeft;
                    float hungryBottom = (float) canvas.getHeight()*116/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*91/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*117/540,paintBlack);
                    canvas.drawRect(hungryLeft,hungryTop,hungryRight,hungryBottom,paintHungry);
                    // sovi timer
                     if(!hungryTimeIsPassed){
                         new HungryTimerThread().start();
                         hungryTimeIsPassed = true;
                     }
                     if (hungryNeedToDrawNow){
                         if(hungryRight - h*hungryWeight >= hungryLeft) {
                             h *= hungryWeight;
                             hungryRight -= h;
                             canvas.drawRect(hungryLeft,hungryTop,hungryRight,hungryBottom,paintHungry);
                             h/= hungryWeight;
                         }
                         if(hungryRight >= hungryLeft && hungryRight - h*hungryWeight < hungryLeft) {
                             hungryRight = hungryLeft;
                             canvas.drawRect(hungryLeft,hungryTop,hungryRight,hungryBottom,paintHungry);
                         }
                         hungryNeedToDrawNow = false;
                     }
                    // qun
                    paintSleep.setColor(sleep);
                    float sleepLeft = (float) canvas.getWidth()*877/1050;
                    float sleepTop = (float) canvas.getHeight()*129/540;
                    float sleepRight2 = (float) canvas.getWidth()*1040/1050;
                    float sleepWeight = sleepRight2 - sleepLeft;
                    if(m4 == 0){sleepRight = (float) canvas.getWidth()*1040/1050;m4 = 1;}
                    float sleepBottom = (float) canvas.getHeight()*153/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*128/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*154/540,paintBlack);
                    canvas.drawRect(sleepLeft, sleepTop, sleepRight, sleepBottom, paintSleep);
                    // qni timer
                    if(!sleepTimeIsPassed){
                        new SleepTimerThread().start();
                        sleepTimeIsPassed = true;
                    }
                    if (sleepNeedToDrawNow){
                        if(sleepRight - q*sleepWeight >= sleepLeft) {
                            q *= sleepWeight;
                            sleepRight -= q;
                            canvas.drawRect(sleepLeft,sleepTop,sleepRight,sleepBottom,paintSleep);
                            q /= sleepWeight;
                        }
                        if(sleepRight >= sleepLeft && sleepRight - q*sleepWeight < sleepLeft) {
                            sleepRight = sleepLeft;
                            canvas.drawRect(sleepLeft,sleepTop,sleepRight,sleepBottom,paintSleep);
                        }
                        sleepNeedToDrawNow = false;
                    }

                    // uraxutyun
                    paintHappy.setColor(happy);
                    float happyLeft = (float) canvas.getWidth()*877/1050;
                    float happyTop = (float) canvas.getHeight()*166/540;
                    if(m1 == 0) {happyRight = (float) canvas.getWidth()*1040/1050;m1 = 1;}
                    float happyRight2 = (float) canvas.getWidth()*1040/1050;
                    float happyWeight = happyRight2 - happyLeft;
                    float happyBottom = (float) canvas.getHeight()*190/540;
                    canvas.drawRect( (float) canvas.getWidth()*876/1050, (float) canvas.getHeight()*165/540,
                            (float) canvas.getWidth()*1041/1050, (float) canvas.getHeight()*191/540,paintBlack);
                    canvas.drawRect(happyLeft,happyTop,happyRight,happyBottom,paintHappy);
                    // uraxutyan timer
                   if(!happyTimeIsPassed){
                       new HappyTimerThread().start();
                       happyTimeIsPassed = true;
                   }
                   if (happyNeedToDrawNow){
                       if(happyRight - s*happyWeight >= happyLeft) {
                           s *= happyWeight;
                           happyRight -= s;
                           canvas.drawRect(happyLeft,happyTop,happyRight,happyBottom,paintHappy);
                           s /= happyWeight;
                       }
                       if(happyRight >= happyLeft && happyRight - s*happyWeight < happyLeft) {
                           happyRight = happyLeft;
                           canvas.drawRect(happyLeft,happyTop,happyRight,happyBottom,paintHappy);
                       }
                       happyNeedToDrawNow = false;
                   }
                    // srtik
                    bitmapHeart = Bitmap.createScaledBitmap(bitmapHeart,canvas.getWidth()*49/1050,canvas.getHeight()*46/540,true);
                    canvas.drawBitmap(bitmapHeart,(float) canvas.getWidth()*816/1050,0,paint);
                    // kext
                    bitmapDirt = Bitmap.createScaledBitmap(bitmapDirt,canvas.getWidth()*60/1050,canvas.getHeight()*51/540,true);
                    canvas.drawBitmap(bitmapDirt,(float) canvas.getWidth()*840/1050,(float) canvas.getHeight()*41/540,paint);
                    // tarelka
                    bitmapHungry = Bitmap.createScaledBitmap(bitmapHungry,canvas.getWidth()*46/1050,canvas.getHeight()*33/540,true);
                    canvas.drawBitmap(bitmapHungry,(float) canvas.getWidth()*850/1050,(float) canvas.getHeight()*87/540,paint);
                    // Zzz
                    bitmapSleep = Bitmap.createScaledBitmap(bitmapSleep,canvas.getWidth()*52/1050,canvas.getHeight()*57/540,true);
                    canvas.drawBitmap(bitmapSleep,(float) canvas.getWidth()*853/1050,(float) canvas.getHeight()*110/540,paint);
                    // Smilik
                    bitmapHappy = Bitmap.createScaledBitmap(bitmapHappy,canvas.getWidth()*34/1050,canvas.getHeight()*35/540,true);
                    canvas.drawBitmap(bitmapHappy,(float) canvas.getWidth()*862/1050,(float) canvas.getHeight()*161/540,paint);
                    // utelu knopken
                    int eatButtonWidth = canvas.getWidth()*106/1050;
                    int eatButtonHeight = canvas.getHeight()*101/540;
                    float eatButtonLeft = (float) canvas.getWidth()*19/1050;
                    float eatButtonTop = (float) canvas.getHeight()*427/540;
                    eat1DarkBitmap =  Bitmap.createScaledBitmap(eat1DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat2DarkBitmap = Bitmap.createScaledBitmap(eat2DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat3DarkBitmap = Bitmap.createScaledBitmap(eat3DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat4DarkBitmap = Bitmap.createScaledBitmap(eat4DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat5DarkBitmap =  Bitmap.createScaledBitmap(eat5DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat6DarkBitmap = Bitmap.createScaledBitmap(eat6DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat7DarkBitmap =  Bitmap.createScaledBitmap(eat7DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat8DarkBitmap = Bitmap.createScaledBitmap(eat8DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat9DarkBitmap = Bitmap.createScaledBitmap(eat9DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eat10DarkBitmap = Bitmap.createScaledBitmap(eat10DarkBitmap,eatButtonWidth, eatButtonHeight,true);
                    eatButtonBitmap = Bitmap.createScaledBitmap(eatButtonBitmap,eatButtonWidth, eatButtonHeight,true);
                    eatButtonBitmap2 = Bitmap.createScaledBitmap(eatButtonBitmap2,eatButtonWidth, eatButtonHeight,true);
                    if(!eatChecker && checkEatButton) {
                        new EatDarkButtonThread().start();
                        checkEatButton = false;
                    }
                    if(drawEatButton) {
                        switch (eatTimer){
                            case 9:
                                eatButtonBitmap = eat9DarkBitmap;
                                break;
                            case 8:
                                eatButtonBitmap = eat8DarkBitmap;
                                break;
                            case 7:
                                eatButtonBitmap = eat7DarkBitmap;
                                break;
                            case 6:
                                eatButtonBitmap = eat6DarkBitmap;
                                break;
                            case 5:
                                eatButtonBitmap = eat5DarkBitmap;
                                break;
                            case 4:
                                eatButtonBitmap = eat4DarkBitmap;
                                break;
                            case 3:
                                eatButtonBitmap = eat3DarkBitmap;
                                break;
                            case 2:
                                eatButtonBitmap = eat2DarkBitmap;
                                break;
                            case 1:
                                eatButtonBitmap = eat1DarkBitmap;
                                break;
                            case 0:
                                eatButtonBitmap = eatButtonBitmap2;
                                eatChecker = true;
                                lastTouchX = 0;
                                lastTouchY = 0;
                        }
                    }
                    canvas.drawBitmap(eatButtonBitmap,eatButtonLeft,eatButtonTop,paint);

                    // cter
                    bitmapUsual1 = Bitmap.createScaledBitmap(bitmapUsual1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapUsual2 = Bitmap.createScaledBitmap(bitmapUsual2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTSH1 = Bitmap.createScaledBitmap(bitmapDTSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTSH2 = Bitmap.createScaledBitmap(bitmapDTSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTS1 = Bitmap.createScaledBitmap(bitmapDTS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTS2 = Bitmap.createScaledBitmap(bitmapDTS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTH1 = Bitmap.createScaledBitmap(bitmapDTH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDTH2 = Bitmap.createScaledBitmap(bitmapDTH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDSH1 = Bitmap.createScaledBitmap(bitmapDSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDSH2 = Bitmap.createScaledBitmap(bitmapDSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTSH1 = Bitmap.createScaledBitmap(bitmapTSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTSH2 = Bitmap.createScaledBitmap(bitmapTSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDH1 = Bitmap.createScaledBitmap(bitmapDH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDH2 = Bitmap.createScaledBitmap(bitmapDH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDS1 = Bitmap.createScaledBitmap(bitmapDS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDS2 = Bitmap.createScaledBitmap(bitmapDS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDT1 = Bitmap.createScaledBitmap(bitmapDT1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapDT2 = Bitmap.createScaledBitmap(bitmapDT2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSH1 = Bitmap.createScaledBitmap(bitmapSH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSH2 = Bitmap.createScaledBitmap(bitmapSH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTH1 = Bitmap.createScaledBitmap(bitmapTH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTH2 = Bitmap.createScaledBitmap(bitmapTH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTS1 = Bitmap.createScaledBitmap(bitmapTS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapTS2 = Bitmap.createScaledBitmap(bitmapTS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapD1 = Bitmap.createScaledBitmap(bitmapD1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapD2 = Bitmap.createScaledBitmap(bitmapD2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapT1 = Bitmap.createScaledBitmap(bitmapT1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapT2 = Bitmap.createScaledBitmap(bitmapT2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapS1 = Bitmap.createScaledBitmap(bitmapS1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapS2 = Bitmap.createScaledBitmap(bitmapS2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapH1 = Bitmap.createScaledBitmap(bitmapH1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapH2 = Bitmap.createScaledBitmap(bitmapH2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSmile1 = Bitmap.createScaledBitmap(bitmapSmile1,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    bitmapSmile2 = Bitmap.createScaledBitmap(bitmapSmile2,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    if(hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft< dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft< sleepWeight / 2.) {
                        bitmap1 = bitmapDTSH1;
                        bitmap2 = bitmapDTSH2;
                    }
                    else if (dirtRight  - dirtLeft< dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft< sleepWeight / 2.) {
                        bitmap1 = bitmapDTS1;
                        bitmap2 = bitmapDTS2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && happyRight - happyLeft < happyWeight / 3. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapTSH1;
                        bitmap2 = bitmapTSH2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft< dirtWeight / 2. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDTH1;
                        bitmap2 = bitmapDTH2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapDSH1;
                        bitmap2 = bitmapDSH2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && dirtRight - dirtLeft < dirtWeight / 2.) {
                        bitmap1 = bitmapDH1;
                        bitmap2 = bitmapDH2;
                    }
                    else if (dirtRight - dirtLeft < dirtWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapDS1;
                        bitmap2 = bitmapDS2;
                    }
                    else if (dirtRight - dirtLeft < dirtWeight / 2. && sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapDT1;
                        bitmap2 = bitmapDT2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapSH1;
                        bitmap2 = bitmapSH2;
                    }
                    else if (sleepRight - sleepLeft < sleepWeight / 2. && hungryRight - hungryLeft < hungryWeight / 2.) {
                        bitmap1 = bitmapTH1;
                        bitmap2 = bitmapTH2;
                    }
                    else if (sleepRight - sleepLeft < sleepWeight / 2. && happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapTS1;
                        bitmap2 = bitmapTS2;
                    }
                    else if (dirtRight - dirtLeft < dirtWeight / 2.) {
                        bitmap1 = bitmapD1;
                        bitmap2 = bitmapD2;
                    }
                    else if (sleepRight - sleepLeft < sleepWeight / 2.) {
                        bitmap1 = bitmapT1;
                        bitmap2 = bitmapT2;
                    }
                    else if (happyRight - happyLeft < happyWeight / 3.) {
                        bitmap1 = bitmapS1;
                        bitmap2 = bitmapS2;
                    }
                    else if (hungryRight - hungryLeft < hungryWeight / 2.) {
                        bitmap1 = bitmapH1;
                        bitmap2 = bitmapH2;
                    }
                    else if(happyRight - happyLeft < (2.)*happyWeight/3.) {
                        bitmap1 = bitmapUsual1;
                        bitmap2 = bitmapUsual2;
                    }
                    else {
                        bitmap1 = bitmapSmile1;
                        bitmap2 = bitmapSmile2;
                    }
                    if(m == 0) {bitmap = bitmap1;m = 1;}
                    //utox cit
                    eat1Bitmap = Bitmap.createScaledBitmap(eat1Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat2Bitmap = Bitmap.createScaledBitmap(eat2Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat3Bitmap = Bitmap.createScaledBitmap(eat3Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat4Bitmap = Bitmap.createScaledBitmap(eat4Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat5Bitmap = Bitmap.createScaledBitmap(eat5Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat6Bitmap = Bitmap.createScaledBitmap(eat6Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat7Bitmap = Bitmap.createScaledBitmap(eat7Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat8Bitmap = Bitmap.createScaledBitmap(eat8Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat9Bitmap = Bitmap.createScaledBitmap(eat9Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    eat10Bitmap = Bitmap.createScaledBitmap(eat10Bitmap,canvas.getWidth() * 145 / 1050,canvas.getHeight()*172/540,true);
                    // cit
                    canvas.drawBitmap(bitmap,(float) canvas.getWidth() * 419/1050,(float) canvas.getHeight()*232/540,paint);
                    //shnchel
                    if(!eating) {
                        if (!timeIsPassed1 && !check) {
                            new ThreadBird1().start();
                            timeIsPassed1 = true;
                        }
                        if (needToDrawNow1 && !check) {
                            bitmap = bitmap1;
                        }
                        if (!timeIsPassed2 && check) {
                            new ThreadBird2().start();
                            timeIsPassed2 = true;
                        }
                        if (needToDrawNow2 && check) {
                            bitmap = bitmap2;
                        }
                    }
                    // utel
                    paint.setTextSize(eatButtonHeight);
                    if(lastTouchX >= eatButtonLeft && lastTouchX <= eatButtonLeft + eatButtonWidth && lastTouchY >= eatButtonTop && lastTouchY <= eatButtonTop + eatButtonHeight && eatChecker) {
                        if(e == 0) {
                            food *= (hungryRight2 - hungryLeft);
                            if (hungryRight + food > hungryRight2) {
                                hungryRight = hungryRight2;
                            } else {
                                hungryRight += food;
                            }
                            food /= (hungryRight2 - hungryLeft);
                            e = 1;
                        }
                        if(!eatingTimeIsPassed) {
                            new EatingThread().start();
                            eating = true;
                            eatingTimeIsPassed = true;
                        }
                    }
                    if(eatingNeedToDrawNow){
                        switch (eat){
                            case 1:
                                bitmap = eat1Bitmap;
                                break;
                            case 2:
                                bitmap = eat2Bitmap;
                                break;
                            case 3:
                                bitmap = eat3Bitmap;
                                break;
                            case 4:
                                bitmap = eat4Bitmap;
                                break;
                            case 5:
                                bitmap = eat5Bitmap;
                                break;
                            case 6:
                                bitmap = eat6Bitmap;
                                break;
                            case 7:
                                bitmap = eat7Bitmap;
                                break;
                            case 8:
                                bitmap = eat8Bitmap;
                                break;
                            case 9:
                                bitmap = eat9Bitmap;
                                break;
                            case 10:
                                bitmap = eat10Bitmap;
                                eating = false;
                                eat = 0;
                                lastTouchY = 0;
                                lastTouchX = 0;
                                eatChecker = false;
                                checkEatButton = true;
                                e = 0;
                                eatButtonBitmap = eat10DarkBitmap;
                                eatTimer = 10;
                                break;
                        }
                    }
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
    class DirtTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                dirtTimeIsPassed = false;
                dirtNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class HungryTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                hungryTimeIsPassed = false;
                hungryNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class SleepTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                sleepTimeIsPassed = false;
                sleepNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class HappyTimerThread extends  Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                happyTimeIsPassed = false;
                happyNeedToDrawNow = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    class ThreadBird1 extends Thread{
        @Override
        public void run() {
            try {
                sleep(1500);
                timeIsPassed1 = false;
                needToDrawNow1 = true;
                check = true;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class ThreadBird2 extends Thread{
        @Override
        public void run() {
            try {
                sleep(1000);
                timeIsPassed2 = false;
                needToDrawNow2 = true;
                check = false;
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class EatingThread extends Thread{
        @Override
        public void run() {
            try {
                if(eat<10) {
                    eat++;
                    sleep(190);
                    eatingTimeIsPassed = false;
                    eatingNeedToDrawNow = true;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class EatDarkButtonThread extends Thread{
        @Override
        public void run() {
            try {
                if(eatTimer>=0) {
                    sleep(1000);
                    checkEatButton = true;
                    drawEatButton = true;
                    eatTimer--;
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

