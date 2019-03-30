package com.acdia.videoplayldw;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.acdia.videoplayldw.view.BTFragment;
import com.acdia.videoplayldw.view.LocalFragment;

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
    private LocalFragment localFragment;

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
        homeFragment = BTFragment.getInstance();
        localFragment = LocalFragment.getInstance();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content,homeFragment);
        fragmentTransaction.add(R.id.content,localFragment);

        fragmentTransaction.show(homeFragment);
        fragmentTransaction.hide(localFragment);
        fragmentTransaction.commitAllowingStateLoss();
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

                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.show(homeFragment);
                fragmentTransaction1.hide(localFragment);
                fragmentTransaction1.commit();
                break;
            case 1:
                main.setSelected(false);
                localvideo.setSelected(true);
                aboutmine.setSelected(false);

                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.hide(homeFragment);
                fragmentTransaction2.show(localFragment);
                fragmentTransaction2.commit();
                break;
            case 2:
                main.setSelected(false);
                localvideo.setSelected(false);
                aboutmine.setSelected(true);

//                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction3.hide(homeFragment);
//                fragmentTransaction3.hide(localFragment);
//                fragmentTransaction3.commit();
                break;
            default:

                break;
        }
    }
}
