package com.yugentechlabs.harrypotterworld.Utility;

import java.util.ArrayList;
import java.util.Random;

public class QuestionSets {

    ArrayList<String> questionSet;
    String[] ques;
    String correct;

    public QuestionSets(ArrayList<String> questionSet) {
        this.questionSet= new ArrayList<String>();
        this.questionSet=(ArrayList<String>)questionSet.clone();
    }

    public void getQuestionByIndex(int i){
        ques=new String[5];
        ques[0]=questionSet.get((i*5));
        ques[1]=questionSet.get(((i*5)+1));
        ques[2]=questionSet.get(((i*5)+2));
        ques[3]=questionSet.get(((i*5)+3));
        ques[4]=questionSet.get(((i*5)+4));
    }

    public String[] getQuesRandomized(int i)
    {
        getQuestionByIndex(i);
        correct=ques[4];
        String temp;
        Random r=new Random();
        int position=r.nextInt(4)+1;
        if(position==4){
            return ques;
        }
        else{
            temp=ques[position];
            ques[position]=ques[4];
            ques[4]=temp;
        }
        return ques;
    }


    public boolean isCorrect(String s){
        return s.equals(correct);
    }




}
