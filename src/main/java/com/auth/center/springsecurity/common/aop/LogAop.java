package com.auth.center.springsecurity.common.aop;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
@Configuration
public class LogAop {

    // logger
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String POINT_LOG_CONTROLLER = "execution (* com.auth.center.springsecurity.controller.*.*(..))";
    public static final String POINT_LOG_CONTROLLER_EXT = "execution (* com.auth.center.springsecurity.*.controller.*.*(..))";
    public static final String POINT_LOG_SERVICE = "execution (* com.auth.center.springsecurity.service.impl.*.*(..))";
    public static final String POINT_LOG_SERVICE_EXT = "execution (* com.auth.center.springsecurity.*.service.impl.*.*(..))";

    public static final String POINT_LOG =
        POINT_LOG_CONTROLLER + " || " + POINT_LOG_CONTROLLER_EXT + " || " + POINT_LOG_SERVICE
            + " || " + POINT_LOG_SERVICE_EXT;


    /**
     * 统计方法执行耗时Around环绕通知
     *
     * @param joinPoint
     * @return
     */
    @Around(POINT_LOG)
    public Object timeAround(ProceedingJoinPoint joinPoint) {
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "_" + signature.getName();
        this.printBeginLog(methodName, args);
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            // 如果是自定义异常，需要抛出上层，否则会拦截多有的自定义异常
            if (e instanceof RuntimeException) {
                this.printErrorLog(methodName, args, e);
                throw (RuntimeException) e;
            } else {
//                this.printErrorLog(methodName, args, e);
                throw new RuntimeException(e);
            }
        }
        // 获取执行的方法名
        long endTime = System.currentTimeMillis();
        // 打印耗时的信息
        this.printExecTime(methodName, args, startTime, endTime);
        return obj;
    }

    /**
     * 判断是否为基本类型：包括String
     */
    private boolean isPrimite(Class<?> clazz) {
        if (clazz.isPrimitive() || clazz == String.class) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串长度是否大于100
     */
    private boolean isShortString(String str) {
        if (str.length() > 100) {
            return false;
        }
        return true;

    }

    /**
     *
     * 打印入口日志，输出入参信息
     */
    private void printBeginLog(String methodName, Object[] args) {
        String param = generateParamDigest(args);
        logger.info("[{}] begin param [{}]", methodName, param);
    }

    /**
     * 打印方法执行耗时的信息
     */
    private void printExecTime(String methodName, Object[] args, long startTime, long endTime) {
        String param = generateParamDigest(args);
        logger.info("[{}] success param [{}] cost {} ms", methodName, param, (endTime - startTime));
    }

    /**
     *
     * 打印错误日志
     *
     */
    private void printErrorLog(String methodName, Object[] args, Throwable e) {
        String param = generateParamDigest(args);
        e.printStackTrace();
        String errormsg = e.getMessage() == null ? "" : e.getMessage();
        logger.error("[{}] error param [{}] errmsg [{}]", methodName, param, errormsg);
    }


    /**
     *
     * 生成参数摘要字符串
     */
    private String generateParamDigest(Object[] args) {
        StringBuffer argString = new StringBuffer();
        for (Object arg : args) {
            if (arg != null) {

                if (isPrimite(arg.getClass())) {
                    // 是基本类型
                    if (isShortString(arg.toString())) {// 长度小于100
                        argString.append(arg.toString()).append(",");
                    } else {
                        argString.append(arg.getClass().getName()).append(",");
                    }
                } else if ((arg instanceof ServletRequest)
                    || (arg instanceof ServletResponse)
                    || arg.getClass().getName().contains("validation")) {// 特定类型只打印类名
                    argString.append(arg.getClass().getName()).append(",");
                } else {
                    // 不是基本类型,输出classname
                    argString.append(arg.toString()).append(",");
                }
            }
        }
        return argString.toString();
    }
}
