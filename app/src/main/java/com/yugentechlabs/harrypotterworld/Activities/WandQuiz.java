package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;
import com.yugentechlabs.harrypotterworld.Utility.Wand;

public class WandQuiz extends AppCompatActivity {

    int quesNum;
    ImageView submit;
    TextView question,one,two,three,wandText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wand_quiz);

        quesNum=0;
        getViews();

        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(wandText);
        YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(submit);

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
//Hide:

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
    }
}