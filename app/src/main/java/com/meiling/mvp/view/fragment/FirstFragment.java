package com.meiling.mvp.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meiling.mvp.R;
import com.meiling.mvp.module.datautil.LogUtil;
import com.meiling.mvp.view.activity.MainActivity2;

/**
 * Created by Administrator on 8:57.
 *
 * @package com.meiling.mvp.view.fragmentv4
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-03-02   08:57
 */

public class FirstFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        TextView click = (TextView) view.findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivityForResult(intent,2000);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        LogUtil.getInstances().e("onActivityResult requestCode:"+requestCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtil.getInstances().e("FirstFragment onResume");
    }
}
