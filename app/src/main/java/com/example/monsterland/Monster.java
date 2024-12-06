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
        monsterHP = 120;
        minAtk = 5;
        maxAtk = 15;
        gameScreen.monsterAttackTextView.setText("Atk: ???");
        gameScreen.monsterHPTextView.setText("Hp: ???");
        gameScreen.player.playerUseArmor();
    }

    public void gateKeeper(){
        monsterHP = 50;
        minAtk = 2;
        maxAtk = 3;
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.player.playerUseArmor();
    }

    public void knight(){
        monsterHP = 75;
        minAtk = 5;
        maxAtk = 5;
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.player.playerUseArmor();
    }

    public void goblinChild(){
        monsterHP = 20;
        minAtk = 1;
        maxAtk = 3;
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.player.playerUseArmor();
    }
}
