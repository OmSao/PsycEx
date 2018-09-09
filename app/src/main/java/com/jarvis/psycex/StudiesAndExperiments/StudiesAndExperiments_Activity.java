package com.jarvis.psycex.StudiesAndExperiments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jarvis.psycex.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudiesAndExperiments_Activity extends AppCompatActivity {
    /*ListView listView;
    TextView textView;
    String[] listItem;*/

    // Array of images, titles and descriptions

    int[] listviewImage = new int[]{
            R.drawable.studies_and_experiments_1_, R.drawable.studies_and_experiments_2_, R.drawable.studies_and_experiments_3_, R.drawable.studies_and_experiments_4_,
            R.drawable.studies_and_experiments_5_, R.drawable.studies_and_experiments_6_, R.drawable.studies_and_experiments_7_, R.drawable.studies_and_experiments_8_,
            R.drawable.studies_and_experiments_9_, R.drawable.studies_and_experiments_10_, R.drawable.studies_and_experiments_11_, R.drawable.studies_and_experiments_12_,
    };

    String[] listviewTitle = new String[]{
            "A Brown and Blue eyes Racism experiment",
            "Asch Conformity Study",
            "Bobo Doll Experiment",
            "Misinformation Effect to Memory",
            "Cognitive Dissonance Experiment",
            "Fantz’s Looking Chamber",
            "Hawthorne Effect",
            "Bystander Effect/Apathy",
            "Learned Helplessness Experiment",
            "Little Albert Experiment",
            "Magical Number Seven",
            "Pavlov’s Dog Experiment"
    };

    String[] listviewShortDescription = new String[]{
            "Effect and Development of Racism", "Conformation to group opinion overshadows personal opinion", "Modelling and Observational learning", "Incorporation of Misinformation into one's memory ",
            "Diagreement between fact and belief", "Understanding development of Infant's vision accuracy", "Observer Expectancy bias", "Diffusion of responsibility when part of group",
            "Helplessness can also be learnt based on past experience", "Phobias in humans learnt by Classical Condition", "Information stored with highest success if have certain length", "Classical conditioning ",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studies_and_experiments);

        /*listView=(ListView)findViewById(R.id.studiesAndExperimentsListView);
        textView=(TextView)findViewById(R.id.textViewUnderStudiesAndExperimentsList);
        listItem = getResources().getStringArray(R.array.studiesAndExperimentsNamesArray);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });*/

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 12; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("studiesAndExperimentsTitle", listviewTitle[i]);
            hm.put("studiesAndExperimentsDescription", listviewShortDescription[i]);
            hm.put("studiesAndExperimentsImage", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"studiesAndExperimentsImage", "studiesAndExperimentsTitle", "studiesAndExperimentsDescription"};
        int[] to = {R.id.studiesAndExperimentImage, R.id.studiesAndExperimentTitle, R.id.studiesAndExperimentDescription};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_studies_and_experiments_listitem, from, to);
        ListView androidListView = (ListView) findViewById(R.id.studiesAndExperimentsListView);
        androidListView.setAdapter(simpleAdapter);

        //perform listView item click event
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),listviewTitle[i],Toast.LENGTH_LONG).show();
                ViewSingleStudiesAndExperiments.indexOfStudiesAndExperimentsSelected = i;
                System.out.println("-------indexOfStudiesAndExperimentsSelected-----------:==>"+ViewSingleStudiesAndExperiments.indexOfStudiesAndExperimentsSelected+"------------------------");
                Intent viewSingleStudiesAndExperimentsIntent = new Intent(StudiesAndExperiments_Activity.this, ViewSingleStudiesAndExperiments.class);
                startActivity(viewSingleStudiesAndExperimentsIntent);
            }
        });

    }
}
