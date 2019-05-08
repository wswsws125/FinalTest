package com.example.wswsw.inclassassignment10;

import java.io.Serializable;

public class Questions implements Serializable {

    private int questionText;
    private int answerA;
    private int answerB;
    private int answerC;
    private int answerD;
    private int rightAnswer;
    private int type;

    public Questions(){

    }


    public Questions(int type){
this.type=type;
    }

//    public Questions(int questionText, int rightAnswer, int photoId, boolean isTrue){
//        this.location = location;
//        this.question = question;
//        this.photoId = photoId;
//        this.isTrue = isTrue;
//    }

    public Questions(int questionText, int answerA, int answerB, int answerC, int answerD,int rightAnswer,int type){
        this.questionText=questionText;
        this.answerA=answerA;
        this.answerB=answerB;
        this.answerC=answerC;
        this.answerD=answerD;
        this.rightAnswer=rightAnswer;
        this.type=type;
    }

    public int getQuestionText(){
        return questionText;
    }


    public int getAnswerA(){
        return answerA;
    }

    public int getAnswerB(){
        return answerB;
    }

    public int getAnswerC(){
        return answerC;
    }

    public int getAnswerD(){
        return answerD;
    }

    public int getRightAnswer(){
        return rightAnswer;
    }

    public int getType(){
        return type;
    }
}
