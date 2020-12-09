package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yugentechlabs.harrypotterworld.R;

public class SortingQuiz extends AppCompatActivity {

    ImageView black,white,oneImage,twoImage,threeImage,fourImage;
    TextView oneText,twoText,threeText,fourText;
    ConstraintLayout one,two,three,four;
    int griffindor, slytherin, hufflepuff, ravenclaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sorting_one_chess);

        griffindor=0;
        slytherin=0;
        ravenclaw=0;
        hufflepuff=0;

        One();
    }

    private void One() {
        black=findViewById(R.id.black);
        white=findViewById(R.id.white);

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(black.getTag().toString().equals("RS")){
                    ravenclaw++;
                    slytherin++;
                }
                else{
                    griffindor++;
                    hufflepuff++;
                }
                setContentView(R.layout.sorting_whose_class);
                Two();
            }
        });

        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(white.getTag().toString().equals("HG")){
                    griffindor++;
                    hufflepuff++;
                }
                else{
                    ravenclaw++;
                    slytherin++;
                }
                setContentView(R.layout.sorting_whose_class);
                Two();
            }
        });
    }

    private void Two() {
        oneImage=findViewById(R.id.one);
        twoImage=findViewById(R.id.two);
        threeImage=findViewById(R.id.three);
        fourImage=findViewById(R.id.four);

        oneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}