package com.example.jd.myapplication1;



        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.graphics.Color;
        import java.util.Random;

public class MainActivity12 extends AppCompatActivity {
        int sum=0,com_win=0,user_win=0;

        TextView com_tv,result_tv,user_tv,win;
        ImageButton scissors_ib ,stone_ib ,cloths_ib;
        ImageView com_iv;
        Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        scissors_ib = (ImageButton) findViewById(R.id.scissors_ib);
        stone_ib = (ImageButton) findViewById(R.id.stone_ib);
        cloths_ib = (ImageButton) findViewById(R.id.cloth_ib);
        reset = (Button)findViewById(R.id.reset);


        scissors_ib.setOnClickListener(clickinhere);
        stone_ib.setOnClickListener(clickinhere);
        cloths_ib.setOnClickListener(clickinhere);
        reset.setOnClickListener(clickinhere);

    }

    private View.OnClickListener clickinhere = new View.OnClickListener() {

        public void onClick(View v) {
            Random ran = new Random();
            Integer com_num,user_num=0;
            com_num = ran.nextInt(3)-1;
            com_tv = (TextView)findViewById(R.id.com_tv);
            com_iv = (ImageView)findViewById(R.id.imageView);
            switch (com_num){
                case -1 :
                    com_tv.setText("AI出拳:剪刀");
                    com_iv.setBackgroundColor(Color.BLUE);
                    break;
                case 0 :
                    com_tv.setText("AI出拳:石頭");
                    com_iv.setBackgroundColor(Color.RED);
                    break;
                case 1 :
                    com_tv.setText("AI出拳:布");
                    com_iv.setBackgroundColor(Color.GREEN);
                    break;
            }
            user_tv = (TextView)findViewById(R.id.user_tv);
            if(v.getId() == scissors_ib.getId()){
                user_num = -1;
                user_tv.setText("玩家出拳:剪刀");
            }
            else if(v.getId() == stone_ib.getId()){
                user_num = 0;
                user_tv.setText("玩家出拳:石頭");
            }
            else if (v.getId() == cloths_ib.getId()){
                user_num = 1;
                user_tv.setText("玩家出拳:布");
            }
            sum++;
            result_tv = (TextView)findViewById(R.id.result_tv);
            if (user_num == com_num){
                result_tv.setText("-平手-");
            }
            else if (user_num == (com_num)*-1){
                if(user_num < com_num)
                {
                    result_tv.setText("~玩家勝利~");
                    user_win++;
                }
                else {
                    result_tv.setText("=AI勝利=");
                    com_win++;
                }
            }
            else if (user_num > com_num){
                result_tv.setText("~~玩家勝利~~");
                user_win++;
            }
            else {
                result_tv.setText("=AI勝利=");
                com_win++;
            }
            win = (TextView)findViewById(R.id.win);
            win.setText("玩家勝率" + user_win*100/sum + "%/AI勝率" + com_win*100/sum + "%");
            if(v.getId() == reset.getId()){
                com_tv.setText("AI出拳");
                com_iv.setBackgroundColor(Color.WHITE);
                user_tv.setText("玩家出拳");
                result_tv.setText("結果");
                sum=0;user_win=0;com_win=0;
                win.setText("玩家勝率" + "%/AI勝率" + "%");
            }

        }
    };





}
