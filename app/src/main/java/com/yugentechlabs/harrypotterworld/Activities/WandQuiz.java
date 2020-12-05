package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quesNum++;
                if(quesNum>1){
                    showQuesOption();
                }
                else{
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
                    Wand wand=new Wand();
                    String s=wand.getWand();
                    Toast.makeText(WandQuiz.this, s, Toast.LENGTH_SHORT).show();
                    LocalUserData l=new LocalUserData(WandQuiz.this);
                    l.putWand(s);
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
                    Wand wand=new Wand();
                    String s=wand.getWand();
                    Toast.makeText(WandQuiz.this, s, Toast.LENGTH_SHORT).show();
                    LocalUserData l=new LocalUserData(WandQuiz.this);
                    l.putWand(s);
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
                    Wand wand=new Wand();
                    String s=wand.getWand();
                    Toast.makeText(WandQuiz.this, s, Toast.LENGTH_SHORT).show();
                    LocalUserData l=new LocalUserData(WandQuiz.this);
                    l.putWand(s);
                }
            }
        });

        showQues();
    }

    private void showQuesOption() {
        submit.setVisibility(View.INVISIBLE);
        wandText.setVisibility(View.INVISIBLE);
        if(quesNum==2){
            one.setVisibility(View.VISIBLE);
            two.setVisibility(View.VISIBLE);
            question.setText("Are you left-handed or right-handed?");
            one.setText("Left-handed");
            two.setText("Right-handed");
        }
        else if(quesNum==3){
            three.setVisibility(View.VISIBLE);
            question.setText("What would your blood status be?");
            one.setText("Muggle");
            two.setText("Hald blood");
            three.setText("Full blood");
        }
        else {
            question.setText("Who do you think is the greatest wizard?");
            one.setText("Albus Dumbledore");
            two.setText("Gellert Grindelwald");
            three.setText("Lord Voldemort");
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
        three=findViewById(R.id.three);
        wandText=findViewById(R.id.wand_text);
        submit=findViewById(R.id.submit);
    }
}