package com.yugentechlabs.harrypotterworld.Utility;

import java.util.Random;

public class Patronus {

    String[] patronusQues,patronus;


    public Patronus(){
        patronusQues= new String[]{"Pick a season", "Summer", "Autumn", "Winter", "Pick a weapon", "Sword", "Spear", "Bow & Arrow", "What is your natural instinct?", "Escape", "Save", "Lead", "What is your biggest fear?", "Betrayal", "Failure", "Change", "Pick a place", "Forest", "Sea", "Mountains"};
        patronus=new String[]{"Swan","Phoenix","Goat","Stag","Otter","Hare","Cat","Doe","Snowy Owl","Wolf","Fox","Horse","Blackbird","Snake","Dragon","Eagle","Lion","Ocra","Shark","Polar Bear"};
        }



        public String[] getQuestionByIndex(int i){
        String[] ques=new String[4];
        ques[0]=patronusQues[i*4];
        ques[1]=patronusQues[(i*4)+1];
        ques[2]=patronusQues[(i*4)+2];
        ques[3]=patronusQues[(i*4)+3];
        return ques;
        }

        public String getPatronus()
        {
        Random random = new Random();
        int position = random.nextInt(20);
        return patronus[position];
        }
    }

