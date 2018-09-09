package com.jarvis.psycex.studyMaterials;

import android.annotation.SuppressLint;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.jarvis.psycex.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jarvis.psycex.DocumentViewer_Activity;
import com.jarvis.psycex.studyMaterials.StudyMaterials_Indexes;

import org.w3c.dom.Document;

/*public class StudyMaterials_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_materials);
    }
}*/

public class StudyMaterials_Activity extends ExpandableListActivity  {

    private ExpandableListAdapter mAdapterView;
    android.widget.ExpandableListView expandableListView;
    Toolbar toolbar;
    private Toolbar supportActionBar;

    @SuppressLint("NewApi")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_materials);

        toolbar = (Toolbar) findViewById(R.id.studyMaterialToolbar);
        toolbar.setTitle("     Study Materials");  //Spaces are placed deliberately
        //toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        StudyMaterials_Indexes indexes = new StudyMaterials_Indexes();

        /************ ncertEngXIPsy Start ****************/

        ListView ncertEngXIPsyListView = new ListView(this);

        // Create Array Adapter
        ArrayAdapter<String> ncertEngXIPsyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, indexes.getNcertEngXIPsyChapList());
        ncertEngXIPsyListView.setAdapter(ncertEngXIPsyAdapter);

        // Add ListView to dialog box.
        final AlertDialog.Builder ncertEngXIPsyDialogBuilder = new AlertDialog.Builder(StudyMaterials_Activity.this);
        ncertEngXIPsyDialogBuilder.setCancelable(true);
        ncertEngXIPsyDialogBuilder.setView(ncertEngXIPsyListView);

        ncertEngXIPsyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //@override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                System.out.println(position + "Chap 0 indexed Class XI Eng Clicked"); // position is 0 indexed like 0,1,2, ...
                DocumentViewer_Activity.positionInListView = position;
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                startActivity(intent);
            }
        });

        /************ ncertEngXIPsy End ****************/

        /************ ncertHinXIPsy Start ****************/

        ListView ncertHinXIPsyListView = new ListView(this);

        // Create Array Adapter
        ArrayAdapter<String> ncertHinXIPsyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, indexes.getNcertHinXIPsyChapList());
        ncertHinXIPsyListView.setAdapter(ncertHinXIPsyAdapter);

        // Add ListView to dialog box.
        final AlertDialog.Builder ncertHinXIPsyDialogBuilder = new AlertDialog.Builder(StudyMaterials_Activity.this);
        ncertHinXIPsyDialogBuilder.setCancelable(true);
        ncertHinXIPsyDialogBuilder.setView(ncertHinXIPsyListView);

        ncertHinXIPsyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //@override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                System.out.println(position + "Chap 0 indexed Class XI Hin Clicked"); // position is 0 indexed like 0,1,2, ...
                DocumentViewer_Activity.positionInListView = position;
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                startActivity(intent);
            }
        });

        /************ ncertHinXIPsy End ****************/

        /************ ncertEngXIIPsy Start ****************/

        ListView ncertEngXIIPsyListView = new ListView(this);

        // Create Array Adapter
        ArrayAdapter<String> ncertEngXIIPsyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, indexes.getNcertEngXIIPsyChapList());
        ncertEngXIIPsyListView.setAdapter(ncertEngXIIPsyAdapter);

        // Add ListView to dialog box.
        final AlertDialog.Builder ncertEngXIIPsyDialogBuilder = new AlertDialog.Builder(StudyMaterials_Activity.this);
        ncertEngXIIPsyDialogBuilder.setCancelable(true);
        ncertEngXIIPsyDialogBuilder.setView(ncertEngXIIPsyListView);

        ncertEngXIIPsyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //@override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                System.out.println(position + "Chap 0 indexed Class XII Eng Clicked"); // position is 0 indexed like 0,1,2, ...
                DocumentViewer_Activity.positionInListView = position;
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                startActivity(intent);
            }
        });

        /************ ncertEngXIIPsy End ****************/

        /************ ncertHinXIIPsy Start ****************/

        ListView ncertHinXIIPsyListView = new ListView(this);

        // Create Array Adapter
        ArrayAdapter<String> ncertHinXIIPsyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, indexes.getNcertHinXIIPsyChapList());
        ncertHinXIIPsyListView.setAdapter(ncertHinXIIPsyAdapter);

        // Add ListView to dialog box.
        final AlertDialog.Builder ncertHinXIIPsyDialogBuilder = new AlertDialog.Builder(StudyMaterials_Activity.this);
        ncertHinXIIPsyDialogBuilder.setCancelable(true);
        ncertHinXIIPsyDialogBuilder.setView(ncertHinXIIPsyListView);

        ncertHinXIIPsyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //@override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                System.out.println(position + "Chap 0 indexed Class XII Hin Clicked"); // position is 0 indexed like 0,1,2, ...
                DocumentViewer_Activity.positionInListView = position;
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                startActivity(intent);
            }
        });

        /************ ncertHinXIIPsy End ****************/

        /************ NIOSPsychology Start ****************/

        ListView NIOSPsyListView = new ListView(this);

        // Create Array Adapter
        ArrayAdapter<String> NIOSPsyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, indexes.getNIOSPsychologyChapList());
        NIOSPsyListView.setAdapter(NIOSPsyAdapter);

        // Add ListView to dialog box.
        final AlertDialog.Builder NIOSPsyDialogBuilder = new AlertDialog.Builder(StudyMaterials_Activity.this);
        NIOSPsyDialogBuilder.setCancelable(true);
        NIOSPsyDialogBuilder.setView(NIOSPsyListView);

        NIOSPsyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //@override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                System.out.println(position + "Chap 0 indexed NIOS Psy Clicked"); // position is 0 indexed like 0,1,2, ...
                DocumentViewer_Activity.positionInListView = position;
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                startActivity(intent);
            }
        });

        /************ NIOSPsychology End ****************/

        /************ BMPaper1 Start ****************/

        ListView BMPaper1PsyListView = new ListView(this);

        // Create Array Adapter
        ArrayAdapter<String> BMPaper1PsyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, indexes.getBMPaper1ChapList());
        BMPaper1PsyListView.setAdapter(BMPaper1PsyAdapter);

        // Add ListView to dialog box.
        final AlertDialog.Builder BMPaper1PsyDialogBuilder = new AlertDialog.Builder(StudyMaterials_Activity.this);
        BMPaper1PsyDialogBuilder.setCancelable(true);
        BMPaper1PsyDialogBuilder.setView(BMPaper1PsyListView);

        BMPaper1PsyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //@override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                System.out.println(position + "Chap 0 indexed BMPaper1Psy Clicked"); // position is 0 indexed like 0,1,2, ...
                DocumentViewer_Activity.positionInListView = position;
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                startActivity(intent);
            }
        });

        /************ BMPaper1 End ****************/

        /************ BMPaper2 Start ****************/

        ListView BMPaper2PsyListView = new ListView(this);

        // Create Array Adapter
        ArrayAdapter<String> BMPaper2PsyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, indexes.getBMPaper2ChapList());
        BMPaper2PsyListView.setAdapter(BMPaper2PsyAdapter);

        // Add ListView to dialog box.
        final AlertDialog.Builder BMPaper2PsyDialogBuilder = new AlertDialog.Builder(StudyMaterials_Activity.this);
        BMPaper2PsyDialogBuilder.setCancelable(true);
        BMPaper2PsyDialogBuilder.setView(BMPaper2PsyListView);

        BMPaper2PsyListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //@override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                System.out.println(position + "Chap 0 indexed BMPaper2Psy Clicked"); // position is 0 indexed like 0,1,2, ...
                DocumentViewer_Activity.positionInListView = position; //Set position of option selected in dialog listView, so that we get the link of the document
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                startActivity(intent);
            }
        });

        /************ BMPaper2 End ****************/




        List<Map<String, String>> groupListItem = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> childListItem = new ArrayList<List<Map<String, String>>>();
        List<List<List<Map<String, String>>>> grandChildListItem = new ArrayList<List<List<Map<String, String>>>>();

        String _3spaces = "   ";
        String _5spaces = "     ";


        /* ******************** Syllabus  ********************* */
        Map<String, String> groupSyllabus = new HashMap<String, String>();
        groupListItem.add(groupSyllabus);
        groupSyllabus.put("parentItem", "CSE Mains Psychology Syllabus");

        List<Map<String, String>> childSyllabus = new ArrayList<Map<String, String>>();
        Map<String, String> childrensyl1 = new HashMap<String, String>();
        childSyllabus.add(childrensyl1);
        childrensyl1.put("childItem", _5spaces + "Syllabus in English");

        Map<String, String> childrensyl2 = new HashMap<String, String>();
        childSyllabus.add(childrensyl2);
        childrensyl2.put("childItem", _5spaces + "मनोविज्ञान पाठ्यक्रम");

        childListItem.add(childSyllabus);

        /* ******************** NCERT Books ********************* */
        Map<String, String> group1 = new HashMap<String, String>();
        groupListItem.add(group1);
        group1.put("parentItem", "NCERT Psychology Books");

        List<Map<String, String>> children1 = new ArrayList<Map<String, String>>();
        Map<String, String> childrenitem1 = new HashMap<String, String>();
        children1.add(childrenitem1);
        childrenitem1.put("childItem", _5spaces + "Class XI English - Introduction to Psychology");

        Map<String, String> childrenitem2 = new HashMap<String, String>();
        children1.add(childrenitem2);
        childrenitem2.put("childItem", _5spaces + "Class XI Hindi - मनोविज्ञान का परिचय");

        Map<String, String> childrenitem3 = new HashMap<String, String>();
        children1.add(childrenitem3);
        childrenitem3.put("childItem", _5spaces +"Class XII English - Psychology");

        Map<String, String> childrenitem4 = new HashMap<String, String>();
        children1.add(childrenitem4);
        childrenitem4.put("childItem", _5spaces +"Class XII Hindi - मनोविज्ञान");

        childListItem.add(children1);

        /* ******************** NIOS Sr. Secondary Psychology  ********************* */
        Map<String, String> group2 = new HashMap<String, String>();
        groupListItem.add(group2);
        group2.put("parentItem", "NIOS Sr. Secondary Psychology");

        List<Map<String, String>> children2 = new ArrayList<Map<String, String>>();
        Map<String, String> childrenitem7 = new HashMap<String, String>();
        children2.add(childrenitem7);
        childrenitem7.put("childItem", _5spaces + "List of 37 Chapters");

        childListItem.add(children2);


        /* ******************** Beautiful Minds Notes  ********************* */
        Map<String, String> group3 = new HashMap<String, String>();
        groupListItem.add(group3);
        group3.put("parentItem", "Beautiful Minds IAS Modules");

        List<Map<String, String>> children3 = new ArrayList<Map<String, String>>();
        Map<String, String> childrenitem10 = new HashMap<String, String>();
        children3.add(childrenitem10);
        childrenitem10.put("childItem", _5spaces + "Paper 1");

        Map<String, String> childrenitem11 = new HashMap<String, String>();
        children3.add(childrenitem11);
        childrenitem11.put("childItem", _5spaces + "Paper 2");

        childListItem.add(children3);

        /* ******************** Essential Books  ********************* */
        Map<String, String> group4 = new HashMap<String, String>();
        groupListItem.add(group4);
        group4.put("parentItem", "Essential Books for Syllabus");

        List<Map<String, String>> children4 = new ArrayList<Map<String, String>>();

        Map<String, String> childrenitem12 = new HashMap<String, String>();
        children4.add(childrenitem12);
        childrenitem12.put("childItem", _5spaces + "Smarak Swain for Paper-II");

        Map<String, String> childrenitem13 = new HashMap<String, String>();
        children4.add(childrenitem13);
        childrenitem13.put("childItem", _5spaces + "Ciccareli 4th Edition");

        Map<String, String> childrenitem14 = new HashMap<String, String>();
        children4.add(childrenitem14);
        childrenitem14.put("childItem", _5spaces + "Book abc");

        Map<String, String> childrenitem15 = new HashMap<String, String>();
        children4.add(childrenitem15);
        childrenitem15.put("childItem", _5spaces + "Book xyz");

        childListItem.add(children4);

        /* ******************** Toppers Notes  ********************* */
        Map<String, String> group5 = new HashMap<String, String>();
        groupListItem.add(group5);
        group5.put("parentItem", "Toppers Notes");

        List<Map<String, String>> children5 = new ArrayList<Map<String, String>>();

        Map<String, String> childrenitem21 = new HashMap<String, String>();
        children5.add(childrenitem21);
        childrenitem21.put("childItem", _5spaces + "Topper 1");

        Map<String, String> childrenitem22 = new HashMap<String, String>();
        children5.add(childrenitem22);
        childrenitem22.put("childItem", _5spaces + "Topper 2");

        Map<String, String> childrenitem23 = new HashMap<String, String>();
        children5.add(childrenitem23);
        childrenitem23.put("childItem", _5spaces + "Topper 3");

        Map<String, String> childrenitem24 = new HashMap<String, String>();
        children5.add(childrenitem24);
        childrenitem24.put("childItem", _5spaces + "Topper 4");

        childListItem.add(children5);

        mAdapterView = new SimpleExpandableListAdapter(
                this,
                groupListItem,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"parentItem"},
                new int[]{android.R.id.text1, android.R.id.text2},
                childListItem,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"childItem"},
                new int[]{android.R.id.text1}
        );
        setListAdapter(mAdapterView);
        expandableListView = getExpandableListView();
        /*expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener(){
            //@override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                System.out.println("GROUP_CLICK_LISTENER: groupPosition:===> "+groupPosition);
                if(groupPosition == 0){  // Means Syllabus option clicked, and it has no child. So take action NOW.
                    Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                    startActivity(intent);
                }
                *//*if(parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);
                } else {
                    parent.expandGroup(groupPosition);
                }*//*
                return true;
            }
        });*/
        //final Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);

        expandableListView.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(android.widget.ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                System.out.println("CHILD_CLICK_LISTENER: groupPosition:===> "+groupPosition+"\tchildPosition:===>"+childPosition);
                Intent intent = new Intent(StudyMaterials_Activity.this, DocumentViewer_Activity.class);
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "Syllabus English Clicked",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("Syllabus English Clicked");
                                DocumentViewer_Activity.documentSelected = "cseMainsEngSyllabus";
                                DocumentViewer_Activity.positionInListView = 0; //Because there is no Dialog Box position for Syllabus Eng/Hin
                                startActivity(intent);
                                //syllabusEnglishDialogBuilder.show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "Syllabus Hindi Clicked",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("Syllabus Hindi Clicked");
                                DocumentViewer_Activity.documentSelected = "cseMainsHinSyllabus";
                                DocumentViewer_Activity.positionInListView = 0; //Because there is no Dialog Box position for Syllabus Eng/Hin
                                startActivity(intent);
                                //syllabusHindiDialogBuilder.show();
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "ncertEngXIPsyDialogBuilder Example",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("ncertEngXIPsyDialogBuilder Clicked");
                                DocumentViewer_Activity.documentSelected = "ncertEngXIPsy";
                                ncertEngXIPsyDialogBuilder.show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "ncertHinXIPsyDialogBuilder Tutorial",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("ncertHinXIPsyDialogBuilder Clicked");
                                DocumentViewer_Activity.documentSelected = "ncertHinXIPsy";
                                ncertHinXIPsyDialogBuilder.show();
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(), "ncertEngXIIPsyDialogBuilder ListView",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("ncertEngXIIPsyDialogBuilder Clicked");
                                DocumentViewer_Activity.documentSelected = "ncertEngXIIPsy";
                                ncertEngXIIPsyDialogBuilder.show();
                                break;
                            case 3:
                                Toast.makeText(getBaseContext(), "ncertHinXIIPsyDialogBuilder ListView",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("ncertHinXIIPsyDialogBuilder Clicked");
                                DocumentViewer_Activity.documentSelected = "ncertHinXIIPsy";
                                ncertHinXIIPsyDialogBuilder.show();
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "NIOSPsyDialogBuilder ListView",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("NIOSPsyDialogBuilder Clicked");
                                DocumentViewer_Activity.documentSelected = "NIOSPsy";
                                NIOSPsyDialogBuilder.show();
                                break;
                            /*case 1:
                                Toast.makeText(getBaseContext(), "Expandable ListView",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(getBaseContext(), "Expandable ListView",
                                        Toast.LENGTH_LONG).show();
                                break;*/
                        }
                        break;
                    case 3:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(getBaseContext(), "BM Paper-1 Clicked",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("BMPaper1PsyDialogBuilder Clicked");
                                DocumentViewer_Activity.documentSelected = "BMPaper1Psy";
                                BMPaper1PsyDialogBuilder.show();
                                break;
                            case 1:
                                Toast.makeText(getBaseContext(), "BM Paper-2 Clicked",
                                        Toast.LENGTH_LONG).show();
                                System.out.println("BMPaper2PsyDialogBuilder Clicked");
                                DocumentViewer_Activity.documentSelected = "BMPaper2Psy";
                                BMPaper2PsyDialogBuilder.show();
                                break;
                        }
                        break;
                }
                return false;
            }
        });



    } //onCreate End

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }
}
