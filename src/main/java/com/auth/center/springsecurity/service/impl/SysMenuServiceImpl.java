package com.auth.center.springsecurity.service.impl;

import com.auth.center.springsecurity.common.model.SysMenu;
import com.auth.center.springsecurity.dao.SysMenuMapper;
import com.auth.center.springsecurity.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> listAllSysMenuQx(String s,
        Page page) {
        return sysMenuMapper.listAllSysMenuQx(s,page);
    }
}
