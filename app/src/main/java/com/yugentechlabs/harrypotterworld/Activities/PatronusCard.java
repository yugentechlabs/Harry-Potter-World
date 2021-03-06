package com.yugentechlabs.harrypotterworld.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.yugentechlabs.harrypotterworld.R;
import com.yugentechlabs.harrypotterworld.Utility.LocalUserData;
import com.yugentechlabs.harrypotterworld.Utility.Patronus;

public class PatronusCard extends AppCompatDialogFragment {

    TextView mainMenu,patronusText;
    ImageView patronusImage;


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.patronus_card,null);
       setCancelable(false);

        super.onCreate(savedInstanceState);


        builder.setView(view);


        mainMenu=view.findViewById(R.id.mainmenu);
        patronusImage=view.findViewById(R.id.patronus_image);
        patronusText=view.findViewById(R.id.patronus_name);



        showPatronusImageText();



        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MainActivity.class));
            }
        });




        return builder.create();
    }



    private void showPatronusImageText() {
        Patronus p=new Patronus();
        int i=p.getRandomPatronus();
        LocalUserData l=new LocalUserData(getContext());
        l.putPatronus(p.getPatronusText(i));
       patronusImage.setImageResource(p.getPatronusImage(i));
        patronusText.setText(p.getPatronusText(i));
    }
}