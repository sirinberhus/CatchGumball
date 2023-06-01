package com.sirin.catchgumball;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    ImageView imageView;
    Button button;
    Button button2;

    Handler handler;
    Runnable runnable;

    int number;
    int score_1;
    float horizantal_x;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


    }

    public void start(View view){
        textView2.setText("Score: " + score_1);
        number = 0;
        handler = new Handler();
        runnable = new Runnable(){
            @Override
            public void run() {
                textView.setText("Time:" +number);
                number++;
                textView.setText("Time: "+ number);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.horizontalBias = new Random().nextFloat();
                layoutParams.verticalBias = new Random().nextFloat();
                imageView.setLayoutParams(layoutParams);
                imageView.setLayoutParams(layoutParams);
                handler.postDelayed(runnable,1000);
            }


        };
        handler.post(runnable);
        button.setEnabled(false);
    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        number = 0;
        score_1 = 0;
    }

    public void score(View view){
        if (number != 0){
            score_1++;
            textView2.setText("Score: " + score_1 );
        }
    }

}