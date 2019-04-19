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
@TableName("sys_role_fhbutton")
public class SysRoleFhbutton extends Model<SysRoleFhbutton> {

    private static final long serialVersionUID = 1L;

    @TableId("RB_ID")
    private String rbId;
    @TableField("ROLE_ID")
    private String roleId;
    @TableField("BUTTON_ID")
    private String buttonId;


    public String getRbId() {
        return rbId;
    }

    public void setRbId(String rbId) {
        this.rbId = rbId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    @Override
    protected Serializable pkVal() {
        return this.rbId;
    }

    @Override
    public String toString() {
        return "SysRoleFhbutton{" +
        "rbId=" + rbId +
        ", roleId=" + roleId +
        ", buttonId=" + buttonId +
        "}";
    }
}
