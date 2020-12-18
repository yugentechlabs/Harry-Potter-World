package com.yugentechlabs.harrypotterworld.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class Settings extends AppCompatDialogFragment{

    TextView signout, privacy, help,yugen, changeNickname;
    View view;
    ProgressBar p;
    EditText name;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.settings,null);

        super.onCreate(savedInstanceState);

        builder.setView(view);

        getViews();

        getClickListeners();

        return builder.create();
    }


    private void getClickListeners() {
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(),LoginSignup.class));
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://anusha-bhattacharya.me/TRIVIZfiles/Privacy%20Policy.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        yugen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://play.google.com/store/apps/dev?id=7710899150179037614";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "yugentechlabs@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Harry Potter World - Help");
                getContext().startActivity(Intent.createChooser(emailIntent, null));
            }
        });

        changeNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=name.getText().toString();
                LocalUserData l=new LocalUserData(getContext());
                l.putNickname(s);
            }
        });
    }


    private void getViews() {
        signout=view.findViewById(R.id.signout);
        help=view.findViewById(R.id.help);
        privacy=view.findViewById(R.id.privacy);
        yugen=view.findViewById(R.id.yugen);
        changeNickname=view.findViewById(R.id.change_nickname);
        name=view.findViewById(R.id.name);
        p=view.findViewById(R.id.progressBar);
    }


}
