package com.jarvis.psycex.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jarvis.psycex.Dashboard_mainActivity;
import com.jarvis.psycex.R;

public class QuizDashboard_Activity extends AppCompatActivity {
    RelativeLayout parentGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);

        parentGrid = (RelativeLayout) findViewById(R.id.quizDashboardParentGrid);
        setQuizSingleEvent(parentGrid);
    }

    private void setQuizSingleEvent(RelativeLayout parentGrid){
        Button mixQuizButton = (Button)findViewById(R.id.mixQuizButton);
        mixQuizButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Quiz Clicked!" , Toast.LENGTH_SHORT ).show();
                Intent quizIntent = new Intent(QuizDashboard_Activity.this, Quiz_Activity.class);
                startActivity(quizIntent);
            }
        });
    }
}
