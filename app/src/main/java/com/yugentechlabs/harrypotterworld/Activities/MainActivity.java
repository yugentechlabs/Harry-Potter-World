package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class MainActivity extends AppCompatActivity {

    ImageView hpQuiz,wandQuiz,patronusQuiz,charQuiz,sortingQuiz;
    TextView nickname,of;
    ImageView settings,banner,houseBanner,wizardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();

        putBanner();
        showRateApp();


        Settings.MyDialogCloseListener closeListener = new Settings.MyDialogCloseListener() {
            @Override
            public void handleDialogClose(DialogInterface dialog) {
                LocalUserData l=new LocalUserData(MainActivity.this);
                nickname.setText(l.getNickname());
            }
        };


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Wobble).duration(400).repeat(0).playOn(settings);
                Settings s=new Settings();
                s.DismissListener(closeListener);
                s.show(getSupportFragmentManager(),"Settings");

            }
        });

        wizardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Wobble).duration(400).repeat(0).playOn(wizardButton);
                LocalUserData l=new LocalUserData(MainActivity.this);
                if(l.getHouse().equals("")){
                    Toast.makeText(MainActivity.this, "Play the Sorting Quiz to unlock your Hogwarts ID card!", Toast.LENGTH_SHORT).show();
                }else {
                    HogwartsId s = new HogwartsId();
                    s.show(getSupportFragmentManager(), "Hogwarts ID");
                }

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

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalUserData l=new LocalUserData(MainActivity.this);
                if(l.getHouse().equals("")){
                    Toast.makeText(MainActivity.this, "Play the Sorting Quiz to unlock your Hogwarts ID card!", Toast.LENGTH_SHORT).show();
                }else {
                    HogwartsId s = new HogwartsId();
                    s.show(getSupportFragmentManager(), "Hogwarts ID");
                }

            }
        });
    }

    private void showRateApp() {
        if(getIntent().getIntExtra("rate_app",0)==1){
            RateApp s=new RateApp();
            s.show(getSupportFragmentManager(),"RateApp");
        }
    }


    private void putBanner() {

        nickname.setTextColor(ContextCompat.getColor(this, R.color.white));
        of.setTextColor(ContextCompat.getColor(this, R.color.white));

        nickname.setVisibility(View.VISIBLE);
        of.setVisibility(View.VISIBLE);
        banner.setVisibility(View.VISIBLE);
        houseBanner.setVisibility(View.VISIBLE);

        LocalUserData l=new LocalUserData(this);
        nickname.setText(l.getNickname());
        String s=l.getHouse();


        if(s.equals("Gryffindor")){
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
        settings=findViewById(R.id.settings_btn);
        banner=findViewById(R.id.banner);
        houseBanner=findViewById(R.id.housebanner);
        nickname=findViewById(R.id.username);
        of=findViewById(R.id.of);
        wizardButton=findViewById(R.id.wizard_btn);
    }

    @Override
    public void onBackPressed() {
      ExitApp e=new ExitApp();
      e.show(getSupportFragmentManager(),"Exit");
    }

    @Override
    protected void onResume() {
        super.onResume();
        putBanner();
    }
}