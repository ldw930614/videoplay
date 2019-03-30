package com.acdia.videoplayldw.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acdia.videoplayldw.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public class LocalFragment extends Fragment {


    Unbinder unbinder;

    public static LocalFragment localFragment;

    public static LocalFragment getInstance()
    {
        if(localFragment == null)
        {
            localFragment = new LocalFragment();
        }
        return localFragment;
    }
    public LocalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_local, container, false);
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
