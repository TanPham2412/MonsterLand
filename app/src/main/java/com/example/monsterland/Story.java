package com.example.monsterland;

import android.view.View;

public class Story {

    GameScreen gameScreen;
    String savePosition;
    String nextPosition1, nextPosition2, nextPosition3, nextPosition, nextPositionTwo;

    String race;

    public Story(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void showAllButton() {
        gameScreen.button1.setVisibility(View.VISIBLE);
        gameScreen.button2.setVisibility(View.VISIBLE);
        gameScreen.button3.setVisibility(View.VISIBLE);
    }

    public void selectPosition(String position) {
        switch (position) {
            case "opening1":
                gameScreen.storyCastle.opening1();
                break;
            case "opening2":
                gameScreen.storyCastle.opening2();
                break;
            case "meetCat":
                gameScreen.storyCastle.meetCat();
                break;
            case "trashCan":
                gameScreen.storyCastle.trashCan();
                break;
            case "useKnife":
                gameScreen.storyCastle.useKnife();
                break;
            case "notUseKnife":
                gameScreen.storyCastle.notUseKnife();
                break;
            case "alley":
                gameScreen.storyCastle.alley();
                break;
            case "intoAlley":
                gameScreen.storyCastle.intoAlley();
                break;
            case "sneakAttack":
                gameScreen.storyCastle.sneakAttack();
                break;
            case "attack":
                gameScreen.storyCastle.attack();
                break;
            case "run":
                gameScreen.storyCastle.run();
                break;
            case "runBeforeAttack":
                gameScreen.storyCastle.runBeforeAttack();
                break;
            case "dead":
                gameScreen.storyCastle.dead();
                break;
            case "goTitleScreen":
                gameScreen.goTitleScreen();
                break;
            case "banditKnife":
                gameScreen.storyCastle.banditKnife();
                break;
            case "intoAlley1":
                gameScreen.storyCastle.intoAlley1();
                break;
            case "outsideCastle":
                gameScreen.storyCastle.outsideCastle();
                break;
            case "keepGoing":
                gameScreen.storyCastle.keepGoing();
                break;
            case "checkAtGate":
                gameScreen.storyCastle.checkAtGate();
                break;
            case "leatherArmor":
                gameScreen.storyCastle.leatherArmor();
                break;
            case "useLeatherArmor":
                gameScreen.storyCastle.useLeatherArmor();
                break;
            case "notUseLeatherArmor":
                gameScreen.storyCastle.notUseLeatherArmor();
                break;
            case "meetMira":
                gameScreen.storyCastle.meetMira();
                break;
            case "tellTruth":
                gameScreen.storyCastle.tellTruth();
                break;
            case "lie":
                gameScreen.storyCastle.lie();
                break;
            case "refuseAnswer":
                gameScreen.storyCastle.refuseAnswer();
                break;
            case "getOutMiraHome":
                gameScreen.storyCastle.getOutMiraHome();
                break;
            case "knightDead":
                gameScreen.storyCastle.knightDead();
                break;
            case "woodenSign":
                gameScreen.storyCastle.woodenSign();
                break;
            case "tenebris":
                gameScreen.storyTenebris.tenebris();
                break;
            case "woodenSign1":
                gameScreen.storyTenebris.woodenSign1();
                break;
            case "meetGoblin":
                gameScreen.storyTenebris.meetGoblin();
                break;
            case "pleaseMeat":
                gameScreen.storyTenebris.pleaseMeat();
                break;
            case "meatRobbery":
                gameScreen.storyTenebris.meatRobbery();
                break;
            case "leave":
                gameScreen.storyTenebris.leave();
                break;
            case "repay":
                gameScreen.storyTenebris.repay();
                break;
            case "noRepay":
                gameScreen.storyTenebris.noRepay();
                break;
            case "killedGoblin":
                gameScreen.storyTenebris.killedGoblin();
                break;
            case "toRiver":
                gameScreen.storyTenebris.toRiver();
                break;
            case "toVillage":
                gameScreen.storyTenebris.toVillage();
                break;
            case "inVillage":
                gameScreen.storyTenebris.inVillage();
                break;
            case "woundedSoldier":
                gameScreen.storyTenebris.woundedSoldier();
                break;
            case "convince":
                gameScreen.storyTenebris.convince();
                break;
            case "findHerb":
                gameScreen.storyTenebris.findHerb();
                break;
            case "attackWolf":
                gameScreen.storyTenebris.attackWolf();
                break;
            case "killedWolf":
                gameScreen.storyTenebris.killedWolf();
                break;
            case "retreat":
                gameScreen.storyTenebris.retreat();
                break;
            case "distract":
                gameScreen.storyTenebris.distract();
                break;
        }
    }
}