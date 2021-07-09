package com.codershil.quiztruefalse.model;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.codershil.quiztruefalse.MainActivity;
import com.codershil.quiztruefalse.R;
import com.codershil.quiztruefalse.VolleySingleton;
import com.codershil.quiztruefalse.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private RequestQueue requestQueue;
    private String url;
    private Context context;

    public QuizManager(Context context) {
        this.context = context;
        requestQueue = VolleySingleton.getInstance().getRequestQueue();
        url = "https://opentdb.com/api.php?amount=10&category=17&type=boolean";
    }

    public List<QuizQuestion> getQuizQuestion(Activity activity) {
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        JsonObjectRequest quizRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray questionArray = response.getJSONArray("results");
                    for (int i = 0; i < questionArray.length(); i++) {
                        JSONObject questionObject = questionArray.getJSONObject(i);
                        String question = questionObject.getString("question");
                        boolean trueAnswer = questionObject.getBoolean("correct_answer");

                        QuizQuestion myQuestion = new QuizQuestion(question, trueAnswer);
                        quizQuestions.add(myQuestion);
                    }

                    CardStackView cardStackView = activity.findViewById(R.id.myCardStackView);
                    cardStackView.setLayoutManager(new CardStackLayoutManager(context));
                    cardStackView.setAdapter(new CardStackAdapter(context, quizQuestions));

                }

                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(quizRequest);

        return quizQuestions;
    }
}
