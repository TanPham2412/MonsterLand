package com.example.monsterland;

import android.annotation.SuppressLint;

@SuppressLint("SetTextI18n")
public class Monster {
    GameScreen gameScreen;
    public int monsterHP, monterAttack, minAtk, maxAtk;

    public Monster(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    // Hàm chung để cập nhật thông tin quái vật
    private void setMonsterStats(int hp, int minAtk, int maxAtk, String race) {
        this.monsterHP = hp;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        gameScreen.player.playerUseArmor();
        // Hiển thị attack range đúng
        gameScreen.monsterAttackTextView.setText("Atk: " + minAtk + " - " + (minAtk + maxAtk - 1));
        gameScreen.monsterHPTextView.setText("Hp: " + monsterHP);
        gameScreen.story.race = race;
    }

    public void bandit() {
        setMonsterStats(50, 2, 3, "primate");
    }

    public void aMystic() {
        setMonsterStats(120, 5, 15, "primate");
        gameScreen.monsterAttackTextView.setText("Atk: ???"); // Nếu bạn muốn hiển thị không xác định
    }

    public void gateKeeper() {
        setMonsterStats(55, 2, 4, "primate");
    }

    public void knight() {
        setMonsterStats(80, 5, 5, "primate");
    }

    public void goblinChild() {
        setMonsterStats(20, 2, 2, "primate");
    }

    public void wolf() {
        setMonsterStats(80, 6, 5, "animal");
    }

    public void elderGoblin() {
        setMonsterStats(100, 6, 6, "primate");
    }

    public void kingGoblin() {
        setMonsterStats(150, 10, 6, "primate");
    }
}
