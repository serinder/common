/*
 * 
 */
package com.jaydenxiao.common.commonutils;


import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


/**
 * 描述：日期处理类.
 *
 */
@SuppressWarnings("all")
public class TimerUtils {

    private static int temp;

//    //计时器
    public static void  startTimer(int Countdown,  TimerListener timerListener) {
        temp = Countdown;
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread()).takeWhile(aLong -> {
                    if (temp == 0 || temp == -1) {
                        return false;
                    } else {
                        return true;
                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long o) {
                        temp--;
                        if (temp == 0) {
                            timerListener.onComplete();
                        } else if (temp == -1) {
                            //不做任何事情
                        } else {
                            timerListener.onLoading(temp);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }


                });
    }

    /*
     *停止计时器，不做任何动作
     */
    public static void stopTimer() {
        temp = -1;
    }

    /**
     * 停止计时器，并回调onComplete
     */
    public static void completed() {
        temp = 0;
    }

    public interface TimerListener {
        void onLoading(int next);

        void onComplete();
    }
}

