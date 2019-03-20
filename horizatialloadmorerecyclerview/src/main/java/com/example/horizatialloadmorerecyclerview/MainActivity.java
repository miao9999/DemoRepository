package com.example.horizatialloadmorerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private PulToLeftViewGroup pull_group;
    private PullAdapter mAdapter;
    private View moved_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_hsv_type_content);
        moved_view = (RelativeLayout) findViewById(R.id.moved_view);
        pull_group = (PulToLeftViewGroup) findViewById(R.id.pull_group);
        pull_group.setMoveViews(moved_view);
        List<String> strings = new LinkedList<>();
        for (int ii = 0; ii < 6; ii++) {
            String str = "";
            strings.add(str);
        }
        mAdapter = new PullAdapter(this,strings);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        mRecyclerView.addItemDecoration(new PullAdapter().SpacesItemDecoration(0, 50, 0, 0));
        mRecyclerView.setAdapter(mAdapter);
        pull_group.setOnPullToLeftListener(new PulToLeftViewGroup.OnPullToLeftListener() {
            @Override
            public void onReleaseFingerToUpload() {
                for (int ii = 0; ii < 6; ii++) {
                    String str = "";
                    mAdapter.addItem(str);
                    Toast.makeText(MainActivity.this, "loadmore", Toast.LENGTH_SHORT).show();
//                    mAdapter.setData();
                }

                mAdapter.notifyDataSetChanged();
                pull_group.completeToUpload();
            }

            @Override
            public void onStartToUpload() {

            }
        });
    }


    private void initView() {
       mRecyclerView  = (RecyclerView) findViewById(R.id.rv_hsv_type_content);
        pull_group = (PulToLeftViewGroup) findViewById(R.id.pull_group);
    }
}

