package com.example.monsterland;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TitleScreen extends AppCompatActivity {
    Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(v -> continueGame());
    }

    public void goToGameScreen(View view) {
        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);
    }

    public void continueGame() {
        SharedPreferences sharedPreferences = getSharedPreferences("GameSaveData", MODE_PRIVATE);
        String savedPosition = sharedPreferences.getString("storyPosition", "opening1");

        Intent gameScreenIntent = new Intent(this, GameScreen.class);
        gameScreenIntent.putExtra("savedPosition", savedPosition);
        startActivity(gameScreenIntent);
    }
}
