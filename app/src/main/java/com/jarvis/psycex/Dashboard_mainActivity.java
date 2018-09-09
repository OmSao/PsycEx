package com.jarvis.psycex;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ShareActionProvider;

import android.support.v4.view.ActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
//import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.jarvis.psycex.StudiesAndExperiments.StudiesAndExperiments_Activity;
import com.jarvis.psycex.dictionary.SearchableDictionary;
import com.jarvis.psycex.notes.Notes_Activity;
import com.jarvis.psycex.quiz.QuizDashboard_Activity;
import com.jarvis.psycex.studyMaterials.StudyMaterials_Activity;
import com.jarvis.psycex.watchVideos.WatchVideos_Activity;

public class Dashboard_mainActivity extends AppCompatActivity {
    LinearLayout parentGrid;
    ScrollView dashboardScrollView;
    AnimationDrawable dashboardBackgroundAnimationDrawableAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);

        dashboardScrollView = (ScrollView) findViewById(R.id.dashboardScrollViewBackground);
        dashboardBackgroundAnimationDrawableAnimationDrawable =(AnimationDrawable) dashboardScrollView.getBackground();
        dashboardBackgroundAnimationDrawableAnimationDrawable.setEnterFadeDuration(5000);
        dashboardBackgroundAnimationDrawableAnimationDrawable.setExitFadeDuration(5000);
        dashboardBackgroundAnimationDrawableAnimationDrawable.start();

        /*MenuItem shareItem =  (MenuItem) findViewById(R.id.actionbar_share);

        shareItem.setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType
            }
        });*/

        parentGrid = (LinearLayout) findViewById(R.id.parentGrid);
        setQuizSingleEvent(parentGrid);
        setNotesSingleEvent(parentGrid);
        setDictionarySingleEvent(parentGrid);
        setStudiesAndExperimentsSingleEvent(parentGrid);
        setStudyMaterialsSingleEvent(parentGrid);
        setWatchVideosEvent(parentGrid);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.main_activity_bar, menu);

        //MenuItem item = menu.findItem(R.id.actionbar_share);



/*        //ShareActionProvider shareActionProvider = (ShareActionProvider) menu.findItem(R.id.actionbar_share).getActionProvider();
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.actionbar_share));
        //ActionProvider shareActionProvider = (ActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.actionbar_share));
        shareActionProvider.setShareIntent(shareAndPromotePsycEx());*/

        return super.onCreateOptionsMenu(menu);
    }

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.actionbar_share:
                System.out.println("asdfasdf;l");
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBodyText = "Check it out. Your message goes here";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
                return true;

            *//*case R.id.help:
                showHelp();
                return true;*//*
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Intent shareAndPromotePsycEx() {
        Intent shareAndPromotePsycExIntent = new Intent(Intent.ACTION_SEND);
        shareAndPromotePsycExIntent.setType("text/plain");
        String shareAndPromotionSubject = "cccc";
        String shareAndPromotionBody = "Hi Psychology Students and Learners. Here is an Awesome App PsycEx(Psychology Explorer) for Psychological Terms Dicitionary, compilation of Studies and Experiments, Concepts and Notes and Courses Videos compilations. So, what are you waiting for ?. Download the app now and dive into Psychology Learning Journey. https://asdfalkasdfasf.asdlkjasdfasd";
        shareAndPromotePsycExIntent.putExtra(Intent.EXTRA_SUBJECT, shareAndPromotionSubject);
        shareAndPromotePsycExIntent.putExtra(Intent.EXTRA_TEXT, shareAndPromotionBody);
        startActivity(Intent.createChooser(shareAndPromotePsycExIntent, "Spread the PsycEx app among Psychology Students and Enthusiasts!!"));
        return shareAndPromotePsycExIntent;
    }*/

    private void setDictionarySingleEvent(LinearLayout parentGrid){
        CardView cardViewNotes = (CardView)findViewById(R.id.dictionary);
        cardViewNotes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Dictionary Clicked!" , Toast.LENGTH_SHORT ).show();
                Intent dictionaryIntent = new Intent(Dashboard_mainActivity.this, SearchableDictionary.class);
                startActivity(dictionaryIntent);
            }
        });
    }
    private void setStudiesAndExperimentsSingleEvent(LinearLayout parentGrid){
        CardView cardViewNotes = (CardView)findViewById(R.id.studiesAndExperiment);
        cardViewNotes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Studies And Experiment Clicked!" , Toast.LENGTH_SHORT ).show();
                Intent studiesAndExperimentIntent = new Intent(Dashboard_mainActivity.this, StudiesAndExperiments_Activity.class);
                startActivity(studiesAndExperimentIntent);
            }
        });
    }

    private void setQuizSingleEvent(LinearLayout parentGrid){
        CardView cardViewQuiz = (CardView)findViewById(R.id.quizIconInMainDashboard);
        cardViewQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Quiz Clicked!" , Toast.LENGTH_SHORT ).show();
                Intent quizIntent = new Intent(Dashboard_mainActivity.this, QuizDashboard_Activity.class);
                startActivity(quizIntent);
            }
        });
    }


    private void setNotesSingleEvent(LinearLayout parentGrid){
        CardView cardViewNotes = (CardView)findViewById(R.id.notesIconInMainDashboard);
        cardViewNotes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Notes Clicked!" , Toast.LENGTH_SHORT ).show();
                Intent notestIntent = new Intent(Dashboard_mainActivity.this, Notes_Activity.class);
                startActivity(notestIntent);
            }
        });
    }

    private void setStudyMaterialsSingleEvent(LinearLayout parentGrid){
        CardView cardViewStudyMaterials = (CardView)findViewById(R.id.studyMaterials);
        cardViewStudyMaterials.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Study Material Clicked!" , Toast.LENGTH_SHORT ).show();
                Intent studyMaterialstIntent = new Intent(Dashboard_mainActivity.this, StudyMaterials_Activity.class);
                startActivity(studyMaterialstIntent);
            }
        });
    }

    private void setWatchVideosEvent(LinearLayout parentGrid){
        CardView cardViewStudyMaterials = (CardView)findViewById(R.id.watchVideos);
        cardViewStudyMaterials.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Watch Videos Clicked!" , Toast.LENGTH_SHORT ).show();
                Intent watchVideostIntent = new Intent(Dashboard_mainActivity.this, WatchVideos_Activity.class);
                startActivity(watchVideostIntent);
            }
        });
    }
}
