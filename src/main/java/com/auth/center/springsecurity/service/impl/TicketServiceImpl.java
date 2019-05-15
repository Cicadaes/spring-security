package com.auth.center.springsecurity.service.impl;

import com.auth.center.springsecurity.common.model.Ticket;
import com.auth.center.springsecurity.dao.TicketMapper;
import com.auth.center.springsecurity.service.ITicketService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 流水单信息表 服务实现类
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
@Service
public class TicketServiceImpl extends ServiceImpl<TicketMapper, Ticket> implements ITicketService {

}
