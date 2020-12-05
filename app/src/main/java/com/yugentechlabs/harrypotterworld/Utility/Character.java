package com.yugentechlabs.harrypotterworld.Utility;

import java.util.Random;

public class Character {

    String[] characterQues,charGryf,charSly,charHuff, charRave;



public Character(){
        characterQues= new String[]{"Which object do you most desire?","Elder Wand","Philosopher’s Stone","Mirror of Erised", "Cloak of Invisibility","Where would you like to hangout?","Three Broomsticks","Borgin and Burkes","Weasleys’ Wizard Wheezes","Shrieking Shack","Pick a potion","Polyjuice Potion","Draught of Peace","Amortentia (Love Potion)","Felix Felicis (Liquid Luck)","Pick a magical creature","Phoenix","Centaur","Basilisk","Hippogriff","What was your childhood like?","Lonely and difficult","Overall positive with a loving family","Relatively quiet and focussed","Had a huge family, so it was chaotic","What’s your greatest strength?","Sense of humour","Perseverence","Loyalty","Humbleness","Pick a drink","Butterbeer","Bubblebrew","Fishy Green Ale","Gillywater","Pick a spell","Expecto Patronum","Expelliarmus","Lumos","Riddikulus","Pick a teacher","Gilderoy Lockhart","Remus Lupin","Sybill Trelawney","Horace Slughorn","Pick a subject","Defense Against the Dark Arts","Transfiguration","Charms","Potions"};
        charGryf=new String[]{"Sir Cadogan","Fleamont Potter","Rowena Ravenclaw", "Albus Dumbledore","Rubeus Hagrid","Minerva McGonagall","Molly Weasley","Arthur Weasley","Sirius Black","Lily Evans","Remus Lupin","Peter Pettigrew","James Potter","Angelica Cole","Emily Tyler","William Weasley","Charles Weasley","Percy Weasley","Oliver Wood","Angelina Johnson","Lee Jordan","Alicia Spinnet","Fred Weasley","George Weasley","Katie Bell","Cormac McLaggen","Hermione Granger","Harry Potter","Dean Thomas","Ron Weasley","Lavender Brown","Seamus Finnigan","Neville Longbottom","Parvati Patil","Colin Creevey","Ginny Weasley","Romilda Vane","Dennis Creevey","James S. Potter","Rose Granger-Weasley","Lily L. Potter","Nearly Headless Nick","Godric Griffindor"};
        charSly=new String[]{"Salazar Slytherin","Bloody Baron","Merlin","Gormlaith Gaunt","Corvinus Gaunt","Phineas N. Black","Horace Slughorn","Tom Riddle","Alecto Carrow","Amycus Carrow","Andromeda Black","Rodolphus Lestrange","Lucius Malfoy","Narcissa Black","Severus Snape","Regulus Black","Draco Malfoy","Vincent Crabbe","Gregory Goyle","Pansy Parkinson","Albus Potter","Scorpius Malfoy","Dolores Umbridge"};
        charHuff=new String[]{"Newton Scamander","Pomona Sprout","Nymphadora Tonks","Cedric Diggory","Tamsin Applebee","Hannah Abbott","Susan Bones","Ernie Macmillan","Teddy Lupin","Owen Cauldwell"};
        charRave=new String[]{"Helena Ravenclaw","Filius Flitwick","Xenophilius Lovegood","Sybill Trelawney","Quirinus Quirrell","Gilderoy Lockhart","Penelope Clearwater","Cho Chang","Mandy Brocklehurst","Padma Patil","Luna Lovegood","Stewart Ackerley"};
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

    public String getCharacter(String house)
    {
        Random random = new Random();
        String s = "";
        if(house.equals("Griffindor")) {
            int position = random.nextInt(charGryf.length);
            s=charGryf[position];
        }
        else if(house.equals("Hufflepuff")) {
            int position = random.nextInt(charHuff.length);
            s=charHuff[position];
        }
        else if(house.equals("Slytherin")) {
            int position = random.nextInt(charSly.length);
            s=charSly[position];
        }
        else if(house.equals("Ravenclaw")) {
            int position = random.nextInt(charRave.length);
            s=charRave[position];
        }
        else{
            int houseNum = random.nextInt(4);
            if(houseNum==0){
                int position = random.nextInt(charGryf.length);
                s=charGryf[position];
            }
            else if(houseNum==1){
                int position = random.nextInt(charHuff.length);
                s=charHuff[position];
            }
            else if(houseNum==2){
                int position = random.nextInt(charRave.length);
                s=charRave[position];
            }
            else{
                int position = random.nextInt(charSly.length);
                s=charSly[position];
            }
        }
        return s;
    }
}
