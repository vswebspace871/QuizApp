package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewNoOfQustion, textViewQuestion;
    ImageView imageView;
    Button buttonOption1, buttonOption2, buttonOption3, buttonOption4, buttonNext;

    ArrayList<Integer> score = new ArrayList<>();
    //int score = 0;
    int totalQuestion = QuizModel.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewNoOfQustion = findViewById(R.id.textViewNoOfQustion);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        imageView = findViewById(R.id.imageView2);

        buttonOption1 = findViewById(R.id.buttonOption1);
        buttonOption2 = findViewById(R.id.buttonOption2);
        buttonOption3 = findViewById(R.id.buttonOption3);
        buttonOption4 = findViewById(R.id.buttonOption4);
        buttonNext = findViewById(R.id.buttonNext);

        buttonOption1.setOnClickListener(this);
        buttonOption2.setOnClickListener(this);
        buttonOption3.setOnClickListener(this);
        buttonOption4.setOnClickListener(this);
        buttonNext.setOnClickListener(this);

        // Print Question and Options
        loadNewQuestion();

    }


    @Override
    public void onClick(View view) {
        buttonOption1.setBackgroundColor(Color.WHITE);
        buttonOption1.setTextColor(Color.BLACK);
        buttonOption2.setBackgroundColor(Color.WHITE);
        buttonOption2.setTextColor(Color.BLACK);
        buttonOption3.setBackgroundColor(Color.WHITE);
        buttonOption3.setTextColor(Color.BLACK);
        buttonOption4.setBackgroundColor(Color.WHITE);
        buttonOption4.setTextColor(Color.BLACK);


        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.buttonNext) {
            //if Next button clicked load question
            currentQuestionIndex++;
            loadNewQuestion();
        } else {
            //if options button clicked
            selectedAnswer = clickedButton.getText().toString();
            if (selectedAnswer.equals(QuizModel.correctAnswers[currentQuestionIndex])) {
                if (!score.contains(currentQuestionIndex)){
                    score.add(currentQuestionIndex);
                }
               // score++, bug fixed, score was increasing again and again;
                clickedButton.setBackgroundColor(Color.GREEN);
            } else {
                clickedButton.setBackgroundColor(Color.RED);
                clickedButton.setTextColor(Color.WHITE);
            }
        }
    }

    private void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            // out of question , finish quiz
            finishQuiz();
            return;
        }
        //counter of question
        int question = currentQuestionIndex + 1;
        textViewNoOfQustion.setText(question + "/" + totalQuestion);

        //setting data to the views
        textViewQuestion.setText(QuizModel.question[currentQuestionIndex]);
        imageView.setImageResource(QuizModel.imgArray[currentQuestionIndex]);
        buttonOption1.setText(QuizModel.choices[currentQuestionIndex][0]);
        buttonOption2.setText(QuizModel.choices[currentQuestionIndex][1]);
        buttonOption3.setText(QuizModel.choices[currentQuestionIndex][2]);
        buttonOption4.setText(QuizModel.choices[currentQuestionIndex][3]);

    }

    private void finishQuiz() {
        //showing result in dialog box
        new AlertDialog.Builder(this)
                .setTitle("Result")
                .setMessage("Score is : " + score.size() + "/" + totalQuestion) //
                .setCancelable(false)
                .setPositiveButton("Restart", (dialogInterface, i) -> restartQuiz())
                .setNegativeButton("Quit", (dialogInterface, i) -> finish()).show();
    }

    private void restartQuiz() {
        //restart quiz, score will empty and index back to zero
        score.clear(); //
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}