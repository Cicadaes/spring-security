package com.auth.center.springsecurity.service.impl;

import com.auth.center.springsecurity.common.model.TicketDetail;
import com.auth.center.springsecurity.dao.TicketDetailMapper;
import com.auth.center.springsecurity.service.ITicketDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 流水单明细表 服务实现类
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
@Service
public class TicketDetailServiceImpl extends
    ServiceImpl<TicketDetailMapper, TicketDetail> implements ITicketDetailService {

}
