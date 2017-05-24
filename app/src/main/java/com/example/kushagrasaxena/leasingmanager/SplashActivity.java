package com.example.kushagrasaxena.leasingmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.kushagrasaxena.leasingmanager.utils.SharedPrefManager;

public class SplashActivity extends Activity implements Animation.AnimationListener
{
    Animation animRotate;
    ImageView iv;

    private String mUsername;

    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        iv=(ImageView)findViewById(R.id.imageView3);

        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        // set animation listener
        animRotate.setAnimationListener(this);
        iv.startAnimation(animRotate);
    }
    private boolean isFirstTime() {
        // create an object of sharedPreferenceManager and get stored user data
            sharedPrefManager = new SharedPrefManager(this);
            mUsername = sharedPrefManager.getName();

            if (mUsername!=null&&mUsername.trim().length()!=0) {
                return true;
            }

        return false;
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    @Override
    public void onAnimationStart(Animation animation)
    {
    }
    @Override
    public void onAnimationEnd(Animation animation)
    {

        if(isFirstTime())
        {
            Intent myInt = new Intent(SplashActivity.this, NavDrawerActivity.class);
            startActivity(myInt);

        }
        else
        {

            Intent myInt=new Intent(SplashActivity.this,MainActivity.class);
            startActivity(myInt);

        }

    }
    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}