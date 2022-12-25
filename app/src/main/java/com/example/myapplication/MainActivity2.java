package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.security.acl.Group;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    TextView Question1, Question2, Question3, Question4, Question5;
    RadioGroup Group1, Group2, Group3, Group4, Group5;
    RadioButton Answer1Q1, Answer2Q1, Answer3Q1, Answer4Q1,
            Answer1Q2, Answer2Q2, Answer3Q2, Answer4Q2,
            Answer1Q3, Answer2Q3, Answer3Q3, Answer4Q3,
            Answer1Q4, Answer2Q4, Answer3Q4, Answer4Q4,
            Answer1Q5, Answer2Q5, Answer3Q5, Answer4Q5;

    Button Submit, Next, Next1, Next2, Next3, Prev, Prev1, Prev2, Prev3;
    ScrollView ScrollView;

    int score = 0;
    int totalQuestions = 5;
    int QuestionIndex = 0;
    String selectedAnswer = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ScrollView = findViewById(R.id.ScrollView);
        textView = findViewById(R.id.textView);

        Question1 = findViewById(R.id.Question1);
        Question2 = findViewById(R.id.Question2);
        Question3 = findViewById(R.id.Question3);
        Question4 = findViewById(R.id.Question4);
        Question5 = findViewById(R.id.Question5);

        Group1 = findViewById(R.id.group1);
        Group2 = findViewById(R.id.group2);
        Group3 = findViewById(R.id.group3);
        Group4 = findViewById(R.id.group4);
        Group5 = findViewById(R.id.group5);

        Answer1Q1 = findViewById(R.id.ansq1a1);
        Answer2Q1 = findViewById(R.id.ansq1a2);
        Answer3Q1 = findViewById(R.id.ansq1a3);
        Answer4Q1 = findViewById(R.id.ansq1a4);

        Answer1Q2 = findViewById(R.id.ansq2a1);
        Answer2Q2 = findViewById(R.id.ansq2a2);
        Answer3Q2 = findViewById(R.id.ansq2a3);
        Answer4Q2 = findViewById(R.id.ansq2a4);

        Answer1Q3 = findViewById(R.id.ansq3a1);
        Answer2Q3 = findViewById(R.id.ansq3a2);
        Answer3Q3 = findViewById(R.id.ansq3a3);
        Answer4Q3 = findViewById(R.id.ansq3a4);

        Answer1Q4 = findViewById(R.id.ansq4a1);
        Answer2Q4 = findViewById(R.id.ansq4a2);
        Answer3Q4 = findViewById(R.id.ansq4a3);
        Answer4Q4 = findViewById(R.id.ansq4a4);

        Answer1Q5 = findViewById(R.id.ansq5a1);
        Answer2Q5 = findViewById(R.id.ansq5a2);
        Answer3Q5 = findViewById(R.id.ansq5a3);
        Answer4Q5 = findViewById(R.id.ansq5a4);

        Submit = findViewById(R.id.Submit);
        Next = findViewById(R.id.btnNext);
        Next1 = findViewById(R.id.btnNext1);
        Next2 = findViewById(R.id.btnNext2);
        Next3 = findViewById(R.id.btnNext3);
        Prev = findViewById(R.id.btnPrev);
        Prev1 = findViewById(R.id.btnPrev1);
        Prev2 = findViewById(R.id.btnPrev2);
        Prev3 = findViewById(R.id.btnPrev3);

        Question1.setOnClickListener(this);
        Question2.setOnClickListener(this);
        Question3.setOnClickListener(this);
        Question4.setOnClickListener(this);
        Question5.setOnClickListener(this);
        Answer1Q1.setOnClickListener(this);
        Answer2Q1.setOnClickListener(this);
        Answer3Q1.setOnClickListener(this);
        Answer4Q1.setOnClickListener(this);
        Answer1Q2.setOnClickListener(this);
        Answer2Q2.setOnClickListener(this);
        Answer3Q2.setOnClickListener(this);
        Answer4Q2.setOnClickListener(this);
        Answer1Q3.setOnClickListener(this);
        Answer2Q3.setOnClickListener(this);
        Answer3Q3.setOnClickListener(this);
        Answer4Q3.setOnClickListener(this);
        Answer1Q4.setOnClickListener(this);
        Answer2Q4.setOnClickListener(this);
        Answer3Q4.setOnClickListener(this);
        Answer4Q4.setOnClickListener(this);
        Answer1Q5.setOnClickListener(this);
        Answer2Q5.setOnClickListener(this);
        Answer3Q5.setOnClickListener(this);
        Answer4Q5.setOnClickListener(this);
        Submit.setOnClickListener(this);

        Questions1();
        Questions2();
        Questions3();
        Questions4();
        Questions5();

        Answers1();
        Answers2();
        Answers3();
        Answers4();
        Answers5();

        CorrectAnswer();

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next();
            }
        });

        Next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next1();
            }
        });

        Next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next2();
            }
        });

        Next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                next3();
            }
        });

        Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                previous();
            }
        });

        Prev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                previous1();
            }
        });

        Prev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                previous2();
            }
        });

        Prev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                previous3();
            }
        });

    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.Submit) {
            
            if (Group1.getCheckedRadioButtonId() == -1 || Group2.getCheckedRadioButtonId() == -1 || Group3.getCheckedRadioButtonId() == -1
            || Group4.getCheckedRadioButtonId() == -1 || Group5.getCheckedRadioButtonId() == -1){
                error();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz5();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz4();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz4();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz4();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz4();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz4();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
            && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                     finishQuiz1();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz1();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz1();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz1();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz1();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz2();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz3();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz3();
            }

            if (Answer3Q1.isChecked() == true && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == false
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz3();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == false && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz3();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == false && Answer1Q4.isChecked() == true && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz3();
            }

            if (Answer3Q1.isChecked() == false && Answer4Q2.isChecked() == true && Answer2Q3.isChecked() == true && Answer1Q4.isChecked() == false && Answer4Q5.isChecked() == true
                    && Group1.getCheckedRadioButtonId() != -1 && Group2.getCheckedRadioButtonId() != -1 && Group3.getCheckedRadioButtonId() != -1
                    && Group4.getCheckedRadioButtonId() != -1 && Group5.getCheckedRadioButtonId() != -1){
                finishQuiz3();
            }
        }
    }

    void CorrectAnswer() {
        Answer1Q4.setText(QA.A[0]);
        Answer4Q2.setText(QA.A[1]);
        Answer2Q3.setText(QA.A[2]);
        Answer1Q4.setText(QA.A[3]);
        Answer4Q5.setText(QA.A[4]);
    }

    void Answers1(){
        Answer1Q1.setText(QA.C1[QuestionIndex][0]);
        Answer2Q1.setText(QA.C1[QuestionIndex][1]);
        Answer3Q1.setText(QA.C1[QuestionIndex][2]);
        Answer4Q1.setText(QA.C1[QuestionIndex][3]);
    }

    void Answers2(){
        Answer1Q2.setText(QA.C2[QuestionIndex][0]);
        Answer2Q2.setText(QA.C2[QuestionIndex][1]);
        Answer3Q2.setText(QA.C2[QuestionIndex][2]);
        Answer4Q2.setText(QA.C2[QuestionIndex][3]);
    }

    void Answers3(){
        Answer1Q3.setText(QA.C3[QuestionIndex][0]);
        Answer2Q3.setText(QA.C3[QuestionIndex][1]);
        Answer3Q3.setText(QA.C3[QuestionIndex][2]);
        Answer4Q3.setText(QA.C3[QuestionIndex][3]);
    }

    void Answers4(){
        Answer1Q4.setText(QA.C4[QuestionIndex][0]);
        Answer2Q4.setText(QA.C4[QuestionIndex][1]);
        Answer3Q4.setText(QA.C4[QuestionIndex][2]);
        Answer4Q4.setText(QA.C4[QuestionIndex][3]);
    }

    void Answers5(){
        Answer1Q5.setText(QA.C5[QuestionIndex][0]);
        Answer2Q5.setText(QA.C5[QuestionIndex][1]);
        Answer3Q5.setText(QA.C5[QuestionIndex][2]);
        Answer4Q5.setText(QA.C5[QuestionIndex][3]);
    }

    void Questions1(){
        Question1.setText(QA.Q1[0]);
    }

    void Questions2(){
        Question2.setText(QA.Q2[0]);
    }

    void Questions3(){
        Question3.setText(QA.Q3[0]);
    }

    void Questions4(){
        Question4.setText(QA.Q4[0]);
    }

    void Questions5(){
        Question5.setText(QA.Q5[0]);
    }

    public void finishQuiz(){
        DialogFinish dialogFinish = new DialogFinish();
        dialogFinish.show(getSupportFragmentManager(), "finish");
    }

    public void finishQuiz1(){
        DialogFinish1 dialogFinish1 = new DialogFinish1();
        dialogFinish1.show(getSupportFragmentManager(), "finish1");
    }

    public void finishQuiz2(){
        DialogFinish2 dialogFinish2 = new DialogFinish2();
        dialogFinish2.show(getSupportFragmentManager(), "finish2");
    }

    public void finishQuiz3(){
        DialogFinish3 dialogFinish3 = new DialogFinish3();
        dialogFinish3.show(getSupportFragmentManager(), "finish3");
    }

    public void finishQuiz4(){
        DialogFinish4 dialogFinish4 = new DialogFinish4();
        dialogFinish4.show(getSupportFragmentManager(), "finish4");
    }

    public void finishQuiz5(){
        DialogFinish5 dialogFinish5 = new DialogFinish5();
        dialogFinish5.show(getSupportFragmentManager(), "finish5");
    }

    public void error(){
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "error");
    }


    public void next() {
        ScrollView.scrollTo(850, 850);
    }
    public void next1() {
        ScrollView.scrollTo(1800, 1800);
    }
    public void next2() {
        ScrollView.scrollTo(2700, 2700);
    }
    public void next3() {
        ScrollView.scrollTo(3400, 3400);
    }
    public void previous() { ScrollView.scrollTo(0, 0); }
    public void previous1() { ScrollView.scrollTo(850, 850); }
    public void previous2() { ScrollView.scrollTo(1800, 1800); }
    public void previous3() { ScrollView.scrollTo(2700, 2700); }
}