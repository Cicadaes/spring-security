package com.auth.center.springsecurity.service.impl;

import com.auth.center.springsecurity.common.model.Invoice;
import com.auth.center.springsecurity.dao.InvoiceMapper;
import com.auth.center.springsecurity.service.IInvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发票表 服务实现类
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements IInvoiceService {

}
