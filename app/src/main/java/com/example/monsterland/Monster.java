package com.example.monsterland;

import java.util.Random;

public class Monster {
    GameScreen gameScreen;
    public int monsterHP, monterAttack, minAtk, maxAtk;
    public Monster(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void bandit(){
        monsterHP = 40;
        minAtk = 2;
        maxAtk = 3;
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.player.playerUseArmor();
    }

    public void aMystic(){
        monsterHP = 100;
        minAtk = 5;
        maxAtk = 11;
        gameScreen.monsterAttackTextView.setText("Atk: ???");
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.player.playerUseArmor();
    }

    public void gateKeeper(){
        monsterHP = 70;
        minAtk = 2;
        maxAtk = 4;
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.player.playerUseArmor();
    }
}
