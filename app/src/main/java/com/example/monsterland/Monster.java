package com.example.monsterland;

import android.annotation.SuppressLint;

@SuppressLint("SetTextI18n")


public class Monster {
    GameScreen gameScreen;
    public int monsterHP, monterAttack, minAtk, maxAtk;
    public Monster(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void bandit(){
        monsterHP = 50;
        minAtk = 2;
        maxAtk = 3;
        gameScreen.player.playerUseArmor();
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = "primate";
    }

    public void aMystic(){
        monsterHP = 120;
        minAtk = 5;
        maxAtk = 15;
        gameScreen.monsterAttackTextView.setText("Atk: ???");
        gameScreen.monsterHPTextView.setText("Hp: ???");
        gameScreen.player.playerUseArmor();
        gameScreen.story.race = "primate";
    }

    public void gateKeeper(){
        monsterHP = 55;
        minAtk = 2;
        maxAtk = 4;
        gameScreen.player.playerUseArmor();
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = "primate";
    }

    public void knight(){
        monsterHP = 80;
        minAtk = 5;
        maxAtk = 5;
        gameScreen.player.playerUseArmor();
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = "primate";
    }

    public void goblinChild(){
        monsterHP = 20;
        minAtk = 2;
        maxAtk = 2;
        gameScreen.player.playerUseArmor();
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = "primate";
    }

    public void wolf(){
        monsterHP = 80;
        minAtk = 6;
        maxAtk = 5;
        gameScreen.player.playerUseArmor();
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = "animal";
    }

    public void elderGoblin(){
        monsterHP = 100;
        minAtk = 6;
        maxAtk = 6;
        gameScreen.player.playerUseArmor();
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = "primate";
    }

    public void kingGoblin(){
        monsterHP = 150;
        minAtk = 10;
        maxAtk = 6;
        gameScreen.player.playerUseArmor();
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = "primate";
    }
}
