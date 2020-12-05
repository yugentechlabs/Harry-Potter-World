package com.yugentechlabs.harrypotterworld.Utility;

import java.util.Random;

public class Wand {
    public static final String[] wandWood={"Elder","Walnut","Blackthorn","Ash","Hawthorn","Rosewood","Cedar","Mahogany","Elm","Chestnut"};
    public static final String[] wandCore={"dragon heartstring","thestral tail hair","troll whisker","unicorn hair","phoenix feather"};
    public static final String[] wandLength={"8","9","10","12¾","10½","15","9½","11","8¾"};
    public static final String[] wandFlexibility={"stiff","reasonably springy","unyielding","pleasantly springy","inflexible","slightly bendy","fairly flexible"};

    public String getWand(){
        Random r=new Random();
        int i=r.nextInt(9);
        String s=wandLength[i]+" inch long, made of ";
        i=r.nextInt(10);
        s+=wandWood[i]+", with a core of ";
        i=r.nextInt(5);
        s+=wandCore[i]+" and is ";
        i=r.nextInt(7);
        s+=wandFlexibility[i]+".";
        return s;
    }

}
