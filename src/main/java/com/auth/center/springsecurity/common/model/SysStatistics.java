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
@TableName("sys_statistics")
public class SysStatistics extends Model<SysStatistics> {

    private static final long serialVersionUID = 1L;

    @TableId("STATISTICS_ID")
    private String statisticsId;
    /**
     * IP
     */
    @TableField("IP")
    private String ip;
    /**
     * 地区
     */
    @TableField("AREA")
    private String area;
    /**
     * 运营商
     */
    @TableField("OPERATOR")
    private String operator;
    /**
     * 日期
     */
    @TableField("CDATE")
    private String cdate;
    /**
     * 时间
     */
    @TableField("CTIME")
    private String ctime;
    @TableField("REGION")
    private String region;


    public String getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(String statisticsId) {
        this.statisticsId = statisticsId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    protected Serializable pkVal() {
        return this.statisticsId;
    }

    @Override
    public String toString() {
        return "SysStatistics{" +
        "statisticsId=" + statisticsId +
        ", ip=" + ip +
        ", area=" + area +
        ", operator=" + operator +
        ", cdate=" + cdate +
        ", ctime=" + ctime +
        ", region=" + region +
        "}";
    }
}
