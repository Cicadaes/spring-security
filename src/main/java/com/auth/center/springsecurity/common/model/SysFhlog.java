package com.auth.center.springsecurity.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
@TableName("sys_fhlog")
public class SysFhlog extends Model<SysFhlog> {

    private static final long serialVersionUID = 1L;

    @TableId("FHLOG_ID")
    private String fhlogId;
    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;
    /**
     * 操作时间
     */
    @TableField("CZTIME")
    private String cztime;
    /**
     * 事件
     */
    @TableField("CONTENT")
    private String content;


    public String getFhlogId() {
        return fhlogId;
    }

    public void setFhlogId(String fhlogId) {
        this.fhlogId = fhlogId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCztime() {
        return cztime;
    }

    public void setCztime(String cztime) {
        this.cztime = cztime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Serializable pkVal() {
        return this.fhlogId;
    }

    @Override
    public String toString() {
        return "SysFhlog{" +
        "fhlogId=" + fhlogId +
        ", username=" + username +
        ", cztime=" + cztime +
        ", content=" + content +
        "}";
    }
}
