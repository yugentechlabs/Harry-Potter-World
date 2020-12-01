package com.yugentechlabs.harrypotterworld.Models;

public class User {

    public User(){
        //just needed
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public String getWand() {
        return wand;
    }

    public void setWand(String wand) {
        this.wand = wand;
    }

    public String getLevelnumber() {
        return levelnumber;
    }

    public void setLevelnumber(String levelnumber) {
        this.levelnumber = levelnumber;
    }

    public User(String email, String heart, String nickname, String character, String coins, String house, String patronus, String wand, String levelnumber) {
        this.email = email;
        this.heart = heart;
        this.nickname = nickname;
        this.character = character;
        this.coins = coins;
        this.house = house;
        this.patronus = patronus;
        this.wand = wand;
        this.levelnumber = levelnumber;
    }

    String email,heart,nickname,character,coins,house,patronus,wand,levelnumber;
}
