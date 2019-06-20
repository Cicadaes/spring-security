package com.auth.center.springsecurity.dao;


import com.auth.center.springsecurity.common.model.SysStatistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
public interface SysStatisticsMapper extends BaseMapper<SysStatistics> {

    List<SysStatistics> searchByParam(Map map);

    int insertData();
}
