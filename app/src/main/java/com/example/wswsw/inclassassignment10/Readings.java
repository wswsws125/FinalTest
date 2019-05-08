package com.example.wswsw.inclassassignment10;

import java.util.ArrayList;

public class Readings {
    private int readingText;
    private ArrayList<Questions> questionList = new ArrayList<Questions>();

    public  Readings(){

    }

    public Readings(int readingText, ArrayList<Questions> questionList){
        this.readingText=readingText;
        this.questionList=questionList;
    }
}
