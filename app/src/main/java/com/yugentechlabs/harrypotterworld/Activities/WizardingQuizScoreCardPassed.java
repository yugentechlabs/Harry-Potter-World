package com.yugentechlabs.harrypotterworld.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class WizardingQuizScoreCardPassed extends AppCompatDialogFragment {

    TextView mainMenu, nextLevel,points;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.scorecard_passed,null);
        setCancelable(false);

        super.onCreate(savedInstanceState);


        mainMenu=view.findViewById(R.id.mainmenu);
        nextLevel=view.findViewById(R.id.nextlevel);
        points=view.findViewById(R.id.points);

        LocalUserData l=new LocalUserData(getContext());
        if(l.getHouse().equals("")){
            points.setText("10 points awarded!");
        }
        else{
            points.setText("10 points to "+l.getHouse()+" !");
        }




        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MainActivity.class));
            }
        });

        nextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuizLevels.class);
                intent.putExtra("levelnum",(WizardingQuiz.currentLevel+1));
                startActivity(intent);
            }
        });

        if(Integer.parseInt(l.getLevelNumber())==WizardingQuiz.currentLevel){
            int x=WizardingQuiz.currentLevel+1;
            l.putLevelNumber(String.valueOf(x));
        }
        builder.setView(view);
        return builder.create();
    }


}
