package com.yugentechlabs.harrypotterworld.Utility;

import com.yugentechlabs.harrypotterworld.R;

import java.util.Random;

public class Character {

    String[] characterQues, characters;
    int[] charImages;
    int i;


public Character(){
        characterQues= new String[]{"Which object do you most desire?","Elder Wand","Philosopher’s Stone","Mirror of Erised", "Cloak of Invisibility","Where would you like to hangout?","Three Broomsticks","Borgin and Burkes","Weasleys’ Wizard Wheezes","Shrieking Shack","Pick a potion","Polyjuice Potion","Draught of Peace","Amortentia (Love Potion)","Felix Felicis (Liquid Luck)","Pick a magical creature","Phoenix","Centaur","Basilisk","Hippogriff","What was your childhood like?","Lonely and difficult","Overall positive with a loving family","Relatively quiet and focussed","Had a huge family, so it was chaotic","What’s your greatest strength?","Sense of humour","Perseverence","Loyalty","Humbleness","Pick a drink","Butterbeer","Bubblebrew","Fishy Green Ale","Gillywater","Pick a spell","Expecto Patronum","Expelliarmus","Lumos","Riddikulus","Pick a teacher","Gilderoy Lockhart","Remus Lupin","Sybill Trelawney","Horace Slughorn","Pick a subject","Defense Against the Dark Arts","Transfiguration","Charms","Potions"};
        characters=new String[]{"Albus Dumbledore","Rubeus Hagrid","Minerva McGonagall","Molly Weasley","Arthur Weasley","Sirius Black","Lily Potter","Remus Lupin","Peter Pettigrew","James Potter","Bill Weasley","Charles Weasley","Percy Weasley","Oliver Wood","Angelina Johnson","Lee Jordan","Fred Weasley","George Weasley","Katie Bell","Cormac McLaggen","Hermione Granger","Harry Potter","Dean Thomas","Ron Weasley","Lavender Brown","Neville Longbottom","Colin Creevey","Ginny Weasley","Horace Slughorn","Tom Riddle","Alecto Carrow","Amycus Carrow","Andromeda Tonks","Lucius Malfoy","Narcissa Black","Severus Snape","Draco Malfoy","Pansy Parkinson","Dolores Umbridge","Newt Scamander","Pomona Sprout","Nymphadora Tonks","Cedric Diggory","Hannah Abbott","Susan Bones","Filius Flitwick","Xenophilius Lovegood","Sybill Trelawney","Quirinus Quirrell","Gilderoy Lockhart","Cho Chang","Luna Lovegood"};
        charImages=new int[]{R.drawable.dumbledore_c,R.drawable.hagrid_c,R.drawable.minerva_c,R.drawable.molly_weasley,R.drawable.arthur_weasley_c,R.drawable.sirius_black_c,R.drawable.lily_potter,R.drawable.remus_lupin_c,R.drawable.peter_pettigrew,R.drawable.james_potter,R.drawable.bill_weasley,R.drawable.charles_weasley,R.drawable.percy_weasley,R.drawable.oliver_wood,R.drawable.angelina_johnson,R.drawable.lee_jordan,R.drawable.fred_weasley,R.drawable.george_weasley,R.drawable.katie_bell,R.drawable.cormac,R.drawable.hermione_granger_c,R.drawable.harry_potter_c,R.drawable.dean_thomas,R.drawable.ron_c,R.drawable.lavender_brown,R.drawable.neville_c,R.drawable.collin_creevey,R.drawable.ginny_weasley,R.drawable.horace_slughorn,R.drawable.tom_riddle,R.drawable.carrow_one,R.drawable.carrow_two,R.drawable.andromeda_tonks,R.drawable.lucius_malfoy,R.drawable.narcissa_malfoy,R.drawable.snape_c,R.drawable.draco_malfoy,R.drawable.pansy_parkinson,R.drawable.dolores_umbridge,R.drawable.newt_scamander,R.drawable.sprout_c,R.drawable.tonks,R.drawable.cedric_c,R.drawable.hanah_abbot,R.drawable.susan_bones,R.drawable.flitwick_c,R.drawable.xenophilius_lovegoof,R.drawable.trelawney,R.drawable.quirrell_c,R.drawable.gilderoy_lockhart_c,R.drawable.cho_chang,R.drawable.luna_lovegood};
    }



    public String[] getQuestionByIndex(int i){
        String[] ques=new String[5];
        ques[0]=characterQues[i*5];
        ques[1]=characterQues[(i*5)+1];
        ques[2]=characterQues[(i*5)+2];
        ques[3]=characterQues[(i*5)+3];
        ques[4]=characterQues[(i*5)+4];
        return ques;
    }

    public String getCharacter()
    {
        Random random = new Random();
        i=random.nextInt(52);
        return characters[i];
    }

    public int getCharacterImage(){
    return charImages[i];
    }

    public boolean checkSize(){
        return charImages.length == characters.length;
    }
}


