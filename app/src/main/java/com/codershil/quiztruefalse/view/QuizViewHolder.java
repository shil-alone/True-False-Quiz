package com.codershil.quiztruefalse.view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codershil.quiztruefalse.R;

public class QuizViewHolder extends RecyclerView.ViewHolder {
    TextView question;
    ImageButton btnTrue,btnFalse;
    public QuizViewHolder(@NonNull View itemView) {
        super(itemView);
        question = itemView.findViewById(R.id.txtQuestion);
        btnTrue = itemView.findViewById(R.id.btnTrue);
        btnFalse = itemView.findViewById(R.id.btnFalse);
    }

    public TextView getQuestion() {
        return question;
    }

    public ImageButton getBtnTrue() {
        return btnTrue;
    }

    public ImageButton getBtnFalse() {
        return btnFalse;
    }
}
