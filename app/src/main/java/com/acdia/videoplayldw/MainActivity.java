package com.acdia.videoplayldw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.acdia.videoplayldw.view.BTFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.main)
    TextView main;
    @BindView(R.id.localvideo)
    TextView localvideo;
    @BindView(R.id.aboutmine)
    TextView aboutmine;

    private BTFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }


    private void initView()
    {
        main.setOnClickListener(this);
        localvideo.setOnClickListener(this);
        aboutmine.setOnClickListener(this);

        main.setSelected(true);
//        homeFragment =BTFragment.instantiate()
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.main:
                togglefrag(0);
                break;
            case R.id.localvideo:
                togglefrag(1);
                break;
            case R.id.aboutmine:
                togglefrag(2);
                break;
        }
    }

    public void togglefrag(int pageNum)
    {
        switch (pageNum)
        {
            case 0:
                main.setSelected(true);
                localvideo.setSelected(false);
                aboutmine.setSelected(false);
                break;
            case 1:
                main.setSelected(false);
                localvideo.setSelected(true);
                aboutmine.setSelected(false);
                break;
            case 2:
                main.setSelected(false);
                localvideo.setSelected(false);
                aboutmine.setSelected(true);
                break;
            default:

                break;
        }
    }
}
