package com.jaydenxiao.common.base;

/**
 * des:baseview
 * Created by xsf
 * on 2016.07.11:53
 */
public interface BaseView {
    /*******内嵌加载*******/
    void showLoading(String title);
    void stopLoading();
    void showErrorTip(String msg);
    /**
     * 错误码
     */
    void onErrorCode(BaseModel model);
//    /**
//     * 进度条显示
//     */
//    void showProgress();
//
//    /**
//     * 进度条隐藏
//     */
//    void hideProgress();
//
//    /**
//     * 文件下载进度监听
//     *
//     * @param progress
//     */
//    void onProgress(int progress);
}
