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
@TableName("sys_dictionaries")
public class SysDictionaries extends Model<SysDictionaries> {

    private static final long serialVersionUID = 1L;

    @TableId("DICTIONARIES_ID")
    private String dictionariesId;
    /**
     * 名称
     */
    @TableField("NAME")
    private String name;
    /**
     * 英文
     */
    @TableField("NAME_EN")
    private String nameEn;
    /**
     * 编码
     */
    @TableField("BIANMA")
    private String bianma;
    /**
     * 排序
     */
    @TableField("ORDER_BY")
    private Integer orderBy;
    /**
     * 上级ID
     */
    @TableField("PARENT_ID")
    private String parentId;
    /**
     * 备注
     */
    @TableField("BZ")
    private String bz;
    /**
     * 排查表
     */
    @TableField("TBSNAME")
    private String tbsname;


    public String getDictionariesId() {
        return dictionariesId;
    }

    public void setDictionariesId(String dictionariesId) {
        this.dictionariesId = dictionariesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getBianma() {
        return bianma;
    }

    public void setBianma(String bianma) {
        this.bianma = bianma;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getTbsname() {
        return tbsname;
    }

    public void setTbsname(String tbsname) {
        this.tbsname = tbsname;
    }

    @Override
    protected Serializable pkVal() {
        return this.dictionariesId;
    }

    @Override
    public String toString() {
        return "SysDictionaries{" +
        "dictionariesId=" + dictionariesId +
        ", name=" + name +
        ", nameEn=" + nameEn +
        ", bianma=" + bianma +
        ", orderBy=" + orderBy +
        ", parentId=" + parentId +
        ", bz=" + bz +
        ", tbsname=" + tbsname +
        "}";
    }
}
