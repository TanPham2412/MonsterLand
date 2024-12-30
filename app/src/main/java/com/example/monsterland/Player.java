package com.example.monsterland;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import java.util.Random;

@SuppressLint("SetTextI18n")
public class Player {

    GameScreen gameScreen;
    public int playerHp = 60;
    public int playerMaxHp = 60;
    public String playerWeapon;
    boolean leatherArmor = false;
    boolean smallShield = false;
    boolean specialPotion = false;
    Random random = new Random();

    public int playerAttack, healingPotion = 1, hpHeal, expGain, playerExp, expNeed = 100;
    public int minAtk, maxAtk, newMinAtk, newMaxAtk, oldMinAtk, oldMaxAtk;

    public Player(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public void dropHealingPotion() {
        healingPotion++;
        updateUIHealingPotion();
    }

    public void useHealingButton() {
        if (healingPotion > 0 && playerHp < playerMaxHp) {
            flashGreenScreen();
            int randomHP = 50 + random.nextInt(31);
            hpHeal = randomHP * playerMaxHp / 10 / 10;
            playerHp = Math.min(playerHp + hpHeal, playerMaxHp);
            healingPotion--;
            updateUIHealingPotion();
            showToast("Bạn đã hồi được " + hpHeal + " hp!", 3000);
        } else {
            handleNoHealingPotion();
        }
    }

    private void updateUIHealingPotion() {
        gameScreen.playerHPTextView.setText("HP: " + playerHp + "/" + playerMaxHp);
        gameScreen.healingPotionTextView.setText("x" + healingPotion);
    }

    private void handleNoHealingPotion() {
        if (playerHp == playerMaxHp) {
            showToast("Hp đã đầy, không thể sử dụng!!!", 3000);
        } else {
            showToast("Bạn không có bình máu!!!", 3000);
        }
        updateUIHealingPotion();
    }

    private void flashGreenScreen() {
        View gameScreenLayout = gameScreen.findViewById(R.id.heal_flash);
        if (gameScreenLayout != null) {
            gameScreenLayout.setVisibility(View.VISIBLE);
            ObjectAnimator colorAnim = ObjectAnimator.ofObject(gameScreenLayout, "backgroundColor", new ArgbEvaluator(),
                    Color.parseColor("#86F407"), Color.parseColor("#000000"));
            colorAnim.setDuration(600);
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim.setInterpolator(new AccelerateDecelerateInterpolator());
            colorAnim.start();

            new Handler().postDelayed(() -> gameScreenLayout.setVisibility(View.INVISIBLE), 600);
        }
    }

    public void showToast(String message, int timeShowMessage) {
        Toast toast = Toast.makeText(gameScreen, message, Toast.LENGTH_LONG);
        toast.show();
        new Handler().postDelayed(toast::cancel, timeShowMessage);
    }

    public void playerExpGain() {
        expGain = 60 + random.nextInt(41);
        playerExp += expGain;
        if (playerExp >= expNeed) {
            levelUp();
        } else {
            showToast("Bạn nhận được " + expGain + " exp. Bạn cần thêm " + (expNeed - expGain) + " exp để lên cấp!!!", 5000);
        }
    }

    private void levelUp() {
        showToast("Bạn nhận được " + expGain + " exp. Bạn đã lên cấp!! Mọi chỉ số của bạn được tăng lên!!", 5000);
        minAtk++;
        playerMaxHp += 10;
        hpHeal = 20 + random.nextInt(21);
        playerHp = Math.min(playerHp + hpHeal, playerMaxHp);
        playerExp = playerExp - expNeed;
        expNeed += 20;
        updateUIStats();
    }

    private void updateUIStats() {
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - " + (minAtk + maxAtk - 1));
        gameScreen.playerHPTextView.setText("HP: " + playerHp + "/" + playerMaxHp);
    }

    // Tối ưu hóa việc thay đổi vũ khí
    private void updateWeapon(int newMinAtk, int newMaxAtk, String weaponName) {
        this.newMinAtk = newMinAtk;
        this.newMaxAtk = newMaxAtk;
        minAtk += newMinAtk - oldMinAtk;
        maxAtk += newMaxAtk - oldMaxAtk;
        oldMinAtk = newMinAtk;
        oldMaxAtk = newMaxAtk;
        playerWeapon = weaponName;
        updateUIWeapon();
    }

    private void updateUIWeapon() {
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - " + (minAtk + maxAtk - 1));
        gameScreen.playerWeaponTextView.setText("Vũ khí: " + playerWeapon);
    }

    public void playerUseStick() {
        updateWeapon(2, 2, "Gậy gỗ");
    }

    public void playerUseRustyKnife() {
        updateWeapon(3, 3, "Dao rỉ");
    }

    public void playerUseBanditKnife() {
        updateWeapon(4, 4, "Dao găm");
    }

    public void playerUseSword() {
        updateWeapon(6, 4, "Kiếm sắt");
    }

    public void playerUseArmor() {
        if (leatherArmor) {
            playerUseLeaderArmor();
        }
    }

    public void playerUseLeaderArmor() {
        gameScreen.monster.minAtk -= 1;
        gameScreen.monster.maxAtk -= 1;
    }
}
