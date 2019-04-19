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
@TableName("sys_fhbutton")
public class SysFhbutton extends Model<SysFhbutton> {

    private static final long serialVersionUID = 1L;

    @TableId("FHBUTTON_ID")
    private String fhbuttonId;
    /**
     * 名称
     */
    @TableField("NAME")
    private String name;
    /**
     * 权限标识
     */
    @TableField("QX_NAME")
    private String qxName;
    /**
     * 备注
     */
    @TableField("BZ")
    private String bz;


    public String getFhbuttonId() {
        return fhbuttonId;
    }

    public void setFhbuttonId(String fhbuttonId) {
        this.fhbuttonId = fhbuttonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQxName() {
        return qxName;
    }

    public void setQxName(String qxName) {
        this.qxName = qxName;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    protected Serializable pkVal() {
        return this.fhbuttonId;
    }

    @Override
    public String toString() {
        return "SysFhbutton{" +
        "fhbuttonId=" + fhbuttonId +
        ", name=" + name +
        ", qxName=" + qxName +
        ", bz=" + bz +
        "}";
    }
}
