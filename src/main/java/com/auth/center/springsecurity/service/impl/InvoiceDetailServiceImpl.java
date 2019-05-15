package com.auth.center.springsecurity.service.impl;

import com.auth.center.springsecurity.common.model.InvoiceDetail;
import com.auth.center.springsecurity.dao.InvoiceDetailMapper;
import com.auth.center.springsecurity.service.IInvoiceDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发票明细表 服务实现类
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
@Service
public class InvoiceDetailServiceImpl extends
    ServiceImpl<InvoiceDetailMapper, InvoiceDetail> implements IInvoiceDetailService {

}
