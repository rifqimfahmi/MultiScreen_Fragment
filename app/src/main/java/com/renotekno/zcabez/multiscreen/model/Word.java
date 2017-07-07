package com.renotekno.zcabez.multiscreen.model;

/**
 * Created by zcabez on 30/06/2017.
 */
public class Word {
    public static final int NO_IMAGE = -1;

    private String english;
    private String miwok;
    private int pronunciationRes;
    private int imageRes = NO_IMAGE;

    public Word(String english, String miwok, int pronunciationRes){
        this.english = english;
        this.miwok = miwok;
        this.pronunciationRes = pronunciationRes;
    }

    public Word(String english, String miwok, int imageRes, int pronunciationRes){
        this.english = english;
        this.miwok = miwok;
        this.imageRes = imageRes;
        this.pronunciationRes = pronunciationRes;
    }

    public String getEnglish() {
        return english;
    }

    public String getMiwok() {
        return miwok;
    }

    public int getImageRes(){ return imageRes; }

    public int getPronunciationRes(){ return pronunciationRes; }

    public boolean hasImage(){
        return imageRes != NO_IMAGE;
    }
}
