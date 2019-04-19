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
@TableName("sys_codeeditor")
public class SysCodeeditor extends Model<SysCodeeditor> {

    private static final long serialVersionUID = 1L;

    @TableId("CODEEDITOR_ID")
    private String codeeditorId;
    /**
     * 类型
     */
    @TableField("TYPE")
    private String type;
    /**
     * 文件名
     */
    @TableField("FTLNMAME")
    private String ftlnmame;
    /**
     * 创建时间
     */
    @TableField("CTIME")
    private String ctime;
    /**
     * 代码
     */
    @TableField("CODECONTENT")
    private String codecontent;


    public String getCodeeditorId() {
        return codeeditorId;
    }

    public void setCodeeditorId(String codeeditorId) {
        this.codeeditorId = codeeditorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFtlnmame() {
        return ftlnmame;
    }

    public void setFtlnmame(String ftlnmame) {
        this.ftlnmame = ftlnmame;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCodecontent() {
        return codecontent;
    }

    public void setCodecontent(String codecontent) {
        this.codecontent = codecontent;
    }

    @Override
    protected Serializable pkVal() {
        return this.codeeditorId;
    }

    @Override
    public String toString() {
        return "SysCodeeditor{" +
        "codeeditorId=" + codeeditorId +
        ", type=" + type +
        ", ftlnmame=" + ftlnmame +
        ", ctime=" + ctime +
        ", codecontent=" + codecontent +
        "}";
    }
}
