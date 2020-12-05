package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class MainActivity extends AppCompatActivity {

    ImageView hpQuiz,wandQuiz,patronusQuiz,charQuiz,sortingQuiz;
    TextView nickname,of;
    ImageView signout,banner,houseBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();

        putBanner();

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,LoginSignup.class));
            }
        });


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



    private void putBanner() {

        nickname.setTextColor(ContextCompat.getColor(this, R.color.white));
        of.setTextColor(ContextCompat.getColor(this, R.color.white));

        nickname.setVisibility(View.VISIBLE);
        of.setVisibility(View.VISIBLE);
        banner.setVisibility(View.VISIBLE);
        houseBanner.setVisibility(View.VISIBLE);

        LocalUserData l=new LocalUserData(this);
        String s=l.getHouse();


        if(s.equals("Griffindor")){
            nickname.setText(l.getNickname());
            banner.setImageResource(R.drawable.griffindor_banner);
            houseBanner.setImageResource(R.drawable.gryffindor);
        }
        else if(s.equals("Ravenclaw")){
            nickname.setText(l.getNickname());
            banner.setImageResource(R.drawable.ravenclaw_banner);
            houseBanner.setImageResource(R.drawable.ravenclaw);
        }
        else if(s.equals("Hufflepuff")){
            nickname.setTextColor(ContextCompat.getColor(this, R.color.text_dark));
            of.setTextColor(ContextCompat.getColor(this, R.color.text_dark));
            nickname.setText(l.getNickname());
            banner.setImageResource(R.drawable.hufflepuff_banner);
            houseBanner.setImageResource(R.drawable.hufflepuff);
        }
        else if(s.equals("Slytherin")){
            nickname.setText(l.getNickname());
            banner.setImageResource(R.drawable.slytherin_banner);
            houseBanner.setImageResource(R.drawable.slytherin);
        }
        else{
            nickname.setVisibility(View.INVISIBLE);
            of.setVisibility(View.INVISIBLE);
            banner.setVisibility(View.INVISIBLE);
            houseBanner.setVisibility(View.INVISIBLE);
        }
    }

    private void getViews() {
        patronusQuiz=findViewById(R.id.patronusquizimage);
        hpQuiz=findViewById(R.id.hpquizimage);
        charQuiz=findViewById(R.id.charquizimage);
        sortingQuiz=findViewById(R.id.sortquizimage);
        wandQuiz=findViewById(R.id.wandquizimage);
        signout=findViewById(R.id.settings_btn);
        banner=findViewById(R.id.banner);
        houseBanner=findViewById(R.id.housebanner);
        nickname=findViewById(R.id.username);
        of=findViewById(R.id.of);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}