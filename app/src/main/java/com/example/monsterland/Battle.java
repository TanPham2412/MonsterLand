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

import java.util.Random;

@SuppressLint("SetTextI18n")
public class Battle {
    public GameScreen gameScreen;
    public Random random = new Random();
    public int percent, randomPercent, randomHP, hp;

    public Battle(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void random() {
        randomPercent = 1 + random.nextInt(10);
        randomHP = 30 + random.nextInt(21);
    }

    public void sneakAttack() {
        random();
        if (percent <= randomPercent) {
            hp = gameScreen.monster.monsterHP * randomHP / 100;
            gameScreen.monster.monsterHP -= hp;
            gameScreen.gameTextView.setText("Bạn đánh lén thành công! Đối phương bị bất ngờ, và cú tấn công của bạn khiến hắn mất " + hp + " điểm sinh lực. Hắn đau đớn và lùi lại, cố gắng lấy lại thế phòng thủ, nhưng bạn đã chiếm được lợi thế.");
            gameScreen.monsterHPTextView.setText("HP: " + gameScreen.monster.monsterHP);
        } else {
            gameScreen.gameTextView.setText("Bạn đánh lén thất bại! Hắn quay lại ngay lập tức, ánh mắt đầy căm thù. Không còn đường lui, bạn buộc phải chiến đấu với hắn. Con dao của hắn lấp lánh trong ánh sáng mờ ảo, và sự nguy hiểm hiện rõ trên từng bước di chuyển.");
        }
    }

    private void flashRedScreen() {
        View gameScreenLayout = gameScreen.findViewById(R.id.damage_flash);
        if (gameScreenLayout != null) {
            gameScreenLayout.setVisibility(View.VISIBLE);
            ObjectAnimator colorAnim = ObjectAnimator.ofObject(gameScreenLayout, "backgroundColor", new ArgbEvaluator(),
                    Color.parseColor("#FF0000"), Color.parseColor("#000000"));
            colorAnim.setDuration(600);
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim.setInterpolator(new AccelerateDecelerateInterpolator());
            colorAnim.start();

            new Handler().postDelayed(() -> {
                gameScreenLayout.setVisibility(View.INVISIBLE);
                Log.d("FlashEffect", "Red flash disappeared");
            }, 600);
        }
    }

    public void attack() {
        flashRedScreen();
        random();
        gameScreen.player.playerAttack = gameScreen.player.minAtk + random.nextInt(gameScreen.player.maxAtk);
        gameScreen.monster.monsterHP -= gameScreen.player.playerAttack;

        gameScreen.monster.monterAttack = gameScreen.monster.minAtk + random.nextInt(gameScreen.monster.maxAtk);
        gameScreen.player.playerHp -= gameScreen.monster.monterAttack;

        String attackMessage = generateAttackMessage(gameScreen.player.playerAttack, gameScreen.monster.monterAttack);

        if (gameScreen.player.smallShield && randomPercent <= 3) {
            gameScreen.gameTextView.setText("Cú đánh của bạn gây ra " + gameScreen.player.playerAttack + " sát thương! Đối thủ bị đẩy lùi một chút.\n\n" + "Hắn cố gắng tấn công lại, nhưng chiếc khiên của bạn đã đỡ trọn đòn đánh, giữ bạn an toàn.");
        } else {
            gameScreen.gameTextView.setText(attackMessage);
        }
        gameScreen.playerHPTextView.setText("HP: " + gameScreen.player.playerHp);
        gameScreen.monsterHPTextView.setText("HP: " + gameScreen.monster.monsterHP);
    }

    private String generateAttackMessage(int playerAttack, int monsterAttack) {
        StringBuilder message = new StringBuilder();
        message.append("Bạn gây ra ").append(playerAttack).append(" sát thương!\n");
        switch (gameScreen.story.race) {
            case "primate":
                message.append(generatePrimateMessage(monsterAttack));
                break;
            case "animal":
                message.append(generateAnimalMessage(monsterAttack));
                break;
        }
        return message.toString();
    }

    private String generatePrimateMessage(int monsterAttack) {
        String[] messages = new String[]{
                "Đối thủ lùi lại, không thể chịu nổi sức mạnh của bạn.\n\nNhưng hắn nhanh chóng đáp trả và gây ra " + monsterAttack + " sát thương khiến bạn phải bước lùi.",
                "Đối thủ loạng choạng vì cú đánh của bạn.\n\nHắn không để bạn dễ dàng thở phào, lập tức tung ra một đòn mạnh và gây " + monsterAttack + " sát thương vào bạn.",
                "Đối phương mất thế nhưng vẫn đứng vững.\n\nĐối thủ phản ứng ngay, gây ra " + monsterAttack + " sát thương khiến bạn phải chống đỡ.",
                "Đối phương lùi lại, đôi mắt tràn đầy căm hận.\n\nHắn ngay lập tức tiến lên, phản công và gây ra " + monsterAttack + " sát thương khiến bạn đau đớn.",
                "Cú tấn công chuẩn xác! Đối phương lùi lại một bước.\n\nNhưng hắn không bỏ cuộc, ngay lập tức lao tới và gây ra " + monsterAttack + " sát thương vào bạn.",
                "Cú ra đòn mạnh mẽ, đối thủ bị đẩy lùi một khoảng.\n\nTuy nhiên, hắn không chần chừ, tấn công lại và gây ra " + monsterAttack + " sát thương vào bạn.",
                "Cú đánh của bạn trúng đích, đối phương khựng lại.\n\nNhưng hắn lập tức hồi phục và tấn công bạn với " + monsterAttack + " sát thương.",
                "Bạn gây ra sát thương mạnh mẽ, khiến đối phương phải lùi lại một chút.\n\nHắn không bỏ cuộc, lập tức đáp trả bằng một đòn hiểm hóc gây " + monsterAttack + " sát thương vào bạn.",
                "Với một đòn quyết đoán! Đối phương chao đảo, nhưng vẫn đứng vững.\n\nHắn ngay lập tức phản công, gây ra " + monsterAttack + " sát thương.",
                "Ra tay mạnh mẽ! Đối phương tỏ ra chật vật.\n\nĐối thủ không dễ bị khuất phục, gây ra " + monsterAttack + " sát thương."
        };
        return messages[randomPercent - 1];
    }

    private String generateAnimalMessage(int monsterAttack) {
        String[] messages = new String[]{
                "Cú đánh của bạn khiến đối phương lùi lại, không thể chịu nổi sức mạnh.\n\nNhưng hắn nhanh chóng phản công và gây ra " + monsterAttack + " sát thương khiến bạn phải bước lùi.",
                "Đối phương loạng choạng vì cú đánh của bạn.\n\nHắn không để bạn dễ dàng thở phào, lập tức tung ra một đòn mạnh và gây " + monsterAttack + " sát thương vào bạn.",
                "Cú đánh mạnh mẽ khiến đối phương mất thế nhưng vẫn đứng vững.\n\nHắn phản ứng ngay, gây ra " + monsterAttack + " sát thương khiến bạn phải chống đỡ.",
                "Đối phương lùi lại, đôi mắt tràn đầy căm hận.\n\nHắn tiến lên, phản công và gây ra " + monsterAttack + " sát thương khiến bạn đau đớn.",
                "Cú tấn công chuẩn xác! Đối phương lùi lại một bước.\n\nNhưng hắn không bỏ cuộc, lao tới và gây ra " + monsterAttack + " sát thương vào bạn.",
                "Cú ra đòn mạnh mẽ, đối phương bị đẩy lùi một khoảng.\n\nTuy nhiên, hắn không chần chừ, tấn công lại và gây ra " + monsterAttack + " sát thương vào bạn.",
                "Cú đánh trúng đích khiến đối phương khựng lại.\n\nNhưng hắn lập tức hồi phục và tấn công bạn với " + monsterAttack + " sát thương.",
                "Bạn gây ra sát thương mạnh mẽ, khiến đối phương phải lùi lại một chút.\n\nHắn không bỏ cuộc, đáp trả ngay lập tức với đòn hiểm hóc gây " + monsterAttack + " sát thương vào bạn.",
                "Với một đòn quyết đoán! Đối phương chao đảo, nhưng vẫn đứng vững.\n\nHắn ngay lập tức phản công, gây ra " + monsterAttack + " sát thương.",
                "Ra tay mạnh mẽ! Đối phương tỏ ra chật vật.\n\nNhưng đối phương không dễ bị khuất phục, gây ra " + monsterAttack + " sát thương."
        };
        return messages[randomPercent - 1];
    }

    public void run() {
        randomHP = 10 + random.nextInt(11);
        hp = gameScreen.player.playerMaxHp * randomHP / 100;
        gameScreen.player.playerHp = Math.max(gameScreen.player.playerHp - hp, 1);
        gameScreen.playerHPTextView.setText("HP: " + gameScreen.player.playerHp + "/" + gameScreen.player.playerMaxHp);
        gameScreen.gameTextView.setText("Chạy trốn không thành công, bạn bị đối thủ tấn công và thương tích, giờ đây chỉ còn cách chiến đấu đến cùng!!! Bạn mất " + hp + " điểm sức khỏe!!!");
    }

    public void boneDart() {
        random();
        int damage;
        if (randomPercent == 1) {
            damage = 15;
        } else if (randomPercent == 2) {
            damage = 7;
        } else if (randomPercent == 3) {
            damage = 5;
        } else if (randomPercent == 4) {
            damage = 12;
        } else if (randomPercent == 5) {
            damage = 8;
        } else if (randomPercent == 6) {
            damage = 15;
        } else if (randomPercent == 7) {
            damage = 10;
        } else {
            damage = 0;
        }
        gameScreen.monster.monsterHP -= damage;
        gameScreen.monsterHPTextView.setText("HP: " + gameScreen.monster.monsterHP);
        gameScreen.gameTextView.setText("Bạn phóng chiếc phi tiêu vào " + getTargetBodyPart() + ". Bạn gây ra " + damage + " sát thương.");
    }

    private String getTargetBodyPart() {
        String targetBodyPart;
        if (randomPercent == 1) {
            targetBodyPart = "mắt kẻ địch";
        } else if (randomPercent == 2) {
            targetBodyPart = "vai phải của kẻ địch";
        } else if (randomPercent == 3) {
            targetBodyPart = "chân trái của kẻ địch";
        } else if (randomPercent == 4) {
            targetBodyPart = "bụng kẻ địch";
        } else if (randomPercent == 5) {
            targetBodyPart = "tay phải của kẻ địch";
        } else if (randomPercent == 6) {
            targetBodyPart = "cổ của kẻ địch";
        } else if (randomPercent == 7) {
            targetBodyPart = "đầu gối của kẻ địch";
        } else {
            targetBodyPart = "không khí";
        }
        return targetBodyPart;
    }
}
