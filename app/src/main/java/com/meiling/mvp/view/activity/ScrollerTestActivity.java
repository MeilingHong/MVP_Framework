package com.meiling.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.meiling.mvp.R;

import butterknife.ButterKnife;

public class ScrollerTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller_test);
        ButterKnife.bind(this);
    }
}
