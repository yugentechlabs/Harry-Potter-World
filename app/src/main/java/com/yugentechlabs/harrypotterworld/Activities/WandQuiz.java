package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yugentechlabs.harrypotterworld.R;

import static java.lang.Thread.sleep;

public class WandQuiz extends AppCompatActivity {
    ProgressDialog progress;
    int quesNum;
    ImageView submit,backButton;
    TextView question,one,two,three,wandText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wand_quiz);

        quesNum=0;
        getViews();

        showLoading();

        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(wandText);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(submit);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesNum++;
                if(quesNum>1){
                    showQuesOption();
                }
                else{
                    YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
                    YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(wandText);
                    YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(submit);
                    showQues();
                }
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesNum++;
                if(quesNum<5){
                    showQuesOption();
                }
                else{
                    WandCard wandCard=new WandCard();
                    wandCard.show(getSupportFragmentManager(),"Wand");
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesNum++;
                if(quesNum<5){
                    showQuesOption();
                }
                else{
                    WandCard wandCard=new WandCard();
                    wandCard.show(getSupportFragmentManager(),"Wand");
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesNum++;
                if(quesNum<5){
                    showQuesOption();
                }
                else{
                    WandCard wandCard=new WandCard();
                    wandCard.show(getSupportFragmentManager(),"Wand");
                }
            }
        });

        showQues();
    }

    private void showQuesOption() {
        submit.setVisibility(View.INVISIBLE);
        wandText.setVisibility(View.INVISIBLE);
        if(quesNum==2){
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.VISIBLE);
            question.setText("Are you left-handed or right-handed?");
            YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
            one.setText("Left-handed");
            YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(one);
            two.setText("Right-handed");
            YoYo.with(Techniques.FadeInRight).duration(700).repeat(0).playOn(two);
        }
        else if(quesNum==3){
            three.setVisibility(View.VISIBLE);
            question.setText("What would your blood status be?");
            YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
            one.setText("Muggle");
            YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(one);
            two.setText("Hald blood");
            YoYo.with(Techniques.FadeInRight).duration(700).repeat(0).playOn(two);
            three.setText("Full blood");
            YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(three);
        }
        else {
            question.setText("Who do you think is the greatest wizard?");
            YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
            one.setText("Albus Dumbledore");
            YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(one);
            two.setText("Gellert Grindelwald");
            YoYo.with(Techniques.FadeInRight).duration(700).repeat(0).playOn(two);
            three.setText("Lord Voldemort");
            YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(three);
        }
    }









    private void showQues() {
        if(quesNum==0) {
            question.setText("What is your height?");

        }
        else{
            wandText.setText("");
            question.setText("What is the color of your eye?");
        }
    }


    private void getViews() {
        question=findViewById(R.id.question);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three_image);
        wandText=findViewById(R.id.wand_text);
        submit=findViewById(R.id.submit);
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