package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yugentechlabs.harrypotterworld.R;

public class MainActivity extends AppCompatActivity {

    ImageView hpQuiz,wandQuiz,patronusQuiz,charQuiz,sortingQuiz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        patronusQuiz=findViewById(R.id.patronusquizimage);
        hpQuiz=findViewById(R.id.hpquizimage);
        charQuiz=findViewById(R.id.charquizimage);
        sortingQuiz=findViewById(R.id.sortquizimage);
        wandQuiz=findViewById(R.id.wandquizimage);


        sortingQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SortingQuiz.class));
            }
        });


        charQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CharacterQuiz.class));
            }
        });

        hpQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,QuizLevels.class));
            }
        });

        TextView t=findViewById(R.id.gamename);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginSignup.class));
            }
        });


        wandQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WandQuiz.class));
            }
        });


        patronusQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PatronusQuiz.class));
            }
        });
    }



}