package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.Character;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;
import com.yugentechlabs.harrypotterworld.Utility.Patronus;

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
            one.setText(ques[1]);
            two.setText(ques[2]);
            three.setText(ques[3]);
            four.setText(ques[4]);
            quesNum++;

        }

        private void next() {
            if(quesNum<10)
                showQues();
            else {
                LocalUserData l=new LocalUserData(this);
                String s=character.getCharacter(l.getHouse());
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                l.putCharacter(s);

                // super.onBackPressed();
            }
        }


        private void getViews() {
            question=findViewById(R.id.question);
            one=findViewById(R.id.one);
            two=findViewById(R.id.two);
            three=findViewById(R.id.three);
            four=findViewById(R.id.four);
        }

    }
