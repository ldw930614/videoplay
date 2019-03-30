package com.acdia.videoplayldw.splash;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.acdia.videoplayldw.MainActivity;
import com.acdia.videoplayldw.R;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_DELAY_TIME = 2000;//毫秒
    private static final int ISOK = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.sendEmptyMessageDelayed(ISOK,SPLASH_DELAY_TIME);
    }

    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what)
            {
                case 1000:
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }

        }
    };
}
