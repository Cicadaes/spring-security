package com.auth.center.springsecurity.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 流水单信息表
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
public class Ticket extends Model<Ticket> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TICKET_ID", type = IdType.AUTO)
    private Long ticketId;
    /**
     * 机构编码
     */
    @TableField("ORG_CODE")
    private String orgCode;
    /**
     * 机构名称
     */
    @TableField("ORG_NAME")
    private String orgName;
    /**
     * 流水年月，YYYYMM
     */
    @TableField("TICKET_YM")
    private BigDecimal ticketYm;
    /**
     * 流水日期，YYYYMMDD
     */
    @TableField("TICKET_YMD")
    private BigDecimal ticketYmd;
    /**
     * 流水账单编号
     */
    @TableField("TICKET_SERIAL_NO")
    private String ticketSerialNo;
    /**
     * 发票类型代码 004：增值税纸质专用发票 007：增值税纸质普通发票 026：增值税电子普通发票
     */
    @TableField("INVOICE_TYPE_CODE")
    private String invoiceTypeCode;
    /**
     * 开票点编码
     */
    @TableField("INVOICE_TERMINAL_CODE")
    private String invoiceTerminalCode;
    /**
     * 销售方纳税人识别号
     */
    @TableField("SELLER_TAX_NO")
    private String sellerTaxNo;
    /**
     * 销售方名称
     */
    @TableField("SELLER_NAME")
    private String sellerName;
    /**
     * 销售方地址电话
     */
    @TableField("SELLER_ADDRESS_PHONE")
    private String sellerAddressPhone;
    /**
     * 销售方银行账号
     */
    @TableField("SELLER_BANK_ACCOUNT")
    private String sellerBankAccount;
    /**
     * 购买方纳税人识别
     */
    @TableField("BUYER_TAX_NO")
    private String buyerTaxNo;
    /**
     * 购买方名称
     */
    @TableField("BUYER_NAME")
    private String buyerName;
    /**
     * 购买方地址电话
     */
    @TableField("BUYER_ADDRESS_PHONE")
    private String buyerAddressPhone;
    /**
     * 购买方银行账号
     */
    @TableField("BUYER_BANK_ACCOUNT")
    private String buyerBankAccount;
    /**
     * 开票人
     */
    @TableField("DRAWER")
    private String drawer;
    /**
     * 收款人
     */
    @TableField("PAYEE")
    private String payee;
    /**
     * 复核人
     */
    @TableField("CHECKER")
    private String checker;
    /**
     * 发票开具类型 0蓝票 ；1红票
     */
    @TableField("INVOICE_TYPE")
    private Integer invoiceType;
    /**
     * 清单标志0：无清单1：带清单
     */
    @TableField("INVOICE_LIST_MARK")
    private Integer invoiceListMark;
    /**
     * 原发票代码
     */
    @TableField("ORIGINAL_INVOICE_CODE")
    private String originalInvoiceCode;
    /**
     * 原发票号码
     */
    @TableField("ORIGINAL_INVOICE_NO")
    private String originalInvoiceNo;
    /**
     * 征税方式 0：普通征税 2：差额征税
     */
    @TableField("TAXATION_MODE")
    private String taxationMode;
    /**
     * 扣除额
     */
    @TableField("DEDUCTIBLE_AMOUNT")
    private BigDecimal deductibleAmount;
    /**
     * 价税合计
     */
    @TableField("INVOICE_TOTAL_PRICE_TAX")
    private BigDecimal invoiceTotalPriceTax;
    /**
     * 合计金额
     */
    @TableField("INVOICE_TOTAL_PRICE")
    private BigDecimal invoiceTotalPrice;
    /**
     * 合计税额
     */
    @TableField("INVOICE_TOTAL_TAX")
    private BigDecimal invoiceTotalTax;
    /**
     * 编码表版本号,商品编码版本号
     */
    @TableField("GOODS_CODE_VERSION")
    private String goodsCodeVersion;
    /**
     * 含税标志
     */
    @TableField("PRICE_TAX_MARK")
    private String priceTaxMark;
    /**
     * 备注
     */
    @TableField("REMARKS")
    private String remarks;
    /**
     * 客户邮箱
     */
    @TableField("BUYER_EMAIL")
    private String buyerEmail;
    /**
     * 客户电话
     */
    @TableField("BUYER_PHONE")
    private String buyerPhone;
    /**
     * 购方类型：0[个人]、1[企业]
     */
    @TableField("BUYER_TYPE")
    private Integer buyerType;
    /**
     * 状态:1未开具
     */
    @TableField("STATUS")
    private Integer status;
    /**
     * 创建人ID
     */
    @TableField("CREATE_USER_ID")
    private String createUserId;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;
    /**
     * 更新人ID
     */
    @TableField("UPDATE_USER_ID")
    private String updateUserId;
    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;
    @TableField("RES1")
    private String res1;
    @TableField("RES2")
    private String res2;
    @TableField("RES3")
    private String res3;


    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getTicketSerialNo() {
        return ticketSerialNo;
    }

    public void setTicketSerialNo(String ticketSerialNo) {
        this.ticketSerialNo = ticketSerialNo;
    }

    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    public String getInvoiceTerminalCode() {
        return invoiceTerminalCode;
    }

    public void setInvoiceTerminalCode(String invoiceTerminalCode) {
        this.invoiceTerminalCode = invoiceTerminalCode;
    }

    public String getSellerTaxNo() {
        return sellerTaxNo;
    }

    public void setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddressPhone() {
        return sellerAddressPhone;
    }

    public void setSellerAddressPhone(String sellerAddressPhone) {
        this.sellerAddressPhone = sellerAddressPhone;
    }

    public String getSellerBankAccount() {
        return sellerBankAccount;
    }

    public void setSellerBankAccount(String sellerBankAccount) {
        this.sellerBankAccount = sellerBankAccount;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public void setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddressPhone() {
        return buyerAddressPhone;
    }

    public void setBuyerAddressPhone(String buyerAddressPhone) {
        this.buyerAddressPhone = buyerAddressPhone;
    }

    public String getBuyerBankAccount() {
        return buyerBankAccount;
    }

    public void setBuyerBankAccount(String buyerBankAccount) {
        this.buyerBankAccount = buyerBankAccount;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getInvoiceListMark() {
        return invoiceListMark;
    }

    public void setInvoiceListMark(Integer invoiceListMark) {
        this.invoiceListMark = invoiceListMark;
    }

    public String getOriginalInvoiceCode() {
        return originalInvoiceCode;
    }

    public void setOriginalInvoiceCode(String originalInvoiceCode) {
        this.originalInvoiceCode = originalInvoiceCode;
    }

    public String getOriginalInvoiceNo() {
        return originalInvoiceNo;
    }

    public void setOriginalInvoiceNo(String originalInvoiceNo) {
        this.originalInvoiceNo = originalInvoiceNo;
    }

    public String getTaxationMode() {
        return taxationMode;
    }

    public void setTaxationMode(String taxationMode) {
        this.taxationMode = taxationMode;
    }

    public BigDecimal getDeductibleAmount() {
        return deductibleAmount;
    }

    public void setDeductibleAmount(BigDecimal deductibleAmount) {
        this.deductibleAmount = deductibleAmount;
    }

    public BigDecimal getInvoiceTotalPriceTax() {
        return invoiceTotalPriceTax;
    }

    public void setInvoiceTotalPriceTax(BigDecimal invoiceTotalPriceTax) {
        this.invoiceTotalPriceTax = invoiceTotalPriceTax;
    }

    public BigDecimal getInvoiceTotalPrice() {
        return invoiceTotalPrice;
    }

    public void setInvoiceTotalPrice(BigDecimal invoiceTotalPrice) {
        this.invoiceTotalPrice = invoiceTotalPrice;
    }

    public BigDecimal getInvoiceTotalTax() {
        return invoiceTotalTax;
    }

    public void setInvoiceTotalTax(BigDecimal invoiceTotalTax) {
        this.invoiceTotalTax = invoiceTotalTax;
    }

    public String getGoodsCodeVersion() {
        return goodsCodeVersion;
    }

    public void setGoodsCodeVersion(String goodsCodeVersion) {
        this.goodsCodeVersion = goodsCodeVersion;
    }

    public String getPriceTaxMark() {
        return priceTaxMark;
    }

    public void setPriceTaxMark(String priceTaxMark) {
        this.priceTaxMark = priceTaxMark;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public Integer getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(Integer buyerType) {
        this.buyerType = buyerType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    @Override
    protected Serializable pkVal() {
        return this.ticketId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
        "ticketId=" + ticketId +
        ", orgCode=" + orgCode +
        ", orgName=" + orgName +
        ", ticketYm=" + ticketYm +
        ", ticketYmd=" + ticketYmd +
        ", ticketSerialNo=" + ticketSerialNo +
        ", invoiceTypeCode=" + invoiceTypeCode +
        ", invoiceTerminalCode=" + invoiceTerminalCode +
        ", sellerTaxNo=" + sellerTaxNo +
        ", sellerName=" + sellerName +
        ", sellerAddressPhone=" + sellerAddressPhone +
        ", sellerBankAccount=" + sellerBankAccount +
        ", buyerTaxNo=" + buyerTaxNo +
        ", buyerName=" + buyerName +
        ", buyerAddressPhone=" + buyerAddressPhone +
        ", buyerBankAccount=" + buyerBankAccount +
        ", drawer=" + drawer +
        ", payee=" + payee +
        ", checker=" + checker +
        ", invoiceType=" + invoiceType +
        ", invoiceListMark=" + invoiceListMark +
        ", originalInvoiceCode=" + originalInvoiceCode +
        ", originalInvoiceNo=" + originalInvoiceNo +
        ", taxationMode=" + taxationMode +
        ", deductibleAmount=" + deductibleAmount +
        ", invoiceTotalPriceTax=" + invoiceTotalPriceTax +
        ", invoiceTotalPrice=" + invoiceTotalPrice +
        ", invoiceTotalTax=" + invoiceTotalTax +
        ", goodsCodeVersion=" + goodsCodeVersion +
        ", priceTaxMark=" + priceTaxMark +
        ", remarks=" + remarks +
        ", buyerEmail=" + buyerEmail +
        ", buyerPhone=" + buyerPhone +
        ", buyerType=" + buyerType +
        ", status=" + status +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", updateUserId=" + updateUserId +
        ", updateTime=" + updateTime +
        ", res1=" + res1 +
        ", res2=" + res2 +
        ", res3=" + res3 +
        "}";
    }
}
