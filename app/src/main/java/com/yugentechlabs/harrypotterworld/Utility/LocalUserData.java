package com.yugentechlabs.harrypotterworld.Utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class LocalUserData {

    private static final String TAG ="Hello" ;
    SharedPreferences sharedPreferences;
    FirebaseFirestore db;
    Context context;

    public LocalUserData(Context c){
        //default
        sharedPreferences = c.getSharedPreferences("com.yugentechlabs.harrypotterworld", Context.MODE_PRIVATE);
        db = FirebaseFirestore.getInstance();
        context=c;

    }

    public LocalUserData(Context c,String email, String house, String wand, String patronus, String character, String levelnumber,String nickname,String heart, String coins) {
        sharedPreferences = c.getSharedPreferences("com.yugentechlabs.harrypotterworld", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("email",email).apply();
        sharedPreferences.edit().putString("house",house).apply();
        sharedPreferences.edit().putString("wand",wand).apply();
        sharedPreferences.edit().putString("patronus",patronus).apply();
        sharedPreferences.edit().putString("character",character).apply();
        sharedPreferences.edit().putString("levelnumber",levelnumber).apply();
        sharedPreferences.edit().putString("nickname",nickname).apply();
        sharedPreferences.edit().putString("heart",heart).apply();
        sharedPreferences.edit().putString("coins",coins).apply();

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

    public String getHeart(){
        String heart=sharedPreferences.getString("heart","");
        return heart;
    }

    public String getCoins(){
        String coins=sharedPreferences.getString("coins","");
        return coins;
    }

    public void putEmail(String email){
        sharedPreferences.edit().putString("email",email).apply();

    }

    public void putWand(String wand){
        sharedPreferences.edit().putString("wand",wand).apply();

        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("wand", wand)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Wand successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putPatronus(String patronus){
        sharedPreferences.edit().putString("patronus",patronus).apply();
        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("patronus", patronus)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Patronus successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });


    }

    public void putCharacter(String character){
        sharedPreferences.edit().putString("character",character).apply();
        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("character", character)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Character successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putHouse(String house){
        sharedPreferences.edit().putString("house",house).apply();

        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("house", house)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "House successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putLevelNumber(String levelNumber){
        sharedPreferences.edit().putString("levelnumber",levelNumber).apply();

        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("levelnumber", levelNumber)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Level successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void putNickname(String nickname){
        sharedPreferences.edit().putString("nickname",nickname).apply();

        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("nickname", nickname)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Nickname successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void putHeart(String heart){
        sharedPreferences.edit().putString("heart",heart).apply();

        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("heart", heart)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Heart successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void putCoins(String coins){
        sharedPreferences.edit().putString("coins",coins).apply();

        DocumentReference doc = db.collection("User").document(getEmail());
        doc.update("coins", coins)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Coins successfully updated!", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Please check your network connection!", Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
