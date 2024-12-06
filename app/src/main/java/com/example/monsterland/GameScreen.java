package com.example.monsterland;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class GameScreen extends AppCompatActivity {

    ImageView gameImageView;
    TextView gameTextView, playerHPTextView, playerAttackTextView, monsterHPTextView, monsterAttackTextView, playerWeaponTextView, healingPotionTextView;
    Button button1, button2, button3, continueButton, useHealingButton, titleButton;
    ImageButton settingButton;

    Dialog dialog;
    Story story = new Story(this);
    StoryCastle storyCastle = new StoryCastle(this);
    StoryArgentis storyArgentis = new StoryArgentis(this);
    StoryTenebris storyTenebris = new StoryTenebris(this);
    Player player = new Player(this);
    Monster monster = new Monster(this);
    Battle battle = new Battle(this);



    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dialog = new Dialog(GameScreen.this);
        dialog.setContentView(R.layout.setting_popup);
        //dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        Objects.requireNonNull(dialog.getWindow()).setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
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

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        titleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTitleScreen();
            }
        });

        useHealingButton = findViewById(R.id.useHealingButton);
        useHealingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.useHealingButton();

            }
        });

        button1.setTransformationMethod(null);
        button2.setTransformationMethod(null);
        button3.setTransformationMethod(null);

        storyCastle.opening1();
    }
    public void button1(View view){
        story.selectPosition(story.nextPosition1);
    }
    public void button2(View view){
        story.selectPosition(story.nextPosition2);
    }
    public void button3(View view){
        story.selectPosition(story.nextPosition3);
    }

    public void goTitleScreen(){
        Intent tileScreen = new Intent(this, TitleScreen.class);
        startActivity(tileScreen);
    }
}