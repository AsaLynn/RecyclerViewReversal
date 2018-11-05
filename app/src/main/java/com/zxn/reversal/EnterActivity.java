package com.zxn.reversal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zxn on 2018-10-23 20:17:19.
 */
public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_pull_down_load_more, R.id.btn_msg_top, R.id.btn_msg_reverse, R.id.btn_msgs_reverse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_pull_down_load_more:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_msg_top:
                startActivity(new Intent(this, TopItemActivity.class));
                break;
            case R.id.btn_msg_reverse:
                startActivity(new Intent(this, StackFromEndActivity.class));
                break;
            case R.id.btn_msgs_reverse:
                startActivity(new Intent(this, StackAddActivity.class));
                break;
        }
    }
}
