package com.example.monsterland;

import java.util.Random;

public class Fight {
    GameScreen gameScreen;
    Random random = new Random();
    int percent, randomPercent, randomHP, hp;
    public Fight(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void random(){
        randomPercent = 1 + random.nextInt(10);
        randomHP = 30 + random.nextInt(21);
    }

    public void battle(){
        random();
        if(percent <= randomPercent){
            hp = gameScreen.monster.monsterHP * randomHP / 10 / 10;
            gameScreen.monster.monsterHP -= hp;
            gameScreen.gameTextView.setText("Bạn đánh lén thành công, đối phương bị - "+hp+" hp!!!");
            gameScreen.monsterHPTextView.setText("HP: "+gameScreen.monster.monsterHP);
        }
        else {
            gameScreen.gameTextView.setText("Bạn đánh lén thất bại, giờ đây bạn phải chiến đấu với tên cướp!!!");
        }
    }

    public void attack(){
        gameScreen.player.playerAttack = gameScreen.player.minAtk + random.nextInt(gameScreen.player.maxAtk);
        gameScreen.monster.monsterHP -= gameScreen.player.playerAttack;

        gameScreen.monster.monterAttack = gameScreen.monster.minAtk + random.nextInt(gameScreen.monster.maxAtk);
        gameScreen.player.playerHp -= gameScreen.monster.monterAttack;

        gameScreen.gameTextView.setText("Bạn gây ra "+gameScreen.player.playerAttack+" sát thương!!!\n\nĐối phương gây ra "+ gameScreen.monster.monterAttack+" sát thương!!!");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp);
        gameScreen.monsterHPTextView.setText("HP: "+gameScreen.monster.monsterHP);
    }

    public void run(){
        randomHP = 10 + random.nextInt(11);
        hp = gameScreen.player.playerMaxHp * randomHP / 10 / 10;
        if(gameScreen.player.playerHp > hp) {
            gameScreen.player.playerHp -= hp;
            gameScreen.playerHPTextView.setText("HP: " + gameScreen.player.playerHp);
            gameScreen.gameTextView.setText("Bạn chạy trốn thất bại và bị hắn làm bị thương.\n\nGiờ đây bạn phải chiến đấu!!!\n\nBạn bị - " + hp + " hp!!!");
        }
        else {
            gameScreen.player.playerHp -= (gameScreen.player.playerHp - 1);
            gameScreen.playerHPTextView.setText("HP: " + gameScreen.player.playerHp);
            gameScreen.gameTextView.setText("Bạn chạy trốn thất bại và bị hắn làm bị thương.\n\nGiờ đây bạn phải chiến đấu!!!\n\nBạn bị - " + (gameScreen.player.playerHp - 1) + " hp!!!");
        }
    }

}
