package com.auth.center.springsecurity.dao;

import com.auth.center.springsecurity.common.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lqq
 * @since 2019-04-20
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> listAllSysMenuQx(@Param("menuId") String s);

    List<SysMenu> selectSubMenuById(@Param("menuId") String s);
}
