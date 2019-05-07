package com.auth.center.springsecurity.plugins.utils;

import java.lang.reflect.Proxy;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

/**
 * @author lqq
 */
public class PluginUtil {
    private PluginUtil() {
    }

    /**
     * <p>Recursive get the original target object.
     * <p>If integrate more than a plugin, maybe there are conflict in these plugins, because plugin will proxy the object.<br>
     * So, here get the original target object
     *
     * @param target proxy-object
     * @return original target object
     */
    public static Object processTarget(Object target) {
        if (Proxy.isProxyClass(target.getClass())) {
            MetaObject metaObject = SystemMetaObject.forObject(target);
            return processTarget(metaObject.getValue("h.target"));
        }
        return target;
    }
}
