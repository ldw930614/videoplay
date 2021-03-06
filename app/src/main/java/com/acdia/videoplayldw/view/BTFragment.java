package com.acdia.videoplayldw.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acdia.videoplayldw.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BTFragment extends Fragment {

    Unbinder unbinder;

    public static BTFragment btFragment;

    public static BTFragment getInstance()
    {
        if(btFragment == null)
        {
            btFragment = new BTFragment();
        }
        return btFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bt, container, false);
        unbinder = ButterKnife.bind(this,view);
        initView();
        return view;
    }

    private void initView()
    {

    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
