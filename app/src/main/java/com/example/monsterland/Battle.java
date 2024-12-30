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

import java.util.Objects;
import java.util.Random;
@SuppressLint("SetTextI18n")

public class Battle {
    GameScreen gameScreen;
    Random random = new Random();
    int percent, randomPercent, randomHP, hp;
    public Battle(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void random(){
        randomPercent = 1 + random.nextInt(10);
        randomHP = 30 + random.nextInt(21);
    }

    public void sneakAttack(){
        random();
        if(percent <= randomPercent){
            hp = gameScreen.monster.monsterHP * randomHP / 10 / 10;
            gameScreen.monster.monsterHP -= hp;
            gameScreen.gameTextView.setText("Bạn đánh lén thành công! Đối phương bị bất ngờ, và cú tấn công của bạn khiến hắn mất "+hp+" điểm sinh lực. Hắn đau đớn và lùi lại, cố gắng lấy lại thế phòng thủ, nhưng bạn đã chiếm được lợi thế.");
            gameScreen.monsterHPTextView.setText("HP: "+gameScreen.monster.monsterHP);
        }
        else {
            gameScreen.gameTextView.setText("Bạn đánh lén thất bại! Hắn quay lại ngay lập tức, ánh mắt đầy căm thù. Không còn đường lui, bạn buộc phải chiến đấu với hắn. Con dao của hắn lấp lánh trong ánh sáng mờ ảo, và sự nguy hiểm hiện rõ trên từng bước di chuyển.");
        }
    }

    private void flashRedScreen() {
        // Tìm View có ID damage_flash
        View gameScreenLayout = gameScreen.findViewById(R.id.damage_flash);
        if (gameScreenLayout != null) {
            // Hiển thị View với hiệu ứng ánh sáng đỏ
            gameScreenLayout.setVisibility(View.VISIBLE);

            // Sử dụng ArgbEvaluator cho chuyển đổi màu từ đỏ sáng đến đen
            ObjectAnimator colorAnim = ObjectAnimator.ofObject(gameScreenLayout, "backgroundColor", new ArgbEvaluator(),
                    Color.parseColor("#FF0000"), Color.parseColor("#000000")); // Từ màu đỏ sáng đến màu đen
            colorAnim.setDuration(600); // Tăng thời gian để hiệu ứng mượt mà hơn
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);  // Lặp lại hiệu ứng để tạo chuyển động
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);    // Lặp lại màu sắc theo hướng ngược lại
            colorAnim.setInterpolator(new AccelerateDecelerateInterpolator()); // Dùng interpolator để làm hiệu ứng mượt mà
            colorAnim.start();

            Log.d("FlashEffect", "Red flash effect applied");

            // Gỡ bỏ ánh sáng sau 600ms và ẩn View
            new Handler().postDelayed(() -> {
                gameScreenLayout.setVisibility(View.INVISIBLE); // Ẩn lại view sau khi flash
                Log.d("FlashEffect", "Red flash disappeared");
            }, 600); // Thời gian ẩn giống với thời gian hiệu ứng
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

        if (gameScreen.player.smallShield) {
            if (randomPercent <= 3) {
                gameScreen.gameTextView.setText("Cú đánh của bạn gây ra " + gameScreen.player.playerAttack + " sát thương! Đối thủ bị đẩy lùi một chút.\n\n" + "Hắn cố gắng tấn công lại, nhưng chiếc khiên của bạn đã đỡ trọn đòn đánh, giữ bạn an toàn.");
            } else {
                gameScreen.gameTextView.setText(attackMessage);
            }
        } else {
            gameScreen.gameTextView.setText(attackMessage);
        }
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp);
        gameScreen.monsterHPTextView.setText("HP: "+gameScreen.monster.monsterHP);
    }

    private String generateAttackMessage(int playerAttack, int monsterAttack) {
        StringBuilder message = new StringBuilder();
        message.append("Bạn gây ra ").append(playerAttack).append(" sát thương!\n");

        if (Objects.equals(gameScreen.story.race, "primate")) {
            message.append(generatePrimateMessage(monsterAttack));
        } else if (Objects.equals(gameScreen.story.race, "animal")) {
            message.append(generateAnimalMessage(monsterAttack));
        }
        return message.toString();
    }

    private String generatePrimateMessage(int monsterAttack) {
        switch (randomPercent) {
            case 1:
                return "Đối thủ lùi lại, không thể chịu nổi sức mạnh của bạn.\n\nNhưng hắn nhanh chóng đáp trả và gây ra " + monsterAttack + " sát thương khiến bạn phải bước lùi.";
            case 2:
                return "Đối thủ loạng choạng vì cú đánh của bạn.\n\nHắn không để bạn dễ dàng thở phào, lập tức tung ra một đòn mạnh và gây " + monsterAttack + " sát thương vào bạn.";
            case 3:
                return "Đối phương mất thế nhưng vẫn đứng vững.\n\nĐối thủ phản ứng ngay, gây ra " + monsterAttack + " sát thương khiến bạn phải chống đỡ.";
            case 4:
                return "Đối phương lùi lại, đôi mắt tràn đầy căm hận.\n\nHắn ngay lập tức tiến lên, phản công và gây ra " + monsterAttack + " sát thương khiến bạn đau đớn.";
            case 5:
                return "Cú tấn công chuẩn xác! Đối phương lùi lại một bước.\n\nNhưng hắn không bỏ cuộc, ngay lập tức lao tới và gây ra " + monsterAttack + " sát thương vào bạn.";
            case 6:
                return "Cú ra đòn mạnh mẽ, đối thủ bị đẩy lùi một khoảng.\n\nTuy nhiên, hắn không chần chừ, tấn công lại và gây ra " + monsterAttack + " sát thương vào bạn.";
            case 7:
                return "Cú đánh của bạn trúng đích, đối phương khựng lại.\n\nNhưng hắn lập tức hồi phục và tấn công bạn với " + monsterAttack + " sát thương.";
            case 8:
                return "Bạn gây ra sát thương mạnh mẽ, khiến đối phương phải lùi lại một chút.\n\nHắn không bỏ cuộc, lập tức đáp trả bằng một đòn hiểm hóc gây " + monsterAttack + " sát thương vào bạn.";
            case 9:
                return "Với một đòn quyết đoán! Đối phương chao đảo, nhưng vẫn đứng vững.\n\nHắn ngay lập tức phản công, gây ra " + monsterAttack + " sát thương.";
            case 10:
                return "Ra tay mạnh mẽ! Đối phương tỏ ra chật vật.\n\nĐối thủ không dễ bị khuất phục, gây ra " + monsterAttack + " sát thương.";
            default:
                return "";
        }
    }

    private String generateAnimalMessage(int monsterAttack) {
        switch (randomPercent) {
            case 1:
                return "Con thú gầm lên đầy giận dữ, lùi lại vài bước.\n\nTuy nhiên, nó lập tức lao lên, vung móng vuốt sắc nhọn và gây ra " + monsterAttack + " sát thương cho bạn.";
            case 2:
                return "Con thú chao đảo, nhưng đôi mắt đỏ rực vẫn nhìn chằm chằm vào bạn.\n\nNó không chần chừ, lao tới với cú cắn sắc bén, gây " + monsterAttack + " sát thương.";
            case 3:
                return "Con thú rít lên đau đớn, nhưng vẫn không chịu khuất phục.\n\nNó đáp trả ngay lập tức, vung móng vuốt về phía bạn và gây " + monsterAttack + " sát thương.";
            case 4:
                return "Con thú lùi lại, gầm lên giận dữ.\n\nNó nhanh chóng phản công, nhảy tới với hàm răng sắc nhọn và gây " + monsterAttack + " sát thương vào bạn.";
            case 5:
                return "Con thú khựng lại trong chốc lát.\n\nNhưng nó không từ bỏ, dùng đuôi của mình quét mạnh vào bạn, gây " + monsterAttack + " sát thương.";
            case 6:
                return "Con thú rít lên đầy giận dữ, lùi lại một chút.\n\nTuy nhiên, nó lập tức dùng chân trước đạp mạnh vào bạn, gây " + monsterAttack + " sát thương.";
            case 7:
                return "Con thú lảo đảo, nhưng vẫn giữ vững thế đứng.\n\nNó gầm lên đầy thịnh nộ, lao tới với cú cắn đầy uy lực, gây " + monsterAttack + " sát thương.";
            case 8:
                return "Bạn tấn công với tất cả sức mạnh, Con thú trông có vẻ bị thương nặng.\n\nThế nhưng, nó không chịu thua, nhảy lên và cào mạnh vào bạn, gây " + monsterAttack + " sát thương.";
            case 9:
                return "Với một đòn quyết đoán! Con thú lùi lại, vẻ mặt đầy đau đớn.\n\nKhông bỏ lỡ cơ hội, nó phản công dữ dội, dùng móng vuốt gây " + monsterAttack + " sát thương vào bạn.";
            case 10:
                return "Bạn ra tay mạnh mẽ, gây ra! Con thú quằn quại, nhưng ánh mắt vẫn lộ vẻ hung tợn.\n\nNgay sau đó, nó dùng đầu húc mạnh vào bạn, gây " + monsterAttack + " sát thương.";
            default:
                return "";
        }
    }


    public void run(){
        randomHP = 10 + random.nextInt(11);
        hp = gameScreen.player.playerMaxHp * randomHP / 10 / 10;
        if(gameScreen.player.playerHp > hp) {
            gameScreen.player.playerHp -= hp;
        }
        else {
            gameScreen.player.playerHp -= (gameScreen.player.playerHp - 1);
        }
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
        gameScreen.gameTextView.setText("Chạy trốn không thành công, bạn bị đối thủ tấn công và thương tích, giờ đây chỉ còn cách chiến đấu đến cùng!!! Bạn mất "+ hp +" điểm sức khỏe!!!");
    }

    public void boneDart(){
        random();
        if (randomPercent == 1){
            gameScreen.gameTextView.setText("Bạn phóng chiếc phi tiêu vào mắt kẻ địch. Phi tiêu cắm sâu vào mắt trái của nó, khiến nó gào lên đau đớn. Bạn gây ra 15 sát thương.");
            gameScreen.monster.monsterHP -= 15;
        }
        if (randomPercent == 2){
            gameScreen.gameTextView.setText("Một chiếc phi tiêu bay vào vai phải của kẻ địch. Cú đánh khiến nó mất thăng bằng và lảo đảo, bạn gây ra 7 sát thương.");
            gameScreen.monster.monsterHP -= 7;
        }
        if (randomPercent == 3){
            gameScreen.gameTextView.setText("Phi tiêu cắm vào chân trái của kẻ địch. Nó quỵ xuống, không thể đứng vững, bạn gây ra 5 sát thương.");
            gameScreen.monster.monsterHP -= 5;
        }
        if (randomPercent == 4){
            gameScreen.gameTextView.setText("Một chiếc phi tiêu vào bụng kẻ địch. Cú đánh mạnh khiến nó bị thương nặng, bạn gây ra 12 sát thương.");
            gameScreen.monster.monsterHP -= 12;
        }
        if (randomPercent == 5){
            gameScreen.gameTextView.setText("Phi tiêu trúng vào tay phải của kẻ địch. Cú đánh khiến nó không thể cầm vũ khí đúng cách nữa, bạn gây ra 8 sát thương.");
            gameScreen.monster.monsterHP -= 8;
        }
        if (randomPercent == 6){
            gameScreen.gameTextView.setText("Bạn phóng phi tiêu vào cổ của kẻ địch. Cú đánh mạnh khiến nó ngã xuống đất, bạn gây ra 15 sát thương.");
            gameScreen.monster.monsterHP -= 15;
        }
        if (randomPercent == 7){
            gameScreen.gameTextView.setText("Phi tiêu cắm vào đầu gối của kẻ địch. Nó đau đớn quỵ xuống, không thể di chuyển nhanh chóng nữa. Bạn gây ra 11 sát thương.");
            gameScreen.monster.monsterHP -= 11;
        }
        if (randomPercent == 8){
            gameScreen.gameTextView.setText("Bạn phóng phi tiêu vào chân của kẻ địch, nhưng nó nhanh chóng nhảy qua một bên. Phi tiêu hụt và chỉ trúng vào cây cối.");
        }
        if (randomPercent == 9){
            gameScreen.gameTextView.setText("Bạn phóng phi tiêu vào cánh tay kẻ địch, nhưng nó vung vũ khí lên chắn. Phi tiêu trúng vào thanh kiếm.");
        }
        if (randomPercent == 10){
            gameScreen.gameTextView.setText("Phi tiêu phóng vào chân của kẻ địch nhưng nó bật nhảy sang bên, né tránh. Phi tiêu chỉ trúng vào đất.");
        }
        gameScreen.monsterHPTextView.setText("HP: "+gameScreen.monster.monsterHP);
        gameScreen.storyTenebris.boneDart--;
    }
}