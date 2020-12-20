package com.yugentechlabs.harrypotterworld.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;
import com.yugentechlabs.harrypotterworld.Utility.Patronus;
import com.yugentechlabs.harrypotterworld.Utility.Wand;

public class WandCard extends AppCompatDialogFragment {

    TextView mainMenu, wandText;
    ImageView wandImage;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.wand_card, null);
       setCancelable(false);

        super.onCreate(savedInstanceState);


        builder.setView(view);


        mainMenu = view.findViewById(R.id.mainmenu);
        wandImage = view.findViewById(R.id.wand_image);
         wandText= view.findViewById(R.id.wand_name);


        showPatronusImageText();


        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });


        return builder.create();
    }


    private void showPatronusImageText() {
        Wand wand=new Wand();
        String s=wand.getWand();
        LocalUserData l=new LocalUserData(getContext());
        l.putWand(s);
        wandText.setText(s);
        wandImage.setImageResource(wand.getWandImage());
    }
}
