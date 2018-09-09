package com.jarvis.psycex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashScreen extends AppCompatActivity {

    private ImageView splashScreenImageView;
    private TextView splashScreenWelcomeMessageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashScreenImageView = (ImageView)findViewById(R.id.splashScreenWelcomeLogo);
        splashScreenWelcomeMessageTextView = (TextView)findViewById(R.id.splashScreenWelcomeMessage);
        Animation splashScreenAnimation = AnimationUtils.loadAnimation(this,R.anim.splash_transition);
        splashScreenImageView.startAnimation(splashScreenAnimation);
        splashScreenWelcomeMessageTextView.startAnimation(splashScreenAnimation);

        final Intent dashboard_mainActivityIntent = new Intent(this, Dashboard_mainActivity.class);
        Thread timer = new Thread(){
            public void run() {
                try{
                    sleep(4000); // 5000 ms is appropriate time


                }catch(InterruptedException e){
                    System.out.println(e.getMessage());
                }
                finally{
                    startActivity(dashboard_mainActivityIntent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
