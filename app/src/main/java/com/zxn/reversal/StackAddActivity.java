package com.zxn.reversal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.dinuscxj.refresh.RecyclerRefreshLayout;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * RecyclerView 实现position列表倒序排列,批量更新数据
 * Created by zxn on 2018-11-05
 */
public class StackAddActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.rrl)
    RecyclerRefreshLayout rrl;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_add_more)
    Button btnAddMore;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_from_end);
        ButterKnife.bind(this);
        rrl.setEnabled(false);
        btnAddMore.setVisibility(View.VISIBLE);
        btnAddMore.setText("批量增加数据");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        layoutManager.setStackFromEnd(true);//列表再底部开始展示，反转后由上面开始展示
        layoutManager.setReverseLayout(true);//列表翻转

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter();
        recyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(data);
        getData();
    }

    private void getData() {
        for (int i = 0; i < 20; i++) {
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.name = "名字:" + i;
            data.add(itemInfo);
        }
        mAdapter.notifyDataSetChanged();
    }

    ArrayList<ItemInfo> data = new ArrayList<>();


    @OnClick({R.id.btn_add, R.id.btn_add_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                addItemSingle();
                break;
            case R.id.btn_add_more:
                addItem();
                break;
        }
    }

    private void addItemSingle() {
        Random random = new Random();
        int nextInt = random.nextInt();
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.name = "新来的:" + nextInt;
        data.add(0, itemInfo);
        mAdapter.notifyDataSetChanged();
    }

    private void addItem() {
        Random random = new Random();
        ArrayList<ItemInfo> newList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int nextInt = random.nextInt();
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.name = "新来的:" + nextInt;
            newList.add(itemInfo);
        }
        data.addAll(0, newList);
        mAdapter.notifyDataSetChanged();
    }

}
