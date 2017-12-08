package com.example.santanyuszi.golfcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends AppCompatActivity {

    Animation animScaleUp;
    Animation animScaleDown;
    Animation animReset;
    int playerOneStroke = 0;
    int playerTwoStroke = 0;

    public void displayForPlayerOne(int score){
        TextView scoreView = (TextView) findViewById(R.id.player_one_stroke);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForPlayerTwo(int score){
        TextView scoreView = (TextView) findViewById(R.id.player_two_stroke);
        scoreView.setText(String.valueOf(score));
    }


    TextView firstPlayerScore = null;
    TextView secondPlayerScore = null;
    Button resetScoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animScaleUp = AnimationUtils.loadAnimation(this,
                R.anim.anim_scale);
        animScaleDown = AnimationUtils.loadAnimation(this,
                R.anim.anim_scale_down);
        animReset = AnimationUtils.loadAnimation(this,
                R.anim.anim_reset);



        firstPlayerScore = (TextView) findViewById(R.id.player_one_stroke);
        secondPlayerScore = (TextView) findViewById(R.id.player_two_stroke);
        resetScoreButton = (Button) findViewById(R.id.end_session);

        firstPlayerScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerOneStroke = playerOneStroke + 1;
                displayForPlayerOne(playerOneStroke);
                firstPlayerScore.startAnimation(animScaleUp);
            }
        });

        secondPlayerScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerTwoStroke = playerTwoStroke + 1;
                displayForPlayerTwo(playerTwoStroke);
                secondPlayerScore.startAnimation(animScaleUp);
            }
        });

        firstPlayerScore.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (playerOneStroke >= 1)
                playerOneStroke = playerOneStroke - 1;
                displayForPlayerOne(playerOneStroke);
                firstPlayerScore.startAnimation(animScaleDown);
                return true;
            }
        });

        secondPlayerScore.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (playerTwoStroke >= 1)
                playerTwoStroke = playerTwoStroke - 1;
                displayForPlayerTwo(playerTwoStroke);
                secondPlayerScore.startAnimation(animScaleDown);
                return true;
            }
        });

        resetScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerOneStroke = 0;
                playerTwoStroke = 0;
                displayForPlayerOne(playerOneStroke);
                displayForPlayerTwo(playerTwoStroke);
                firstPlayerScore.startAnimation(animReset);
                secondPlayerScore.startAnimation(animReset);
            }
        });

    }
}
