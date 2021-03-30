package com.jaydenxiao.common.basebean;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * Created by xsf
 * on 2016.09.9:47
 */
public class BaseRespose <T> implements Serializable {
    public int status;
    public String msg;
    public T data;
    public boolean success(){
        return status == 200;
    }
//    public String code;
//    public String msg;
//
//    public T data;
//
//    public boolean success() {
//        return "1".equals(code);
//    }

//    @Override
//    public String toString() {
//        return "BaseRespose{" +
//                "code='" + code + '\'' +
//                ", msg='" + msg + '\'' +
//                ", data=" + data +
//                '}';
//    }
}
