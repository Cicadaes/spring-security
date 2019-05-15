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
 * 发票表
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
public class Invoice extends Model<Invoice> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "INVOICE_ID", type = IdType.AUTO)
    private Long invoiceId;
    /**
     * 发票年月，YYYYMM
     */
    @TableField("INVOICE_YM")
    private BigDecimal invoiceYm;
    /**
     * 发票日期，YYYYMMDD
     */
    @TableField("INVOICE_YMD")
    private BigDecimal invoiceYmd;
    /**
     * 开票流水号，唯一标志开票请求。支持数字字母下划线组合
     */
    @TableField("SERIAL_NO")
    private String serialNo;
    /**
     * 发票类型代码。 004：增值税纸质专用发票，007：增值税纸质普通发票， 026增值税电子普通发票
     */
    @TableField("INVOICE_TYPE_CODE")
    private String invoiceTypeCode;
    /**
     * 开票点编码
     */
    @TableField("INVOICE_TERMINAL_CODE")
    private String invoiceTerminalCode;
    /**
     * 特殊票种标记，00：普通发票 02：农业发票 06：抵扣通行费 07：其他通行费 08:成品油 默认：00
     */
    @TableField("INVOICE_SPECIAL_MARK")
    private String invoiceSpecialMark;
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
     * 购方纳税人识别
     */
    @TableField("BUYER_TAX_NO")
    private String buyerTaxNo;
    /**
     * 购方名称
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
     * 综合税率
     */
    @TableField("CONSOLIDATED_TAX_RATE")
    private BigDecimal consolidatedTaxRate;
    /**
     * 含税标志0：不含税 1：含税
     */
    @TableField("PRICE_TAX_MARK")
    private Integer priceTaxMark;
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
     * 状态:1已开具、2已红冲、3已开具未生成板式
     */
    @TableField("STATUS")
    private Integer status;
    /**
     * 发票代码
     */
    @TableField("INVOICE_CODE")
    private String invoiceCode;
    /**
     * 发票号码
     */
    @TableField("INVOICE_NO")
    private String invoiceNo;
    /**
     * 开票日期
     */
    @TableField("INVOICE_DATE")
    private Date invoiceDate;
    /**
     * 税控防伪码
     */
    @TableField("TAX_CONTROL_CODE")
    private String taxControlCode;
    /**
     * 版式文件地址
     */
    @TableField("FORMAT_FILE_URL")
    private String formatFileUrl;
    /**
     * 机器编号
     */
    @TableField("MACHINE_NO")
    private String machineNo;
    /**
     * 签名状态：0：未验签
1：验签成功
 2表示未同步
     */
    @TableField("CHECK_SIGN")
    private Integer checkSign;
    /**
     * 校验码
     */
    @TableField("INVOICE_CHECK_CODE")
    private String invoiceCheckCode;
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
    /**
     * 组织机构代码
     */
    @TableField("ORG_CODE")
    private String orgCode;
    @TableField("RES2")
    private String res2;
    @TableField("RES3")
    private String res3;


    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getInvoiceYm() {
        return invoiceYm;
    }

    public void setInvoiceYm(BigDecimal invoiceYm) {
        this.invoiceYm = invoiceYm;
    }

    public BigDecimal getInvoiceYmd() {
        return invoiceYmd;
    }

    public void setInvoiceYmd(BigDecimal invoiceYmd) {
        this.invoiceYmd = invoiceYmd;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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

    public String getInvoiceSpecialMark() {
        return invoiceSpecialMark;
    }

    public void setInvoiceSpecialMark(String invoiceSpecialMark) {
        this.invoiceSpecialMark = invoiceSpecialMark;
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

    public BigDecimal getConsolidatedTaxRate() {
        return consolidatedTaxRate;
    }

    public void setConsolidatedTaxRate(BigDecimal consolidatedTaxRate) {
        this.consolidatedTaxRate = consolidatedTaxRate;
    }

    public Integer getPriceTaxMark() {
        return priceTaxMark;
    }

    public void setPriceTaxMark(Integer priceTaxMark) {
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

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getTaxControlCode() {
        return taxControlCode;
    }

    public void setTaxControlCode(String taxControlCode) {
        this.taxControlCode = taxControlCode;
    }

    public String getFormatFileUrl() {
        return formatFileUrl;
    }

    public void setFormatFileUrl(String formatFileUrl) {
        this.formatFileUrl = formatFileUrl;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public Integer getCheckSign() {
        return checkSign;
    }

    public void setCheckSign(Integer checkSign) {
        this.checkSign = checkSign;
    }

    public String getInvoiceCheckCode() {
        return invoiceCheckCode;
    }

    public void setInvoiceCheckCode(String invoiceCheckCode) {
        this.invoiceCheckCode = invoiceCheckCode;
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
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
        return this.invoiceId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
        "invoiceId=" + invoiceId +
        ", invoiceYm=" + invoiceYm +
        ", invoiceYmd=" + invoiceYmd +
        ", serialNo=" + serialNo +
        ", invoiceTypeCode=" + invoiceTypeCode +
        ", invoiceTerminalCode=" + invoiceTerminalCode +
        ", invoiceSpecialMark=" + invoiceSpecialMark +
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
        ", consolidatedTaxRate=" + consolidatedTaxRate +
        ", priceTaxMark=" + priceTaxMark +
        ", remarks=" + remarks +
        ", buyerEmail=" + buyerEmail +
        ", buyerPhone=" + buyerPhone +
        ", buyerType=" + buyerType +
        ", status=" + status +
        ", invoiceCode=" + invoiceCode +
        ", invoiceNo=" + invoiceNo +
        ", invoiceDate=" + invoiceDate +
        ", taxControlCode=" + taxControlCode +
        ", formatFileUrl=" + formatFileUrl +
        ", machineNo=" + machineNo +
        ", checkSign=" + checkSign +
        ", invoiceCheckCode=" + invoiceCheckCode +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", updateUserId=" + updateUserId +
        ", updateTime=" + updateTime +
        ", orgCode=" + orgCode +
        ", res2=" + res2 +
        ", res3=" + res3 +
        "}";
    }
}
