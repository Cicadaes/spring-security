package com.auth.center.springsecurity.dao;

import com.auth.center.springsecurity.common.model.Ticket;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 流水单信息表 Mapper 接口
 * </p>
 *
 * @author lqq
 * @since 2019-05-14
 */
public interface TicketMapper extends BaseMapper<Ticket> {
    int insertData();

    List<Ticket> searchByParam(Map map);
}
