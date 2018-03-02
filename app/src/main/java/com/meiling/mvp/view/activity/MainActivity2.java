package com.meiling.mvp.view.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.meiling.mvp.R;
import com.meiling.mvp.module.db.PhoneDBUtil;
import com.meiling.mvp.view.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity2 extends BaseActivity {

    /**
     * ButterKnife 进行以来注入，对于不需要使用的组件最好不进行注入
     */
    @BindView(R.id.click)
    TextView click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.click})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.click:
//                showDialog_withAnimation();
//                accessNet();
                finish();
                break;
        }
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
    @Override
    public View getView(int resourceID) {
        return null;
    }

    @Override
    public void setView(int resourceID, ViewTYPE viewTYPE, Object data) {

    }

    @Override
    public void setViewTag(int resourceID, ViewTYPE viewTYPE, Object data) {

    }

    @Override
    public Object getParamter(int type) {
        return null;
    }

    @Override
    public void showMyDialog(int type) {

    }

    @Override
    public void dismissMyDialog(int type) {

    }

    @Override
    public void onSuccess(int type, int httpResponseCode, Object result) {

    }

    @Override
    public void onError(int type, int httpResponseCode, Object errorMsg) {

    }
}
