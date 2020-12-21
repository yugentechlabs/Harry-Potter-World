package com.yugentechlabs.harrypotterworld.Activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.yugentechlabs.harrypotterworld.R;
import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    ImageView background,logo;
    TextView gamename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getViews();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        Animation anim= AnimationUtils.loadAnimation(this,R.anim.splash);
        logo.setAnimation(anim);
        gamename.setAnimation(anim);

        background.animate().alpha((float) 0.3).setDuration(4500);

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startActivity(new Intent(SplashScreen.this,LoginSignup.class));
            }
        }).start();
    }


    private void getViews() {
        background=findViewById(R.id.back);
        logo=findViewById(R.id.logo);
        gamename=findViewById(R.id.gamename);
    }
}