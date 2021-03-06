package com.jaydenxiao.common.baserx;

import android.content.Context;

import com.google.gson.Gson;
import com.jaydenxiao.common.baseapp.BaseApplication;
import com.jaydenxiao.common.R;
import com.jaydenxiao.common.basebean.ErrorRespose;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.jaydenxiao.common.commonutils.NetWorkUtils;
import com.jaydenxiao.common.commonwidget.LoadingDialog;

//import org.reactivestreams.Subscriber;

//import rx.Subscriber;


import java.io.IOException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;
/**
 * des:订阅封装
 * Created by xsf
 * on 2016.09.10:16
 */
/********************使用例子********************/
/*_apiService.login(mobile, verifyCode)
        .//省略
        .subscribe(new RxSubscriber<User user>(mContext,false) {
@Override
public void _onNext(User user) {
        // 处理user
        }

@Override
public void _onError(String msg) {
        ToastUtil.showShort(mActivity, msg);
        });*/
public abstract class RxSubscriber<T> extends DisposableObserver<T> {

    private Context mContext;
    private String msg;
    private boolean showDialog=true;


    /**
     * 是否显示浮动dialog
     */
    public void showDialog() {
        this.showDialog= true;
    }
    public void hideDialog() {
        this.showDialog= true;
    }

    public RxSubscriber(Context context, String msg,boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog=showDialog;
    }
    public RxSubscriber(Context context) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading),false);
    }
    public RxSubscriber(Context context,boolean showDialog) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading),showDialog);
    }

//    @Override
//    public void onCompleted() {
//        if (showDialog)
//            LoadingDialog.cancelDialogForLoading();
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (showDialog) {
//            try {
//                LoadingDialog.showDialogForLoading((Activity) mContext,msg,true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }


    @Override
    public void onNext(T t) {

        _onNext(t);
    }
    @Override
    public void onError(Throwable e) {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            try{
                if(httpException.code() != 403){
                    String error = httpException.response().errorBody().string();
                    LogUtils.logd(error);
                    final Class<T>  responseClass = (Class<T>) ErrorRespose.class;
                    final T resp =  new Gson().fromJson(error,responseClass);
                    if (resp != null) {
                        _onError(((ErrorRespose)resp).getError().getMessage());
                    }
                }else{
                    _onError(BaseApplication.getAppContext().getString(R.string.net_error));
                }


            }catch(IOException e1) {
                e1.printStackTrace();
            }
        }
        //其它
        else {
            _onError(BaseApplication.getAppContext().getString(R.string.net_error));
        }
    }

    @Override
    public void onComplete() {
        if (showDialog)
            LoadingDialog.cancelDialogForLoading();
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);

}
