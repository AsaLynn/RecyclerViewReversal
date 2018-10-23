package com.zxn.reversal;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by zxn on 2018/10/22.
 */
public class MyAdapter extends BaseQuickAdapter<ItemInfo, BaseViewHolder> {

    public MyAdapter(@Nullable List<ItemInfo> data) {
        super(data);
    }

    public MyAdapter() {
        super(R.layout.item_applet);
    }

    @Override
    protected void convert(BaseViewHolder helper, ItemInfo item) {
        helper.setText(R.id.tv_name, item.name);
    }
}
