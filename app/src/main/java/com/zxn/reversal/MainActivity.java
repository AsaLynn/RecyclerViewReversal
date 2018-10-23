package com.zxn.reversal;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dinuscxj.refresh.RecyclerRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zxn on 2018-10-22 17:21:23.
 */
public class MainActivity extends AppCompatActivity implements RecyclerRefreshLayout.OnRefreshListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    RecyclerRefreshLayout refreshLayout;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        refreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter();
        recyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(data);
        getData();
    }

    ArrayList<ItemInfo> data = new ArrayList<>();

    private void getData() {
        for (int i = items * (page - 1); i < items * page; i++) {
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.name = "名字" + i;
            data.add(itemInfo);
        }
        mAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    private int page = 1;
    private int items = 10;

    @Override
    public void onRefresh() {
        page++;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
            }
        }, 2 * 1000);
    }

    private Handler handler = new Handler();
}
