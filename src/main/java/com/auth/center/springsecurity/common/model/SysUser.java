package com.auth.center.springsecurity.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @TableId("USER_ID")
    private String userId;
    @TableField("USERNAME")
    private String username;
    @TableField("PASSWORD")
    private String password;
    @TableField("NAME")
    private String name;
    @TableField("RIGHTS")
    private String rights;
    @TableField("ROLE_ID")
    private String roleId;
    @TableField("LAST_LOGIN")
    private String lastLogin;
    @TableField("IP")
    private String ip;
    @TableField("STATUS")
    private String status;
    @TableField("BZ")
    private String bz;
    @TableField("SKIN")
    private String skin;
    @TableField("EMAIL")
    private String email;
    @TableField("NUMBER")
    private String number;
    @TableField("PHONE")
    private String phone;
    @TableField("ENABLED")
    private Integer enabled;
    @TableField("LASTPASSWORDRESETDATE")
    private Date lastpasswordresetdate;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getLastpasswordresetdate() {
        return lastpasswordresetdate;
    }

    public void setLastpasswordresetdate(Date lastpasswordresetdate) {
        this.lastpasswordresetdate = lastpasswordresetdate;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "userId=" + userId +
        ", username=" + username +
        ", password=" + password +
        ", name=" + name +
        ", rights=" + rights +
        ", roleId=" + roleId +
        ", lastLogin=" + lastLogin +
        ", ip=" + ip +
        ", status=" + status +
        ", bz=" + bz +
        ", skin=" + skin +
        ", email=" + email +
        ", number=" + number +
        ", phone=" + phone +
        ", enabled=" + enabled +
        ", lastpasswordresetdate=" + lastpasswordresetdate +
        "}";
    }
}
