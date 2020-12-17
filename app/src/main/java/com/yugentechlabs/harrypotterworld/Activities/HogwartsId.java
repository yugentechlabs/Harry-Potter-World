package com.yugentechlabs.harrypotterworld.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;

import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;

public class HogwartsId extends AppCompatDialogFragment {

    TextView patronus,wand,name,character;
    LinearLayout card;
    View view;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        view=inflater.inflate(R.layout.hogwarts_id,null);

        super.onCreate(savedInstanceState);


        builder.setView(view);


        name=view.findViewById(R.id.name);
        character=view.findViewById(R.id.character);
        wand=view.findViewById(R.id.wand);
        patronus=view.findViewById(R.id.patronus);
        card=view.findViewById(R.id.card);

        change();


        return builder.create();
    }

    private void change() {

        LocalUserData l=new LocalUserData(getContext());
        String nameL=l.getNickname();
        String houseL=l.getHouse();
        String wandL=l.getWand();
        String patronusL=l.getPatronus();
        String characterL=l.getCharacter();

        changeHouse(houseL);

        name.setText(nameL);

        if(!wandL.equals(""))
        {
            wand.setText(wandL);
        }
        if(!characterL.equals(""))
        {
            character.setText(characterL);
        }
        if(!patronusL.equals(""))
        {
            patronus.setText(patronusL);
        }

    }

    private void changeHouse(String house) {
        if(house.equals("Gryffindor"))
        {
            card.setBackgroundResource(R.drawable.id_card_gryffindor);
        }
        else if(house.equals("Hufflepuff"))
        {
            card.setBackgroundResource(R.drawable.id_card_hufflepuff);
        }
        else if(house.equals("Slytherin"))
        {
            card.setBackgroundResource(R.drawable.id_card_slytherin);
        }
        else
        {
            card.setBackgroundResource(R.drawable.id_card_ravenclaw);
        }
    }

}