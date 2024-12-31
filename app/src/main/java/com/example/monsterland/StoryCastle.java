
package com.example.monsterland;

import android.annotation.SuppressLint;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@SuppressLint("SetTextI18n")

public class StoryCastle {
    GameScreen gameScreen;
    boolean knightDead = false;
    public StoryCastle(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }
    public void opening1(){
        gameScreen.gameImageView.setImageResource(R.drawable.city);
        gameScreen.gameTextView.setText("Bạn sống trong thành phố Umbra, nơi một lời nguyền cổ xưa đã đè nặng lên đời sống của người dân, khiến nhiều người mắc phải các biến chứng kỳ lạ. Những cơn gió mang theo mùi hương tẩm thuốc và bóng tối vương vấn trong không gian.");
        gameScreen.player.playerUseStick();
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);
        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "opening2";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "opening";
        gameScreen.story.resetMonsterText();
    }
    public void opening(){
        gameScreen.gameImageView.setImageResource(R.drawable.city);
        gameScreen.gameTextView.setText("Bạn sống trong thành phố Umbra, nơi một lời nguyền cổ xưa đã đè nặng lên đời sống của người dân, khiến nhiều người mắc phải các biến chứng kỳ lạ. Những cơn gió mang theo mùi hương tẩm thuốc và bóng tối vương vấn trong không gian.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);
        gameScreen.story.nextStory();

        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "opening";
        gameScreen.story.resetMonsterText();
    }
    public void opening2(){
        gameScreen.gameImageView.setImageResource(R.drawable.scar);
        gameScreen.gameTextView.setText("Bạn nhận ra rằng đó là dấu vết của một con quái vật đã chết, nhưng lời nguyền vẫn còn tồn tại.\n\n Để giải thoát khỏi số phận này, bạn phải tìm Mira, một thầy thuốc nổi tiếng ẩn cư ở ngoài rìa thành phố, nhờ giúp đỡ.");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "meetCat";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "opening2";
        gameScreen.story.resetMonsterText();
    }
    public void meetCat(){
        gameScreen.gameImageView.setImageResource(R.drawable.cat);
        gameScreen.gameTextView.setText("Bạn cần rời khỏi thành phố càng sớm càng tốt để gặp Mira mà không bị phát hiện, nếu không sẽ gặp rắc rối lớn. Khi đi qua một con hẻm, bạn nhìn thấy một chú mèo đang bới rác, và một vật gì đó lấp lánh đang tỏa sáng dưới lớp rác.\n" + "\n" + "Liệu bạn có dừng lại kiểm tra món đồ này hay tiếp tục bước đi, giữ tốc độ và sự cẩn trọng?");

        gameScreen.button1.setText("Tới chỗ thùng rác");
        gameScreen.button2.setText("Tiếp tục đi");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "trashCan";
        gameScreen.story.nextPosition2 = "alley";

        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "meetCat";
        gameScreen.story.resetMonsterText();
    }
    public void trashCan(){
        gameScreen.gameImageView.setImageResource(R.drawable.trash);
        gameScreen.gameTextView.setText("Bạn nhìn thấy một con dao, tuy bị rỉ sét nhưng vẫn sắc bén và chắc chắn hơn cây gậy gỗ hiện tại. Món đồ này có thể sẽ giúp ích trong những tình huống nguy hiểm sắp tới.\n" + "\n" + "Bạn có muốn thay gậy gỗ bằng con dao này không?");

        gameScreen.button1.setText("Có");
        gameScreen.button2.setText("Không");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "useKnife";
        gameScreen.story.nextPosition2 = "notUseKnife";

        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "trashCan";
        gameScreen.story.resetMonsterText();
    }
    public void useKnife(){
        gameScreen.gameImageView.setImageResource(R.drawable.rustyknife);
        gameScreen.gameTextView.setText("Bạn trang bị con dao thành công, cảm nhận sự vững chắc và sắc bén của nó trong tay. Sức mạnh của bạn đã tăng lên, điểm tấn công hiện tại là 3 - 5, khiến bạn tự tin hơn.\n" + "\n" + "Bạn tiếp tục bước về phía trước, sẵn sàng đối mặt với những thử thách tiếp theo.");
        gameScreen.player.playerUseRustyKnife();
        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "alley";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "useKnife1";
        gameScreen.story.resetMonsterText();
    }
    public void useKnife1() {
        gameScreen.gameImageView.setImageResource(R.drawable.rustyknife);
        gameScreen.gameTextView.setText("Bạn trang bị con dao thành công, cảm nhận sự vững chắc và sắc bén của nó trong tay. Sức mạnh của bạn đã tăng lên, điểm tấn công hiện tại là 3 - 5, khiến bạn tự tin hơn.\n" + "\n" + "Bạn tiếp tục bước về phía trước, sẵn sàng đối mặt với những thử thách tiếp theo.");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "alley";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "useKnife1";
        gameScreen.story.resetMonsterText();
    }
    public void notUseKnife(){
        gameScreen.gameImageView.setImageResource(R.drawable.go);
        gameScreen.gameTextView.setText("Bạn liếc qua món đồ, nhưng quyết định không dừng lại. Cảm giác khẩn trương thôi thúc bạn tiếp tục bước đi, hướng về phía trước, nơi những nguy hiểm vẫn đang chờ đón.");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "alley";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "notUseKnife";
        gameScreen.story.resetMonsterText();
    }
    public void alley(){
        gameScreen.gameImageView.setImageResource(R.drawable.waysign);
        gameScreen.gameTextView.setText("Đứng trước con hẻm tối tăm, bạn cảm nhận rõ sự nguy hiểm đang rình rập phía trong. Đám du côn tụ tập ở đó, ánh mắt họ sắc lạnh và đầy thách thức.\n" + "\n" + "Bạn sẽ chọn đối mặt với họ, tìm cách vượt qua, hay tìm lối khác để tránh rắc rối?");

        gameScreen.button1.setText("Đi vào hẻm");
        gameScreen.button2.setText("Đi về phía trước");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "intoAlley";
        gameScreen.story.nextPosition2 = "keepGoing";
        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "alley";
        gameScreen.story.resetMonsterText();
    }
    public void intoAlley(){
        gameScreen.story.nextPosition = "banditKnife";
        gameScreen.story.nextPositionTwo = "run";
        gameScreen.gameImageView.setImageResource(R.drawable.bandit);
        gameScreen.gameTextView.setText("Trước mặt bạn, tên côn đồ đứng chắn đường, ánh mắt đầy thách thức và nụ cười nhếch mép. Không gian xung quanh có vẻ tĩnh lặng, nhưng bạn biết hắn có thể gây rắc rối bất cứ lúc nào.\n" + "\n" + "Bạn sẽ đối đầu với hắn hay tìm cách lẩn tránh ");
        gameScreen.monster.bandit();

        gameScreen.button1.setText("Đánh lén (50% cơ hội)");
        gameScreen.button2.setText("Lẩn tránh (70% cơ hội)");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "sneakAttack";
        gameScreen.story.nextPosition2 = "runBeforeAttack";
        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "intoAlley";
    }
    public void sneakAttack(){
        gameScreen.story.nextPosition = "banditKnife";
        gameScreen.story.nextPositionTwo = "run";
        gameScreen.gameImageView.setImageResource(R.drawable.bandit);
        gameScreen.battle.percent = 5;
        gameScreen.battle.sneakAttack();

        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("Bỏ chạy (30%)");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = gameScreen.story.nextPositionTwo;
        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "sneakAttack";
    }
    public void attack(){
        if (Objects.equals(gameScreen.story.nextPosition, "banditKnife")){
            gameScreen.gameImageView.setImageResource(R.drawable.bandit);
        } else if(Objects.equals(gameScreen.story.nextPosition, "outsideCastle")){
            gameScreen.gameImageView.setImageResource(R.drawable.hood);
        } else if(Objects.equals(gameScreen.story.nextPosition, "leatherArmor")){
            gameScreen.gameImageView.setImageResource(R.drawable.gatekeeper);
        } else if(Objects.equals(gameScreen.story.nextPosition, "knightDead")){
            gameScreen.gameImageView.setImageResource(R.drawable.knight);
        } else if(Objects.equals(gameScreen.story.nextPosition, "killedGoblin")){
            gameScreen.gameImageView.setImageResource(R.drawable.goblin);
        } else if(Objects.equals(gameScreen.story.nextPosition, "killedWolf")){
            gameScreen.gameImageView.setImageResource(R.drawable.wolfhead);
        }
        gameScreen.battle.attack();
        if(gameScreen.player.playerHp <=0){

            gameScreen.button1.setText("Bạn đã bị đánh bại!!!");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "dead";
            gameScreen.story.invisible2Button();

            gameScreen.story.resetMonsterText();
            gameScreen.playerAttackTextView.setText("");
            gameScreen.playerHPTextView.setText("");
            gameScreen.story.savePosition = "deadAttack";

        }
        else if (gameScreen.monster.monsterHP <=0) {
            gameScreen.story.nextStory();

            gameScreen.story.nextPosition1 = gameScreen.story.nextPosition;
            gameScreen.story.invisible2Button();
            gameScreen.player.playerExpGain();

            gameScreen.player.dropHealingPotion();
            gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch! Hắn ngã xuống, và chiến thắng là của bạn.\n\nBạn nhận được một bình máu, giúp hồi phục sức khỏe và chuẩn bị cho những thử thách tiếp theo.");

            gameScreen.story.resetMonsterText();
            gameScreen.story.savePosition = "winAttack";
        }
        else {
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Bỏ chạy (30% cơ hội)");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.nextPosition2 = gameScreen.story.nextPositionTwo;
            gameScreen.story.invisible1Button();

            gameScreen.story.savePosition = "waitAttack";
        }
    }
    public void setImage() {
        Map<String, Integer> imageMap = new HashMap<>();
        imageMap.put("banditKnife", R.drawable.bandit);
        imageMap.put("outsideCastle", R.drawable.hood);
        imageMap.put("leatherArmor", R.drawable.gatekeeper);
        imageMap.put("knightDead", R.drawable.knight);
        imageMap.put("killedGoblin", R.drawable.goblin);
        imageMap.put("killedWolf", R.drawable.wolfhead);
        Integer imageResource = imageMap.get(gameScreen.story.nextPosition);
        if (imageResource != null) {
            gameScreen.gameImageView.setImageResource(imageResource);
        }
    }
    public void winAttack(){
        setImage();
        gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch! Hắn ngã xuống, và chiến thắng là của bạn.\n\nBạn nhận được một bình máu, giúp hồi phục sức khỏe và chuẩn bị cho những thử thách tiếp theo.");
        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = gameScreen.story.nextPosition;
        gameScreen.story.invisible2Button();

        gameScreen.story.resetMonsterText();
        gameScreen.story.savePosition = "winAttack";
    }
    public void deadAttack(){
        setImage();
        gameScreen.button1.setText("Bạn đã bị đánh bại!!!");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "dead";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "deadAttack";
        gameScreen.story.resetMonsterText();
    }
    public void waitAttack(){
        setImage();

        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("Bỏ chạy (30% cơ hội)");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = gameScreen.story.nextPositionTwo;
        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "waitAttack";
    }
    public void run(){
        gameScreen.battle.random();
        if (gameScreen.battle.randomPercent <= 3){
            gameScreen.gameImageView.setImageResource(R.drawable.waysign);
            gameScreen.gameTextView.setText("Bạn đã quay lại trước con hẻm, nơi vẫn còn những dấu vết đẫm máu. Bầu không khí tĩnh lặng, nhưng sự nguy hiểm vẫn còn rình rập.\n" + "\n" + "Bạn sẽ vào hẻm một lần nữa để đối mặt với những kẻ du côn, hay bạn sẽ tìm một con đường khác để tránh xa mối nguy này?");

            gameScreen.button1.setText("Đi vào hẻm");
            gameScreen.button2.setText("Đi về phía trước");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "intoAlley";
            gameScreen.story.nextPosition2 = "keepGoing";
            gameScreen.story.invisible1Button();

            gameScreen.story.resetMonsterText();
        }
        else {
            gameScreen.battle.run();
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.invisible2Button();
        }
        gameScreen.story.savePosition = "run";
    }
    public void runBeforeAttack(){
        gameScreen.story.nextPosition = "banditKnife";
        gameScreen.battle.random();
        if (gameScreen.battle.randomPercent <= 7){
            gameScreen.gameImageView.setImageResource(R.drawable.waysign);
            gameScreen.gameTextView.setText("Bạn đã quay lại trước con hẻm, nơi vẫn còn những dấu vết đẫm máu. Bầu không khí tĩnh lặng, nhưng sự nguy hiểm vẫn còn rình rập.\n" + "\n" + "Bạn sẽ vào hẻm một lần nữa để đối mặt với những kẻ du côn, hay bạn sẽ tìm một con đường khác để tránh xa mối nguy này?");

            gameScreen.button1.setText("Đi vào hẻm");
            gameScreen.button2.setText("Đi về phía trước");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "intoAlley";
            gameScreen.story.nextPosition2 = "keepGoing";
            gameScreen.story.invisible1Button();

            gameScreen.story.resetMonsterText();
        }
        else {
            gameScreen.gameImageView.setImageResource(R.drawable.bandit);
            gameScreen.gameTextView.setText("Bạn đã bị phát hiện! Tiếng bước chân vang lên từ phía sau, kẻ địch đang tiến lại gần, ánh mắt đầy thù địch. Không còn lựa chọn nào khác, bạn buộc phải chiến đấu để bảo vệ chính mình!");

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.invisible2Button();
        }
        gameScreen.story.savePosition = "runBeforeAttack";
    }
    public void banditKnife(){
        gameScreen.gameImageView.setImageResource(R.drawable.banditknife);
        gameScreen.gameTextView.setText("Sau một cuộc giao đấu căng thẳng, bạn cuối cùng cũng tiêu diệt được tên côn đồ. Hắn gục xuống, thở dốc và không còn khả năng phản kháng. Khi kiểm tra thi thể của hắn, bạn tìm thấy một con dao sắc bén được giấu kỹ trong áo hắn. Con dao có vẻ là một công cụ hữu ích trong hành trình tiếp theo của bạn, nên bạn quyết định cầm lấy nó.");
        gameScreen.player.playerUseBanditKnife();

        gameScreen.story.nextStory();

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "intoAlley1";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "banditKnife1";
        gameScreen.story.resetMonsterText();
    }
    public void banditKnife1(){
        gameScreen.gameImageView.setImageResource(R.drawable.banditknife);
        gameScreen.gameTextView.setText("Sau một cuộc giao đấu căng thẳng, bạn cuối cùng cũng tiêu diệt được tên côn đồ. Hắn gục xuống, thở dốc và không còn khả năng phản kháng. Khi kiểm tra thi thể của hắn, bạn tìm thấy một con dao sắc bén được giấu kỹ trong áo hắn. Con dao có vẻ là một công cụ hữu ích trong hành trình tiếp theo của bạn, nên bạn quyết định cầm lấy nó.");

        gameScreen.story.nextStory();

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "intoAlley1";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "banditKnife1";
        gameScreen.story.resetMonsterText();
    }
    public void dead(){
        gameScreen.gameImageView.setImageResource(R.drawable.dead);
        gameScreen.gameTextView.setText("Bạn đã chết! Kẻ thù tấn công quá mạnh mẽ và bạn không kịp phản ứng. Cái kết đột ngột này đánh dấu sự kết thúc của một hành trình, nhưng cũng là cơ hội để bạn học hỏi và chuẩn bị cho những cuộc phiêu lưu tiếp theo!\n\n GAME OVER!!!");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "goTitleScreen";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "dead";
        gameScreen.story.resetMonsterText();
    }
    public void intoAlley1(){
        gameScreen.story.nextPosition = "outsideCastle";
        gameScreen.gameImageView.setImageResource(R.drawable.hood);
        gameScreen.gameTextView.setText("Sau khi đánh bại tên côn đồ, bạn nhận thấy một bóng dáng thần bí đang quan sát từ xa. Hắn đứng im lặng, nhưng khí thế toát ra sự nguy hiểm tột cùng. Ánh mắt sắc bén và cơ thể cường tráng khiến bạn nhận ra hắn là một đối thủ cực kỳ mạnh mẽ.    " + "\n" + "Phía trước, một cánh cửa nhỏ mở ra, dẫn đến lối đi bí mật để ra ngoài thành—cơ hội duy nhất để thoát khỏi tình huống nguy hiểm này.");
        gameScreen.monster.aMystic();

        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("Chạy qua cánh cửa");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = gameScreen.story.nextPosition;
        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "intoAlley1";
        gameScreen.story.resetMonsterText();
    }
    public void outsideCastle(){
        gameScreen.gameImageView.setImageResource(R.drawable.castle);
        gameScreen.gameTextView.setText("Bạn đã ra ngoài thành, cảm giác tự do và an toàn tạm thời bao phủ lấy bạn. Nhưng ngay lập tức, sự lo lắng về lời nguyền lại ùa về. Bạn biết mình cần phải gặp Mira càng sớm càng tốt để tìm cách xóa bỏ nó. Thời gian không còn nhiều, và mỗi phút trôi qua đều quan trọng.");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "meetMira";
        gameScreen.story.invisible2Button();

        gameScreen.story.resetMonsterText();
        gameScreen.story.savePosition = "outsideCastle";
    }
    public void keepGoing(){
        gameScreen.story.nextPositionTwo = "run";
        gameScreen.story.nextPosition = "leatherArmor";
        gameScreen.gameImageView.setImageResource(R.drawable.gatekeeper);
        gameScreen.gameTextView.setText("Bạn đến trước cổng thành, nơi có một người gác cổng đang đứng nghiêm nghị. Ánh mắt của hắn sắc bén, nhìn bạn một cách nghi ngờ. Không có gì là dễ dàng khi đối mặt với những người gác cổng, họ có thể không cho phép bạn đi qua nếu không có lý do chính đáng.\n" + "\n" + "Bạn sẽ làm gì tiếp theo? Tấn cộng hắn, tìm cách lách qua mà không bị phát hiện hay quay lại?");
        gameScreen.monster.gateKeeper();

        gameScreen.button1.setText("Lén lút lách qua (50%)");
        gameScreen.button2.setText("Tấn công");
        gameScreen.button3.setText("Quay lại");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "checkAtGate";
        gameScreen.story.nextPosition2 = "attack";
        gameScreen.story.nextPosition3 = "alley";

        gameScreen.story.savePosition = "keepGoing";
    }
    public void checkAtGate(){
        gameScreen.battle.random();
        gameScreen.gameImageView.setImageResource(R.drawable.gatekeeper);
        if (gameScreen.battle.randomPercent <= 5){
            gameScreen.gameTextView.setText("Bạn đã bị phát hiện! Người gác cổng lập tức rút kiếm, ánh mắt đầy thách thức và sẵn sàng đối đầu. Không còn đường lui, bạn buộc phải chiến đấu để tiếp tục hành trình của mình.\n" + "\n" + "Hãy chuẩn bị tinh thần, chiến đấu hết sức để vượt qua thử thách này!");

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Bỏ chạy");
            gameScreen.button3.setText("");

            gameScreen.story.showAllButton();

            gameScreen.story.nextPosition1 = "attack";
            gameScreen.story.nextPosition2 = "run";
            gameScreen.story.invisible1Button();
        }else{
            gameScreen.gameTextView.setText("Bạn đã thành công không bị phát hiện khi tiến qua cổng! Người gác cổng không chú ý đến bạn, và bạn lặng lẽ vượt qua mà không gặp bất kỳ trở ngại nào. Cổng thành mở ra, dẫn bạn vào con đường mới, nơi cuộc hành trình tiếp tục.\n" + "\n" + "Giờ đây, bạn đã gần hơn với Mira và cách xóa bỏ lời nguyền.");

            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");

            gameScreen.story.nextStory();

            gameScreen.story.nextPosition1 = "outsideCastle";
            gameScreen.story.invisible2Button();

            gameScreen.story.resetMonsterText();
        }
        gameScreen.story.savePosition = "checkAtGate";
    }
    public void leatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.leatherarmor);
        gameScreen.gameTextView.setText("Chiến thắng kẻ địch, bạn nhận một bộ giáp da. Bộ giáp nhẹ nhưng đủ chắc chắn để bảo vệ bạn khỏi những đòn tấn công cơ bản.\n" + "\n" + "Bạn có muốn trang bị giáp da ngay bây giờ không?");


        gameScreen.button1.setText("Có");
        gameScreen.button2.setText("Không");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "useLeatherArmor";
        gameScreen.story.nextPosition2 = "notUseLeatherArmor";
        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "leatherArmor";
        gameScreen.story.resetMonsterText();
    }
    public void useLeatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.leatherarmor);
        gameScreen.gameTextView.setText("Bạn trang bị bộ giáp da thành công, cảm nhận lớp bảo vệ mới che chắn cơ thể. Với nó, sát thương bạn nhận vào sẽ giảm đi một phần, tăng thêm cơ hội sống sót.\n" + "\n" + "Hít một hơi thật sâu, bạn tiếp tục tiến bước vào con đường phía trước, nơi hiểm nguy vẫn đang rình rập");
        gameScreen.player.leatherArmor = true;
        gameScreen.player.playerMaxHp += 20;
        gameScreen.player.playerHp += 20;
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        if(gameScreen.player.playerHp > gameScreen.player.playerMaxHp){
            gameScreen.player.playerHp = gameScreen.player.playerMaxHp;
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        }
        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "outsideCastle";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "useLeatherArmor1";
        gameScreen.story.resetMonsterText();
    }
    public void useLeatherArmor1(){
        gameScreen.gameImageView.setImageResource(R.drawable.leatherarmor);
        gameScreen.gameTextView.setText("Bạn trang bị bộ giáp da thành công, cảm nhận lớp bảo vệ mới che chắn cơ thể. Với nó, sát thương bạn nhận vào sẽ giảm đi một phần, tăng thêm cơ hội sống sót.\n" + "\n" + "Hít một hơi thật sâu, bạn tiếp tục tiến bước vào con đường phía trước, nơi hiểm nguy vẫn đang rình rập");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "outsideCastle";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "useLeatherArmor1";
        gameScreen.story.resetMonsterText();
    }
    public void notUseLeatherArmor(){
        gameScreen.gameImageView.setImageResource(R.drawable.go);
        gameScreen.gameTextView.setText("Bạn liếc nhanh qua món đồ, nhưng cảm giác không an toàn khiến bạn quyết định bỏ qua. Không dừng lại, bạn tiếp tục bước về phía trước, đôi mắt cảnh giác, chuẩn bị đối mặt với những thử thách đang chờ đón.");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "outsideCastle";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "outsideCastle";
        gameScreen.story.resetMonsterText();
    }
    public void meetMira(){
        gameScreen.gameImageView.setImageResource(R.drawable.mira);
        gameScreen.gameTextView.setText("Bạn đến gặp Mira\n\nMira nhìn bạn một lúc lâu, đôi mắt có chút lo lắng. Cô hỏi:\n\n'Ngươi có thể nói cho ta rõ hơn về vết thương này không? Nó là vết thương cũ hay là dấu hiệu của sự nguy hiểm? Nếu cần ta sẵn sàng giúp, nhưng ta cần phải biết sự thật.'");

        gameScreen.story.showAllButton();

        gameScreen.button1.setText("Bạn thú nhận sự thật");
        gameScreen.button2.setText("Nói dối đây là vết thương cũ");
        gameScreen.button3.setText("Bạn từ chối trả lời");

        gameScreen.story.nextPosition1 = "tellTruth";
        gameScreen.story.nextPosition2 = "lie";
        gameScreen.story.nextPosition3 = "refuseAnswer";

        gameScreen.story.savePosition = "meetMira";
        gameScreen.story.resetMonsterText();
    }
    public void tellTruth(){
        gameScreen.gameImageView.setImageResource(R.drawable.postion);
        gameScreen.gameTextView.setText("Mira nhìn bạn, lo lắng nhưng kiên quyết. Cô đồng ý giúp, giải thích rằng để phá vỡ lời nguyền, bạn phải tìm đủ ba mảnh vỡ ở Rừng Đen - Tenebris, Hồ Bạc - Argentis và Thành Trì Tháp Đen - The Black Tower\n\n Mira đưa bạn một lọ thuốc đặc biệt để hỗ trợ bạn.");

        gameScreen.player.specialPotion = true;

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "getOutMiraHome";
        gameScreen.story.invisible2Button();
        gameScreen.story.savePosition = "tellTruth";
        gameScreen.story.resetMonsterText();
    }
    public void lie(){
        gameScreen.gameImageView.setImageResource(R.drawable.think);
        gameScreen.gameTextView.setText("Mira thoáng nghi ngờ nhưng vẫn quyết định giúp bạn. Cô đưa bạn thuốc giảm đau và chỉ dẫn cách vượt qua thử thách đầu tiên, dù ánh mắt vẫn lộ vẻ lo âu. Tuy nhiên, mối quan hệ giữa bạn và Mira sẽ không hoàn toàn gắn kết nếu sự thật chưa được thú nhận.");

        gameScreen.player.playerHp += 10;
        if(gameScreen.player.playerHp > gameScreen.player.playerMaxHp){
            gameScreen.player.playerHp = gameScreen.player.playerMaxHp;
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
        }
        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "getOutMiraHome";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "lie";
        gameScreen.story.resetMonsterText();
    }
    public void refuseAnswer(){
        gameScreen.gameImageView.setImageResource(R.drawable.look);
        gameScreen.gameTextView.setText("Mira nhìn bạn với ánh mắt sợ hãi và lập tức ra lệnh rời đi. Cô tin rằng dấu ấn này sẽ mang thảm họa không chỉ cho bạn mà còn cho toàn thành phố Umbra.\n\n Cuộc hành trình của bạn đã kết thúc!\n\n GAME OVER!!!");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "goTitleScreen";
        gameScreen.story.invisible2Button();

        gameScreen.story.savePosition = "refuseAnswer";
        gameScreen.story.resetMonsterText();
    }
    public void getOutMiraHome(){
        gameScreen.story.nextPositionTwo = "woodenSign";
        gameScreen.story.nextPosition = "knightDead";
        gameScreen.gameImageView.setImageResource(R.drawable.knight);
        gameScreen.gameTextView.setText("Rời khỏi nhà Mira, bạn cảm thấy một luồng áp lực kỳ lạ. Quay lại, bạn bắt gặp ánh mắt quen thuộc đang xoáy sâu vào mình. Một vị hiệp sĩ, tay cầm chặt thanh kiếm sáng loáng, bất ngờ lao tới. Tiếng bước chân nặng nề và sát khí từ hắn khiến tim bạn đập mạnh — hắn đang đuổi theo bạn!");
        gameScreen.monster.knight();

        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("Bỏ chạy");
        gameScreen.button3.setText("");

        gameScreen.story.showAllButton();

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = "woodenSign";
        gameScreen.story.invisible1Button();

        gameScreen.story.savePosition = "getOutMiraHome";
    }
    public void knightDead(){
        gameScreen.gameImageView.setImageResource(R.drawable.gladius);
        gameScreen.gameTextView.setText("Bạn nhặt thanh kiếm từ tay tên hiệp sĩ vừa gục ngã. Lưỡi kiếm gỉ sét, nhưng dường như nó tỏa ra một luồng sức mạnh bí ẩn, hòa quyện với ý chí của bạn. Một cảm giác dâng trào lan tỏa—sức mạnh của bạn đã tăng lên!");

        gameScreen.player.playerUseSword();

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "woodenSign";
        gameScreen.story.invisible2Button();

        gameScreen.story.resetMonsterText();
        knightDead = true;
        gameScreen.story.savePosition = "knightDead1";
    }
    public void knightDead1(){
        gameScreen.gameImageView.setImageResource(R.drawable.gladius);
        gameScreen.gameTextView.setText("Bạn nhặt thanh kiếm từ tay tên hiệp sĩ vừa gục ngã. Lưỡi kiếm gỉ sét, nhưng dường như nó tỏa ra một luồng sức mạnh bí ẩn, hòa quyện với ý chí của bạn. Một cảm giác dâng trào lan tỏa—sức mạnh của bạn đã tăng lên!");

        gameScreen.story.nextStory();

        gameScreen.story.nextPosition1 = "woodenSign";
        gameScreen.story.invisible2Button();

        gameScreen.story.resetMonsterText();
        knightDead = true;
        gameScreen.story.savePosition = "knightDead1";
    }
    public void woodenSign(){
        gameScreen.gameImageView.setImageResource(R.drawable.sign);
        gameScreen.gameTextView.setText("Theo lời của Mira, bạn đã đến trước tấm biển gỗ cũ kỹ, trên đó khắc hai con đường: một lối dẫn vào Rừng Đen - Tenebris, nơi bóng tối và hiểm nguy rình rập, và lối kia hướng về Hồ Bạc - Argentis, ánh sáng phản chiếu vẻ huyền bí đầy mê hoặc.\n" + "\n" + "Bạn sẽ chọn tiến vào đâu trước?");

        gameScreen.story.showAllButton();

        gameScreen.button1.setText("Rừng Đen - Tenebris");
        gameScreen.button2.setText("Hồ Bạc - Argentis");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "tenebris";
        gameScreen.story.nextPosition2 = "argentis";
        gameScreen.story.invisible1Button();

        gameScreen.story.resetMonsterText();
        gameScreen.story.savePosition = "woodenSign";
    }
}
