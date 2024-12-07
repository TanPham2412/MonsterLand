package com.example.monsterland;

import android.view.View;

public class StoryTenebris {
    GameScreen gameScreen;

    public boolean tenebris = false, repayGoblin = false, goblinCurse = false, wolfTrap = false;
    int bonedart = 0;
    public StoryTenebris(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public void tenebris(){
        gameScreen.gameImageView.setImageResource(R.drawable.jungle);
        gameScreen.gameTextView.setText("Bạn bước vào Rừng Tenebris, nơi tiếng gió rít lên như những tiếng thở của ma quái, và bóng tối dày đặc che lấp con đường phía trước. Mảnh vỡ đầu tiên của lời nguyền được cho là nằm sâu trong lòng rừng, nơi những sinh vật kỳ dị sinh sống và bảo vệ nó bằng mọi giá.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.story.showAllButton();

        if(!gameScreen.storyArgentis.argentis){
            gameScreen.button1.setText("Tiếp tục đi");
            gameScreen.button2.setText("Quay lại");
            gameScreen.button3.setText("");

            if(gameScreen.storyCastle.knightDead){
                gameScreen.story.nextPosition1 = "toVillage";
                gameScreen.story.nextPosition2 = "woodenSign";
            }
            else {
                gameScreen.story.nextPosition1 = "meetGoblin";
                gameScreen.story.nextPosition2 = "woodenSign1";
            }
            gameScreen.story.nextPosition3 = "";
            gameScreen.button3.setVisibility(View.INVISIBLE);
        } else {
            gameScreen.button1.setText("Tiếp tục đi");
            gameScreen.button2.setText("Quay lại");
            gameScreen.button3.setText("");

            gameScreen.story.nextPosition1 = "toVillage";
            gameScreen.story.nextPosition2 = "woodenSign";
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }

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
    }

    public void meetGoblin(){
        gameScreen.gameImageView.setImageResource(R.drawable.goblin);
        gameScreen.gameTextView.setText("Sau khi chạy trốn khỏi tên hiệp sĩ, bạn lạc vào sâu trong rừng, bỏ lỡ tuyến đường của Mira. Mệt mỏi và đói khát, bạn loay hoay giữa những cây cổ thụ thì bất ngờ, một đứa trẻ tộc goblin xuất hiện, cầm miếng thịt trên tay. Vẻ mặt nó hiếu kỳ nhưng cũng đầy cảnh giác. Cơn đói khiến bạn chú ý đến miếng thịt, nhưng goblin không phải là tộc dễ đoán. Bạn sẽ làm gì?");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.story.showAllButton();

        gameScreen.button1.setText("Tiến lại gần và xin miếng thịt");
        gameScreen.button2.setText("Cướp lấy miếng thịt");
        gameScreen.button3.setText("Rời khỏi đó mà không làm gì");

        gameScreen.story.nextPosition1 = "pleaseMeat";
        gameScreen.story.nextPosition2 = "meatRobbery";
        gameScreen.story.nextPosition3 = "leave";

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
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
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
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
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
    }

    public void noRepay(){
        repay();
        repayGoblin = false;
        gameScreen.gameTextView.setText("Sau khi goblin cho bạn miếng thịt, bạn nhận lấy và ăn một cách cẩn thận, cảm nhận sức lực dần hồi phục. Goblin chỉ lặng lẽ quan sát, không nói lời nào. Bạn cảm ơn nó, không hứa hẹn gì, chỉ đơn giản là biết rằng sự giúp đỡ này đã đủ trong lúc cần thiết. Sau khi ăn xong, bạn đứng dậy, cảm thấy bớt mệt mỏi hơn, rồi tiếp tục hành trình của mình.");
    }

    public void killedGoblin(){
        gameScreen.monsterHPTextView.setText("");
        gameScreen.monsterAttackTextView.setText("");
        leave();
        gameScreen.gameTextView.setText("Sau khi tiêu diệt goblin con, hơi thở cuối cùng của nó ám lấy bạn, cảm giác lạnh lẽo lan tỏa khắp cơ thể. Một lời nguyền mơ hồ như đang bám riết lấy bạn, khiến bạn không thể nào thoát khỏi. Bạn biết rằng những kẻ đồng loại của nó sẽ không để yên, và sự trả thù đang đến gần. Cảm giác đó như một bóng đen bám theo, đe dọa cuộc hành trình phía trước của bạn.");
        goblinCurse = true;
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
            gameScreen.story.nextPosition3 = "";
            gameScreen.button3.setVisibility(View.INVISIBLE);
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
            gameScreen.story.nextPosition3 = "";

            gameScreen.button3.setVisibility(View.INVISIBLE);
        }
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
    }

    public void attackWolf(){
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
    }

    public void killedWolf(){
        gameScreen.monsterAttackTextView.setText("");
        gameScreen.monsterHPTextView.setText("");
        distract();
        gameScreen.gameTextView.setText("Bạn đã thành công tiêu diệt con sói. Với cái xác của nó, bạn nhanh chóng chế tạo những chiếc phi tiêu bằng xương sắc bén. Đồng thời, bạn thu thập các thảo dược quý hiếm để chữa trị cho người chiến binh, hy vọng rằng hành động này sẽ giúp anh ta hồi phục và cung cấp thông tin quan trọng về vị trí của bọn orc.");
        bonedart = 5;
    }


    public void retreat(){
        woundedSoldier();
        gameScreen.gameTextView.setText("Sau khi quay lại làng và tìm kiếm phương án khác, bạn đối mặt với một lựa chọn quan trọng: Liệu bạn sẽ kêu gọi sự giúp đỡ từ dân làng hay trực tiếp đối đầu với nguy hiểm, tìm đến hang ổ của bọn orc? Hay quay lại đối mặt với con sói và chiến đấu?");
    }

    public void distract(){
        gameScreen.gameImageView.setImageResource(R.drawable.herbsbundle);
        gameScreen.gameTextView.setText("Với sự thông minh của mình, bạn quyết định đánh lạc hướng con sói. Sử dụng bẫy mà dân làng đưa cho, bạn khéo léo dẫn dụ con sói vào vị trí bẫy. Chỉ trong giây lát, con sói bị mắc kẹt, không kịp phản ứng. Bạn nhanh chóng thu thập thảo dược quý hiếm mà không hề bị thương, cảm giác thành công dâng trào khi bạn hoàn thành nhiệm vụ mà không gặp nguy hiểm.");
        gameScreen.playerHPTextView.setText("HP: "+gameScreen.player.playerHp+ "/"+gameScreen.player.playerMaxHp);

        gameScreen.healingPotionTextView.setText("x"+gameScreen.player.healingPotion);

        gameScreen.button1.setText("Quay lại làng");
        gameScreen.button2.setText("") ;
        gameScreen.button3.setText("");

        gameScreen.story.nextPosition1 = "";
        gameScreen.story.nextPosition2 = "";
        gameScreen.story.nextPosition3 = "";

        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
    }
}
