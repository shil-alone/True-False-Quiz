package com.codershil.quiztruefalse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.codershil.quiztruefalse.model.QuizManager;

public class MainActivity extends AppCompatActivity {
    private QuizManager quizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizManager = new QuizManager(this);
        quizManager.getQuizQuestion(this);

    }
}