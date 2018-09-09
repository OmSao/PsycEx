package com.jarvis.psycex.quiz;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jarvis.psycex.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ScoreAnalysisAnswers_Activity extends AppCompatActivity {
    private TextView mScoreView;   // view for current total score
    private int mScore = 0;  // current total score
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mScoreView = (TextView)findViewById(R.id.score);
        setContentView(R.layout.activity_score_analysis_answers);

        TextView totalNumberOfQuestionsTV = (TextView) findViewById(R.id.totalNumberOfQuestionText);
        TextView numberOfAttemptedTV = (TextView) findViewById(R.id.numberOfAttemptedText);
        TextView numberOfSkippedTV = (TextView) findViewById(R.id.numberOfSkippedText);
        TextView numberOfCorrectTV = (TextView) findViewById(R.id.numberOfCorrectText);
        TextView numberOfWrongTV = (TextView) findViewById(R.id.numberOfWrongText);

        PieChart pieChart = (PieChart) findViewById(R.id.piechart);


        //TextView txtHighScore = (TextView) findViewById(R.id.textHighScore);
        // receive the score from last activity by Intent
        Intent intentFromQuiz = getIntent();
        int totalNumberOfQuestions = intentFromQuiz.getIntExtra("totalNumberQuestions", 0);
        int numberOfCorrectAnswers = intentFromQuiz.getIntExtra("totalNumberOfCorrectAnswers", 0);
        int numberOfSkippedQuestions = intentFromQuiz.getIntExtra("totalNumberOfSkippedQuestions", 0);

        // display current score
        totalNumberOfQuestionsTV.setText(totalNumberOfQuestionsTV.getText()  + Integer.toString(totalNumberOfQuestions));
        numberOfAttemptedTV.setText(numberOfAttemptedTV.getText() + Integer.toString(totalNumberOfQuestions - numberOfSkippedQuestions));
        numberOfSkippedTV.setText(numberOfSkippedTV.getText() + Integer.toString(numberOfSkippedQuestions));
        numberOfCorrectTV.setText(numberOfCorrectTV.getText()  + Integer.toString(numberOfCorrectAnswers));
        numberOfWrongTV.setText(numberOfWrongTV.getText() + Integer.toString(totalNumberOfQuestions - numberOfSkippedQuestions - numberOfCorrectAnswers));


        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(numberOfCorrectAnswers, 0));   //Correct
        if((totalNumberOfQuestions - numberOfSkippedQuestions - numberOfCorrectAnswers) > 0){
            yvalues.add(new Entry(totalNumberOfQuestions - numberOfSkippedQuestions - numberOfCorrectAnswers, 1)); //Wrong
        }
        if(numberOfSkippedQuestions > 0) {
            yvalues.add(new Entry(numberOfSkippedQuestions, 2));  //Skipped
        }


        // array of graph different colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(ContextCompat.getColor(this, android.R.color.holo_green_light));  //Correct
        if((totalNumberOfQuestions - numberOfSkippedQuestions - numberOfCorrectAnswers) > 0) {
            colors.add(ContextCompat.getColor(this, android.R.color.holo_red_light)); //Wrong
        }
        if(numberOfSkippedQuestions > 0) {
            colors.add(ContextCompat.getColor(this, android.R.color.holo_orange_light)); //Skipped
        }

        PieDataSet dataSet = new PieDataSet(yvalues, "");
        //dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setValueTextSize(15f);

        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Correct");
        xVals.add("Wrong");
        xVals.add("Skipped");

        PieData data = new PieData(xVals, dataSet);

        //Disable Hole in the Pie Chart
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(35f);
        pieChart.setHoleRadius(30f);

        pieChart.setDescription("Quiz Score Analysis");

        Legend l = pieChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        /*l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setYOffset(0f);*/


        // colors according to the dataset
        dataSet.setColors(colors);

        // In percentage Term
        //data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));

        pieChart.setData(data);

    }
}
