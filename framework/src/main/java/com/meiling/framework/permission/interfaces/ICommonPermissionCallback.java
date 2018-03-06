package com.meiling.framework.permission.interfaces;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 8:58.
 *
 * @package com.meiling.framework.permission
 * @auther By MeilingHong
 * @emall marisareimu123@gmail.com
 * @date 2018-03-05   08:58
 */

public interface ICommonPermissionCallback {
    void onRequestPermissionsResultCallback(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults);
}
