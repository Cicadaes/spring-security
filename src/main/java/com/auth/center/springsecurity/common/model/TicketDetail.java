package com.auth.center.springsecurity.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 流水单明细表
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
@TableName("TICKET_DETAIL")
public class TicketDetail extends Model<TicketDetail> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DETAIL_ID", type = IdType.AUTO)
    private Long detailId;
    /**
     * 流水ID
     */
    @TableField("TICKET_ID")
    private Long ticketId;
    /**
     * 发票年月，YYYYMM
     */
    @TableField("TICKET_YM")
    private BigDecimal ticketYm;
    /**
     * 发票日期，YYYYMMDD
     */
    @TableField("TICKET_YMD")
    private BigDecimal ticketYmd;
    /**
     * 行号
     */
    @TableField("GOODS_LINE_NO")
    private Integer goodsLineNo;
    /**
     * 发票行性质 0：正常行，1：折扣行，2：被折扣行
     */
    @TableField("GOODS_LINE_NATURE")
    private Integer goodsLineNature;
    /**
     * 商品编码
     */
    @TableField("GOODS_CODE")
    private String goodsCode;
    /**
     * 纳税人自行编码
     */
    @TableField("GOODS_EXTEND_CODE")
    private String goodsExtendCode;
    /**
     * 商品名称
     */
    @TableField("GOODS_NAME")
    private String goodsName;
    /**
     * 商品税目
     */
    @TableField("GOODS_TAX_ITEM")
    private String goodsTaxItem;
    /**
     * 规格型号
     */
    @TableField("GOODS_SPECIFICATION")
    private String goodsSpecification;
    /**
     * 单位
     */
    @TableField("GOODS_UNIT")
    private String goodsUnit;
    /**
     * 商品数量
     */
    @TableField("GOODS_QUANTITY")
    private BigDecimal goodsQuantity;
    /**
     * 商品单价
     */
    @TableField("GOODS_PRICE")
    private BigDecimal goodsPrice;
    /**
     * 商品金额
     */
    @TableField("GOODS_TOTAL_PRICE")
    private BigDecimal goodsTotalPrice;
    /**
     * 税额
     */
    @TableField("GOODS_TOTAL_TAX")
    private BigDecimal goodsTotalTax;
    /**
     * 税率
     */
    @TableField("GOODS_TAX_RATE")
    private BigDecimal goodsTaxRate;
    /**
     * 折行对应行号
     */
    @TableField("GOODS_DISCOUNT_LINE_NO")
    private Integer goodsDiscountLineNo;
    /**
     * 增值税特殊管理
     */
    @TableField("VAT_SPECIAL_MANAGEMENT")
    private String vatSpecialManagement;
    /**
     * 零税率标识：空代表无， 1 出口免税和其他免税优惠政策， 2 不征增值税， 3 普通零税率
     */
    @TableField("FREE_TAX_MARKL")
    private String freeTaxMarkl;
    /**
     * 是否使用优惠政策 0:未使用，1:使用
     */
    @TableField("PREFERENTIAL_MARK")
    private String preferentialMark;
    /**
     * 更新人
     */
    @TableField("UPDATE_USER_ID")
    private String updateUserId;
    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;
    /**
     * 创建人
     */
    @TableField("CREATE_USER_ID")
    private String createUserId;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;


    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public BigDecimal getTicketYm() {
        return ticketYm;
    }

    public void setTicketYm(BigDecimal ticketYm) {
        this.ticketYm = ticketYm;
    }

    public BigDecimal getTicketYmd() {
        return ticketYmd;
    }

    public void setTicketYmd(BigDecimal ticketYmd) {
        this.ticketYmd = ticketYmd;
    }

    public Integer getGoodsLineNo() {
        return goodsLineNo;
    }

    public void setGoodsLineNo(Integer goodsLineNo) {
        this.goodsLineNo = goodsLineNo;
    }

    public Integer getGoodsLineNature() {
        return goodsLineNature;
    }

    public void setGoodsLineNature(Integer goodsLineNature) {
        this.goodsLineNature = goodsLineNature;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsExtendCode() {
        return goodsExtendCode;
    }

    public void setGoodsExtendCode(String goodsExtendCode) {
        this.goodsExtendCode = goodsExtendCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTaxItem() {
        return goodsTaxItem;
    }

    public void setGoodsTaxItem(String goodsTaxItem) {
        this.goodsTaxItem = goodsTaxItem;
    }

    public String getGoodsSpecification() {
        return goodsSpecification;
    }

    public void setGoodsSpecification(String goodsSpecification) {
        this.goodsSpecification = goodsSpecification;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public BigDecimal getGoodsQuantity() {
        return goodsQuantity;
    }

    public void setGoodsQuantity(BigDecimal goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public BigDecimal getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(BigDecimal goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public BigDecimal getGoodsTotalTax() {
        return goodsTotalTax;
    }

    public void setGoodsTotalTax(BigDecimal goodsTotalTax) {
        this.goodsTotalTax = goodsTotalTax;
    }

    public BigDecimal getGoodsTaxRate() {
        return goodsTaxRate;
    }

    public void setGoodsTaxRate(BigDecimal goodsTaxRate) {
        this.goodsTaxRate = goodsTaxRate;
    }

    public Integer getGoodsDiscountLineNo() {
        return goodsDiscountLineNo;
    }

    public void setGoodsDiscountLineNo(Integer goodsDiscountLineNo) {
        this.goodsDiscountLineNo = goodsDiscountLineNo;
    }

    public String getVatSpecialManagement() {
        return vatSpecialManagement;
    }

    public void setVatSpecialManagement(String vatSpecialManagement) {
        this.vatSpecialManagement = vatSpecialManagement;
    }

    public String getFreeTaxMarkl() {
        return freeTaxMarkl;
    }

    public void setFreeTaxMarkl(String freeTaxMarkl) {
        this.freeTaxMarkl = freeTaxMarkl;
    }

    public String getPreferentialMark() {
        return preferentialMark;
    }

    public void setPreferentialMark(String preferentialMark) {
        this.preferentialMark = preferentialMark;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.detailId;
    }

    @Override
    public String toString() {
        return "TicketDetail{" +
        "detailId=" + detailId +
        ", ticketId=" + ticketId +
        ", ticketYm=" + ticketYm +
        ", ticketYmd=" + ticketYmd +
        ", goodsLineNo=" + goodsLineNo +
        ", goodsLineNature=" + goodsLineNature +
        ", goodsCode=" + goodsCode +
        ", goodsExtendCode=" + goodsExtendCode +
        ", goodsName=" + goodsName +
        ", goodsTaxItem=" + goodsTaxItem +
        ", goodsSpecification=" + goodsSpecification +
        ", goodsUnit=" + goodsUnit +
        ", goodsQuantity=" + goodsQuantity +
        ", goodsPrice=" + goodsPrice +
        ", goodsTotalPrice=" + goodsTotalPrice +
        ", goodsTotalTax=" + goodsTotalTax +
        ", goodsTaxRate=" + goodsTaxRate +
        ", goodsDiscountLineNo=" + goodsDiscountLineNo +
        ", vatSpecialManagement=" + vatSpecialManagement +
        ", freeTaxMarkl=" + freeTaxMarkl +
        ", preferentialMark=" + preferentialMark +
        ", updateUserId=" + updateUserId +
        ", updateTime=" + updateTime +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        "}";
    }
}
