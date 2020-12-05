package com.yugentechlabs.harrypotterworld.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yugentechlabs.harrypotterworld.Models.Level;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.QuestionSets;

public class WizardingQuiz extends AppCompatActivity {

    String levelNumber;
    FirebaseFirestore db;
    QuestionSets questionSets;
    TextView level,question,one,two,three,four,questionNumber;
    int quesNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizarding_quiz);

        quesNum=0;


        levelNumber=getIntent().getStringExtra("levelNumber");

        db = FirebaseFirestore.getInstance();

        level=findViewById(R.id.level);
        question=findViewById(R.id.question);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        questionNumber=findViewById(R.id.question_number);

        level.setText("Level "+levelNumber);
        getLevelfromDB();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(one.getText().toString());
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(two.getText().toString());
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(three.getText().toString());
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(four.getText().toString());
            }
        });


    }

    private void next(String answerSelected) {

        //if answer wrong show dialog box
        //if end of question arrived show another dialog

        if(questionSets.isCorrect(answerSelected) && quesNum<10){
            //answer box color change

            showQuestion(questionSets.getQuesRandomized(quesNum));
        }
        else
        {
            WizardingQuiz.super.onBackPressed();
        }
    }


    private void getLevelfromDB() {

        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait...");
        progressDialog.show();

        DocumentReference docRef = db.collection("WizardingQuizLevels").document(levelNumber);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                progressDialog.dismiss();
                try {
                    Level level = documentSnapshot.toObject(Level.class);
                    questionSets = new QuestionSets(level.getLevel());
                    showQuestion(questionSets.getQuesRandomized(quesNum));
                }
                catch (Exception e){
                    Toast.makeText(WizardingQuiz.this, "Unable to fetch level.", Toast.LENGTH_SHORT).show();
                    WizardingQuiz.super.onBackPressed();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                WizardingQuiz.super.onBackPressed();
                Toast.makeText(WizardingQuiz.this, "Unable to fetch level.", Toast.LENGTH_SHORT).show();
            }
        });

    }



    private void showQuestion(String[] ques) {
        questionNumber.setText(("Question "+String.valueOf(quesNum+1)));
        question.setText(ques[0]);
        one.setText(ques[1]);
        two.setText(ques[2]);
        three.setText(ques[3]);
        four.setText(ques[4]);
        quesNum++;
    }

}