package com.jarvis.psycex.watchVideos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jarvis.psycex.R;
import com.jarvis.psycex.StudiesAndExperiments.StudiesAndExperiments_Activity;
import com.jarvis.psycex.StudiesAndExperiments.ViewSingleStudiesAndExperiments;
import com.jarvis.psycex.VideoViewer_Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WatchVideos_Activity extends AppCompatActivity {

    // Array of images, titles and descriptions

    int[] listviewImage = new int[]{
            R.drawable.watch_videos_1_,
            R.drawable.watch_videos_2_,
            R.drawable.watch_videos_3_,
            R.drawable.watch_videos_4_,
            R.drawable.watch_videos_5_,
    };

    String[] listviewTitle = new String[]{
            "MIT Open Courseware",
            "CEC UGC courses",
            "Open Yale Psychology course by Paul Bloom",
            "Examrace IAS Mains Psychology Optional",
            "Crash Course Psychology"

    };

    String[] listviewShortDescription = new String[]{
            "24 Videos. Very detailed video and time taking. Watch during free time.",
            "25 Videos. Elaborate discussions and explaination on selected topics. You will develop deeper insights.",
            "20 Videos. Wonderful explaination of different schools of Psychology, Motivation and Emotions and few topics of Paper-1 topics.",
            "34 Videos. Covers as per our CSE Mains syllabus",
            "40 Videos. Quick Revision and Creative content for remembering. Watch in free time."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_videos);



        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 5; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("watchVideosTitle", listviewTitle[i]);
            hm.put("watchVideosDescription", listviewShortDescription[i]);
            hm.put("watchVideosImage", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"watchVideosImage", "watchVideosTitle", "watchVideosDescription"};
        int[] to = {R.id.watchVideosImage, R.id.watchVideosTitle, R.id.watchVideosDescription};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_watch_videos_listitem, from, to);
        ListView androidListView = (ListView) findViewById(R.id.watchVideosListView);
        androidListView.setAdapter(simpleAdapter);

        //perform listView item click event
        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),listviewTitle[i],Toast.LENGTH_LONG).show();
                VideoViewer_Activity.playlistOrVideoLink = "https://www.youtube.com/watch?v=2fbrl6WoIyo&amp;list=PL44ABC9278E2EE706";

                System.out.println("-------indexOfWatchVideosSelected-----------:==>"+VideoViewer_Activity.playlistOrVideoLink+"------------------------");
                Intent viewVideoIntent = new Intent(WatchVideos_Activity.this, VideoViewer_Activity.class);
                startActivity(viewVideoIntent);
            }
        });
    }
}
