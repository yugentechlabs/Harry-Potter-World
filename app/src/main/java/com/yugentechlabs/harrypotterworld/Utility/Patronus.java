package com.yugentechlabs.harrypotterworld.Utility;

import com.yugentechlabs.harrypotterworld.R;

import java.util.Random;

public class Patronus {

    String[] patronusQues,patronus;
    int[] drawables;

    public Patronus(){
        patronusQues= new String[]{"Pick a season", "Summer", "Autumn", "Winter", "Pick a weapon", "Sword", "Spear", "Bow & Arrow", "What is your natural instinct?", "Escape", "Save", "Lead", "What is your biggest fear?", "Betrayal", "Failure", "Change", "Pick a place", "Forest", "Sea", "Mountains"};
        drawables= new int[]{R.drawable.stag, R.drawable.polarbear, R.drawable.lion, R.drawable.wolf, R.drawable.panther, R.drawable.elephant, R.drawable.otter, R.drawable.sparrow, R.drawable.fox, R.drawable.squirrel, R.drawable.goat, R.drawable.snake, R.drawable.horse, R.drawable.hare, R.drawable.cat, R.drawable.shark};
        patronus= new String[]{"Stag", "Polar Bear", "Lion", "Wolf", "Panther", "Elephant", "Otter", "Sparrow", "Fox", "Squirrel", " Goat", "Snake", "Horse", "Hare", "Cat", "Shark"};
        }



        public String[] getQuestionByIndex(int i){
        String[] ques=new String[4];
        ques[0]=patronusQues[i*4];
        ques[1]=patronusQues[(i*4)+1];
        ques[2]=patronusQues[(i*4)+2];
        ques[3]=patronusQues[(i*4)+3];
        return ques;
        }

        public int getRandomPatronus()
        {
        Random random = new Random();
            return random.nextInt(16);
        }

    public String getPatronusText(int i)
    {
        return patronus[i];
    }
    public int getPatronusImage(int i)
    {
        return drawables[i];
    }
    }

