package com.auth.center.springsecurity.service;

import com.auth.center.springsecurity.common.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> listAllSysMenuQx(String s);
}
