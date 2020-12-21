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

public class HouseCard extends AppCompatDialogFragment {

    TextView mainMenu,houseText;
    ImageView houseImage;
    String house;

    public static final String gry="You belong in Gryffindor, where dwell the brave at heart, their daring nerve and chivalry set Gryffindors apart.";
    public static final String rav="You belong in Ravenclaw, if you have a ready mind, where those of wit and learning will always find their kind.";
    public static final String sly="You belong in Slytherin, where you'll find your real friends, those cunning folks use any means to achieve their ends.";
    public static final String huf="You belong in Hufflepuff, where they are just and loyal, those special Hufflepuffs are true and unafraid of toil.";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialog);

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.sorting_end_card,null);
       setCancelable(false);

        super.onCreate(savedInstanceState);

        builder.setView(view);


        mainMenu=view.findViewById(R.id.mainmenu);
        houseImage=view.findViewById(R.id.house_name);
        houseText=view.findViewById(R.id.house_text);

        house=SortingQuiz.house;

        LocalUserData l=new LocalUserData(getContext());
        l.putHouse(house);

        showHouseImageText();



        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),MainActivity.class));
            }
        });




        return builder.create();
    }



    private void showHouseImageText() {

        if(house.equals("Gryffindor")){
            houseText.setText(gry);
            houseImage.setImageResource(R.drawable.gryffindor);

        }
        else if(house.equals("Ravenclaw")){
            houseText.setText(rav);
            houseImage.setImageResource(R.drawable.ravenclaw);
        }
        else if(house.equals("Hufflepuff")){
            houseText.setText(huf);
            houseImage.setImageResource(R.drawable.hufflepuff);
        }
        else{
            houseText.setText(sly);
            houseImage.setImageResource(R.drawable.slytherin);
        }
    }
}
