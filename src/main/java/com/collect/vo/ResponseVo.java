package com.collect.vo;

import java.io.Serializable;

/**
 * restful统一返回对象
 * Created by nina_nyang on 2018/4/28.
 */
public class ResponseVo implements Serializable{

    private static final long serialVersionUID = -2285073332607128679L;
    /**
     * 成功标识
     */
    private boolean success;


    /**
     * 错误信息
     */
    private String message;

    /**
     * 错误码
     */
    private int code;


    /**
     * 返回对象
     */
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
