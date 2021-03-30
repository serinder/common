package com.jaydenxiao.common.basebean;

import java.io.Serializable;

/**
 * des:封装服务器返回数据
 * Created by xsf
 * on 2016.09.9:47
 */
public class ErrorRespose implements Serializable {
    private Error error;
    public void setError(Error error) {
        this.error = error;
    }
    public Error getError() {
        return error;
    }

    public class Error {

        private int code;
        private String message;
        public void setCode(int code) {
            this.code = code;
        }
        public int getCode() {
            return code;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }

    }
}
