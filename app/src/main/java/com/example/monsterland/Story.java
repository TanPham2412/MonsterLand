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

    public void invisible2Button(){
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void invisible1Button(){
        gameScreen.story.nextPosition3 = "";
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
    public void resetMonsterText(){
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
    }

    public void selectPosition(String position) {
        switch (position) {
            case "opening1":
                gameScreen.storyCastle.opening1();
                break;
            case "opening":
                gameScreen.storyCastle.opening();
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
            case "useKnife1":
                gameScreen.storyCastle.useKnife1();
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
            case "waitAttack":
                gameScreen.storyCastle.waitAttack();
                break;
            case "winAttack":
                gameScreen.storyCastle.winAttack();
                break;
            case "deadAttack":
                gameScreen.storyCastle.deadAttack();
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
            case "banditKnife1":
                gameScreen.storyCastle.banditKnife1();
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
            case "useLeatherArmor1":
                gameScreen.storyCastle.useLeatherArmor1();
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
            case "knightDead1":
                gameScreen.storyCastle.knightDead1();
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
            case "repay1":
                gameScreen.storyTenebris.repay1();
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
            case "backToVillage":
                gameScreen.storyTenebris.backToVillage();
                break;
            case "noHelpGoblin":
                gameScreen.storyTenebris.noHelpGoblin();
                break;
            case "kingGoblin":
                gameScreen.storyTenebris.kingGoblin();
                break;
            case "boneDart":
                gameScreen.storyTenebris.boneDart();
                break;
            case "winBoneDart":
                gameScreen.storyTenebris.winBoneDart();
                break;
            case "deadBoneDart":
                gameScreen.storyTenebris.deadBoneDart();
                break;
            case "waitBoneDart":
                gameScreen.storyTenebris.waitBoneDart();
                break;
            case "attack1":
                gameScreen.storyTenebris.attack1();
                break;
            case "waitAttack1":
                gameScreen.storyTenebris.waitAttack1();
                break;
            case "winAttack1":
                gameScreen.storyTenebris.winAttack1();
                break;
            case "deadAttack1":
                gameScreen.storyTenebris.deadAttack1();
                break;
            case "helpGoblin":
                gameScreen.storyTenebris.helpGoblin();
                break;
            case "distract":
                gameScreen.storyTenebris.distract();
                break;
        }
    }
}