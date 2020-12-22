package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.Patronus;

import static java.lang.Thread.sleep;

public class PatronusQuiz extends AppCompatActivity {

    TextView question,one,two,three;
    Patronus patronus;
    int quesNum;
    ProgressDialog progress;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patronus_quiz);

        getViews();
        quesNum=0;


        patronus=new Patronus();
        showLoading();


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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
        backButton=findViewById(R.id.back_btn);

    }

    void showLoading(){
        progress=new ProgressDialog(this);
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progress.dismiss();
            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        ExitQuiz e=new ExitQuiz();
        e.show(getSupportFragmentManager(),"Exit");
    }
}