package com.yugentechlabs.harrypotterworld.Activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

import static android.content.Context.VIBRATOR_SERVICE;

public class WizardingQuizScoreCardPassed extends AppCompatDialogFragment {

    TextView mainMenu, nextLevel;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.scorecard_passed,null);
        builder.setCancelable(false);

        super.onCreate(savedInstanceState);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                startActivity(new Intent(getContext(),QuizLevels.class));
            }
        });


        mainMenu=view.findViewById(R.id.mainmenu);
        nextLevel=view.findViewById(R.id.nextlevel);


        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MainActivity.class));
            }
        });

        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),QuizLevels.class));
            }
        });


        LocalUserData l=new LocalUserData(getContext());
        if(Integer.parseInt(l.getLevelNumber())==WizardingQuiz.currentLevel){
            int x=WizardingQuiz.currentLevel+1;
            l.putLevelNumber(String.valueOf(x));
        }
        builder.setView(view);
        return builder.create();
    }

}
