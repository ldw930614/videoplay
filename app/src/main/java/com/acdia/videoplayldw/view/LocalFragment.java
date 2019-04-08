package com.acdia.videoplayldw.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.acdia.playerlib.PlayerActivity;
import com.acdia.videoplayldw.R;
import com.acdia.videoplayldw.models.VideoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class LocalFragment extends Fragment {

    @BindView(R.id.toobar)
    Toolbar toobar;
    @BindView(R.id.listmovie)
    ListView listmovie;

    Unbinder unbinder;

    private static int LIST_FINISH = 1000;

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
                Toast.makeText(getActivity(),"搜索",Toast.LENGTH_LONG).show();

            Intent it = new Intent(getActivity(), PlayerActivity.class);

            startActivity(it);
            }
        });


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                getLocalMovie(getActivity());
            }
        });

        t1.start();
    }


    private Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what == LIST_FINISH)
            {
                List<VideoBean> list = (List<VideoBean>)msg.obj;
                String[] dataList = new String[list.size()];
                for(int i = 0;i<list.size();i++)
                {
                    Log.i("myPrint",list.get(i).getPath());
                    dataList[i] = list.get(i).getPath();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,dataList);
                listmovie.setAdapter(adapter);
            }
        }

    };


    private void getLocalMovie(Context context)
    {
        List<VideoBean> list = getVideoList(context);

        Message msg = Message.obtain();
        msg.what = LIST_FINISH;
        msg.obj = list;
        mHandler.sendMessage(msg);
    }

    public List<VideoBean> getVideoList(Context context) {
        List<VideoBean> sysVideoList = new ArrayList<>();

        String[] thumbColumns = {MediaStore.Video.Thumbnails.DATA,
                MediaStore.Video.Thumbnails.VIDEO_ID};

        String[] mediaColumns = {MediaStore.Video.Media._ID,
                MediaStore.Video.Media.DATA, MediaStore.Video.Media.DURATION};

        Cursor cursor = context.getContentResolver().query(MediaStore.Video.Media
                        .EXTERNAL_CONTENT_URI,
                mediaColumns, null, null, null);

        if (cursor == null) {
            return sysVideoList;
        }
        if (cursor.moveToFirst()) {
            do {
                VideoBean info = new VideoBean();
                int id = cursor.getInt(cursor
                        .getColumnIndex(MediaStore.Video.Media._ID));
                Cursor thumbCursor = context.getContentResolver().query(
                        MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                        thumbColumns, MediaStore.Video.Thumbnails.VIDEO_ID
                                + "=" + id, null, null);
                if (thumbCursor.moveToFirst()) {
                    info.setThumbPath(thumbCursor.getString(thumbCursor
                            .getColumnIndex(MediaStore.Video.Thumbnails.DATA)));
                }
                info.setPath(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media
                        .DATA)));
                info.setDuration(cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Video
                        .Media.DURATION)));
                sysVideoList.add(info);
            } while (cursor.moveToNext());

            if(cursor!=null){
                cursor.close();
            }
        }
        return sysVideoList;
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
