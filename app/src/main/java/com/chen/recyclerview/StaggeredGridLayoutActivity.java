package com.chen.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class StaggeredGridLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private RecyclerViewStaggeredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();
        mAdapter = new RecyclerViewStaggeredAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onLongItemClick(View view, int position) {

                mAdapter.deleteData(position);
            }
        });
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
//
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        int id = item.getItemId();
//        switch (id) {
//            case R.id.action_add:
//
//                mAdapter.addData(1);
//                break;
//
//            case R.id.action_delete:
//                mAdapter.deleteData(1);
//                break;
//            case R.id.action_gridview:
//
//                mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
//                break;
//
//            case R.id.action_listview:
//
//                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//                break;
//
//            case R.id.action_hor_gridview:
//                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
//                break;
//
//            case R.id.action_staggered:
//
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }
}
