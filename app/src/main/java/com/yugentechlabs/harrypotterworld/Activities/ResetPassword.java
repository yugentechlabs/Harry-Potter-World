package com.yugentechlabs.harrypotterworld.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.yugentechlabs.harrypotterworld.R;

public class ResetPassword extends AppCompatDialogFragment {
    private EditText email;
    TextView resetButton;
    ProgressDialog progress;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.forgot_password_dialog,null);
        builder.setView(view);


        email=view.findViewById(R.id.resetemail);
        resetButton=(TextView) view.findViewById(R.id.resetpass);



        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String emailAddress=email.getText().toString();
                progress=new ProgressDialog(getContext());
                progress.setTitle("Please Wait...");
                progress.setCancelable(false);
                progress.show();
                progress.setContentView(R.layout.loading_dialog);
                progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                auth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progress.dismiss();
                                if (task.isSuccessful()) {
                                    Toast.makeText(getContext(), "Check your email to reset your password.", Toast.LENGTH_SHORT).show();
                                    dismiss();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(getContext(), "Check your internet connection.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });






        return builder.create();
    }


}