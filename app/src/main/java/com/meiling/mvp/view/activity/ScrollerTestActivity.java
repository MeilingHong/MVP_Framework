package com.meiling.mvp.view.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import com.meiling.mvp.R;
import com.meiling.mvp.module.datautil.LogUtil;
import com.meiling.mvp.module.db.PhoneDBUtil;
import com.meiling.mvp.view.widget.MyVerticalScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollerTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_test);
        ButterKnife.bind(this);
    }
}
