package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yugentechlabs.harrypotterworld.Models.Level;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.QuestionSets;
import static java.lang.Thread.sleep;

public class WizardingQuiz extends AppCompatActivity {
    ProgressDialog progress;
    public static int currentLevel;
    FirebaseFirestore db;
    QuestionSets questionSets;
    TextView level,question,one,two,three,four,questionNumber;
    int quesNum;
    Level cLevel;
    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizarding_quiz);

        quesNum=0;
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        showLoading();

        cLevel= (Level) getIntent().getSerializableExtra("level");

        db = FirebaseFirestore.getInstance();

        level=findViewById(R.id.level);
        question=findViewById(R.id.question);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three_image);
        four=findViewById(R.id.four_image);
        questionNumber=findViewById(R.id.question_number);
        backButton=findViewById(R.id.back_btn);

        String l="Level "+cLevel.getLevelnum();
        level.setText(l);

        questionSets = new QuestionSets(cLevel.getLevel());
        showQuestion(questionSets.getQuesRandomized(quesNum));


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

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

        currentLevel=cLevel.getLevelnum();
        if(questionSets.isCorrect(answerSelected) && quesNum<10){

            showQuestion(questionSets.getQuesRandomized(quesNum));
        }
        else if(!questionSets.isCorrect(answerSelected))
        {
            WizardingQuizScoreCardFailed scoreCard=new WizardingQuizScoreCardFailed();
            scoreCard.show(getSupportFragmentManager(),"Your Score");
        }
        else{
            WizardingQuizScoreCardPassed scoreCard=new WizardingQuizScoreCardPassed();
            scoreCard.show(getSupportFragmentManager(),"Your Score");


        }
    }

    private void showQuestion(String[] ques) {
        questionNumber.setText(("Question "+ (quesNum + 1)));
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
                    sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progress.dismiss();
            }
        }).start();
    }

    @Override
    public void onBackPressed() {
        ExitWizardingQuiz e=new ExitWizardingQuiz();
        e.show(getSupportFragmentManager(),"Exit");
    }
}