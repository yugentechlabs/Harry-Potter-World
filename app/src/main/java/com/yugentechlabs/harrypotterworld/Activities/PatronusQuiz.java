package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        one.setText(ques[1]);
        two.setText(ques[2]);
        three.setText(ques[3]);
        quesNum++;

    }

    private void next() {
        if(quesNum<5)
            showQues();
        else {
            String s=patronus.getPatronus();
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            LocalUserData l=new LocalUserData(this);
            l.putPatronus(s);

           // super.onBackPressed();
        }
    }


    private void getViews() {
        question=findViewById(R.id.question);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
    }
}