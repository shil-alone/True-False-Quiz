package com.codershil.quiztruefalse.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codershil.quiztruefalse.R;
import com.codershil.quiztruefalse.model.QuizQuestion;
import com.codershil.quiztruefalse.view.QuizViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<QuizViewHolder> {
    private Context context;
    private List<QuizQuestion> questionsList;
    private LayoutInflater layoutInflater;

    public CardStackAdapter(Context context, List<QuizQuestion> questionsList) {
        this.context = context;
        this.questionsList = questionsList;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.getQuestion().setText(questionsList.get(position).getQuestionsText());

        holder.getBtnTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "true is tapped", Toast.LENGTH_SHORT).show();
                if (questionsList.get(position).isTrueAnswer()){
                    Toast.makeText(context, "Correct !", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "!Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.getBtnFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!questionsList.get(position).isTrueAnswer()){
                    Toast.makeText(context, "Correct !", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "!Incorrect", Toast.LENGTH_SHORT).show();
                }            }
        });


    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }
}
