package com.auth.center.springsecurity.service.impl;

import com.auth.center.springsecurity.common.model.SysUser;
import com.auth.center.springsecurity.dao.SysUserMapper;
import com.auth.center.springsecurity.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
