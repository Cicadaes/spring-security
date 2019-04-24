/**
 * Project Name:bwtools-common
 * File Name:BaseJsonResult.java
 * Package Name:com.baiwang.cloud.common.model
 * Date:2017年10月20日上午11:08:23
 * Copyright (c) 2017, wuyuegang@baiwang.com All Rights Reserved.
 *
*/

package com.auth.center.springsecurity.common.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.List;

public class R<T> extends BaseJsonModel
{
    private static final long serialVersionUID = -7532190660864165247L;

    /**
     * 返回值的成功标志;true 为请求成功；false为请求失败
     * 所有返回成功数据的格式 success 必须为 true；
     * 所有异常数据  success必须为 false； 【异常包括参数校验错误、无返回数据、系统异常等等问题导致的异常数据】
     */
    @JSONField
    private boolean success = true;

    /**
     * 返回值为成功时的提示信息
     */
    @JSONField
    private String message = null;
    
    /**
     * 错误码，成功时为0，失败时由SystemErrorEnum枚举定义
     */
    @JSONField
    private String errorCode = "0";
    
    /**
     * 错误信息，成功是为null，失败时由SystemErrorEnum枚举定义
     */
    @JSONField
    private String errorMsg = null;

    /**
     * 请求唯一id
     */
    @JSONField
    private String requestId = null;
    /**
     * 分页返回的总条数
     */
    @JSONField
    private Integer total = 0;
    
    /**
     * 返回值list
     */
    @JSONField
    private List<T> data = new ArrayList<T>();
    
    /**
     * 
     * Creates a new instance of BaseJsonResult.
     *
     */
    public R()
    {
        
    }

    public static R error(String msg) {
        return error("500", msg);
    }


    public static R error(String code, String msg) {
        R r = new R();
        r.setSuccess(false);
        r.setErrorCode(code);
        r.setErrorMsg(msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.message="请求成功";
        r.data.add(msg);
        return r;
    }

    public static R ok() {
        R r = new R();
        r.message="请求成功";
        return r;    }

    /**
     * 
     * Creates a new instance of R.
     *
     * @param data
     */

    public R(List<T> data)
    {
        if (data != null && data.size() > 0)
        {
            this.data = data;
        }
        this.message="请求成功";
    }
    
    /**
     * 
     * Creates a new instance of R.
     *
     * @param data
     */
    public R(T data)
    {
        this.data.add(data);
    }
    
    public boolean isSuccess()
    {
        return success;
    }
    
    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getErrorCode()
    {
        return errorCode;
    }
    
    public String getErrorMsg()
    {
        return errorMsg;
    }
    
    public List<T> getData()
    {
        return data;
    }

    public Integer getTotal()
    {
        return total;
    }

    public void setTotal(Integer total)
    {
        this.total = total;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }
}
