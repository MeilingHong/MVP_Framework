package com.meiling.framework.common;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 11:59.
 *
 * @package com.meiling.framework
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-02-27   11:59
 */

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
