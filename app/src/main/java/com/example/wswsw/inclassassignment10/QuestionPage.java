package com.example.wswsw.inclassassignment10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuestionPage extends AppCompatActivity {

    RadioGroup radioGroupQ1;
    RadioGroup radioGroupQ2;
    RadioGroup radioGroupQ3;
    Button submitButton;

    String selectedAnsQ1 = "";
    String selectedAnsQ2 = "";
    String selectedAnsQ3 = "";

    private int QuestionIndex = 0;

    private int score=0;
    boolean[] correctOrNot = new boolean[10];

    private Questions[] mQuestionBank1 = new Questions[]{
            new Questions(R.string.read1_q1_question,R.string.read1_question1_A,R.string.read1_question1_B,R.string.read1_question1_C,R.string.read1_question1_D,R.string.read1_question1_rightAnswer,R.string.read1_question1_type),
       new Questions(R.string.read1_q2_question,R.string.read1_question2_A,R.string.read1_question2_B,R.string.read1_question2_C,R.string.read1_question2_D,R.string.read1_question2_rightAnswer,R.string.read1_question2_type),
       new Questions(R.string.read1_q3_question,R.string.read1_question3_A,R.string.read1_question3_B,R.string.read1_question3_C,R.string.read1_question3_D,R.string.read1_question3_rightAnswer,R.string.read1_question3_type),
//totally 10 questions of one reading passage in one list
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=0;
                checkAnswerOne();
                Bundle b = new Bundle();
                b.putBooleanArray(Keys.EXTRA_CORRECT_RESULT, correctOrNot);

                Intent intent = new Intent(getBaseContext(), ResultPage.class);
//                intent.putExtra(Keys.EXTRA_QUESTIONLIST, mQuestionBank1);
                intent.putExtra(Keys.EXTRA_SCORE, score);
                intent.putExtra(Keys.EXTRA_CORRECT_RESULT, correctOrNot);
                startActivity(intent);
            }
        });

        setTitle("Reading Page");
        loadReading();


    }


    public void loadReading(){



        //put the questionList and reading text in one Readings obj

        //add the readings in one readingList
//        ArrayList<Readings> readingList=new ArrayList<Readings>();
//        readingList.add(reading1);

        //todo:draw a random reading, match number 1 2 with question objs


    }

    public void showTheReading(Readings r){
        //todo: put parameters in one reading object into Views in xml, using a for loop

    }

    public void checkAnswer(){

        //todo:check if user's answer==true answer
        radioGroupQ1 = (RadioGroup) findViewById(R.id.q1_radioGroup);
        radioGroupQ1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.q1_radioButtonA) {
                    selectedAnsQ1 = "A";
                } else if (checkedId == R.id.q1_radioButtonB) {
                    selectedAnsQ1 = "B";
                }else if(checkedId == R.id.q1_radioButtonC) {
                    selectedAnsQ1 = "C";
                }else{
                    selectedAnsQ1 = "D";
                }

            }
        });
    }

    private void checkAnswerOne(){
        if (((RadioButton)findViewById(R.id.q1_radioButtonD)).isChecked()) {
            score++;
            correctOrNot[0]=true;}
        if (((RadioButton)findViewById(R.id.q2_radioButtonB)).isChecked()) {
            score++;
            correctOrNot[1]=true;}
        if (((RadioButton)findViewById(R.id.q3_radioButtonA)).isChecked()) {
            score++;
            correctOrNot[2]=true;}



    }




}
