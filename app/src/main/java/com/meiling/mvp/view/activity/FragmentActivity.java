package com.meiling.mvp.view.activity;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.meiling.mvp.R;
import com.meiling.mvp.module.datautil.log.LogUtil;
import com.meiling.mvp.module.db.PhoneDBUtil;
import com.meiling.mvp.view.fragment.FirstFragment;
import com.meiling.mvp.view.fragmentv4.FirstFragmentV4;

import butterknife.ButterKnife;

//import android.support.v4.app.FragmentManager;

public class FragmentActivity extends AppCompatActivity {

    /**
     * ButterKnife 进行以来注入，对于不需要使用的组件最好不进行注入
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        ButterKnife.bind(this);
        setFragmentV4();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.getInstances().e("FragmentActivity onResume");
    }

    //FragmentManager 在一个Activity容器中只能使用一个
    public void setFragment(){
        //TODO android.app
        /*
03-02 09:35:39.689 29860-29860/? E/MVP_Frame: FragmentActivity onResume
03-02 09:35:39.694 29860-29860/? E/MVP_Frame: FirstFragment onResume
03-02 09:35:43.460 29860-29860/com.meiling.mvp E/MVP_Frame: onActivityResult requestCode:2000
03-02 09:35:43.466 29860-29860/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:35:43.471 29860-29860/com.meiling.mvp E/MVP_Frame: FirstFragment onResume
**********************************************************************************************
03-02 09:36:50.547 30579-30579/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:36:50.553 30579-30579/com.meiling.mvp E/MVP_Frame: FirstFragment onResume
03-02 09:37:45.280 30579-30579/com.meiling.mvp E/MVP_Frame: onActivityResult requestCode:2000
03-02 09:37:45.284 30579-30579/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:37:45.288 30579-30579/com.meiling.mvp E/MVP_Frame: FirstFragment onResume

         */
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new FirstFragment(),FirstFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
    /*
03-02 09:36:50.547 30579-30579/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:36:50.553 30579-30579/com.meiling.mvp E/MVP_Frame: FirstFragment onResume
03-02 09:37:45.280 30579-30579/com.meiling.mvp E/MVP_Frame: onActivityResult requestCode:2000
03-02 09:37:45.284 30579-30579/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:37:45.288 30579-30579/com.meiling.mvp E/MVP_Frame: FirstFragment onResume
**********************
03-02 09:38:20.247 31399-31399/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:38:20.253 31399-31399/com.meiling.mvp E/MVP_Frame: FirstFragmentV4 onResume
03-02 09:39:41.555 31399-31399/com.meiling.mvp E/MVP_Frame: onActivityResult requestCode:1000
03-02 09:39:41.557 31399-31399/com.meiling.mvp E/MVP_Frame: FragmentActivity onActivityResult requestCode:66536
03-02 09:39:41.562 31399-31399/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:39:41.567 31399-31399/com.meiling.mvp E/MVP_Frame: FirstFragmentV4 onResume
     */

    public void setFragmentV4(){
        //TODO  android.support.v4.app
        /*
03-02 09:34:47.888 29341-29341/? E/MVP_Frame: FragmentActivity onResume
03-02 09:34:47.894 29341-29341/? E/MVP_Frame: FirstFragmentV4 onResume
03-02 09:35:00.232 29341-29341/com.meiling.mvp E/MVP_Frame: onActivityResult requestCode:1000
03-02 09:35:00.235 29341-29341/com.meiling.mvp E/MVP_Frame: FragmentActivity onActivityResult
03-02 09:35:00.237 29341-29341/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:35:00.240 29341-29341/com.meiling.mvp E/MVP_Frame: FirstFragmentV4 onResume
*********************************************************************************************************
03-02 09:38:20.247 31399-31399/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:38:20.253 31399-31399/com.meiling.mvp E/MVP_Frame: FirstFragmentV4 onResume
03-02 09:39:41.555 31399-31399/com.meiling.mvp E/MVP_Frame: onActivityResult requestCode:1000
03-02 09:39:41.557 31399-31399/com.meiling.mvp E/MVP_Frame: FragmentActivity onActivityResult requestCode:66536
03-02 09:39:41.562 31399-31399/com.meiling.mvp E/MVP_Frame: FragmentActivity onResume
03-02 09:39:41.567 31399-31399/com.meiling.mvp E/MVP_Frame: FirstFragmentV4 onResume
         */
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new FirstFragmentV4(),FirstFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.getInstances().e("FragmentActivity onActivityResult requestCode:"+requestCode);
    }

    public void accessNet(){
        //TODO Only Retrofit
//        Retrofit retrofit = RetrofitUtil.getRetrofit();
//        LoginService loginService = retrofit.create(LoginService.class);
//        loginService.doLogin("8ABF29D717E0399C65BCA88F819DC795","1","18011935659")
//                .enqueue(new Callback<Login_Result>() {
//                    @Override
//                    public void onResponse(Call<Login_Result> call, Response<Login_Result> response) {
//                        Log.e("LOGUTIL",""+response.body().toString());
//                    }
//
//                    @Override
//                    public void onFailure(Call<Login_Result> call, Throwable t) {
//
//                    }
//                });
        //TODO Retrofit + RxJava
        //TODO Post Request
//        Retrofit retrofit = RetrofitUtil.getRetrofit("http://app.quanjiakan.com");
//        RxLoginService loginService = retrofit.create(RxLoginService.class);
//        loginService.doLogin("8ABF29D717E0399C65BCA88F819DC795","1","18011935659")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Login_Result>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("LOGUTIL","Error:"+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(Login_Result response) {
//                        Log.e("LOGUTIL","Result:"+response.toString());
//                    }
//                });
        //TODO Get Reqesut 含有重定向的Get请求 --  由于该网址不接受JSON数据，请求会出错
//        Retrofit retrofit = RetrofitUtil.getRetrofit("http://www.hao123.com");
//        RxGetRequest rxGetRequest = retrofit.create(RxGetRequest.class);
//        rxGetRequest.getReqesut()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("LOGUTIL","Error:"+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String response) {
//                        Log.e("LOGUTIL","Result:"+response.toString());
//                    }
//                });
        //TODO Get Reqesut 返回的数据是JSON格式，但返回类型使用的是String,会出错
        //http://app.quanjiakan.com/device/service?code=childWatch&type=watchlist&userid=11303
//        Retrofit retrofit = RetrofitUtil.getRetrofit("http://app.quanjiakan.com");
//        RxGetRequest2 rxGetRequest = retrofit.create(RxGetRequest2.class);
//        rxGetRequest.getReqesut("childWatch","watchlist","11303")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("LOGUTIL","Error:"+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(String response) {
//                        Log.e("LOGUTIL","Result:"+response.toString());
//                    }
//                });
        //TODO Get Reqesut ,Completed
//        Retrofit retrofit = RetrofitUtil.getRetrofit("http://app.quanjiakan.com");
//        RxGetRequest3 rxGetRequest = retrofit.create(RxGetRequest3.class);
//        rxGetRequest.getReqesut("childWatch","watchlist","11303")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<GetResult>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this, "Get Top Movie Completed", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("LOGUTIL","Error:"+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(GetResult response) {
//                        Log.e("LOGUTIL","Result:"+response.toString());
//                    }
//                });

//        PhoneDBUtil.getCallLogRecord(this);

//        PhoneDBUtil.getPhoneContacts(this);
//        PhoneDBUtil.getSIMContacts(this);
        PhoneDBUtil.getSmsInPhone(this);
    }

    public void showDialog_withAnimation(){
        final Dialog mDialog = new Dialog(this,R.style.CommonDialongStyle);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_common_hint, null);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        tv_title.setText(getString(R.string.title));

        TextView tv_content = (TextView) view.findViewById(R.id.tv_content);
        tv_content.setText(getString(R.string.content));

        TextView btn_cancel =  (TextView) view.findViewById(R.id.btn_cancel);
        btn_cancel.setText(getString(R.string.cancel));
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });

        TextView btn_confirm =  (TextView) view.findViewById(R.id.btn_confirm);
        btn_confirm.setText(getString(R.string.confirm));
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });


        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
        //TODO 这里的转换需要进行封装，做成统一的单位转换工具
        lp.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,getResources().getDisplayMetrics());
        lp.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,getResources().getDisplayMetrics());;
        lp.gravity = Gravity.CENTER;

        mDialog.setContentView(view, lp);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
    }

    //*********************************************************************************

}
