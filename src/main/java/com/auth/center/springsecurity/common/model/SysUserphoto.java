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
@TableName("sys_userphoto")
public class SysUserphoto extends Model<SysUserphoto> {

    private static final long serialVersionUID = 1L;

    @TableId("USERPHOTO_ID")
    private String userphotoId;
    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;
    /**
     * 原图
     */
    @TableField("PHOTO0")
    private String photo0;
    /**
     * 头像1
     */
    @TableField("PHOTO1")
    private String photo1;
    /**
     * 头像2
     */
    @TableField("PHOTO2")
    private String photo2;
    /**
     * 头像3
     */
    @TableField("PHOTO3")
    private String photo3;


    public String getUserphotoId() {
        return userphotoId;
    }

    public void setUserphotoId(String userphotoId) {
        this.userphotoId = userphotoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto0() {
        return photo0;
    }

    public void setPhoto0(String photo0) {
        this.photo0 = photo0;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    @Override
    protected Serializable pkVal() {
        return this.userphotoId;
    }

    @Override
    public String toString() {
        return "SysUserphoto{" +
        "userphotoId=" + userphotoId +
        ", username=" + username +
        ", photo0=" + photo0 +
        ", photo1=" + photo1 +
        ", photo2=" + photo2 +
        ", photo3=" + photo3 +
        "}";
    }
}
