package com.androidmorefast.pc.appejemplosplashscreen;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends FragmentActivity {

    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.contenedor, new SplashScreenFragment()).commit();
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.animator.voltear_izquierda,
                         R.animator.salir_a_la_izquierda)
                        .replace(R.id.contenedor, new MainFragment()).commit();
            }
        };
        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

}
