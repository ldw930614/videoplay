package com.acdia.videoplayldw.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.acdia.videoplayldw.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class LocalFragment extends Fragment {

    @BindView(R.id.toobar)
    Toolbar toobar;

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

        toobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"aaa",Toast.LENGTH_LONG).show();
            }
        });
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
