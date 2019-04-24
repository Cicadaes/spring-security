package com.auth.center.springsecurity.common.aop;

import com.auth.center.springsecurity.common.annotation.Permit;
import com.auth.center.springsecurity.common.base.RException;
import com.auth.center.springsecurity.common.util.Jurisdiction;
import com.auth.center.springsecurity.jwt.JwtTokenUtil;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ClassName: <br>
 * Function: <br>
 * date: 2019/4/24 下午4:06<br>
 * @author liqiangqiang<br>
 * @version
 * @since JDK 1.8
 */
@Aspect
@Configuration
public class PermissionProxy {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private Jurisdiction jurisdiction;

    @Around("@annotation(com.auth.center.springsecurity.common.annotation.Permit)")
    public void check(ProceedingJoinPoint point) throws ClassNotFoundException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
            .getRequestAttributes()).getRequest();
        String tokenHead = request.getHeader(tokenHeader);
        String token = tokenHead.substring(7);
        String userId = jwtTokenUtil.getPrivateClaimFromToken(token, "user_id");
        String targetName = point.getTarget().getClass().getName();    //获得执行方法的类名
        String methodName = point.getSignature().getName();            //获得执行方法的方法名
        Object[] arguments = point.getArgs();                          //获取切点方法的所有参数类型
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();    //获取公共方法，不包括类私有的
        String menuUrl = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();     //对比方法中参数的个数
                if (clazzs.length == arguments.length) {
                    menuUrl = method.getAnnotation(Permit.class).url();
                    break;
                }
            }
        }
        if (!jurisdiction.buttonJurisdiction(menuUrl, userId)) {
            throw new RException("401","没有权限访问!");
        }
    }
}
