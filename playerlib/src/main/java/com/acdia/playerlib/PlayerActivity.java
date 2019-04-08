package com.acdia.playerlib;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import java.net.URI;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = (VideoView)findViewById(R.id.videoplayer);
        playerVideo();


    }

    private void playerVideo()
    {
//        videoView.setOnPreparedListener();

        Uri uri = Uri.parse("/storage/emulated/0/MovieDownload/亲爱的艾琳.720p.BD中字[最新电影www.66e.cc].mp4");
//        Uri uri = Uri.parse("http://pic.ibaotu.com/00/20/08/96e888piCHck.mp4");
        videoView.setVideoURI(uri);
        videoView.start();
    }
}
