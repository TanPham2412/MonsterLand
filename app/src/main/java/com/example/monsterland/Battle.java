package com.example.monsterland;

import java.util.Objects;
import java.util.Random;

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

    public void attack(){
        gameScreen.player.playerAttack = gameScreen.player.minAtk + random.nextInt(gameScreen.player.maxAtk);
        gameScreen.monster.monsterHP -= gameScreen.player.playerAttack;

        gameScreen.monster.monterAttack = gameScreen.monster.minAtk + random.nextInt(gameScreen.monster.maxAtk);
        gameScreen.player.playerHp -= gameScreen.monster.monterAttack;

        random();
        if (Objects.equals(gameScreen.story.race, "primate")){
            if(randomPercent == 1) {
                gameScreen.gameTextView.setText("Với một cú ra tay đầy sức mạnh, bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Đối thủ lùi lại, không thể chịu nổi sức mạnh của bạn.\n\n" + "Nhưng hắn nhanh chóng đáp trả và gây ra "+gameScreen.monster.monterAttack+" sát thương khiến bạn phải bước lùi.");
            } else if (randomPercent == 2) {
                gameScreen.gameTextView.setText("Bạn tấn công mạnh mẽ, gây ra "+gameScreen.player.playerAttack+" sát thương! Đối thủ loạng choạng vì cú đánh của bạn.\n\n" + "Hắn không để bạn dễ dàng thở phào, lập tức tung ra một đòn mạnh và gây "+gameScreen.monster.monterAttack+" sát thương vào bạn.");
            } else if (randomPercent == 3) {
                gameScreen.gameTextView.setText("Bạn ra đòn nhanh chóng, gây ra "+gameScreen.player.playerAttack+" sát thương! Đối phương mất thế nhưng vẫn đứng vững.\n\n" + "Đối thủ phản ứng ngay, gây ra "+gameScreen.monster.monterAttack+" sát thương khiến bạn phải chống đỡ.");
            } else if (randomPercent == 4) {
                gameScreen.gameTextView.setText("Cú đánh của bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Đối phương lùi lại, đôi mắt tràn đầy căm hận.\n\n" + "Hắn ngay lập tức tiến lên, phản công và gây ra "+gameScreen.monster.monterAttack+" sát thương khiến bạn đau đớn.");
            } else if (randomPercent == 5) {
                gameScreen.gameTextView.setText("Bạn gây ra "+gameScreen.player.playerAttack+" sát thương với cú tấn công chuẩn xác! Đối phương lùi lại một bước.\n\n" + "Nhưng hắn không bỏ cuộc, ngay lập tức lao tới và gây ra "+gameScreen.monster.monterAttack+" sát thương vào bạn.");
            } else if (randomPercent == 6) {
                gameScreen.gameTextView.setText("Với cú ra đòn mạnh mẽ, bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Đối thủ bị đẩy lùi một khoảng.\n\n" + "Tuy nhiên, hắn không chần chừ, tấn công lại và gây ra "+gameScreen.monster.monterAttack+" sát thương vào bạn.");
            } else if (randomPercent == 7) {
                gameScreen.gameTextView.setText("Cú đánh của bạn trúng đích, gây ra "+gameScreen.player.playerAttack+" sát thương! Đối phương khựng lại, có vẻ không kịp phản ứng.\n\n" + "Nhưng hắn lập tức hồi phục và tấn công bạn với "+gameScreen.monster.monterAttack+" sát thương.");
            } else if (randomPercent == 8) {
                gameScreen.gameTextView.setText("Bạn gây ra "+gameScreen.player.playerAttack+" sát thương mạnh mẽ, khiến đối phương phải lùi lại một chút.\n\n" + "Hắn không bỏ cuộc, lập tức đáp trả bằng một đòn hiểm hóc gây "+gameScreen.monster.monterAttack+" sát thương vào bạn.");
            } else if (randomPercent == 9) {
                gameScreen.gameTextView.setText("Với một đòn quyết đoán, bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Đối phương chao đảo, nhưng vẫn đứng vững.\n\n" + "Hắn ngay lập tức phản công, gây ra "+gameScreen.monster.monterAttack+" sát thương khiến bạn phải lùi lại.");
            } else if (randomPercent == 10) {
                gameScreen.gameTextView.setText("Bạn ra đòn mạnh mẽ, gây ra "+gameScreen.player.playerAttack+" sát thương! Đối phương tỏ ra chật vật nhưng vẫn quyết liệt tiếp tục chiến đấu.\n\n" + "Đối thủ không dễ bị khuất phục, gây ra "+gameScreen.monster.monterAttack+" sát thương khiến bạn phải dừng lại một chút.");
            }
        } else if (Objects.equals(gameScreen.story.race, "animal")) {
            if(randomPercent == 1) {
                gameScreen.gameTextView.setText("Với một cú ra đòn mạnh mẽ, bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú gầm lên đầy giận dữ, lùi lại vài bước.\n\n" + "Tuy nhiên, nó lập tức lao lên, vung móng vuốt sắc nhọn và gây ra "+gameScreen.monster.monterAttack+" sát thương cho bạn.");
            } else if (randomPercent == 2) {
                gameScreen.gameTextView.setText("Bạn tấn công chính xác, gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú chao đảo, nhưng đôi mắt đỏ rực vẫn nhìn chằm chằm vào bạn.\n\n" + "Nó không chần chừ, lao tới với cú cắn sắc bén, gây "+gameScreen.monster.monterAttack+" sát thương.");
            } else if (randomPercent == 3) {
                gameScreen.gameTextView.setText("Cú đánh của bạn trúng đích, gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú rít lên đau đớn, nhưng vẫn không chịu khuất phục.\n\n" + "Nó đáp trả ngay lập tức, vung móng vuốt về phía bạn và gây "+gameScreen.monster.monterAttack+" sát thương.");
            } else if (randomPercent == 4) {
                gameScreen.gameTextView.setText("Với cú ra tay mạnh mẽ, bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú lùi lại, gầm lên giận dữ.\n\n" + "Nó nhanh chóng phản công, nhảy tới với hàm răng sắc nhọn và gây "+gameScreen.monster.monterAttack+" sát thương vào bạn.");
            } else if (randomPercent == 5) {
                gameScreen.gameTextView.setText("Bạn ra đòn chuẩn xác, gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú khựng lại trong chốc lát.\n\n" + "Nhưng nó không từ bỏ, dùng đuôi của mình quét mạnh vào bạn, gây "+gameScreen.monster.monterAttack+" sát thương.");
            } else if (randomPercent == 6) {
                gameScreen.gameTextView.setText("Cú tấn công mạnh mẽ của bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú rít lên đầy giận dữ, lùi lại một chút.\n\n" + "Tuy nhiên, nó lập tức dùng chân trước đạp mạnh vào bạn, gây "+gameScreen.monster.monterAttack+" sát thương.");
            } else if (randomPercent == 7) {
                gameScreen.gameTextView.setText("Bạn tung đòn nhanh gọn, gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú lảo đảo, nhưng vẫn giữ vững thế đứng.\n\n" + "Nó gầm lên đầy thịnh nộ, lao tới với cú cắn đầy uy lực, gây "+gameScreen.monster.monterAttack+" sát thương.");
            } else if (randomPercent == 8) {
                gameScreen.gameTextView.setText("Bạn tấn công với tất cả sức mạnh, gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú trông có vẻ bị thương nặng.\n\n" + "Thế nhưng, nó không chịu thua, nhảy lên và cào mạnh vào bạn, gây "+gameScreen.monster.monterAttack+" sát thương.");
            } else if (randomPercent == 9) {
                gameScreen.gameTextView.setText("Với một đòn quyết đoán, bạn gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú lùi lại, vẻ mặt đầy đau đớn.\n\n" + "Không bỏ lỡ cơ hội, nó phản công dữ dội, dùng móng vuốt gây "+gameScreen.monster.monterAttack+" sát thương vào bạn.");
            } else if (randomPercent == 10) {
                gameScreen.gameTextView.setText("Bạn ra tay mạnh mẽ, gây ra "+gameScreen.player.playerAttack+" sát thương! Con thú quằn quại, nhưng ánh mắt vẫn lộ vẻ hung tợn.\n\n" + "Ngay sau đó, nó dùng đầu húc mạnh vào bạn, gây "+gameScreen.monster.monterAttack+" sát thương.");
            }
        }

        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
        gameScreen.monsterHPTextView.setText("HP: " + gameScreen.monster.monsterHP);
        if (gameScreen.player.playerHp < 20 * gameScreen.player.playerMaxHp / 100){
            gameScreen.player.showToast("Sinh lực của bạn dưới 20%!!!",5000);
        }
    }

    public void run(){
        randomHP = 10 + random.nextInt(11);
        hp = gameScreen.player.playerMaxHp * randomHP / 10 / 10;
        if(gameScreen.player.playerHp > hp) {
            gameScreen.player.playerHp -= hp;
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
            gameScreen.gameTextView.setText("Chạy trốn không thành công, bạn bị đối thủ tấn công và thương tích, giờ đây chỉ còn cách chiến đấu đến cùng!!! Bạn mất "+ hp +" điểm sức khỏe!!!");
        }
        else {
            gameScreen.player.playerHp -= (gameScreen.player.playerHp - 1);
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
            gameScreen.gameTextView.setText("Chạy trốn không thành công, bạn bị đối thủ tấn công và thương tích, giờ đây chỉ còn cách chiến đấu đến cùng!!! Bạn mất "+ hp +" điểm sức khỏe!!!");
        }
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
        gameScreen.storyTenebris.bonedart--;
    }
}