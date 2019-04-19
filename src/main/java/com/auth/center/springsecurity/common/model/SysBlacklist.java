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
@TableName("sys_blacklist")
public class SysBlacklist extends Model<SysBlacklist> {

    private static final long serialVersionUID = 1L;

    @TableId("BLACKLIST_ID")
    private String blacklistId;
    /**
     * IP
     */
    @TableField("IP")
    private String ip;
    /**
     * 备注
     */
    @TableField("BZ")
    private String bz;
    /**
     * 时间
     */
    @TableField("CTIME")
    private String ctime;


    public String getBlacklistId() {
        return blacklistId;
    }

    public void setBlacklistId(String blacklistId) {
        this.blacklistId = blacklistId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    protected Serializable pkVal() {
        return this.blacklistId;
    }

    @Override
    public String toString() {
        return "SysBlacklist{" +
        "blacklistId=" + blacklistId +
        ", ip=" + ip +
        ", bz=" + bz +
        ", ctime=" + ctime +
        "}";
    }
}
