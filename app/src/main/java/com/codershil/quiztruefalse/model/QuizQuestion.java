package com.codershil.quiztruefalse.model;

public class QuizQuestion {

    private String questionsText;
    private boolean trueAnswer;

    public QuizQuestion(String questionsText, boolean trueAnswer) {
        this.questionsText = questionsText;
        this.trueAnswer = trueAnswer;
    }

    public String getQuestionsText() {
        return questionsText;
    }

    public void setQuestionsText(String questionsText) {
        this.questionsText = questionsText;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
