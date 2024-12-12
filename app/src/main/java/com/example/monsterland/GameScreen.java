package com.example.monsterland;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class GameScreen extends AppCompatActivity {

    ImageView gameImageView;
    TextView gameTextView, playerHPTextView, playerAttackTextView, monsterHPTextView, monsterAttackTextView, playerWeaponTextView, healingPotionTextView;
    Button button1, button2, button3, continueButton, useHealingButton, titleButton, saveButton;
    ImageButton settingButton;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Dialog dialog;
    Story story = new Story(this);
    StoryCastle storyCastle = new StoryCastle(this);
    StoryTenebris storyTenebris = new StoryTenebris(this);
    StoryArgentis storyArgentis = new StoryArgentis(this);

    Monster monster = new Monster(this);
    Battle battle = new Battle(this);

    Player player = new Player(this);

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        sharedPreferences = getSharedPreferences("GameSaveData", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        dialog = new Dialog(GameScreen.this);
        dialog.setContentView(R.layout.setting_popup);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_setting_popup));
        dialog.setCancelable(false);

        gameImageView = findViewById(R.id.gameImageView);
        gameTextView = findViewById(R.id.gameTextView);
        playerHPTextView = findViewById(R.id.playerHPTextView);
        playerAttackTextView = findViewById(R.id.playerAttackTextView);
        playerWeaponTextView = findViewById(R.id.playerWeaponTextView);
        monsterHPTextView = findViewById(R.id.monsterHpTextView);
        monsterAttackTextView = findViewById(R.id.monsterAttackTextView);
        healingPotionTextView = findViewById(R.id.healingPotionTextView);

        button1 = findViewById(R.id.choiceButton1);
        button2 = findViewById(R.id.choiceButton2);
        button3 = findViewById(R.id.choiceButton3);

        settingButton = findViewById(R.id.settingButton);
        continueButton = dialog.findViewById(R.id.continueButton);
        titleButton = dialog.findViewById(R.id.titleButton);
        saveButton = dialog.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> saveGame());

        settingButton.setOnClickListener(v -> dialog.show());

        continueButton.setOnClickListener(v -> dialog.dismiss());

        titleButton.setOnClickListener(v -> goTitleScreen());

        useHealingButton = findViewById(R.id.useHealingButton);
        useHealingButton.setOnClickListener(v -> player.useHealingButton());

        button1.setTransformationMethod(null);
        button2.setTransformationMethod(null);
        button3.setTransformationMethod(null);


        String savedPosition = getIntent().getStringExtra("savedPosition");
        if (savedPosition != null) {
            loadGame(savedPosition);
        } else {
            storyCastle.opening1();
        }
    }

    public void button1(View view) {
        story.selectPosition(story.nextPosition1);
    }

    public void button2(View view) {
        story.selectPosition(story.nextPosition2);
    }

    public void button3(View view) {
        story.selectPosition(story.nextPosition3);
    }

    public void goTitleScreen() {
        Intent titleScreenIntent = new Intent(this, TitleScreen.class);
        startActivity(titleScreenIntent);
    }

    public void saveGame() {
        editor.putInt("playerHp", player.playerHp);
        editor.putInt("playerMaxHp", player.playerMaxHp);
        editor.putString("playerWeapon", player.playerWeapon);
        editor.putInt("playerExp", player.playerExp);
        editor.putInt("healingPotion", player.healingPotion);
        editor.putInt("minAtk", player.minAtk);
        editor.putInt("maxAtk", player.maxAtk);
        editor.putInt("expNeed", player.expNeed);
        editor.putBoolean("leatherArmor", player.leatherArmor);
        editor.putBoolean("specialPotion", player.specialPotion);
        editor.putBoolean("smallShield", player.smallShield);

        editor.putBoolean("knightDead", storyCastle.knightDead);

        editor.putBoolean("tenebris", storyTenebris.tenebris);
        editor.putBoolean("repayGoblin", storyTenebris.repayGoblin);
        editor.putBoolean("goblinCurse", storyTenebris.goblinCurse);
        editor.putBoolean("wolfTrap", storyTenebris.wolfTrap);
        editor.putInt("boneDart", storyTenebris.boneDart);

        editor.putString("race", story.race);
        editor.putInt("monsterHP", monster.monsterHP);
        editor.putInt("monsterMinAtk", monster.minAtk);
        editor.putInt("monsterMaxAtk", monster.maxAtk);

        editor.putString("nextPosition", story.nextPosition);
        editor.putString("nextPositionTwo", story.nextPositionTwo);
        editor.putString("storyPosition", story.savePosition);

        editor.apply();

        Toast.makeText(this, "Game Saved!", Toast.LENGTH_SHORT).show();
    }


    public void loadGame(String savedPosition) {
        if (sharedPreferences.contains("playerHp")) {
            player.playerHp = sharedPreferences.getInt("playerHp", player.playerHp);
            player.playerMaxHp = sharedPreferences.getInt("playerMaxHp", player.playerMaxHp);
            player.playerWeapon = sharedPreferences.getString("playerWeapon", player.playerWeapon);
            player.playerExp = sharedPreferences.getInt("playerExp", player.playerExp);

            player.healingPotion = sharedPreferences.getInt("healingPotion", player.healingPotion);
            player.minAtk = sharedPreferences.getInt("minAtk", player.minAtk);
            player.maxAtk = sharedPreferences.getInt("maxAtk", player.maxAtk);
            player.expNeed = sharedPreferences.getInt("expNeed", player.expNeed);

            player.leatherArmor = sharedPreferences.getBoolean("leatherArmor", player.leatherArmor);
            player.specialPotion = sharedPreferences.getBoolean("specialPotion", player.specialPotion);
            player.specialPotion = sharedPreferences.getBoolean("smallShield", player.smallShield);
            story.savePosition = savedPosition;

            playerHPTextView.setText("HP: " + player.playerHp + "/" + player.playerMaxHp);
            playerWeaponTextView.setText("Vũ khí: " + player.playerWeapon);
            healingPotionTextView.setText("x" + player.healingPotion);
            playerAttackTextView.setText("Atk: " + player.minAtk + " - " + (player.minAtk + player.maxAtk - 1));

            storyCastle.knightDead = sharedPreferences.getBoolean("knightDead", storyCastle.knightDead);

            storyTenebris.repayGoblin = sharedPreferences.getBoolean("repayGoblin", storyTenebris.repayGoblin);
            storyTenebris.goblinCurse = sharedPreferences.getBoolean("goblinCurse", storyTenebris.goblinCurse);
            storyTenebris.wolfTrap = sharedPreferences.getBoolean("wolfTrap", storyTenebris.wolfTrap);
            storyTenebris.tenebris = sharedPreferences.getBoolean("tenebris", storyTenebris.tenebris);
            storyTenebris.boneDart = sharedPreferences.getInt("boneDart", storyTenebris.boneDart);

            story.race = sharedPreferences.getString("race", story.race);
            monster.monsterHP = sharedPreferences.getInt("monsterHP", monster.monsterHP);
            monster.minAtk = sharedPreferences.getInt("monsterMinAtk", monster.minAtk);
            monster.maxAtk = sharedPreferences.getInt("monsterMaxAtk", monster.maxAtk);

            monsterHPTextView.setText("Hp: " + monster.monsterHP);
            monsterAttackTextView.setText("Atk: " + monster.minAtk + " - " + (monster.minAtk + monster.maxAtk - 1));

            story.nextPosition = sharedPreferences.getString("nextPosition", story.nextPosition);
            story.nextPositionTwo = sharedPreferences.getString("nextPositionTwo", story.nextPositionTwo);
            story.selectPosition(savedPosition);
        } else {
            storyCastle.opening1();
        }
    }

}
