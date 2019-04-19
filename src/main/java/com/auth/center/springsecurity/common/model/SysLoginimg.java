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
@TableName("sys_loginimg")
public class SysLoginimg extends Model<SysLoginimg> {

    private static final long serialVersionUID = 1L;

    @TableId("LOGINIMG_ID")
    private String loginimgId;
    /**
     * 文件名
     */
    @TableField("NAME")
    private String name;
    /**
     * 路径
     */
    @TableField("FILEPATH")
    private String filepath;
    /**
     * 状态
     */
    @TableField("TYPE")
    private Integer type;
    /**
     * 排序
     */
    @TableField("FORDER")
    private Integer forder;


    public String getLoginimgId() {
        return loginimgId;
    }

    public void setLoginimgId(String loginimgId) {
        this.loginimgId = loginimgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getForder() {
        return forder;
    }

    public void setForder(Integer forder) {
        this.forder = forder;
    }

    @Override
    protected Serializable pkVal() {
        return this.loginimgId;
    }

    @Override
    public String toString() {
        return "SysLoginimg{" +
        "loginimgId=" + loginimgId +
        ", name=" + name +
        ", filepath=" + filepath +
        ", type=" + type +
        ", forder=" + forder +
        "}";
    }
}
