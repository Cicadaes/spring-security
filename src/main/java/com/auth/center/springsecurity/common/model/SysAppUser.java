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
@TableName("sys_app_user")
public class SysAppUser extends Model<SysAppUser> {

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
    @TableField("PHONE")
    private String phone;
    @TableField("SFID")
    private String sfid;
    @TableField("START_TIME")
    private String startTime;
    @TableField("END_TIME")
    private String endTime;
    @TableField("YEARS")
    private Integer years;
    @TableField("NUMBER")
    private String number;
    @TableField("EMAIL")
    private String email;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSfid() {
        return sfid;
    }

    public void setSfid(String sfid) {
        this.sfid = sfid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysAppUser{" +
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
        ", phone=" + phone +
        ", sfid=" + sfid +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", years=" + years +
        ", number=" + number +
        ", email=" + email +
        "}";
    }
}
