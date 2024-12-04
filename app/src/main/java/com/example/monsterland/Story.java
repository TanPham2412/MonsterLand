package com.example.monsterland;

import android.view.View;

public class Story {

    GameScreen gameScreen;
    String nextPosition1, nextPosition2, nextPosition3, nextPosition;

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
        }
    }
}






