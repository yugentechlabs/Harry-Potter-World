package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.Character;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class CharacterQuiz extends AppCompatActivity {

        TextView question,one,two,three,four;
        Character character;
        int quesNum;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_character_quiz);

            getViews();
            quesNum=0;


            character=new Character();



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

            four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    next();
                }
            });

            showQues();
        }

        private void showQues() {
            String[] ques=character.getQuestionByIndex(quesNum);
            question.setText(ques[0]);
            YoYo.with(Techniques.FadeIn).duration(700).repeat(0).playOn(question);
            one.setText(ques[1]);
            YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(one);
            two.setText(ques[2]);
            YoYo.with(Techniques.FadeInRight).duration(700).repeat(0).playOn(two);
            three.setText(ques[3]);
            YoYo.with(Techniques.FadeInLeft).duration(700).repeat(0).playOn(three);
            four.setText(ques[4]);
            YoYo.with(Techniques.FadeInRight).duration(700).repeat(0).playOn(four);
            quesNum++;

        }

        private void next() {
            if(quesNum<10)
                showQues();
            else {
                CharacterCard c=new CharacterCard();
                c.show(getSupportFragmentManager(),"Character");

                // super.onBackPressed();
            }
        }


        private void getViews() {
            question=findViewById(R.id.question);

            one=findViewById(R.id.one);

            two=findViewById(R.id.two);

            three=findViewById(R.id.three_image);

            four=findViewById(R.id.four_image);

        }

    }
