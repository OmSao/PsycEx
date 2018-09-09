package com.jarvis.psycex.quiz;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jarvis.psycex.R;
import com.jarvis.psycex.quiz.QuestionBank.QuestionBank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Quiz_Activity extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView;   // view for current total score
    private TextView mQuestionView;  //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView

    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 1; // current question number. Starts with 1st Question

    private TextView statusBoardTotalQuestionsTV; // stores number of Questions in Quiz
    private TextView statusBoardAttemptedQuestionsTV; // stores number of Questions in Quiz
    private TextView statusBoardUnattemptedQuestionsTV; // stores number of Questions in Quiz

    private int mTotalNumberOfQuestionInQuiz = mQuestionLibrary.getNumberOfQuestions();
    private int mTotalNumberOfAttemptedInQuiz = 0;
    private int mTotalNumberOfUnattemptedInQuiz = mTotalNumberOfQuestionInQuiz - mTotalNumberOfAttemptedInQuiz;

    private List<int[]> mUserChoice = new ArrayList<int[]>();  // for storing User's selected Choice. Will be used for changing color of Choice selected.

    private Button finishQuizAndViewScoreButton;
    private Button prevButton;
    private Button nextButton;

    /*final Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
    fadeIn.setDuration(3000);

    final Animation fadeOut = new AlphaAnimation(1.0f, 0.0f);
    fadeOut.setDuration(3000);*/

    AnimationSet as = new AnimationSet(true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        finishQuizAndViewScoreButton = (Button) findViewById(R.id.finishQuizAndViewScore);  // button view for Finish Quiz button
        finishQuizAndViewScoreButton.setVisibility(View.GONE);                               // hide it intially

        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        // setup screen for the first question with four alternative to answer

        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choiceA);
        mButtonChoice2 = (Button)findViewById(R.id.choiceB);
        mButtonChoice3 = (Button)findViewById(R.id.choiceC);
        mButtonChoice4 = (Button)findViewById(R.id.choiceD);

        statusBoardTotalQuestionsTV = (TextView) findViewById(R.id.statusBoardTotalQuestions);
        statusBoardAttemptedQuestionsTV = (TextView) findViewById(R.id.statusBoardAttemptedQuestions);
        statusBoardUnattemptedQuestionsTV = (TextView) findViewById(R.id.statusBoardUnattemptedQuestions);

        updateQuestion(mQuestionNumber);
        // show current total score for the user
        //updateScore(mScore);
    }

    private void updateQuestion(int mQuestionNumber){
        System.out.println("----QuestionNumber"+mQuestionNumber);
        // check if we are not outside array bounds for questions
        if(mQuestionNumber <= mQuestionLibrary.getNumberOfQuestions() ){

            finishQuizAndViewScoreButton.setVisibility(View.GONE);

            if(mQuestionNumber == 1){
                prevButton.setEnabled(false);
            }
            else{
                prevButton.setEnabled(true);
            }

            if(mQuestionNumber == mQuestionLibrary.getNumberOfQuestions()){
                nextButton.setEnabled(false);
            }
            else{
                nextButton.setEnabled(true);
            }
            // set the text for new question, and new 4 alternative to answer on four buttons
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice1.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));

            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice2.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));

            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice3.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));

            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mButtonChoice4.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));

            statusBoardTotalQuestionsTV.setText(Integer.toString(mTotalNumberOfQuestionInQuiz));

            if(mQuestionNumber == mQuestionLibrary.getNumberOfQuestions() ) {
                finishQuizAndViewScoreButton.setVisibility(View.VISIBLE);
            }

            mAnswer = mQuestionLibrary.getCorrectAnswersChoice(mQuestionNumber) + ". " +mQuestionLibrary.getCorrectAnswersText(mQuestionNumber);
            mQuestionNumber++;

        }
        else {
            //Toast.makeText(Quiz_Activity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
            finishQuizAndViewScoreButton.setVisibility(View.VISIBLE);
            /*Intent scoreAnalysisAnswersIntent = new Intent(Quiz_Activity.this, ScoreAnalysisAnswers_Activity.class);
            startActivity(scoreAnalysisAnswersIntent);
            // show current total score for the user
            updateScore(mScore);*/

            /*Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);*/
        }
    }

    // show current total score for the user
    private void updateScore(int point) {
        mScoreView.setText("" + mScore+"/"+mQuestionLibrary.getNumberOfQuestions());
    }

    public void onChoiceClick(View view) {
        //all logic for all answers buttons in one method
        final Button clickedChoiceButton = (Button) view;
        clickedChoiceButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            public void run(){
                updateQuestion(++mQuestionNumber); // pre-increment operator so that, first increment and then
            }
        }, 1000);


        // if the answer is correct, increase the score
        System.out.println("---"+clickedChoiceButton.getText());
        System.out.println("---"+mAnswer);

        if (clickedChoiceButton.getText().equals(mAnswer)){
            mScore = mScore + 1;
            //Toast.makeText(Quiz_Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(Quiz_Activity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

            // show current total score for the user
        //updateScore(mScore);
    }

    public void prevButtonClick(View view){
        System.out.println("----Previous clicked");
        --mQuestionNumber;
        updateQuestion(mQuestionNumber);
    }

    public void nextButtonClick(View view){
        System.out.println("----Next clicked");
        ++mQuestionNumber;
        updateQuestion(mQuestionNumber);
    }

    public void showScoreAnalysisAnswerButtonOnClick(View view){
        Intent scoreAnalysisAnswersIntent = new Intent(Quiz_Activity.this, ScoreAnalysisAnswers_Activity.class);

        scoreAnalysisAnswersIntent.putExtra("totalNumberQuestions", mQuestionLibrary.getNumberOfQuestions()); // pass the total number of Questions to the second screen
        scoreAnalysisAnswersIntent.putExtra("totalNumberOfSkippedQuestions", 0); // pass the number of skipped questions to the second screen
        scoreAnalysisAnswersIntent.putExtra("totalNumberOfCorrectAnswers", mScore); // pass the current score to the second screen


        startActivity(scoreAnalysisAnswersIntent);
        // show current total score for the user
        //updateScore(mScore);
    }
}
