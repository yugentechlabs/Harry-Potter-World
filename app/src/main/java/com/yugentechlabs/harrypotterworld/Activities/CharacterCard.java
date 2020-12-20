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
import com.yugentechlabs.harrypotterworld.Utility.Character;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;
import com.yugentechlabs.harrypotterworld.Utility.Wand;

public class CharacterCard extends AppCompatDialogFragment {

    TextView mainMenu;
    ImageView characterImage;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.character_card, null);
       setCancelable(false);

        super.onCreate(savedInstanceState);


        builder.setView(view);


        mainMenu = view.findViewById(R.id.main_btn);
        characterImage = view.findViewById(R.id.char_image);




        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });

        showCharacter();

        return builder.create();
    }


    private void showCharacter() {
        Character c=new Character();
        String s=c.getCharacter();
       characterImage.setImageResource(c.getCharacterImage());

        LocalUserData l=new LocalUserData(getContext());
        l.putCharacter(s);

    }

}
