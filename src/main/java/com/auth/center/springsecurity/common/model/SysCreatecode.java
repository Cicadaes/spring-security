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
@TableName("sys_createcode")
public class SysCreatecode extends Model<SysCreatecode> {

    private static final long serialVersionUID = 1L;

    @TableId("CREATECODE_ID")
    private String createcodeId;
    /**
     * 包名
     */
    @TableField("PACKAGENAME")
    private String packagename;
    /**
     * 类名
     */
    @TableField("OBJECTNAME")
    private String objectname;
    /**
     * 表名
     */
    @TableField("TABLENAME")
    private String tablename;
    /**
     * 属性集
     */
    @TableField("FIELDLIST")
    private String fieldlist;
    /**
     * 创建时间
     */
    @TableField("CREATETIME")
    private String createtime;
    /**
     * 描述
     */
    @TableField("TITLE")
    private String title;
    @TableField("FHTYPE")
    private String fhtype;


    public String getCreatecodeId() {
        return createcodeId;
    }

    public void setCreatecodeId(String createcodeId) {
        this.createcodeId = createcodeId;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getObjectname() {
        return objectname;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getFieldlist() {
        return fieldlist;
    }

    public void setFieldlist(String fieldlist) {
        this.fieldlist = fieldlist;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFhtype() {
        return fhtype;
    }

    public void setFhtype(String fhtype) {
        this.fhtype = fhtype;
    }

    @Override
    protected Serializable pkVal() {
        return this.createcodeId;
    }

    @Override
    public String toString() {
        return "SysCreatecode{" +
        "createcodeId=" + createcodeId +
        ", packagename=" + packagename +
        ", objectname=" + objectname +
        ", tablename=" + tablename +
        ", fieldlist=" + fieldlist +
        ", createtime=" + createtime +
        ", title=" + title +
        ", fhtype=" + fhtype +
        "}";
    }
}
