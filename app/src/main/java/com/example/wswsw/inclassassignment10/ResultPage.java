package com.example.wswsw.inclassassignment10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    private TextView scoreTextview;
    private TextView mistakesTextview;
    private TextView quoteTextview;


    Button backButton;
    boolean[] correctResult;
    int scoreResult;
    int mistakeNum=0;
    String quoteForStudent="";
    String mistakeType="";

    private Questions[] questionList = new Questions[]{
            new Questions(R.string.read1_q1_question,R.string.read1_question1_A,R.string.read1_question1_B,R.string.read1_question1_C,R.string.read1_question1_D,R.string.read1_question1_rightAnswer,R.string.read1_question1_type),
            new Questions(R.string.read1_q2_question,R.string.read1_question2_A,R.string.read1_question2_B,R.string.read1_question2_C,R.string.read1_question2_D,R.string.read1_question2_rightAnswer,R.string.read1_question2_type),
            new Questions(R.string.read1_q3_question,R.string.read1_question3_A,R.string.read1_question3_B,R.string.read1_question3_C,R.string.read1_question3_D,R.string.read1_question3_rightAnswer,R.string.read1_question3_type),
//totally 10 questions of one reading passage in one list
    };

    String mistakeReport=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);

        //receive data
        int scoreResult= getIntent().getIntExtra(Keys.EXTRA_SCORE,0);
        Bundle b = this.getIntent().getExtras();
        correctResult=b.getBooleanArray(Keys.EXTRA_CORRECT_RESULT);
//        questionList= (Questions[]) getIntent().getSerializableExtra(Keys.EXTRA_QUESTIONLIST);


        //show the score
        scoreTextview = (TextView)findViewById(R.id.score_textview);
        scoreTextview.setText(scoreResult+"/"+questionList.length);

        mistakesTextview = (TextView)findViewById(R.id.mistakes_textview);
        getMistakes(correctResult,questionList);
        mistakesTextview.setText(mistakeReport);

        quoteTextview = (TextView)findViewById(R.id.quote_textview);
        quoteForStudent=getQuoteForStudent(mistakeNum,questionList);
        quoteTextview.setText(quoteForStudent);




        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultPage.this,ReadingApp.class));

            }
        });




    }
    public void getMistakes(boolean[] correctResult,Questions[] questionList){
        //get index of false [i] in correctOrNot array,
        //show mQuestionBank[i]+rightanswer+type
        for(int i = 0; i< questionList.length; i++){

            if (correctResult[i]==false){
                mistakeNum+=1;
                mistakeType+=" "+getString(questionList[i].getType())+" ";

                mistakeReport+=getString(questionList[i].getQuestionText())
                +"\n"+getString(questionList[i].getAnswerA())
                        +"\n"+getString(questionList[i].getAnswerB())
                        +"\n"+getString(questionList[i].getAnswerC())
                        +"\n"+getString(questionList[i].getAnswerD())
                        +"\n\nThe right answer is: "+getString(questionList[i].getRightAnswer())
                +"\nThe type of this question is: "+getString(questionList[i].getType())+
                        "\n=================================\n";

            }

        }
    }

    public String getQuoteForStudent(int mistakeNum,Questions[] questionList){
        quoteForStudent="Practice"+mistakeType+" \n";
        if(mistakeNum==0){
            quoteForStudent+=getString(R.string.encourage_excellent);
        }else if(mistakeNum>=questionList.length*0.66){
            quoteForStudent+=getString(R.string.encourage_bad);
        }else{quoteForStudent+=getString(R.string.encourage_good);
        }

        return quoteForStudent;
    }

    public String correctArrayToString(boolean[] correctResult){
        String allResult="";
        for(int i=0;i<correctResult.length;i++){
             allResult=correctResult[i]+" ";
        }
        return allResult;
    }


}
