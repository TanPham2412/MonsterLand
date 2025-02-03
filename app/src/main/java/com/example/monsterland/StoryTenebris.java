package com.example.monsterland;

import android.annotation.SuppressLint;
import android.view.View;
@SuppressLint("SetTextI18n")

public class StoryTenebris {
    GameScreen gameScreen;

    public boolean tenebris = false, repayGoblin = false, goblinCurse = false, wolfTrap = false;
    int boneDart = 0;
    public StoryTenebris(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public void tenebris(){
        gameScreen.gameImageView.setImageResource(R.drawable.jungle);
        gameScreen.gameTextView.setText("Bạn bước vào Rừng Tenebris, nơi tiếng gió rít lên như những tiếng thở của ma quái, và bóng tối dày đặc che lấp con đường phía trước. Mảnh vỡ đầu tiên của lời nguyền được cho là nằm sâu trong lòng rừng, nơi những sinh vật kỳ dị sinh sống và bảo vệ nó bằng mọi giá.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.story.showAllButton();

        gameScreen.button1.setText("Tiếp tục đi");
        gameScreen.button2.setText("Quay lại");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "meetGoblin";
        if(!gameScreen.storyArgentis.argentis){
            if(!gameScreen.storyCastle.knightDead){
                gameScreen.story.nextPosition2 = "woodenSign1";
                gameScreen.button3.setVisibility(View.INVISIBLE);
            } else {
                gameScreen.story.nextPosition2 = "woodenSign";
            }
        } else {
            gameScreen.story.nextPosition2 = "woodenSign";
        }
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "tenebris";
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
    }

    public void woodenSign1(){
        gameScreen.story.nextPosition = "knightDead";
        gameScreen.gameImageView.setImageResource(R.drawable.knight);
        gameScreen.gameTextView.setText("Bạn quay lại vị trí tấm biển cũ, nhưng sự tĩnh lặng giờ đã biến mất. Tên hiệp sĩ xuất hiện giữa màn sương, đôi mắt sáng rực như hố lửa đầy hận thù. Thanh kiếm gỉ sét phát ra ánh sáng sắc lạnh, tựa như đang khát máu. Không còn đường lui, sát khí dày đặc tràn ngập không gian. Tiếng bước chân hắn chậm rãi nhưng đầy đe dọa, mỗi bước như một bản án tử. Trận chiến này là thử thách sống còn.");
        gameScreen.monster.knight();
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);
        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "woodenSign1";
    }

    public void meetGoblin(){
        gameScreen.gameImageView.setImageResource(R.drawable.goblin);
        gameScreen.gameTextView.setText("Sau khi chạy trốn khỏi tên hiệp sĩ, bạn lạc vào sâu trong rừng, bỏ lỡ tuyến đường của Mira. Mệt mỏi và đói khát, bạn loay hoay giữa những cây cổ thụ thì bất ngờ, một đứa trẻ tộc goblin xuất hiện, cầm miếng thịt trên tay. Vẻ mặt nó hiếu kỳ nhưng cũng đầy cảnh giác. Cơn đói khiến bạn chú ý đến miếng thịt, nhưng goblin không phải là tộc dễ đoán. Bạn sẽ làm gì?");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.story.showAllButton();

        gameScreen.button1.setText("Tiến lại gần xin miếng thịt");
        gameScreen.button2.setText("Cướp lấy miếng thịt");
        gameScreen.button3.setText("Rời khỏi đó mà không làm gì");

        gameScreen.story.nextPosition1 = "pleaseMeat";
        gameScreen.story.nextPosition2 = "meatRobbery";
        gameScreen.story.nextPosition3 = "leave";
        gameScreen.story.savePosition = "meetGoblin";
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
    }

    public void pleaseMeat(){
        gameScreen.gameImageView.setImageResource(R.drawable.meat);
        gameScreen.battle.random();
        if(gameScreen.battle.randomPercent <=5){
            gameScreen.gameTextView.setText("Sau một hồi quan sát, đứa trẻ goblin thấy bạn đói và mệt mỏi. Nó lưỡng lự một chút, rồi gật đầu và đưa miếng thịt cho bạn. Mặc dù không rõ lý do, bạn nhận lấy, cảm ơn và ăn một cách cẩn thận. Cơn đói giảm bớt phần nào, giúp bạn hồi phục sức lực. Goblin vẫn giữ im lặng, ánh mắt tò mò nhìn bạn như đang chờ đợi một phản ứng.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.story.showAllButton();

            gameScreen.button1.setText("Bạn hứa sẽ trả ơn");
            gameScreen.button2.setText("Bạn không hứa hẹn điều gì");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "repay";
            gameScreen.story.nextPosition2 = "noRepay";

        }
        else {
            gameScreen.gameTextView.setText("Bạn tiến lại gần goblin, hy vọng xin một ít thức ăn, nhưng đứa trẻ nhìn bạn với vẻ mặt cảnh giác. Nó lắc đầu, giữ chặt miếng thịt trong tay và lùi lại một bước. Ánh mắt đầy phòng thủ, như thể không muốn chia sẻ bất cứ thứ gì. Bạn cảm nhận rõ sự nguy hiểm tiềm ẩn trong hành động của goblin và nhận ra rằng việc tiếp tục xin thức ăn có thể không phải là lựa chọn tốt.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.story.showAllButton();

            gameScreen.button1.setText("Cướp lấy miếng thịt");
            gameScreen.button2.setText("Rời khỏi đó mà không làm gì");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "meatRobbery";
            gameScreen.story.nextPosition2 = "leave";

        }
        gameScreen.story.nextPosition3 = "";
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "pleaseMeat";
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
    }

    public void meatRobbery(){
        gameScreen.gameImageView.setImageResource(R.drawable.goblin);
        gameScreen.monster.goblinChild();
        gameScreen.story.nextPosition = "killedGoblin";
        gameScreen.gameTextView.setText("Bạn tiến tới gần goblin, ánh mắt quyết đoán. Chỉ trong một khoảnh khắc, bạn lao tới giật mạnh miếng thịt khỏi tay nó. Goblin kêu lên, mắt đầy ngạc nhiên và tức giận, nhưng bạn đã nắm chặt miếng thịt. Nó nhìn bạn với ánh mắt thù địch, rõ ràng không định để bạn dễ dàng thoát. Nếu không tiêu diệt nó, nó sẽ phản kháng rất dữ dội.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "meatRobbery";
    }
    public void leave(){
        gameScreen.gameImageView.setImageResource(R.drawable.goblin);
        gameScreen.gameTextView.setText("Bạn đứng im, quan sát đứa trẻ goblin một lúc. Dù cơn đói khiến bạn muốn miếng thịt, nhưng bạn cũng biết rằng tình huống này có thể trở nên nguy hiểm. Sau một hồi do dự, bạn quyết định không làm gì cả. Bạn lặng lẽ quay lưng, tránh xa goblin và tiếp tục đi về phía trước, tìm kiếm cơ hội khác để giải quyết cơn đói của mình mà không gây thêm rắc rối.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "toRiver";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "leave";
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
    }

    public void repay(){
        gameScreen.gameImageView.setImageResource(R.drawable.goblin);
        gameScreen.gameTextView.setText("Sau khi goblin quyết định cho bạn miếng thịt, bạn nhận lấy và cảm ơn nó bằng một nụ cười. Cơn đói đã được xoa dịu, giúp bạn lấy lại sức lực. Bạn nhìn vào mắt goblin, cảm nhận được sự kỳ lạ trong ánh mắt đó. Bạn hứa sẽ trả ơn nó một ngày nào đó, dù bạn không biết làm thế nào, nhưng lòng biết ơn của bạn sẽ không bao giờ phai nhạt. Goblin chỉ gật đầu, như thể chấp nhận lời hứa của bạn, rồi quay người biến mất vào trong bóng tối của rừng.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        repayGoblin = true;

        if(gameScreen.player.playerHp < gameScreen.player.playerMaxHp) {
            int hp = gameScreen.player.playerMaxHp - gameScreen.player.playerHp;
            gameScreen.player.playerHp += 30;
            if (gameScreen.player.playerHp > gameScreen.player.playerMaxHp) {
                gameScreen.player.playerHp = gameScreen.player.playerMaxHp;
                gameScreen.player.showToast("Bạn đã hồi được " + hp + " hp!", 3000);
            }
            else {
                gameScreen.player.showToast("Bạn đã hồi được " + 30 + " hp!", 3000);
            }
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
        }

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "toRiver";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "repay1";
    }

    public void repay1(){
        gameScreen.gameImageView.setImageResource(R.drawable.goblin);
        gameScreen.gameTextView.setText("Sau khi goblin quyết định cho bạn miếng thịt, bạn nhận lấy và cảm ơn nó bằng một nụ cười. Cơn đói đã được xoa dịu, giúp bạn lấy lại sức lực. Bạn nhìn vào mắt goblin, cảm nhận được sự kỳ lạ trong ánh mắt đó. Bạn hứa sẽ trả ơn nó một ngày nào đó, dù bạn không biết làm thế nào, nhưng lòng biết ơn của bạn sẽ không bao giờ phai nhạt. Goblin chỉ gật đầu, như thể chấp nhận lời hứa của bạn, rồi quay người biến mất vào trong bóng tối của rừng.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "toRiver";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "repay1";
    }

    public void noRepay(){
        repay();
        repayGoblin = false;
        gameScreen.gameTextView.setText("Sau khi goblin cho bạn miếng thịt, bạn nhận lấy và ăn một cách cẩn thận, cảm nhận sức lực dần hồi phục. Goblin chỉ lặng lẽ quan sát, không nói lời nào. Bạn cảm ơn nó, không hứa hẹn gì, chỉ đơn giản là biết rằng sự giúp đỡ này đã đủ trong lúc cần thiết. Sau khi ăn xong, bạn đứng dậy, cảm thấy bớt mệt mỏi hơn, rồi tiếp tục hành trình của mình.");
        gameScreen.story.savePosition = "noRepay";
    }

    public void killedGoblin(){
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
        leave();
        gameScreen.gameTextView.setText("Sau khi tiêu diệt goblin con, hơi thở cuối cùng của nó ám lấy bạn, cảm giác lạnh lẽo lan tỏa khắp cơ thể. Một lời nguyền mơ hồ như đang bám riết lấy bạn, khiến bạn không thể nào thoát khỏi. Bạn biết rằng những kẻ đồng loại của nó sẽ không để yên, và sự trả thù đang đến gần. Cảm giác đó như một bóng đen bám theo, đe dọa cuộc hành trình phía trước của bạn.");
        goblinCurse = true;
        gameScreen.story.savePosition = "killedGoblin";
    }

    public void toRiver(){
        gameScreen.gameImageView.setImageResource(R.drawable.river);
        gameScreen.gameTextView.setText("Sau một vài giờ lang thang trong rừng, bạn phát hiện một dòng suối nhỏ với làn nước trong vắt, nơi bạn có thể nghỉ ngơi. Khi ngồi xuống, bạn nhận thấy vài dấu vết lạ trên bờ, có thể là của con người hoặc một sinh vật khác. Cảm giác hồi hộp dâng lên, bạn quyết định theo dấu vết này, hy vọng sẽ dẫn bạn đến một manh mối quan trọng.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "toVillage";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "toRiver";
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
    }

    public void toVillage(){
        gameScreen.gameImageView.setImageResource(R.drawable.village);
        gameScreen.gameTextView.setText("Bạn đến một ngôi làng nhỏ nằm ẩn mình giữa rừng. Cảnh vật xung quanh khá yên bình, nhưng bạn cảm nhận được sự bí ẩn của nơi này. Có lẽ đây chính là ngôi làng mà Mira đã nhắc tới. Bạn quyết định đi vào, tìm gặp trưởng làng để hỏi thêm thông tin về con Huơu ma và cách giải quyết vấn đề.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "inVillage";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "toVillage";
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
    }

    public void inVillage(){
        gameScreen.gameImageView.setImageResource(R.drawable.minions);
        gameScreen.gameTextView.setText("Khi bước vào làng, bạn nhanh chóng nhận ra một bầu không khí kỳ lạ bao trùm nơi đây. Người dân nhìn bạn bằng ánh mắt lo lắng, khuôn mặt họ lộ rõ vẻ hoảng sợ và tuyệt vọng. Không giống với những gì Mira đã kể, ngôi làng này dường như đang chịu đựng một nỗi ám ảnh nào đó, khiến bạn không khỏi cảm thấy bất an.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "woundedSoldier";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "inVillage";
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
    }

    public void woundedSoldier(){
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
        gameScreen.gameImageView.setImageResource(R.drawable.kneebandage);
        gameScreen.gameTextView.setText("Sau khi dò hỏi thông tin từ những người dân, bạn phát hiện trưởng làng đã bị lũ orc bắt đi. Hy vọng duy nhất là một chiến binh trong làng, người duy nhất biết vị trí của trưởng làng bị bắt. Tuy nhiên, anh ta đang bị thương nặng, nằm trên giường trong tình trạng nguy kịch. Người dân nói anh ấy cần một loại thảo dược quý hiếm để chữa trị, và chỉ có bạn mới có thể tìm được nó.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.story.showAllButton();

        gameScreen.button1.setText("Đi tìm thảo dược");
        gameScreen.button2.setText("Xông vào sào huyệt Orc");
        gameScreen.button3.setText("Thuyết phục dân làng giúp đỡ");

        gameScreen.story.nextPosition1 = "findHerb";
        gameScreen.story.nextPosition2 = "orcBase";
        gameScreen.story.nextPosition3 = "convince";
        gameScreen.story.savePosition = "woundedSoldier";
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
    }

    public void convince(){
        gameScreen.gameImageView.setImageResource(R.drawable.wolftrap);
        gameScreen.gameTextView.setText("Bạn quyết định thuyết phục dân làng giúp đỡ, giải thích rằng cứu sống người chiến binh là hy vọng duy nhất để giải cứu trưởng làng. Sau một hồi bàn bạc, dân làng đồng ý hỗ trợ. Họ đưa cho bạn một cái bẫy thú, được thiết kế chắc chắn, có thể giúp bạn đối phó với những sinh vật nguy hiểm trong rừng.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        wolfTrap = true;

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "findHerb";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "convince";
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
    }

    public void findHerb(){
        gameScreen.gameImageView.setImageResource(R.drawable.wolfhead);
        gameScreen.story.showAllButton();
        if(!wolfTrap){
            gameScreen.gameTextView.setText("Bạn quyết định giúp đỡ người chiến binh và bắt đầu hành trình tìm kiếm thảo dược trong rừng sâu. Đúng như dự đoán, khu rừng đầy rẫy những nguy hiểm rình rập, và sau nhiều giờ tìm kiếm, bạn phát hiện ra loại thảo dược quý hiếm đang mọc trong một khu vực hẻo lánh. Nhưng không may, nó đang được một con sói lớn canh giữ, với đôi mắt sắc lạnh và bộ lông sẫm màu phản chiếu ánh sáng. Con sói gầm gừ, sẵn sàng lao tới bất cứ lúc nào.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.button1.setText("Tấn công con sói.");
            gameScreen.button2.setText("Rút lui tìm phương án khác.") ;
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attackWolf";
            gameScreen.story.nextPosition2 = "retreat";
        }
        else {
            gameScreen.gameTextView.setText("Bạn bắt đầu hành trình tìm kiếm thảo dược trong rừng sâu. Đúng như dự đoán, khu rừng đầy rẫy những nguy hiểm rình rập, và sau nhiều giờ tìm kiếm, bạn phát hiện ra loại thảo dược quý hiếm đang mọc trong một khu vực hẻo lánh. Nhưng không may, nó đang được một con sói lớn canh giữ, với đôi mắt sắc lạnh và bộ lông sẫm màu phản chiếu ánh sáng. Con sói gầm gừ, sẵn sàng lao tới bất cứ lúc nào.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.button1.setText("Tấn công con sói.");
            gameScreen.button2.setText("Tìm cách đánh lạc hướng.") ;
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attackWolf";
            gameScreen.story.nextPosition2 = "distract";

        }
        gameScreen.story.nextPosition3 = "";
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
        gameScreen.story.savePosition = "findHerb";
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
    }

    public void attackWolf(){
        gameScreen.gameImageView.setImageResource(R.drawable.wolfhead);
        gameScreen.story.nextPosition = "killedWolf";
        gameScreen.monster.wolf();
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);
        gameScreen.gameTextView.setText("Quyết tâm đối mặt với con sói, bạn lao vào trong một bước đi đầy dũng cảm. Con sói phản ứng nhanh, nhưng nhờ vào kỹ năng và sự quyết đoán của mình, bạn đã thành công gây thương tích cho nó.");
        gameScreen.player.showToast("Bạn đã thành công trong việc tấn công con sói, khiến nó mất đi 20 HP.",2000);
        gameScreen.button1.setText("Tấn công");
        gameScreen.button2.setText("") ;
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "attack";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "attackWolf";
    }

    public void killedWolf(){
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
        distract();
        gameScreen.gameTextView.setText("Bạn đã thành công tiêu diệt con sói. Với cái xác của nó, bạn nhanh chóng chế tạo những chiếc phi tiêu bằng xương sắc bén. Đồng thời, bạn thu thập các thảo dược quý hiếm để chữa trị cho người chiến binh, hy vọng rằng hành động này sẽ giúp anh ta hồi phục và cung cấp thông tin quan trọng về vị trí của bọn orc.");
        boneDart = 5;
        gameScreen.story.savePosition = "killedWolf";
    }


    public void retreat(){
        woundedSoldier();
        gameScreen.gameTextView.setText("Sau khi quay lại làng và tìm kiếm phương án khác, bạn đối mặt với một lựa chọn quan trọng: Liệu bạn sẽ kêu gọi sự giúp đỡ từ dân làng hay trực tiếp đối đầu với nguy hiểm, tìm đến hang ổ của bọn orc? Hay quay lại đối mặt với con sói và chiến đấu?");
        gameScreen.story.savePosition = "retreat";
    }

    public void distract(){
        gameScreen.gameImageView.setImageResource(R.drawable.herbsbundle);
        gameScreen.gameTextView.setText("Với sự thông minh của mình, bạn quyết định đánh lạc hướng con sói. Sử dụng bẫy mà dân làng đưa cho, bạn khéo léo dẫn dụ con sói vào vị trí bẫy. Chỉ trong giây lát, con sói bị mắc kẹt, không kịp phản ứng. Bạn nhanh chóng thu thập thảo dược quý hiếm mà không hề bị thương, cảm giác thành công dâng trào khi bạn hoàn thành nhiệm vụ mà không gặp nguy hiểm.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText("Quay lại làng");
        gameScreen.button2.setText("") ;
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "backToVillage";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "distract";
    }

    public void backToVillage(){
        if (!goblinCurse){
            gameScreen.gameImageView.setImageResource(R.drawable.goblinelder);
            gameScreen.gameTextView.setText("Trên đường trở về làng, bạn bất ngờ gặp đứa trẻ goblin đi cùng với một chiến binh goblin. Đứa bé tiến lại gần, ánh mắt vừa lo lắng vừa hy vọng. Nó nói rằng con gái của tộc trưởng goblin đang bị thương nặng, và thảo dược mà bạn đang mang chính là thứ họ cần để cứu mạng cô ấy. Lời nói của đứa trẻ khiến bạn phải suy nghĩ: liệu bạn sẽ giúp họ hay giữ thảo dược cho chiến binh của làng?");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.story.showAllButton();

            gameScreen.button1.setText("Giúp");
            gameScreen.button2.setText("Không giúp") ;
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "helpGoblin";
            gameScreen.story.nextPosition2 = "noHelpGoblin";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else{
            gameScreen.gameImageView.setImageResource(R.drawable.goblinking);
            gameScreen.gameTextView.setText("Trên đường trở về làng, bạn bất ngờ đối mặt với một goblin, toàn thân trang bị vũ khí sắc bén và ánh mắt tràn đầy sát khí. Đây chắc hẳn là tù trưởng goblin mà dân làng từng nói với bạn. Bạn nhận ra rằng đây không phải một cuộc gặp gỡ ngẫu nhiên. Lời nguyền từ việc giết hại đứa trẻ goblin trước đó vẫn còn ám lên bạn, và giờ đây dường như chính nó đã dẫn lối cho goblin này tìm đến bạn.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.button1.setText(">");
            gameScreen.button2.setText("") ;
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "kingGoblin";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        gameScreen.story.savePosition = "backToVillage";
    }
    public void helpGoblin(){
        gameScreen.gameImageView.setImageResource(R.drawable.roundshield);
        if(!repayGoblin) {
            gameScreen.gameTextView.setText("Bạn đưa toàn bộ thảo dược cho goblin, ánh mắt nó sáng lên đầy cảm kích. Nó nhận lấy bằng đôi tay run run, miệng lẩm bẩm cảm ơn bằng thứ tiếng khó hiểu.\n" + "\n" + "Để đáp lại, goblin trao cho bạn một chiếc khiên nhỏ, khẽ nói: \"Thứ này sẽ bảo vệ bạn.\"\n" + "\n" + "Nhìn món quà trên tay, bạn nhận ra rằng lòng tốt đôi khi là vũ khí mạnh nhất trong thế giới đầy hiểm nguy này.");
            gameScreen.playerHPTextView.setText("HP: " + gameScreen.player.playerHp + "/" + gameScreen.player.playerMaxHp);
            gameScreen.story.showAllButton();

        }else {
            gameScreen.gameTextView.setText("Bạn quyết định chia sẻ một nửa thảo dược của mình với goblin. Đôi mắt nó sáng lên, đầy bất ngờ và cảm kích. Goblin cúi đầu, đưa tay nhận lấy phần thảo dược một cách kính cẩn.\n\n" + "Để đáp lại, goblin trao cho bạn một chiếc khiên nhỏ. 'Cảm ơn, bạn thật sự tốt bụng,' goblin lí nhí nói bằng thứ tiếng khàn khàn của nó.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);
            gameScreen.player.shield = true;
        }
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "helpGoblin";
    }

    public void noHelpGoblin(){
        if(repayGoblin){
            gameScreen.gameImageView.setImageResource(R.drawable.herbsbundle);
            gameScreen.gameTextView.setText("Bạn quyết định không chia sẻ thảo dược cho goblin. Với giọng điềm tĩnh, bạn giải thích rằng thảo dược này cần thiết để cứu chữa cho một người quan trọng.\n\n" + "Goblin lắng nghe và gật đầu chậm rãi, đôi mắt nó ánh lên sự cảm thông. 'Tôi hiểu,' nó nói khẽ, rồi từ từ rời đi mà không oán trách.");
            gameScreen.playerHPTextView.setText("HP: " + gameScreen.player.playerHp + "/" + gameScreen.player.playerMaxHp);

            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            kingGoblin();
            gameScreen.monster.elderGoblin();
            gameScreen.gameImageView.setImageResource(R.drawable.goblinelder);
            gameScreen.story.nextPosition = "kingGoblinDrop";
            gameScreen.gameTextView.setText("Bạn quyết định không giúp goblin, từ chối chia sẻ thảo dược. Với ánh mắt đầy phẫn nộ, goblin chiến binh rít lên: 'Ngươi sẽ hối hận vì điều này!'\n\n" + "Hắn rút vũ khí ra, lao tới với ý định cướp lấy thảo dược bằng vũ lực. Trận chiến nảy lửa sắp bắt đầu, và bạn siết chặt tay chuẩn bị đối đầu với kẻ thù thù địch.");
        }
        gameScreen.story.savePosition = "noHelpGoblin";
    }

    public void kingGoblin(){
        gameScreen.story.nextPosition = "kingGoblinDrop";
        gameScreen.monster.kingGoblin();
        gameScreen.gameImageView.setImageResource(R.drawable.goblinking);
        if (boneDart > 0){
            gameScreen.gameTextView.setText("Goblin nhìn bạn với vẻ căm hận, tiếng gầm gừ đầy giận dữ vang vọng khắp khu rừng. Bạn cảm nhận rõ ràng rằng cuộc đối đầu này là không thể tránh khỏi, và chỉ có một trong hai người rời khỏi nơi đây còn sống.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.story.showAllButton();

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Dùng phi tiêu xương (x"+boneDart+")");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack1";
            gameScreen.story.nextPosition2 = "boneDart";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        else {
            gameScreen.monster.kingGoblin();
            gameScreen.gameTextView.setText("Goblin nhìn bạn với vẻ căm hận, tiếng gầm gừ đầy giận dữ vang vọng khắp khu rừng. Bạn cảm nhận rõ ràng rằng cuộc đối đầu này là không thể tránh khỏi, và chỉ có một trong hai người rời khỏi nơi đây còn sống.");
            gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

            gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

            gameScreen.story.showAllButton();

            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack1";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        gameScreen.story.savePosition = "kingGoblin";
    }

    public void kingGoblinDrop(){
        gameScreen.gameImageView.setImageResource(R.drawable.roundshield);
        gameScreen.gameTextView.setText("Sau khi hạ gục kẻ thù, bạn giật lấy chiếc khiên kiên cố từ tay hắn. Lớp kim loại sứt mẻ nhưng vẫn toát lên vẻ vững chắc, như đã từng cản phá vô số đòn tấn công. Giờ đây, nó sẽ trở thành lá chắn bảo vệ bạn trước những hiểm nguy phía trước");
        gameScreen.playerHPTextView.setText("HP: " + gameScreen.player.playerHp + "/" + gameScreen.player.playerMaxHp);

        gameScreen.player.shield = true;

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);

        gameScreen.story.savePosition = "kingGoblinDrop";
    }

    public void boneDart(){
        gameScreen.battle.boneDart();
        if(gameScreen.player.playerHp <=0){
            gameScreen.button1.setText("Bạn đã bị đánh bại!!!");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "dead";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
            gameScreen.story.savePosition = "deadBoneDart";
        }
        else if (gameScreen.monster.monsterHP <=0) {
            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = gameScreen.story.nextPosition;
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
            gameScreen.player.playerExpGain();
            gameScreen.player.dropHealingPotion();
            gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch! Hắn ngã xuống, và chiến thắng là của bạn.\n\nBạn nhận được một bình máu, giúp hồi phục sức khỏe và chuẩn bị cho những thử thách tiếp theo.");
            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");
            gameScreen.story.savePosition = "winBoneDart";
        }
        else {
            if(boneDart > 0){
                gameScreen.button1.setText("Tấn công");
                gameScreen.button2.setText("Dùng phi tiêu xương (x"+boneDart+")");
                gameScreen.button3.setText("");

                gameScreen.story.nextPosition1 = "attack1";
                gameScreen.story.nextPosition2 = "boneDart";
                gameScreen.story.nextPosition3 = "";

                gameScreen.button3.setVisibility(View.INVISIBLE);
            }else {
                gameScreen.button1.setText("Tấn công");
                gameScreen.button2.setText("");
                gameScreen.button3.setText("");

                gameScreen.story.nextPosition1 = "attack1";
                gameScreen.story.nextPosition2 = "";
                gameScreen.story.nextPosition3 = "";

                gameScreen.button2.setVisibility(View.INVISIBLE);
                gameScreen.button3.setVisibility(View.INVISIBLE);
            }
            gameScreen.story.savePosition = "waitBoneDart";
        }

    }
    public void winBoneDart(){
        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = gameScreen.story.nextPosition;
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);

        gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch! Hắn ngã xuống, và chiến thắng là của bạn.\n\nBạn nhận được một bình máu, giúp hồi phục sức khỏe và chuẩn bị cho những thử thách tiếp theo.");
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
        gameScreen.story.savePosition = "winBoneDart";
    }

    public void deadBoneDart(){
        gameScreen.button1.setText("Bạn đã bị đánh bại!!!");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "dead";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }

    public void waitBoneDart(){
        if(boneDart > 0){
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Dùng phi tiêu xương (x"+boneDart+")");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack1";
            gameScreen.story.nextPosition2 = "boneDart";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }else {
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack1";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        gameScreen.story.savePosition = "waitBoneDart";
    }
    public void attack1(){
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
            gameScreen.story.savePosition = "deadAttack1";
        }
        else if (gameScreen.monster.monsterHP <=0) {

            gameScreen.button1.setText(">");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = gameScreen.story.nextPosition;
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
            gameScreen.player.playerExpGain();

            gameScreen.player.dropHealingPotion();
            gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch! Hắn ngã xuống, và chiến thắng là của bạn.\n\nBạn nhận được một bình máu, giúp hồi phục sức khỏe và chuẩn bị cho những thử thách tiếp theo.");

            gameScreen.monsterAttackTextView.setText("");
            gameScreen.monsterHPTextView.setText("");

            gameScreen.story.savePosition = "winAttack1";
        }
        else {
            if(boneDart > 0){
                gameScreen.button1.setText("Tấn công");
                gameScreen.button2.setText("Dùng phi tiêu xương (x"+boneDart+")");
                gameScreen.button3.setText("");

                gameScreen.story.nextPosition1 = "attack1";
                gameScreen.story.nextPosition2 = "boneDart";
                gameScreen.story.nextPosition3 = "";

                gameScreen.button3.setVisibility(View.INVISIBLE);
            }else {
                gameScreen.button1.setText("Tấn công");
                gameScreen.button2.setText("");
                gameScreen.button3.setText("");

                gameScreen.story.nextPosition1 = "attack1";
                gameScreen.story.nextPosition2 = "";
                gameScreen.story.nextPosition3 = "";

                gameScreen.button2.setVisibility(View.INVISIBLE);
                gameScreen.button3.setVisibility(View.INVISIBLE);
            }
            gameScreen.story.savePosition = "waitAttack1";
        }

    }

    public void deadAttack1(){

        gameScreen.button1.setText("Bạn đã bị đánh bại!!!");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "dead";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.story.savePosition = "deadAttack1";
    }

    public void winAttack1(){

        gameScreen.button1.setText(">");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = gameScreen.story.nextPosition;
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);

        gameScreen.gameTextView.setText("Bạn đã thành công đánh bại kẻ địch! Hắn ngã xuống, và chiến thắng là của bạn.\n\nBạn nhận được một bình máu, giúp hồi phục sức khỏe và chuẩn bị cho những thử thách tiếp theo.");

        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");

        gameScreen.story.savePosition = "winAttack1";
    }

    public void waitAttack1(){

        if(boneDart > 0){
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("Dùng phi tiêu xương (x"+boneDart+")");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack1";
            gameScreen.story.nextPosition2 = "boneDart";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }else {
            gameScreen.button1.setText("Tấn công");
            gameScreen.button2.setText("");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "attack1";
            gameScreen.story.nextPosition2 = "";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button2.setVisibility(View.INVISIBLE);
            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        gameScreen.story.savePosition = "waitAttack1";
    }

}
