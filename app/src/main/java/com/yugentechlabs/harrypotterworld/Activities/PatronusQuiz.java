package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;
import com.yugentechlabs.harrypotterworld.Utility.Patronus;

public class PatronusQuiz extends AppCompatActivity {

    TextView question,one,two,three;
    Patronus patronus;
    int quesNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patronus_quiz);

        getViews();
        quesNum=0;


        patronus=new Patronus();



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        showQues();
    }

    private void showQues() {
        String[] ques=patronus.getQuestionByIndex(quesNum);
        question.setText(ques[0]);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        one.setText(ques[1]);
        YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(one);
        two.setText(ques[2]);
        YoYo.with(Techniques.FadeInRight).duration(700).repeat(0).playOn(two);
        three.setText(ques[3]);
        YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(three);
        quesNum++;

    }

    private void next() {
        if(quesNum<5)
            showQues();
        else {

            PatronusCard patronusCard=new PatronusCard();
            patronusCard.show(getSupportFragmentManager(),"Patronus");

           // super.onBackPressed();
        }
    }


    private void getViews() {
        question=findViewById(R.id.question);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three_image);
    }
}