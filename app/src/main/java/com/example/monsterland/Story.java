package com.example.monsterland;

import android.view.View;

import java.util.Random;


public class Story {

    GameScreen gameScreen;
    String nextPosition1, nextPosition2, nextPosition3, nextPosition;
    public Story(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public void showAllButton(){
        gameScreen.button1.setVisibility(View.VISIBLE);
        gameScreen.button2.setVisibility(View.VISIBLE);
        gameScreen.button3.setVisibility(View.VISIBLE);
    }

    public void selectPosition(String position){
        switch (position){
            case "opening2": opening2(); break;
            case "meetCat": meetCat(); break;
            case "trashCan": trashCan(); break;
            case "useKnife": useKnife(); break;
            case "notUseKnife": notUseKnife(); break;
            case "alley": alley(); break;
            case "intoAlley": intoAlley(); break;
            case "sneakAttack": sneakAttack(); break;
            case "attack": attack(); break;
            case "run": run(); break;
            case "runBeforeAttack": runBeforeAttack(); break;
            case "dead": dead(); break;
            case "goTitleScreen": gameScreen.goTitleScreen(); break;
            case "intoAlley1": intoAlley1(); break;
            case "outsideCastle": outsideCastle(); break;
            case "keepGoing": keepGoing(); break;
            case "checkAtGate": checkAtGate(); break;
            case "leatherArmor": leatherArmor(); break;
            case "useLeatherArmor": useLeatherArmor(); break;
            case "notUseLeatherArmor": notUseLeatherArmor(); break;
        }
    }
    public void opening1(){
        gameScreen.gameImageView.setImageResource(R.drawable.city);
        gameScreen.gameTextView.setText("Bạn sống trong thành phố Umbra, nơi một lời nguyền cổ xưa đã đè nặng lên đời sống của người dân, khiến nhiều người mắc phải các biến chứng kỳ lạ. Những cơn gió mang theo mùi hương tẩm thuốc và bóng tối vương vấn trong không gian.");
        gameScreen.player.playerUseStick();
        gameScreen.player.healingPotion();
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        nextPosition1 = "opening2";
        nextPosition2 = "";
        nextPosition3 = "";
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

        nextPosition1 = "meetCat";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void meetCat(){
        gameScreen.gameImageView.setImageResource(R.drawable.cat);
        gameScreen.gameTextView.setText("Giờ đây bạn cần phải ra khỏi thành phố và không bị phát hiện, nếu không bạn sẽ gặp phải phiền phức.\n\n Trên đường đi bạn thấy một chú mèo đang bới rác và có một thứ gì đó lấp lánh đang tỏa ra!");

        gameScreen.button1.setText("Tới chỗ thùng rác");
        gameScreen.button2.setText("Tiếp tục đi");
        gameScreen.button3.setText("");

        showAllButton();

        nextPosition1 = "trashCan";
        nextPosition2 = "alley";
        nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void trashCan(){
        gameScreen.gameImageView.setImageResource(R.drawable.trash);
        gameScreen.gameTextView.setText("Bạn tìm thấy một con dao. Tuy có phần bị rỉ sét nhưng vẫn tốt hơn cây gậy gỗ của bạn\n\nBạn có muốn sử dụng không");

        gameScreen.button1.setText("Có");
        gameScreen.button2.setText("Không");
        gameScreen.button3.setText("");

        showAllButton();

        nextPosition1 = "useKnife";
        nextPosition2 = "notUseKnife";
        nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void useKnife(){
        gameScreen.gameImageView.setImageResource(R.drawable.rustyknife);
        gameScreen.gameTextView.setText("Bạn trang bị thành công, sức mạnh của bạn đã tăng lên. Điểm tấn công của bạn lúc này là 3 - 5\n\nBạn tiếp tục đi về phía trước");
        gameScreen.player.playerUseRustyKnife();
        gameScreen.player.healingPotion();
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        nextPosition1 = "alley";
        nextPosition2 = "";
        nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void notUseKnife(){
        gameScreen.gameImageView.setImageResource(R.drawable.go);
        gameScreen.gameTextView.setText("Bạn bỏ qua món đồ và tiếp tục đi về phía trước!");

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        nextPosition1 = "alley";
        nextPosition2 = "";
        nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void alley(){
        gameScreen.gameImageView.setImageResource(R.drawable.waysign);
        gameScreen.gameTextView.setText("Bạn đứng trước một con hẻm, trong con hẻm là nơi tụ tập bọn du côn.\n\nBạn sẽ làm gì?");

        gameScreen.button1.setText("Đi vào hẻm");
        gameScreen.button2.setText("Đi về phía trước");
        gameScreen.button3.setText("");

        showAllButton();

        nextPosition1 = "intoAlley";
        nextPosition2 = "keepGoing";
        nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void intoAlley(){
        gameScreen.gameImageView.setImageResource(R.drawable.bandit);
        gameScreen.gameTextView.setText("Thật không may, phía trước có một tên côn đồ. Bạn sẽ làm gì tiếp theo?\n\n");
        gameScreen.monster.bandit();

        gameScreen.button1.setText("Đánh lén (50%)");
        gameScreen.button2.setText("Quay lại (70%)");
        gameScreen.button3.setText("");

        showAllButton();

        nextPosition1 = "sneakAttack";
        nextPosition2 = "runBeforeAttack";
        nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
    public void sneakAttack(){
        nextPosition = "intoAlley1";
        gameScreen.gameImageView.setImageResource(R.drawable.bandit);
        gameScreen.fight.percent = 5;
        gameScreen.fight.battle();

        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("Bỏ chạy");
        gameScreen.button3.setText("");

        nextPosition1 = "attack";
        nextPosition2 = "run";
        nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void attack(){
        gameScreen.fight.attack();
        if(gameScreen.player.playerHp <=0){

            gameScreen.button1.setText("Bạn đã bị đánh bại!!!");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else if (gameScreen.monster.monsterHP <=0) {
            gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch!!");

            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            nextPosition1 = nextPosition;
            nextPosition2 = "";
            nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
            gameScreen.player.playerExpGain();
            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");
        }
        else if (gameScreen.player.playerHp <=0 && gameScreen.monster.monsterHP <=0) {
            gameScreen.gameTextView.setText("Bạn và kẻ thù đồng quy vu tận!!");
            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            nextPosition1 = "dead";
            nextPosition2 = "";
            nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Bỏ chạy (30%)");
            gameScreen.button3.setText("");

            nextPosition1 = "attack";
            nextPosition2 = "run";
            nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
    }

    public void run(){
        gameScreen.fight.random();
        if (gameScreen.fight.randomPercent <= 3){
            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");
            gameScreen.gameImageView.setImageResource(R.drawable.waysign);
            gameScreen.gameTextView.setText("Bạn đã quay lại trước con hẻm.\n\nBạn sẽ làm gì?");

            gameScreen.button1.setText("Đi vào hẻm");
            gameScreen.button2.setText("Đi về phía trước");
            gameScreen.button3.setText("");

            showAllButton();

            nextPosition1 = "intoAlley";
            nextPosition2 = "keepGoing";
            nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            gameScreen.fight.run();
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            showAllButton();

            nextPosition1 = "attack";
            nextPosition2 = "";
            nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
    }

    public void runBeforeAttack(){
        gameScreen.fight.random();
        if (gameScreen.fight.randomPercent <= 7){
            gameScreen.gameImageView.setImageResource(R.drawable.waysign);
            gameScreen.gameTextView.setText("Bạn đã quay lại trước con hẻm.\n\nBạn sẽ làm gì?");

            gameScreen.button1.setText("Đi vào hẻm");
            gameScreen.button2.setText("Đi về phía trước");
            gameScreen.button3.setText("");

            showAllButton();

            nextPosition1 = "intoAlley";
            nextPosition2 = "keepGoing";
            nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            gameScreen.gameTextView.setText("Bạn đã bị phát hiện, giờ đây bạn buộc phải chiến đấu!!!");

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            nextPosition1 = "attack";
            nextPosition2 = "";
            nextPosition3 = "";

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

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void intoAlley1(){
        nextPosition = "outsideCastle";
        gameScreen.gameImageView.setImageResource(R.drawable.hood);
        gameScreen.gameTextView.setText("Sau khi đánh bại tên côn đồ, bạn phát hiện ra có một người thần bí đã chứng kiến toàn bộ sự việc.\n\nPhía trước chính là lối đi bí mật để ra ngoài thành!");
        gameScreen.monster.aMystic();

        gameScreen.button1.setText("Tấn công anh ta");
        gameScreen.button2.setText("Tiếp tục đi");
        gameScreen.button3.setText("");

        showAllButton();

        nextPosition1 = "attack";
        nextPosition2 = nextPosition;
        nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void outsideCastle(){
        gameScreen.gameImageView.setImageResource(R.drawable.castle);
        gameScreen.gameTextView.setText("Bạn đã ra ngoài thành. Giờ đây bạn phải đi gặp Mira để tìm cách xóa bỏ lời nguyền!!!");
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        nextPosition1 = "meetMira";
        nextPosition2 = "";
        nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
    public void keepGoing(){
        nextPosition = "leatherArmor";
        gameScreen.gameImageView.setImageResource(R.drawable.gatekeeper);
        gameScreen.gameTextView.setText("Bạn đến trước cổng thành. Ở phía trước có người gác cổng!!!");
        gameScreen.monster.gateKeeper();
        gameScreen.button1.setText("Đi qua cổng (50%)");
        gameScreen.button2.setText("Tấn công");
        gameScreen.button3.setText("Quay lại");

        showAllButton();

        nextPosition1 = "checkAtGate";
        nextPosition2 = "attack";
        nextPosition3 = "alley";
    }

    public void checkAtGate(){
        gameScreen.fight.random();
        gameScreen.gameImageView.setImageResource(R.drawable.gatekeeper);
        if (gameScreen.fight.randomPercent <= 5){
            gameScreen.gameTextView.setText("Bạn đã bị phát hiện!!!\n\nChiến đấu!!!");

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Bỏ chạy");
            gameScreen.button3.setText("");

            showAllButton();

            nextPosition1 = "attack";
            nextPosition2 = "run";
            nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }else{
            gameScreen.gameTextView.setText("Bạn không bị phát hiện!!!");

            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");

            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            nextPosition1 = "outsideCastle";
            nextPosition2 = "";
            nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
    }

    public void leatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.leatherarmor);
        gameScreen.gameTextView.setText("Bạn nhận được một bình thuốc hồi máu và một bộ giáp da sau khi đánh bại kẻ địch\n\nBạn có muốn sử dụng giáp da không?");

        gameScreen.player.healingPotion += 1;
        gameScreen.player.healingPotion();

        gameScreen.button1.setText("Có");
        gameScreen.button2.setText("Không");
        gameScreen.button3.setText("");

        showAllButton();

        nextPosition1 = "useLeatherArmor";
        nextPosition2 = "notUseLeatherArmor";
        nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void useLeatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.leatherarmor);
        gameScreen.gameTextView.setText("Bạn trang bị thành công, sát thương bạn nhận vào sẽ giảm được một phần.\n\nBạn tiếp tục đi về phía trước");
        gameScreen.player.leatherArmor = true;

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        nextPosition1 = "alley";
        nextPosition2 = "";
        nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
    public void notUseLeatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.go);
        gameScreen.gameTextView.setText("Bạn bỏ qua món đồ và tiếp tục đi về phía trước!");

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        nextPosition1 = "outsideCastle";
        nextPosition2 = "";
        nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
}

