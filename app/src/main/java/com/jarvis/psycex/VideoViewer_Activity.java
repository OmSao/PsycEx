package com.jarvis.psycex;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jarvis.psycex.studyMaterials.StudyMaterials_Indexes;

public class VideoViewer_Activity extends AppCompatActivity {

    private WebView webView;
    private ProgressDialog progDailog;
    //public static String documentSelected="null";
    //public static int positionInListView=0;
    public static String  playlistOrVideoLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_viewer);

        progDailog = ProgressDialog.show(VideoViewer_Activity.this, "PsycEx Loading the video","Please wait...", true);
        progDailog.setCancelable(false);
        //System.out.println("____________________________________"+documentSelected);
        //System.out.println("____________________________________"+positionInListView);
        System.out.println("_________________Link to be clicked___________________"+playlistOrVideoLink);

        webView = (WebView) findViewById(R.id.videoViewerWebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });

        /*if(documentSelected.equals("cseMainsEngSyllabus")){
            webView.loadUrl(StudyMaterials_Indexes.getcseMainsEngSyllabusLinks().get(0));
        }
        else if(documentSelected.equals("cseMainsHinSyllabus")){
            webView.loadUrl(StudyMaterials_Indexes.getcseMainsHinSyllabusLinks().get(0));
        }*/
        webView.loadUrl(playlistOrVideoLink);
    }
}
