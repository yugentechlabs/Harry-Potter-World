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

public class ExitWizardingQuiz extends AppCompatDialogFragment {
    TextView yes, no;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.exit_dialog, null);
        builder.setView(view);

        TextView t=view.findViewById(R.id.exit_text);
        t.setText("Are you sure you want to exit the quiz?");

        TextView yes = view.findViewById(R.id.yes);
        TextView no = view.findViewById(R.id.no);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),QuizLevels.class));
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

            }
        });

        return builder.create();
    }
}