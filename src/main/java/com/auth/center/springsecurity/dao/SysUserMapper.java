package com.auth.center.springsecurity.dao;


import com.auth.center.springsecurity.common.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser findByUsername(@Param("username")String username);
}
