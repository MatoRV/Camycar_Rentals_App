package com.example.camycarrentals.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.camycarrentals.R;
import com.example.camycarrentals.View.UsuarioView.LoginActivity;

public class SplashView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_animation1);
        ImageView splash = findViewById(R.id.ivSplash);
        splash.startAnimation(animation1);
        //        RotateAnimation anim = new RotateAnimation(0f, 350f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 1f);
        //        anim.setInterpolator(new LinearInterpolator());
        //        anim.setRepeatCount(Animation.INFINITE);
        //        anim.setDuration(1000);
        //        final ImageView splash = (ImageView) findViewById(R.id.ivSplash);
        //        splash.startAnimation(anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashView.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_animation, R.anim.static_animation);
                finish();
                splash.setAnimation(null);
            }
        }, 2000);
    }
}