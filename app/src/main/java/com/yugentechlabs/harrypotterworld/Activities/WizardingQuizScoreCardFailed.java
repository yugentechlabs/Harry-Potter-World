package com.yugentechlabs.harrypotterworld.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.yugentechlabs.harrypotterworld.R;

public class WizardingQuizScoreCardFailed extends AppCompatDialogFragment {

    TextView continueBtn,mainMenu;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.scorecard_failed,null);
        builder.setCancelable(false);

        super.onCreate(savedInstanceState);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
               startActivity(new Intent(getContext(),QuizLevels.class));
            }
        });

        builder.setView(view);


        mainMenu=view.findViewById(R.id.main_menu);
        continueBtn=view.findViewById(R.id.continue_btn);


        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MainActivity.class));
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),QuizLevels.class));
            }
        });

        return builder.create();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        //startActivity(new Intent(getContext(),QuizLevels.class));
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        //startActivity(new Intent(getContext(),QuizLevels.class));
    }
}
