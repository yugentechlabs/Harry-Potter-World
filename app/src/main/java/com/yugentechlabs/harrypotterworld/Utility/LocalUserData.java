package com.yugentechlabs.harrypotterworld.Utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.yugentechlabs.harrypotterworld.Activities.MainActivity;
import com.yugentechlabs.harrypotterworld.R;

public class LocalUserData {

    private static final String TAG ="Hello" ;
    SharedPreferences sharedPreferences;
    FirebaseFirestore db;
    Context context;
    ProgressDialog progress;

    public LocalUserData(Context c){
        //default
        sharedPreferences = c.getSharedPreferences("com.yugentechlabs.harrypotterworld", Context.MODE_PRIVATE);
        db = FirebaseFirestore.getInstance();
        context=c;

    }

    public LocalUserData(Context c,String email, String house, String wand, String patronus, String character, String levelnumber,String nickname) {
        sharedPreferences = c.getSharedPreferences("com.yugentechlabs.harrypotterworld", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("email",email).apply();
        sharedPreferences.edit().putString("house",house).apply();
        sharedPreferences.edit().putString("wand",wand).apply();
        sharedPreferences.edit().putString("patronus",patronus).apply();
        sharedPreferences.edit().putString("character",character).apply();
        sharedPreferences.edit().putString("levelnumber",levelnumber).apply();
        sharedPreferences.edit().putString("nickname",nickname).apply();
        db = FirebaseFirestore.getInstance();
        context=c;
    }

    public String getEmail(){
        String email=sharedPreferences.getString("email","");
        return email;
    }


    public String getHouse(){
        String house=sharedPreferences.getString("house","");
        return house;
    }

    public String getWand(){
        String wand=sharedPreferences.getString("wand","");
        return wand;
    }


    public String getPatronus(){
        String patronus=sharedPreferences.getString("patronus","");
        return patronus;
    }

    public String getCharacter(){
        String character=sharedPreferences.getString("character","");
        return character;
    }


    public String getLevelNumber(){
        String levelNumber=sharedPreferences.getString("levelnumber","");
        return levelNumber;
    }

    public String getNickname(){
        String nickname=sharedPreferences.getString("nickname","");
        return nickname;
    }

    public void putEmail(String email){
        sharedPreferences.edit().putString("email",email).apply();

    }

    public void putWand(String wand){


        progress=new ProgressDialog(context);
        progress.setTitle("Please Wait...");
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("wand", wand)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progress.dismiss();
                        sharedPreferences.edit().putString("wand",wand).apply();
                        //Toast.makeText(context, "Wand successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                       Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putPatronus(String patronus){


        DocumentReference doc = db.collection("User").document(getEmail());

        progress=new ProgressDialog(context);
        progress.setTitle("Please Wait...");
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        doc.update("patronus", patronus)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progress.dismiss();
                        sharedPreferences.edit().putString("patronus",patronus).apply();
                        //Toast.makeText(context, "Patronus successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });


    }

    public void putCharacter(String character){

        DocumentReference doc = db.collection("User").document(getEmail());

        progress=new ProgressDialog(context);
        progress.setTitle("Please Wait...");
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        doc.update("character", character)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progress.dismiss();
                        sharedPreferences.edit().putString("character",character).apply();
                        //Toast.makeText(context, "Character successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putHouse(String house){


        DocumentReference doc = db.collection("User").document(getEmail());

        progress=new ProgressDialog(context);
        progress.setTitle("Please Wait...");
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        doc.update("house", house)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progress.dismiss();
                        sharedPreferences.edit().putString("house",house).apply();
                       // Toast.makeText(context, "House successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putLevelNumber(String levelNumber){
        DocumentReference doc = db.collection("User").document(getEmail());

        progress=new ProgressDialog(context);
        progress.setTitle("Please Wait...");
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);


        doc.update("levelnumber", levelNumber)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        sharedPreferences.edit().putString("levelnumber",levelNumber).apply();
                        progress.dismiss();
                        //Toast.makeText(context, "Level successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putNickname(String nickname){
        DocumentReference doc = db.collection("User").document(getEmail());

        progress=new ProgressDialog(context);
        progress.setTitle("Please Wait...");
        progress.setCancelable(false);
        progress.show();
        progress.setContentView(R.layout.loading_dialog);
        progress.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        doc.update("nickname", nickname)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progress.dismiss();
                        sharedPreferences.edit().putString("nickname",nickname).apply();
                        //Toast.makeText(context, "Nickname successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progress.dismiss();
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
