package com.example.monsterland;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
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

    public void dropHealingPotion(){
        healingPotion += 1;
        gameScreen.playerHPTextView.setText("HP: "+playerHp+"/"+playerMaxHp);
        gameScreen.healingPotionTextView.setText("x"+healingPotion);
    }
    public void useHealingButton() {
        flashGreenScreen();
        int hp = playerMaxHp - playerHp;
        if (healingPotion > 0) {
            if (playerHp < playerMaxHp) {
                int randomHP = 50 + random.nextInt(31) ;
                hpHeal = randomHP * playerMaxHp / 10 / 10;
                playerHp += hpHeal;
                healingPotion--;
                if (playerHp > playerMaxHp) {
                    playerHp = playerMaxHp;
                    gameScreen.playerHPTextView.setText("HP: "+playerHp+ "/"+playerMaxHp);
                    gameScreen.healingPotionTextView.setText("x"+healingPotion);
                    showToast("Bạn đã hồi được " + hp + " hp!", 3000);
                }else {
                    gameScreen.playerHPTextView.setText("HP: " + playerHp + "/" + playerMaxHp);
                    gameScreen.healingPotionTextView.setText("x" + healingPotion);
                    showToast("Bạn đã hồi được " + hpHeal + " hp!", 3000);
                }
            } else {
                gameScreen.playerHPTextView.setText("HP: "+playerHp+ "/"+playerMaxHp);
                gameScreen.healingPotionTextView.setText("x"+healingPotion);
                showToast("Hp đã đầy, không thể sử dụng!!!", 3000);
            }
        } else {
            gameScreen.playerHPTextView.setText("HP: "+playerHp+ "/"+playerMaxHp);
            gameScreen.healingPotionTextView.setText("x"+healingPotion);
            showToast("Bạn không có bình máu!!!", 3000);
        }
    }
    private void flashGreenScreen() {
        // Tìm View có ID heal_flash
        View gameScreenLayout = gameScreen.findViewById(R.id.heal_flash);
        if (gameScreenLayout != null) {
            // Hiển thị View với hiệu ứng ánh sáng xanh
            gameScreenLayout.setVisibility(View.VISIBLE);

            // Sử dụng ArgbEvaluator cho chuyển đổi màu từ xanh sáng đến đen
            ObjectAnimator colorAnim = ObjectAnimator.ofObject(gameScreenLayout, "backgroundColor", new ArgbEvaluator(),
                    Color.parseColor("#86F407"), Color.parseColor("#000000")); // Từ màu xanh sáng đến màu đen
            colorAnim.setDuration(600); // Tăng thời gian để hiệu ứng mượt mà hơn
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);  // Lặp lại hiệu ứng để tạo chuyển động
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);    // Lặp lại màu sắc theo hướng ngược lại
            colorAnim.setInterpolator(new AccelerateDecelerateInterpolator()); // Dùng interpolator để làm hiệu ứng mượt mà
            colorAnim.start();

            Log.d("FlashEffect", "Green flash effect applied");

            // Gỡ bỏ ánh sáng sau 600ms và ẩn View
            new Handler().postDelayed(() -> {
                gameScreenLayout.setVisibility(View.INVISIBLE); // Ẩn lại view sau khi flash
                Log.d("FlashEffect", "Green flash disappeared");
            }, 600); // Thời gian ẩn giống với thời gian hiệu ứng
        }
    }

    public void showToast(String message, int timeShowMessage) {
        Toast toast = Toast.makeText(gameScreen, message, Toast.LENGTH_LONG);
        toast.show();
        new Handler().postDelayed(toast::cancel, timeShowMessage);
    }
    public void playerExpGain(){
        expGain = 60 + random.nextInt(41);
        playerExp += expGain;
        if (playerExp >= expNeed){
            showToast("Bạn nhận được "+expGain+" exp. Bạn đã lên cấp!! Mọi chỉ số của bạn được tăng lên!!",5000);
            minAtk += 1;
            playerMaxHp += 10;
            int randomHP = 20 + random.nextInt(21) ;
            hpHeal = randomHP * playerMaxHp / 10 / 10;
            playerHp += hpHeal;
            if (playerHp > playerMaxHp) {
                playerHp = playerMaxHp;
            }
            playerExp = playerExp - expNeed;
            expNeed += 20;
            gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
            gameScreen.playerHPTextView.setText("HP: "+playerHp+ "/"+playerMaxHp);
        }else {
            showToast("Bạn nhận được "+expGain+" exp. Bạn cần thêm "+(expNeed - expGain)+" exp để lên cấp!!!",5000);
        }
    }
    public void playerUseStick(){
        //2 - 3
        minAtk = 2;
        maxAtk = 2;
        oldMinAtk = 2;
        oldMaxAtk = 2;
        playerWeapon = "Gậy gỗ";
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.playerWeaponTextView.setText("Vũ khí: " + playerWeapon);
    }
    public void playerUseRustyKnife(){
        //3 - 5
        newMinAtk = 3;
        newMaxAtk = 3;
        minAtk += newMinAtk - oldMinAtk;
        maxAtk += newMaxAtk - oldMaxAtk;
        oldMinAtk = newMinAtk;
        oldMaxAtk = newMaxAtk;
        playerWeapon = "Dao rỉ";
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.playerWeaponTextView.setText("Vũ khí: " + playerWeapon);
    }

    public void playerUseBanditKnife(){
        //4 - 7
        newMinAtk = 4;
        newMaxAtk = 4;
        minAtk += newMinAtk - oldMinAtk;
        maxAtk += newMaxAtk - oldMaxAtk;
        oldMinAtk = newMinAtk;
        oldMaxAtk = newMaxAtk;
        playerWeapon = "Dao găm";
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.playerWeaponTextView.setText("Vũ khí: " + playerWeapon);
    }

    public void playerUseSword(){
        //6 - 9
        newMinAtk = 6;
        newMaxAtk = 4;
        minAtk += newMinAtk - oldMinAtk;
        maxAtk += newMaxAtk - oldMaxAtk;
        oldMinAtk = newMinAtk;
        oldMaxAtk = newMaxAtk;
        playerWeapon = "Kiếm sắt";
        gameScreen.playerAttackTextView.setText("Atk: " + minAtk + " - "+ (minAtk + maxAtk - 1));
        gameScreen.playerWeaponTextView.setText("Vũ khí: " + playerWeapon);
    }

    public void playerUseArmor(){
        if (leatherArmor){
            playerUseLeaderArmor();
        }
    }

    public void playerUseLeaderArmor(){
        gameScreen.monster.minAtk -= 1;
        gameScreen.monster.maxAtk -= 1;
    }

}

