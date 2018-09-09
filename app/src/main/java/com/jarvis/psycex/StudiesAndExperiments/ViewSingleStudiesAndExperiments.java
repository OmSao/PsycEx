package com.jarvis.psycex.StudiesAndExperiments;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jarvis.psycex.R;

import java.lang.reflect.Field;

public class ViewSingleStudiesAndExperiments extends AppCompatActivity {

    public static int indexOfStudiesAndExperimentsSelected = 0;
    TextView titleTextView;  //If you assign it values by findViewById here itself, it will give error saying: can't instantiate before onCreate
    ImageView mainImageView;
    TextView conductedBy;
    TextView dateAndPlaces;
    TextView topic;
    TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_single_studies_and_experiments);

        titleTextView = (TextView)findViewById(R.id.titleStudiesAndExperimentsViewer);
        mainImageView = (ImageView)findViewById(R.id.imageStudiesAndExperimentsViewer);
        conductedBy = (TextView)findViewById(R.id.conductedByStudiesAndExperimentsViewer);
        dateAndPlaces = (TextView)findViewById(R.id.dateAndPlaceStudiesAndExperimentsViewer);
        topic = (TextView)findViewById(R.id.topicStudiesAndExperimentsViewer);
        details = (TextView)findViewById(R.id.detailsStudiesAndExperimentsViewer);

        //String allDetailsArray[] = getResources().getStringArray(R.array._1_StudiesAndExperiments);
        System.out.println("---------------------"+"_"+Integer.toString(indexOfStudiesAndExperimentsSelected + 1) + "_StudiesAndExperiments");
        String allDetailsArray[] = getResources().getStringArray(getResources().getIdentifier("_"+Integer.toString(indexOfStudiesAndExperimentsSelected + 1) + "_StudiesAndExperiments", "array", getPackageName() ));

        //int id = getResources().getIdentifier("studies_and_experiments_1_", "drawable", getPackageName());
        int id = getResources().getIdentifier("studies_and_experiments_"+Integer.toString(indexOfStudiesAndExperimentsSelected + 1)+"_", "drawable", getPackageName());
        Drawable d = getResources().getDrawable(id);

        titleTextView.setText(allDetailsArray[0]);
        //mainImageView.setImageResource(R.drawable.studies_and_experiments_a_class_divided);
        mainImageView.setImageDrawable(d);
        conductedBy.setText(allDetailsArray[2]);
        dateAndPlaces.setText(allDetailsArray[3]);
        topic.setText(allDetailsArray[4]);
        details.setText(allDetailsArray[5]);



    }
}
