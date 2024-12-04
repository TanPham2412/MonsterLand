package com.example.monsterland;

import android.view.View;

public class StoryCastle {
    GameScreen gameScreen;
    public StoryCastle(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void opening1(){
        gameScreen.gameImageView.setImageResource(R.drawable.city);
        gameScreen.gameTextView.setText("Bạn sống trong thành phố Umbra, nơi một lời nguyền cổ xưa đã đè nặng lên đời sống của người dân, khiến nhiều người mắc phải các biến chứng kỳ lạ. Những cơn gió mang theo mùi hương tẩm thuốc và bóng tối vương vấn trong không gian.");
        gameScreen.player.playerUseStick();
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp);
        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "opening2";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void opening2(){
        gameScreen.gameImageView.setImageResource(R.drawable.scar);
        gameScreen.gameTextView.setText("Bạn nhận ra rằng đó là dấu vết của một con quái vật đã chết, nhưng lời nguyền vẫn còn tồn tại.\n\n Để giải thoát khỏi số phận này, bạn phải tìm Mira, một thầy thuốc nổi tiếng ẩn cư ở ngoài rìa thành phố, nhờ giúp đỡ.");

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);

        gameScreen.story.nextPosition1 = "meetCat";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
    }

    public void meetCat(){
        gameScreen.gameImageView.setImageResource(R.drawable.cat);
        gameScreen.gameTextView.setText("Giờ đây bạn cần phải ra khỏi thành phố và không bị phát hiện, nếu không bạn sẽ gặp phải phiền phức.\n\n Trên đường đi bạn thấy một chú mèo đang bới rác và có một thứ gì đó lấp lánh đang tỏa ra!");

        gameScreen.button1.setText("Tới chỗ thùng rác");
        gameScreen.button2.setText("Tiếp tục đi");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "trashCan";
        gameScreen.story.nextPosition2 = "alley";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void trashCan(){
        gameScreen.gameImageView.setImageResource(R.drawable.trash);
        gameScreen.gameTextView.setText("Bạn tìm thấy một con dao. Tuy có phần bị rỉ sét nhưng vẫn tốt hơn cây gậy gỗ của bạn.\n\nBạn có muốn sử dụng không?");

        gameScreen.button1.setText("Có");
        gameScreen.button2.setText("Không");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "useKnife";
        gameScreen.story.nextPosition2 = "notUseKnife";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void useKnife(){
        gameScreen.gameImageView.setImageResource(R.drawable.rustyknife);
        gameScreen.gameTextView.setText("Bạn trang bị thành công, sức mạnh của bạn đã tăng lên. Điểm tấn công của bạn lúc này là 3 - 5\n\nBạn tiếp tục đi về phía trước");
        gameScreen.player.playerUseRustyKnife();
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "alley";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void notUseKnife(){
        gameScreen.gameImageView.setImageResource(R.drawable.go);
        gameScreen.gameTextView.setText("Bạn bỏ qua món đồ và tiếp tục đi về phía trước!");

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "alley";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void alley(){
        gameScreen.gameImageView.setImageResource(R.drawable.waysign);
        gameScreen.gameTextView.setText("Bạn đứng trước một con hẻm, trong con hẻm là nơi tụ tập bọn du côn.\n\nBạn sẽ làm gì?");

        gameScreen.button1.setText("Đi vào hẻm");
        gameScreen.button2.setText("Đi về phía trước");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "intoAlley";
        gameScreen.story.nextPosition2 = "keepGoing";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void intoAlley(){
        gameScreen.gameImageView.setImageResource(R.drawable.bandit);
        gameScreen.gameTextView.setText("Thật không may, phía trước có một tên côn đồ. Bạn sẽ làm gì tiếp theo?\n\n");
        gameScreen.monster.bandit();

        gameScreen.button1.setText("Đánh lén (50%)");
        gameScreen.button2.setText("Quay lại (70%)");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "sneakAttack";
        gameScreen.story.nextPosition2 = "runBeforeAttack";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
    public void sneakAttack(){
        gameScreen.story.nextPosition = "intoAlley1";
        gameScreen.gameImageView.setImageResource(R.drawable.bandit);
        gameScreen.battle.percent = 5;
        gameScreen.battle.sneakAttack();

        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("Bỏ chạy");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = "run";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void attack(){
        gameScreen.battle.attack();
        if(gameScreen.player.playerHp <=0){

            gameScreen.button1.setText("Bạn đã bị đánh bại!!!");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "dead";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else if (gameScreen.monster.monsterHP <=0) {
            gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch!!");

            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = gameScreen.story.nextPosition;
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
            gameScreen.player.playerExpGain();
            if(gameScreen.battle.percent <=7) {
                gameScreen.player.dropHealingPotion();
            }
            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");
        }
        else if (gameScreen.player.playerHp <=0 && gameScreen.monster.monsterHP <=0) {
            gameScreen.gameTextView.setText("Bạn và kẻ thù đồng quy vu tận!!");
            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "dead";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Bỏ chạy (30%)");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.nextPosition2 = "run";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
    }

    public void run(){
        gameScreen.story.nextPosition = "intoAlley1";
        gameScreen.battle.random();
        if (gameScreen.battle.randomPercent <= 3){
            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");
            gameScreen.gameImageView.setImageResource(R.drawable.waysign);
            gameScreen.gameTextView.setText("Bạn đã quay lại trước con hẻm.\n\nBạn sẽ làm gì?");

            gameScreen.button1.setText("Đi vào hẻm");
            gameScreen.button2.setText("Đi về phía trước");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "intoAlley";
            gameScreen.story.nextPosition2 = "keepGoing";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            gameScreen.battle.run();
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
    }

    public void runBeforeAttack(){
        gameScreen.story.nextPosition = "intoAlley1";
        gameScreen.battle.random();
        if (gameScreen.battle.randomPercent <= 7){
            gameScreen.gameImageView.setImageResource(R.drawable.waysign);
            gameScreen.gameTextView.setText("Bạn đã quay lại trước con hẻm.\n\nBạn sẽ làm gì?");

            gameScreen.button1.setText("Đi vào hẻm");
            gameScreen.button2.setText("Đi về phía trước");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "intoAlley";
            gameScreen.story.nextPosition2 = "keepGoing";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            gameScreen.gameTextView.setText("Bạn đã bị phát hiện, giờ đây bạn buộc phải chiến đấu!!!");

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
    }

    public void dead(){
        gameScreen.gameImageView.setImageResource(R.drawable.dead);
        gameScreen.gameTextView.setText("Bạn đã chết!!!");
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "goTitleScreen";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void intoAlley1(){
        gameScreen.story.nextPosition = "outsideCastle";
        gameScreen.gameImageView.setImageResource(R.drawable.hood);
        gameScreen.gameTextView.setText("Sau khi đánh bại tên côn đồ, bạn phát hiện ra có một người thần bí đã chứng kiến toàn bộ sự việc.\n\nPhía trước chính là lối đi bí mật để ra ngoài thành!");
        gameScreen.monster.aMystic();

        gameScreen.button1.setText("Tấn công anh ta");
        gameScreen.button2.setText("Tiếp tục đi");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = gameScreen.story.nextPosition;
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void outsideCastle(){
        gameScreen.gameImageView.setImageResource(R.drawable.castle);
        gameScreen.gameTextView.setText("Bạn đã ra ngoài thành. Giờ đây bạn phải đi gặp Mira để tìm cách xóa bỏ lời nguyền!!!");
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "meetMira";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);

        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
    }
    public void keepGoing(){
        gameScreen.story.nextPosition = "leatherArmor";
        gameScreen.gameImageView.setImageResource(R.drawable.gatekeeper);
        gameScreen.gameTextView.setText("Bạn đến trước cổng thành. Ở phía trước có người gác cổng!!!");
        gameScreen.monster.gateKeeper();
        gameScreen.button1.setText("Đi qua cổng (50%)");
        gameScreen.button2.setText("Tấn công");
        gameScreen.button3.setText("Quay lại");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "checkAtGate";
        gameScreen.story.nextPosition2 = "attack";
        gameScreen.story.nextPosition3 = "alley";
    }

    public void checkAtGate(){
        gameScreen.battle.random();
        gameScreen.gameImageView.setImageResource(R.drawable.gatekeeper);
        if (gameScreen.battle.randomPercent <= 5){
            gameScreen.gameTextView.setText("Bạn đã bị phát hiện!!!\n\nChiến đấu!!!");

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Bỏ chạy");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.nextPosition2 = "run";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }else{
            gameScreen.gameTextView.setText("Bạn không bị phát hiện!!!");

            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");

            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "outsideCastle";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
    }

    public void leatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.leatherarmor);
        gameScreen.gameTextView.setText("Bạn nhận được một bình thuốc hồi máu và một bộ giáp da sau khi đánh bại kẻ địch\n\nBạn có muốn sử dụng giáp da không?");

        gameScreen.button1.setText("Có");
        gameScreen.button2.setText("Không");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "useLeatherArmor";
        gameScreen.story.nextPosition2 = "notUseLeatherArmor";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void useLeatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.leatherarmor);
        gameScreen.gameTextView.setText("Bạn trang bị thành công, sát thương bạn nhận vào sẽ giảm được một phần.\n\nBạn tiếp tục đi về phía trước");
        gameScreen.player.leatherArmor = true;
        gameScreen.player.playerHp +=20;
        if(gameScreen.player.playerHp > gameScreen.player.playerMaxHp){
            gameScreen.player.playerHp = gameScreen.player.playerMaxHp;
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp);
        }

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "alley";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
    public void notUseLeatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.go);
        gameScreen.gameTextView.setText("Bạn bỏ qua món đồ và tiếp tục đi về phía trước!");

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "outsideCastle";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
}

