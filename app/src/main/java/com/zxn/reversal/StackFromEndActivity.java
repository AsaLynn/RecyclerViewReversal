package com.zxn.reversal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dinuscxj.refresh.RecyclerRefreshLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * RecyclerView 实现position列表倒序排列
 * Created by zxn on 2018-10-25 19:14:04.
 */
public class StackFromEndActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.rrl)
    RecyclerRefreshLayout rrl;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_from_end);
        ButterKnife.bind(this);
        rrl.setEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        layoutManager.setStackFromEnd(true);//列表再底部开始展示，反转后由上面开始展示
        layoutManager.setReverseLayout(true);//列表翻转

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter();
        recyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(data);
//        getData();
        rrl.setRefreshing(false);
    }

    ArrayList<ItemInfo> data = new ArrayList<>();


    private int page = 1;
    private int items = 10;

    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        addItem();
    }

    private void addItem() {
        Random random = new Random();
        int i = random.nextInt();
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.name = "名字:" + i;
        Collections.reverse(data);
        data.add(itemInfo);
        Collections.reverse(data);
        mAdapter.notifyDataSetChanged();
        //recyclerView.smoothScrollToPosition(0);
    }
}
