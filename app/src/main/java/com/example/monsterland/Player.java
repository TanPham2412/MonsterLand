package com.example.monsterland;

import android.os.Handler;
import android.widget.Toast;

import java.util.Random;

public class Player {

    GameScreen gameScreen;
    public int playerHp = 50;
    public int playerMaxHp = 50;
    public String playerWeapon;
    boolean leatherArmor = false;
    Random random = new Random();

    public int playerAttack, healingPotion = 1, hpHeal, expGain, playerExp, expNeed = 100;
    public int minAtk, maxAtk;

    public Player(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public void dropHealingPotion(){
        healingPotion += 1;
        gameScreen.playerHPTextView.setText("HP: "+playerHp);
        gameScreen.healingPotionTextView.setText("x"+healingPotion);
        showToast("Bạn nhận được một bình máu sau khi đánh bại kẻ địch", 3000);
    }


    public void useHealingButton() {
        if (healingPotion > 0) {
            if (playerHp < playerMaxHp) {
                int randomHP = 40 + random.nextInt(31) ;
                hpHeal = randomHP * playerMaxHp / 10 / 10;
                playerHp += hpHeal;
                healingPotion--;
                if (playerHp > playerMaxHp) {
                    playerHp = playerMaxHp;
                }
                gameScreen.playerHPTextView.setText("HP: "+playerHp);
                gameScreen.healingPotionTextView.setText("x"+healingPotion);
                showToast("Bạn đã hồi được " + hpHeal + " hp!", 3000);
            } else {
                gameScreen.playerHPTextView.setText("HP: "+playerHp);
                gameScreen.healingPotionTextView.setText("x"+healingPotion);
                showToast("Hp đã đầy, không thể sử dụng!!!", 3000);
            }
        } else {
            gameScreen.playerHPTextView.setText("HP: "+playerHp);
            gameScreen.healingPotionTextView.setText("x"+healingPotion);
            showToast("Bạn không có bình máu!!!", 3000);
        }
    }

    private void showToast(String message, int timeShowMessage) {
        Toast toast = Toast.makeText(gameScreen, message, Toast.LENGTH_LONG);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, timeShowMessage);
    }
    public void playerUseStick(){
        //2 - 3
        minAtk = 2;
        maxAtk = 2;
        playerWeapon = "Gậy gỗ";
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.playerWeaponTextView.setText("Vũ khí: " + playerWeapon);
    }
    public void playerUseRustyKnife(){
        //3 - 5
        minAtk += 1;
        maxAtk += 1;
        playerWeapon = "Dao rỉ";
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.playerWeaponTextView.setText("Vũ khí: " + playerWeapon);
    }

    public void playerUseLeaderArmor(){
        gameScreen.monster.minAtk -= 1;
        gameScreen.monster.maxAtk -= 1;
    }

    public void playerExpGain(){
        expGain = 60 + random.nextInt(41);
        playerExp += expGain;
        if (playerExp >= expNeed){
            showToast("Bạn nhận được "+expGain+". Bạn đã lên cấp!! Mọi chỉ số của bạn được tăng lên!!",5000);
            minAtk += 1;
            playerMaxHp += 10;
            int randomHP = 20 + random.nextInt(21) ;
            hpHeal = randomHP * playerMaxHp / 10 / 10;
            playerHp += hpHeal;
            if (playerHp > playerMaxHp) {
                playerHp = playerMaxHp;
            }
            playerExp = 0;
            expNeed += 20;
            gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
            gameScreen.playerHPTextView.setText("Hp: "+playerHp);
        }else {
            showToast("Bạn nhận được "+expGain+" exp. Bạn cần thêm "+(expNeed - expGain)+" exp để lên cấp!!!",5000);
        }
    }

    public void playerUseArmor(){
        if (leatherArmor){
            playerUseLeaderArmor();
        }
    }
}

