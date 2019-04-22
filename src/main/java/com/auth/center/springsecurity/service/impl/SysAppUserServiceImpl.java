package com.auth.center.springsecurity.service.impl;

import com.auth.center.springsecurity.common.model.SysAppUser;
import com.auth.center.springsecurity.dao.SysAppUserMapper;
import com.auth.center.springsecurity.service.ISysAppUserService;
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
public class SysAppUserServiceImpl extends ServiceImpl<SysAppUserMapper, SysAppUser> implements ISysAppUserService {

}
