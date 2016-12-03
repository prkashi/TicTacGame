package com.example.punithrkashi.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    Boolean state  = true;

    public void draw (View view) {
/*Test*/

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());


        if (gameState[tappedCounter] == 2 && state == true) {

            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.one);
                activePlayer = 1;
                gameState[tappedCounter] = 0;

            } else {

                counter.setImageResource(R.drawable.cross);
                activePlayer = 0;
                gameState[tappedCounter] = 1;

            }
            counter.animate().translationYBy(1000f).setDuration(300);
        }

    for(int[] winningPosition:winningPositions){

        if(gameState[winningPosition[0]]==gameState[winningPosition[1]]
            && gameState[winningPosition[1]] == gameState[winningPosition[2]]
            && gameState[winningPosition[0]] != 2){

            Toast.makeText(this,"Player " + gameState[winningPosition[0]] + " Won", Toast.LENGTH_LONG).show();
            state = false;
        }

    }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
